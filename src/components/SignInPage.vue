<template>
  <div class="sign-in-page">
    <h1>Sign In</h1>
    <form @submit.prevent="handleLogin">
      <input v-model="username" placeholder="Username" required />
      <input v-model="password" type="password" placeholder="Password" required />
      <button type="submit">Sign In</button>
    </form>
    <p>
      New User? 
      <a @click="goToSignUp" href="javascript:void(0)">Sign up here</a>
    </p>
    <p v-if="error" class="error">{{ error }}</p>
  </div>
</template>

<script>
export default {
  data() {
    return {
      username: '',
      password: '',
      error: ''
    };
  },
  methods: {
    async handleLogin() {
      try {
        const response = await fetch('http://localhost:8081/api/users/login', {
          method: 'POST',
          headers: { 'Content-Type': 'application/json' },
          body: JSON.stringify({
            username: this.username,
            password: this.password
          })
        });

        if (!response.ok) {
          this.error = 'Invalid credentials.';
          return;
        }

        const userData = await response.json();
        // Store user data (e.g., in Vuex or localStorage) and redirect
        console.log('User logged in:', userData);
        this.$router.push('/profile');
      } catch (err) {
        this.error = 'An error occurred while logging in.';
      }
    },
    goToSignUp() {
      this.$router.push('/signup'); // Navigate to the sign-up page
    }
  }
};
</script>

<style>
.sign-in-page {
  /* Add styles for the sign-in page */
}
.error {
  color: red;
}
</style>
