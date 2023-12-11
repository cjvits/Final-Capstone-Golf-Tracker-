<!-- src/views/HomeView.vue -->
<template>
  <div class="home-container">

    <div class="header">
      <h2>Welcome Home Ya Golf'n Yinzer!</h2>
    </div>

<div class="row">
  <div class="left-column">
    <h3 class="teeTimeTitle">Upcoming Tee Times:</h3>
    <TeeTimes v-for="(league, index) in leagues" v-bind:key="index" :league="league" :users="$store.state.user.users"/>
  </div>
  <div class="center-column">
    <LeaderBoard v-for="(league, index) in leagues" v-bind:key="index" :league="league" :users="$store.state.user.users" />
  </div>
  <div class="right-column">
    <NewLeagueCreator ></NewLeagueCreator>
    <LeagueOrganizerSelector></LeagueOrganizerSelector>
    <!-- <router-link class="league-organizer-link" v-bind:to="{name: 'league-organizer'}">My League Organizer Page</router-link> -->
  </div>
</div>
<!-- <router-link v-bind:to="{name: 'login', params:{'id': 1}}">Home</router-link> -->

    <!-- <div class="footer">
  <p>
  </p>
</div> -->
  </div>
</template>

<script>
import LeaderBoard from "../components/LeaderBoard.vue";
import NewLeagueCreator from "../components/NewLeagueCreator.vue";
import LeagueService from "../services/LeagueService";
import TeeTimes from "../components/TeeTimes.vue";
import LeagueOrganizerSelector from "../components/LeagueOrganizerSelector.vue";

export default {
  components: {
    LeaderBoard,
    NewLeagueCreator,
    TeeTimes,
    LeagueOrganizerSelector,
  },
  data() {
    return {
      teeTimes: [
        // Your tee time data goes here
        // { id: 1, time: '08:00 AM', date: '2023-12-01', users: [{ id: 1, username: 'User1' }, { id: 2, username: 'User2' }] },
      ],
      users: [
        // Your user data goes here
      ],
      leagues: [],
      newLeague: {
        name: '',
      }
    };
  },
  methods: {
    // logOut(){
    //   this.$store.commit("LOGOUT");
    //   this.$router.push("/");
    // },
    //send to logout view in order to logout. Code written for us already in LogoutView
    retrieveLeagues() {
      LeagueService
        .getLeaguesByUserId(this.$store.state.user.id)
        .then(response => {
          this.leagues = response.data;
        })
        .catch(error => {
          this.handleErrorResponse(error, 'getting');
        });
    }
  },
  created() {
    this.retrieveLeagues();
  }

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

.loading-message {
  margin-top: 20px;
  font-style: italic;
  color: darkkhaki;
}

h3 {
  font-weight: bold;
  text-decoration-line: underline;
}

h2 {
  color: #093708;
}

/* .league-organizer-link {
  color: #093708;
  justify-self: center;
  padding: 2rem;
}

.league-organizer-link:hover {
  color: #116110;
  text-decoration-line: underline;
} */

/* Container for flexboxes */
.row {
  display: -webkit-flex;
  display: flex;
  padding: 10px;
  height: 50%;
  /* adjust to auto after things are in them! */
}

/* Left and right column */
.right-column {
   -webkit-flex: 1;
   -ms-flex: 1;
   flex: 1.25;
   border-radius: 15px;
   margin: .5rem;
   background-color: darkkhaki;
   opacity: .9;
   padding: 1rem;
   height: auto;
   display: flex;
   flex-direction: column;
   justify-content: center;
   align-items: center;
   flex-grow: 1;
}

.left-column {
  overflow: scroll;
   -webkit-flex: 1;
   -ms-flex: 1;
   flex: .75;
   border-radius: 15px;
   margin: .5rem;
   background-color: darkkhaki;
   opacity: .9;
   padding: 1rem;
   height: auto;
}

/* Middle column */
.center-column {
  overflow: scroll;
  -webkit-flex: 2;
  -ms-flex: 2;
  flex: 2;
  border-radius: 15px;
  margin: .5rem;
  background-color: #093708;
  opacity: .9;
  color: darkkhaki;
  padding: 1rem;
  height: auto;
}


.left-column::-webkit-scrollbar,
.center-column::-webkit-scrollbar {
  width: 15px;
}

.left-column::-webkit-scrollbar-thumb,
.center-column::-webkit-scrollbar-thumb {
  background-color: darkgreen;
  border-radius: 4px;
}

.left-column::-webkit-scrollbar-corner,
.center-column::-webkit-scrollbar-corner {
  display: none;
}

.leaderboard-title {
  width: 100%;
  border-collapse: collapse;
  margin-top: 20px;
}

/* Style the footer */
/* .footer {
  background-color: #f1f1f1;
  padding: 10px;
  text-align: center;
} */

.home-container {
  background-image: url("../assets/goldenGolf.jpeg");
  background-color: #312917;
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