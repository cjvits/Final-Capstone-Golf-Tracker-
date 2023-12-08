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

    </div>
</template>

<script>
import NewLeagueCreator from '../components/NewLeagueCreator.vue';
// import LeagueService from '../services/LeagueService';

export default {
    data() {
        return {
            // isLeagueOrganizer: false
        }
    },

    // components: {
        // NewLeagueCreator,
    // },

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
        showNewLeagueCreator () {
            NewLeagueCreator;
        }
    }
}
</script>

<style scoped>
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
</style>