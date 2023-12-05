<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
  </div>

  <nav>
    <!-- leaderboard stuff -->

    <!-- tee times stuff -->

    <!-- creating a new league -->

    <!-- admin stuff IF ADMIN -->

    <!-- logout -->
    <button v-on:click="logOut">Log Out</button>
  </nav>

  <div>
    <!-- my upcoming -->
  </div>

<!-- TODO: Include links/show:
  - leader board
  - tee-times
  - create a new league

TODO: IF LEAGUE ORGANIZER
  - link to go to league organization page

TODO: IF ADMIN
  - include ability/form to add a golf course -->


</template>

<script>
export default {
  methods: {
    logOut(){
      this.$store.commit("LOGOUT");
      this.$router.push("/");
    }
  }
};
</script> 


