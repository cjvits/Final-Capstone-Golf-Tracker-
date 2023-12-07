<!-- src/views/HomeView.vue -->
<template>
<div class="home-container">

<div class="header">
  <h2>Welcome Home Ya Golf'n Yinzer!</h2>
  <!-- <LeaderBoard :users="$store.state.user.users" /> -->
</div>

<div class="row">
  <div class="left-column">Left Column</div>
  <div class="center-column">
    <LeaderBoard :users="$store.state.user.users" />
  </div>
  <div class="right-column">Right Column</div>
</div>

<!-- <div class="footer">
  <p>
  </p>
</div> -->
</div>
</template>





<!-- TODO: Include links/show:
  - leader board
  - tee-times
  - create a new league

TODO: IF LEAGUE ORGANIZER
  - link to go to league organization page

TODO: IF ADMIN
  - include ability/form to add a golf course -->


<script>
// import HomePage from "@/components/HomePage";
import LeaderBoard from "@/components/LeaderBoard.vue";

export default {
  components: {
    LeaderBoard,
  },
  methods: {
    logOut(){
      this.$store.commit("LOGOUT");
      this.$router.push("/");
    },
  },
};
</script> 

<style scoped>
* {
  box-sizing: border-box;
}

/* Style the header */
.header {
  padding: 30px;
  text-align: center;
  font-size: 35px;
}

/* Container for flexboxes */
.row {
  display: -webkit-flex;
  display: flex;
}

/* Create three unequal columns that sits next to each other */
.row {
  padding: 10px;
  height: 50%; /* adjust to auto after things are in them! */
}

/* Left and right column */
.right-column {
   -webkit-flex: 1;
   -ms-flex: 1;
   flex: 1.25;
   border-radius: 15px;
   margin: .5rem;
   background-color: darkkhaki;
   opacity: .8;
}

.left-column {
   -webkit-flex: 1;
   -ms-flex: 1;
   flex: .75;
   border-radius: 15px;
   margin: .5rem;
   background-color: darkkhaki;
   opacity: .8;
}

/* Middle column */
.center-column {
  -webkit-flex: 2;
  -ms-flex: 2;
  flex: 2;
  border-radius: 15px;
  margin: .5rem;
  background-color: #093708;
  opacity: .8;
  color: darkkhaki;
}

/* Style the footer */
/* .footer {
  background-color: #f1f1f1;
  padding: 10px;
  text-align: center;
} */

.home-container {
  background-image: url("../assets/goldenGolf.jpeg");
  height: 100vh;
  background-size: cover;
  background-position: center;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  padding: 0 20px;
  text-align: center;
  font-family: 'Hedvig Letters Serif', serif;
  color: #093708;
  font-weight: 600;
}

/* Responsive layout - makes the three columns stack on top of each other instead of next to each other */
@media (max-width: 600px) {
  .row {
    -webkit-flex-direction: column;
    flex-direction: column;
  }
}

</style>

<!-- <style scoped>
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
</style> -->