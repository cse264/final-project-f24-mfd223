<template>
  <div>
    <NavBar />
    <h2>Profile</h2>
    <div v-if="user">
      <p><strong>Username:</strong> {{ user.username }}</p>
      <p><strong>Status:</strong> {{ user.paidUser ? 'Paid User' : 'Free User' }}</p>
    </div>
    <p v-else>You are not signed in.</p>
  </div>
  <div>
    <button @click="signOut">Sign Out</button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      user: null
    };
  },
  created() {
    const storedUser = localStorage.getItem('user');
    if (storedUser) {
      this.user = JSON.parse(storedUser);
    }
  },
  methods: {
    signOut() {
      localStorage.removeItem('user');
      this.$router.push('/'); // Redirect to home page
    }
  }
};
</script>






