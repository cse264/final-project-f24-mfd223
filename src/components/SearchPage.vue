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
      <input type="text" placeholder="Enter a city" />
      <button>Search</button>
    </div>
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
      error: null,
    };
  },
  components: {
    NavBar,
  },
};
</script>
