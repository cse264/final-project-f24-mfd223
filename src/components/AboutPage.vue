<template>
  <div>
    <NavBar />
    <div class="about-content">
      <h1>About WeatherWise</h1>
      <p>
        Welcome to<strong>WeatherWise!</strong>With WeatherWise, you
        can search for up-to-date weather information from any city.
        Premium users can see up to a 5 day forecast, while free users
        will see the forecast for the current day.
      </p>
      <p>
        <strong>Creators:</strong>
        <ul>
          <li>Michael DeFulvio - mfd223@lehigh.edu</li>
          <li>Evan McDonnell - esm227@lehigh.edu</li>
          <li></li>
        </ul>
      </p>
    </div>
  </div>
</template>

<script>
import NavBar from "./NavBar.vue";

export default {
  name: "AboutPage",
  components: {
    NavBar,
  },
};
</script>

<style scoped>
.about-content {
    margin: 80px auto;
    max-width: 600px;
    background: white;
    border: 1px solid #ccc;
    border-radius: 10px;
    padding: 20px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

h1, h2 {
  color: #1e90ff;
}

p, ul {
  line-height: 1.6;
  color: #333;
}

ul {
  padding-left: 20px;
}
</style>
