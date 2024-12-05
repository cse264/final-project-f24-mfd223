/* Profile page will list the currently logged in user and the account type.
   If a user is not logged in, this page will indicate that. */

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
    // Uses the currently logged in user for the profile information
    const storedUser = localStorage.getItem('user');
    if (storedUser) {
      this.user = JSON.parse(storedUser);
    }
  },
  components: {
    NavBar
  },
  methods: {
    // Signing out will remove the user from temporary storage
    signOut() {
      localStorage.removeItem('user');
      this.$router.push('/'); // Redirects to home page
    }
  }
};
</script>






