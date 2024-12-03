<template>
  <nav class="top-nav">
    <div class="site-name">
      <h4>WeatherWise</h4>
    </div>
    <div class="nav-links">
      <router-link to="/">Home</router-link>
      <router-link to="/about">About</router-link>
      <router-link to="/profile">Profile</router-link>
    </div>
    <div>
    <SignInButton />
    </div>
  </nav>
</template>

<script>
import SignInButton from "./SignInButton.vue";
import "../assets/WeatherApp.css";
export default {
  name: "NavBar",
  components: {
    SignInButton,
  },
};
</script>