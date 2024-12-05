<template>
  <div class="sign-up-page">
    <NavBar />
    <h1>Sign Up</h1>
    <form @submit.prevent="handleSignUp">
      <input v-model="username" placeholder="Username" required />
      <input v-model="password" type="password" placeholder="Password" required />
      <div>
        <label>
          <input type="checkbox" v-model="paidUser" /> Paid User?
        </label> 
      </div>
      <button type="submit">Sign Up</button>
    </form>
    <p v-if="error" class="error">{{ error }}</p>
    <p v-if="success" class="success">{{ success }}</p>
  </div>
</template>

<script>
import NavBar from './NavBar.vue';
export default {
  data() {
    return {
      username: '',
      password: '',
      paidUser: false,
      error: '',
      success: ''
    };
  },
  components: {
    NavBar,
  },
  methods: {
    async handleSignUp() {
      try {
        // Registers user with backend with post method
        const response = await fetch('http://localhost:8081/api/users/register', {
          method: 'POST',
          headers: { 'Content-Type': 'application/json' },
          body: JSON.stringify({
            username: this.username,
            password: this.password,
            paidUser: this.paidUser // User must select the option to be paid or free user
          })
        });

        // If the response from backend fails, error is set
        if (!response.ok) {
          this.error = 'Registration failed. Username might already be taken.';
          return;
        }

        // Otherwise success message is set
        this.success = 'User registered successfully! You can now sign in.';
        this.username = '';
        this.password = '';
        this.paidUser = false;
        this.error = '';
      } catch (err) {
        this.error = 'An error occurred while registering.';
      }
    }
  }
};
</script>

<style>
.sign-up-page {
    margin: 80px auto;
    max-width: 300px;
    background: white;
    border: 1px solid #ccc;
    border-radius: 10px;
    padding: 20px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}
.error { /* errors displayed red */
  color: red;
}
.success { /* success message displayed in green */
  color: green;
}
</style>
