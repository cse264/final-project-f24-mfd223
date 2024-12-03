<template>
  <div class="profile-page">
    <NavBar />
    <div class="profile-content">
      <h1>User Profile</h1>
      <div class="profile-details">
        <p><strong>Name:</strong> Temp User</p>
        <p><strong>Hometown:</strong> Bethlehem</p>
        <p><strong>Account Type:</strong> Free</p>
      </div>
    </div>
  </div>
</template>

<script>
import NavBar from "@/components/NavBar.vue";
import "../assets/ProfilePage.css";

export default {
  name: "ProfilePage",
  components: {
    NavBar,
  },
};
</script>




