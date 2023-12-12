<template>
    <div class="organizer-page-container">
        <div class="header">
            <h2>Yinzer League Organizer</h2>
        </div>

        <div class="row">
            <div class="left-column">
                <h3>Update Yinzer Scores</h3>
                <NewMatchForm></NewMatchForm>
                <UpdateScore></UpdateScore>
                <ul>
                    <li>Will list Matches from league</li>
                    <li>LO will be able to click a button per match to add scores</li>
                    <li>Will update </li>
                </ul>
            </div>

            <div class="center-column">
                INSERT LEAGUE LEADER BOARD:
                Since we are currently getting the boards by user, this won't work. 
                We could get the board by league for this one. It's also not necessary.
                <LeaderBoard></LeaderBoard>
                <!-- <LeaderBoard v-for="(league, index) in leagues" v-bind:key="index" :league="league" :users="$store.state.league.id" /> -->
                

            </div>

            <div class="right-column">
            
                <Golfers />
            </div>
        </div>
    </div>
</template>

<script>
import LeagueService from '../services/LeagueService.js';
import LeaderBoard from '../components/LeaderBoard.vue';
import Golfers from '../components/Golfers.vue';
import NewMatchForm from '../components/NewMatchForm.vue'
import UpdateScore from '../components/UpdateScore.vue';
import GolfersInLeague from '../components/GolfersInLeague.vue'
// import { BIconUiChecksGrid } from 'bootstrap-vue';

export default {
    components: {
        Golfers,
        NewMatchForm,
        UpdateScore,
        // LeaderBoard,
    },
    data() {
        return {
            league: {}
            // isLeagueOrganizer: false,
            // leagues: [{
                
            // }]
        };
    },


    computed: {

    //     togglePage() {
    //       if (this.user.id === this.league.leagueCoordinatorId) {
    //         return this.isLeagueOrganizer;
    //       }
    //       return 'Become a League Organizer';
    //     },
    //   },
    
        isLeagueOrganizer() {
            return this.user.id === this.league?.leagueCoordinatorId;
        },
    },

    methods: {

        createNewMatch() {
            LeagueService
            .createMatch(this.match)
            .then((response) => {
                    if (response.status == 201) {
                        this.$router.push({
                            path: '/league-organizer',
                            query: { registration: 'success' },
                        });
                    }
                })
                .catch((error) => {
                    const response = error.response;
                    this.registrationErrors = true;
                    if (response.status === 400) {
                        this.registrationErrorMsg = 'Bad Request: Validation Errors';
                    }
                });
        }
    },
        
   created() {
    // Fetch all leagues associated with the coordinator's ID
    LeagueService
        .getLeaguesByCoordinatorId(this.$store.state.user.id)
        .then((response) => {
            // Find the league with the matching league ID
            const league = response.data.find(league => league.leagueId == this.$route.params.leagueId);

            if (league) {
                // Check if the user is the coordinator of the found league
                if (league.coordinatorId == this.$store.state.user.id) { // Use loose comparison (==) here
                    // Allow access because the user is the coordinator of the league
                    this.league = league;

                    // You can also load the golfers or perform other actions here
                } else {
                    // If the user is not the coordinator, redirect to access denied
                    this.$router.push('/access-denied');
                }
            } else {
                // If the league with the specified ID doesn't exist, redirect to access denied
                this.$router.push('/access-denied');
            }
        })
        .catch((error) => {
            if (error.response.status === 403) {
                this.$router.push('/access-denied');
            }
        });
},
};
</script>

<style scoped>
    * {
        box-sizing: border-box;
    }  
    .page-container {
        padding-top: 15%;
        background-image: url("../assets/goldenGolf.jpeg");
        background-color: #312917;
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
        align-items: stretch;
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
        height: 75%;
    }

    /* Left and right column */
    .right-column {
        -webkit-flex: 1;
        -ms-flex: 1;
        flex: 1;
        border-radius: 15px;
        margin: .5rem;
        background-color: darkkhaki;
        opacity: .9;
        overflow: scroll;
    }

    .left-column {
        -webkit-flex: 1;
        -ms-flex: 1;
        flex: 1;
        border-radius: 15px;
        margin: .5rem;
        background-color: darkkhaki;
        opacity: .9;
        overflow: scroll;
    }

    .center-column {
        -webkit-flex: 2;
        -ms-flex: 2;
        flex: 1.25;
        border-radius: 15px;
        margin: .5rem;
        background-color: #093708;
        opacity: .9;
        color: darkkhaki;
        overflow: scroll;
    }
    .left-column::-webkit-scrollbar,
    .right-column::-webkit-scrollbar,
    .center-column::-webkit-scrollbar {
        width: 15px;
    }
    .left-column::-webkit-scrollbar-thumb,
    .right-column::-webkit-scrollbar-thumb{
        background-color: darkkhaki;
        border-radius: 15px;
    }
    .center-column::-webkit-scrollbar-thumb {
        background-color: #093708;
        border-radius: 15px;
    }
    .left-column::-webkit-scrollbar-corner,
    .right-column::-webkit-scrollbar-corner,
    .center-column::-webkit-scrollbar-corner {
        display: none;
    }
</style>