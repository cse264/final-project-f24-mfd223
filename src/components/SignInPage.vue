<template>
  <div class="sign-in-page">
    <NavBar/>
    <h1>Sign In</h1>
    <form @submit.prevent="handleLogin">
      <input v-model="username" placeholder="Username" required />
      <input v-model="password" type="password" placeholder="Password" required />
      <div>
        <button type="submit">Sign In</button>
      </div>
    </form>
    <p>
      New User? 
      <a @click="goToSignUp" href="javascript:void(0)">Sign up here</a>
    </p>
    <p v-if="error" class="error">{{ error }}</p>
  </div>
</template>

<script>
import NavBar from './NavBar.vue'
export default {
  data() {
    return {
      username: '',
      password: '',
      error: ''
    };
  },
  components: {
    NavBar
  },
  methods: {
    async handleLogin() {
        try {
            // Fetches login from backend
            const response = await fetch('http://localhost:8081/api/users/login', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            // Adds logged in user using post method
            body: JSON.stringify({
                username: this.username,
                password: this.password
                })
            });

            // Backend handles credentials
            // If an response fails, login credentials are invalid
            if (!response.ok) {
                this.error = 'Invalid credentials.';
                return;
            }

            const userData = await response.json();
            // Save user data to localStorage so profile page reflects logged in user
            localStorage.setItem('user', JSON.stringify(userData));
    
            // Redirect to the profile page after logging in
            this.$router.push('/profile');
        } catch (err) {
            this.error = 'An error occurred while logging in.';
        }
    },
    goToSignUp() {
      this.$router.push('/signup'); // Navigate to the sign-up page when pressed
    }
  }
};
</script>


// Additional styling elements for sign-in page (makes it so text doesn't clash with backgroun gif)
<style>
.sign-in-page {
    margin: 80px auto;
    max-width: 300px;
    background: white;
    border: 1px solid #ccc;
    border-radius: 10px;
    padding: 20px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}
.error {
  color: red;
}
</style>
