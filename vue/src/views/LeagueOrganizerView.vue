<template>
    <div class="organizer-page-container">
        <div class="header">
            <h2>Yinzer League Organizer</h2>
        </div>

        <div class="row">
            <div class="left-column">
                <h3>Update Yinzer Scores</h3>
                <NewMatchForm></NewMatchForm>
                <MatchList></MatchList>
                <!-- <ul>
                    <li>Will list Matches from league</li>
                    <li>LO will be able to click a button per match to add scores</li>
                    <li>Will update </li>
                </ul> -->
            </div>

            <div class="center-column">
                <!-- INSERT LEAGUE LEADER BOARD:
                Since we are currently getting the boards by user, this won't work. 
                We could get the board by league for this one. It's also not necessary. -->
                <leader-board :league="leagueById" :users="$store.state.user.users" />
                

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
import MatchList from '../components/MatchList.vue';
// import { BIconUiChecksGrid } from 'bootstrap-vue';

export default {
    components: {
        Golfers,
        NewMatchForm,
        LeaderBoard,
        MatchList
    },
    data() {
        return {
            league: {},
            matches: []
        }
    },
    computed: {
        leagueById(){
            let leagueId = this.$route.params.leagueId;
            return this.$store.state.userLeagues.find((item) => {
                return item.leagueId == leagueId;
            })
        }
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
            // This is league data associated with the coordinator's ID
            // coordinator must be only one allowed to view page but it's all currently blocked
            LeagueService
                .getLeaguesByCoordinatorId(this.$store.state.user.id)
                .then((response) => {
                    // this should iterate through all of the leagues to match the league with the league ID
                    this.league = response.data.find(league => league.leagueId == this.$route.params.leagueId);
                    console.log(this.league)

                    // If the user is not the coordinator and is not part of the league, block access
                    if (!this.league) {
                        this.$router.push('/access-denied');
                    }
                })
                .catch((error) => {
                    if (error.response.status === 403) {
                        this.$router.push('/access-denied');
                    }
                });
            LeagueService
                .getAllMatches(this.$route.params.leagueId)
                .then((response) => {
                    this.$store.commit("SET_LEAGUE_MATCHES", response.data);
                    this.matches = response.data;
                });
            // here is where we need to call a GET ALL MATCHES method 
            // pulling all the matches from the backend

            // 
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

    h3 {
        padding-top: 20px;
        font-weight: bold;
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
        padding: 1rem;
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