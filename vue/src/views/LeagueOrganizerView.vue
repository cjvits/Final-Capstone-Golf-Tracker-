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
                <!-- <LeaderBoard></LeaderBoard> -->
                <LeaderBoard v-for="(league, index) in leagues" v-bind:key="index" :league="league" :users="$store.state.league.id" />
                

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

export default {
    components: {
        Golfers,
        NewMatchForm,
        UpdateScore,
        LeaderBoard,
    },
    data() {
        return {
            // isLeagueOrganizer: false
            leagues: [{
                
            }]
        }
    },

    

    // computed: {


    //     togglePage() {
    //       if (this.user.id === league.leagueCoordinatorId) {
    //         return isLeagueOrganizer = true;
    //       }
    //       return 'Become a League Organizer';
    //     },
    //   },

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

        LeagueService
            .getAllGolfers()
            .then((response) => this.matches = response.data)
        }

}
</script>

<style scoped>
* {
    box-sizing: border-box;
}
.page-container {
    background-image: url("../assets/goldenGolf.jpeg");
    background-color: #312917;
    height: 100vh;
    background-size: 100%;
    background-repeat: no-repeat;
    background-position: center;
    font-family: 'Hedvig Letters Serif', serif;
    color: #093708;
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
    padding-top: 3rem;
    background-image: url("../assets/goldenGolf.jpeg");
    height: 100vh;
    background-size: 100%;
    background-repeat: no-repeat;
    background-position: center;
    font-family: 'Hedvig Letters Serif', serif;
    color: #093708;
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

/* Responsive layout - makes the three columns stack on top of each other instead of next to each other */
@media (max-width: 600px) {
  .row {
    -webkit-flex-direction: column;
    flex-direction: column;
  }
}
</style>