<template>
  <div class="weather-app">
    <NavBar />
    <img
      alt="WeatherWise logo"
      src="../assets/logo.png"
      :style="{ width: '200px', height: 'auto' }"
    />
    <h1>Welcome to WeatherWise!</h1>
    <div class="search-bar">
      <input type="text" v-model="city" placeholder="Enter a city" />
      <button @click="searchWeather">Search</button>
    </div>
    <p v-if="error">{{error}}</p>
  </div>
</template>

<script>
import "../assets/WeatherApp.css";
import NavBar from "./NavBar.vue";
export default {
  name: "WeatherApp",
  data() {
    return {
      city: "",
      weatherData: null,
      error: "",
    };
  },
  methods: {
    searchWeather() {
      if (this.city.trim()) {
        this.$router.push({ name: 'weather-detail', params: { city: this.city } });
      } else {
        this.error = 'Please enter a city name!';
      }
    }
  },
  components: {
    NavBar,
  },
};
</script>
