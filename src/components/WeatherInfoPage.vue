<template>
  <div class="weather-content">
    <NavBar />
    <div v-if="weather">
      <h2>{{ weather.name }}, {{ weather.sys.country }}</h2>
      <p>Temperature: {{ weather.main.temp }}°C</p>
      <p>Weather: {{ weather.weather[0].description }}</p>
      <p>Humidity: {{ weather.main.humidity }}%</p>
      <p>Wind Speed: {{ weather.wind.speed }} m/s</p>
    </div>
    <div v-if="forecast && isPaidUser">
      <h3>5-Day Forecast</h3>
      <div v-for="(item, index) in forecast" :key="index">
        <p><strong>{{ item.date }}</strong>: {{ item.temp }}°C, {{ item.description }}</p>
      </div>
    </div>
    <p v-else-if="!isPaidUser">Upgrade to see the 5-day forecast!</p>
    <p v-if="error">{{ error }}</p>
  </div>
</template>

<script>
import NavBar from './NavBar.vue';
import "../assets/WeatherInfoPage.css";
export default {
  data() {
    return {
      weather: null,
      forecast: null,
      error: '',
      isPaidUser: false
    };
  },
  components: {
    NavBar,
  },
  created() {
    this.getWeather();
  },
  methods: {
    async getWeather() {
        const city = this.$route.params.city;

        // Retrieves the user that's logged in
        const storedUser = localStorage.getItem('user'); 
        const user = storedUser ? JSON.parse(storedUser) : null;

        console.log('Parsed user:', user); // Log the parsed user object (used for debugging)
        this.isPaidUser = user && user.paidUser; // Checks if the user is a paid user (if there is a user logged in)
        console.log('Is paid user:', this.isPaidUser); // Log the isPaidUser status (used for debugging)

        const apiKey = process.env.VUE_APP_API_KEY;
        const geoUrl = `http://api.openweathermap.org/geo/1.0/direct?q=${city}&limit=1&appid=${apiKey}`;

        this.error = '';
        this.weather = null;
        this.forecast = null;

        try {
            // Fetch data from the OpenWeatherMap API
            const geoResponse = await fetch(geoUrl);
            const geoData = await geoResponse.json();
            if (!geoData.length) { // If nothing is found, error is set
            this.error = 'City not found!';
            return;
            }

            // City is identified with latitude and longitude
            const { lat, lon } = geoData[0];

            // Fetches current weather from the determined latitude and longitude location
            const weatherUrl = `https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&appid=${apiKey}&units=metric`;
            const weatherResponse = await fetch(weatherUrl);
            const weatherData = await weatherResponse.json();

            if (weatherData.cod === 200) {
                this.weather = weatherData;

                if (this.isPaidUser) {
                    // Fetches 5-day forecast for paid users
                    const forecastUrl = `https://api.openweathermap.org/data/2.5/forecast?lat=${lat}&lon=${lon}&appid=${apiKey}&units=metric`;
                    const forecastResponse = await fetch(forecastUrl);
                    const forecastData = await forecastResponse.json();

                if (forecastData.cod === '200') {
                    this.forecast = forecastData.list
                    .filter((item, index) => index % 8 === 0) // Get one entry per day
                    .map(item => ({
                        date: new Date(item.dt * 1000).toLocaleDateString(),
                        // Sets temperature and weather description for each day in forecast
                        temp: item.main.temp, 
                        description: item.weather[0].description
                    }));
                }
            }
            } else {
                this.error = 'City not found!';
            }
        } catch (err) {
            this.error = 'Something went wrong.';
        }
      },
    }
};
</script>
