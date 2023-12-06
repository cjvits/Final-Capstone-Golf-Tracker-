<template>
  <div class="home">
    <h1>Home</h1>
  </div>

<<<<<<< HEAD
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
=======
  <!-- TODO: Include links/show:
>>>>>>> bf13accb44c46b73325d2c7232e5ae3fe9674a0a
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


<style scoped>
.home {
  justify-content: center;
  align-items: center;
  background-image: url("../assets/goldenGolf.jpeg");
  height: 100vh;
  background-size: cover;
  background-position: center;
  display: flexbox;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  padding: 0 20px;
  text-align: center;
  font-family: 'Hedvig Letters Serif', serif;
  color: #093708;
  font-weight: 600;
}
</style>