<template>
  <div class="profile-content">
    <NavBar />
    <h2>Profile</h2>
    <div v-if="user">
      <p><strong>Username:</strong> {{ user.username }}</p>
      <p><strong>Status:</strong> {{ user.paidUser ? 'Paid User' : 'Free User' }}</p>
    </div>
    <p v-else>You are not signed in.</p>
    <button @click="signOut">Sign Out</button>
  </div>
</template>

<script>
import NavBar from './NavBar.vue';
import "../assets/ProfilePage.css";
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
  components: {
    NavBar
  },
  methods: {
    signOut() {
      localStorage.removeItem('user');
      this.$router.push('/'); // Redirect to home page
    }
  }
};
</script>






