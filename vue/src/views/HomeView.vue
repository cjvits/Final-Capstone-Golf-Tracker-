<!-- src/views/HomeView.vue -->
<template>
  <div class="home-container">

    <div class="header">
      <h2>Welcome Home Ya Golf'n Yinzer!</h2>
    </div>

<div class="row">
  <div class="left-column">
    <h3 class="teeTimeTitle">Upcoming Tee Times:</h3>
    <TeeTimes v-for="(league, index) in $store.state.userLeagues" v-bind:key="index" :league="league" :users="$store.state.user.users"/>
  </div>

  <div class="center-column" v-if="$store.state.userLeagues.length > 0">
    <LeaderBoard v-for="(league, index) in $store.state.userLeagues" v-bind:key="index" :league="league" :users="$store.state.user.users" />

  </div>
  
  <div class="right-column">
    <LeagueOrganizerSelector></LeagueOrganizerSelector>
    <NewLeagueCreator></NewLeagueCreator>
  </div>
</div>
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
      teeTimes: [],
      users: [],
      leagues: [],
      newLeague: {
        name: '',
      }
    };
  },
};
</script> 

<style scoped>
* {
  box-sizing: border-box;
}

.header {
  padding: 30px;
  text-align: center;
  font-size: 35px;
}

h3 {
  font-weight: bold;
  font-size: large;
  text-decoration-line: underline;
}

h2 {
  color: #093708;
}

.row {
  display: -webkit-flex;
  display: flex;
  padding: 10px;
  height: 75%;
}

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
   -webkit-flex: 1;
   -ms-flex: 1;
   flex: .75;
   border-radius: 15px;
   margin: .5rem;
   background-color: darkkhaki;
   opacity: .9;
   padding: 1rem;
   height: auto;
   overflow: scroll;
}

.center-column {
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
  overflow: scroll;
}

.left-column::-webkit-scrollbar,
.center-column::-webkit-scrollbar {
  width: 15px;
}
.left-column::-webkit-scrollbar-thumb {
  background-color: darkkhaki;
}
.center-column::-webkit-scrollbar-thumb {
  background-color: #093708;
  border-radius: 4px;
}
.left-column::-webkit-scrollbar-corner,
.center-column::-webkit-scrollbar-corner {
  display: none;
}

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