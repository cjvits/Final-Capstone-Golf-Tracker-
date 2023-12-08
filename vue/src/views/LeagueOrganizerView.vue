<!-- TODO: form for updating scores

TODO: form for inviting golfers to league

TODO: form for setting matches/tee-times -->

<template>
    <!--  IF YOU ARE NOT A LEAGUE ORGANIZER AND YOU GET TO THIS PAGE -->
    <!-- <div class="page-container" v-if="!isLeagueOrganizer">
        <div class="info">
            <h1>Become a League Organizer</h1>
            <h2>A League Organizer takes on the responsibility to coordinate & update a specific league.</h2>
            <h3>As a league organizer, you will:</h3>
            <ul>
                <li>Choose the course the course for the league</li>
                <li>Invite golfers into your league</li>
                <li>Set up tee-times & matches for golfers in your league</li>
                <li>Update individual scores after each day of league play</li>
            </ul>
        </div>
        <NewLeagueCreator></NewLeagueCreator>
    </div> -->

    <!-- IF YOU ARE A LEAGUE ORGANIZER -->
    <div class="organizer-page-container">
        <div class="header">
            <h2>Yinzer League Organizer</h2>
        </div>

        <div class="row">
            <div class="left-column">
                <h3>Update Yinzer Scores</h3>
         
            </div>

            <div class="center-column">
                INSERT LEAGUE LEADER BOARD:
                Since we are currently getting the boards by user, this won't work. 
                We could get the board by league for this one. It's also not necessary.
                <!-- <LeaderBoard></LeaderBoard> -->

            </div>

            <div class="right-column">
                <h3>Add Yinzers to League</h3>
                OR
                <h3>League Yinzers</h3>
                <Golfers />
            </div>
        </div>
    </div>
</template>

<script>
// import NewLeagueCreator from '../components/NewLeagueCreator.vue';
// import LeagueService from '../services/LeagueService.js';
// import LeaderBoard from '../components/LeaderBoard.vue';
import Golfers from '../components/Golfers.vue';

export default {
    data() {
        return {
            // isLeagueOrganizer: false
        }
    },

    components: {
        Golfers,
        // LeaderBoard,
    // NewLeagueCreator,
    },

    // computed: {

    // getShowHideFormText() {
    //   if (this.isFormShowing) {
    //     return 'Hide Form';
    //   }
    //   return 'Become a League Organizer';
    // },

    //     togglePage() {
    //       if (this.user.id === leagueCoordinator.id) {
    //         return isLeagueOrganizer = true;
    //       }
    //       return 'Become a League Organizer';
    //     },
    //   },

    methods: {

    }
}
</script>

<style scoped>
* {
    box-sizing: border-box;
}
.page-container {
    padding-top: 15%;
    background-image: url("../assets/goldenGolf.jpeg");
    height: 100vh;
    background-size: 100%;
    background-repeat: no-repeat;
    background-position: center;
    font-family: 'Hedvig Letters Serif', serif;
    color: #06612f;
    font-weight: 600;
    text-align: center;
}

.info {
    background-color: darkkhaki;
    opacity: .85;
}

h2 {
    background-color: darkkhaki;
}

.organizer-page-container {
    padding-top: 15%;
    background-image: url("../assets/goldenGolf.jpeg");
    height: 100vh;
    background-size: 100%;
    background-repeat: no-repeat;
    background-position: center;
    font-family: 'Hedvig Letters Serif', serif;
    color: #06612f;
    font-weight: 600;
    text-align: center;
}

/* Style the header */
.header {
    padding: 30px;
    text-align: center;
    font-size: 35px;
}
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
    flex: 1;
    border-radius: 15px;
    margin: .5rem;
    background-color: darkkhaki;
    opacity: .8;
}

.left-column {
    -webkit-flex: 1;
    -ms-flex: 1;
    flex: 1;
    border-radius: 15px;
    margin: .5rem;
    background-color: darkkhaki;
    opacity: .8;
}

.center-column {
  -webkit-flex: 2;
  -ms-flex: 2;
  flex: 1.25;
  border-radius: 15px;
  margin: .5rem;
  background-color: #093708;
  opacity: .8;
  color: darkkhaki;
}
</style>