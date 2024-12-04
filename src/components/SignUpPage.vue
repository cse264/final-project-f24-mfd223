<template>
  <div class="sign-up-page">
    <h1>Sign Up</h1>
    <form @submit.prevent="handleSignUp">
      <input v-model="username" placeholder="Username" required />
      <input v-model="password" type="password" placeholder="Password" required />
      <label>
        <input type="checkbox" v-model="paidUser" /> Paid User?
      </label>
      <button type="submit">Sign Up</button>
    </form>
    <p v-if="error" class="error">{{ error }}</p>
    <p v-if="success" class="success">{{ success }}</p>
  </div>
</template>

<script>
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
  methods: {
    async handleSignUp() {
      try {
        const response = await fetch('http://localhost:8081/api/users/register', {
          method: 'POST',
          headers: { 'Content-Type': 'application/json' },
          body: JSON.stringify({
            username: this.username,
            password: this.password,
            paidUser: this.paidUser
          })
        });

        if (!response.ok) {
          this.error = 'Registration failed. Username might already be taken.';
          return;
        }

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
  /* Add styles for the sign-up page */
}
.error {
  color: red;
}
.success {
  color: green;
}
</style>
