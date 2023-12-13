<template>
    <button v-on:click.prevent="isFormShowing = !isFormShowing">
        {{ isFormShowing ? "Hide Form" : "Create a new match" }}
    </button>

    <section class="golfers-to-add" v-if=isFormShowing>
        <form class="new-match-form" v-on:submit.prevent="createMatch">

            <div class="form-input-group">
                <label for="match-date">Match Date: </label>
                <input type="date" id="match-date" v-model="match.teeDate" />
            </div>
            <div class="form-input-group">
                <label for="match-time">Match Time: </label>
                <input type="time" id="match-time" v-model="match.teeTime" required autofocus />
            </div>

            <h1>Add some yinzers to your match:</h1>

            <div class="all-possible-golfers">
                <label for="golfer1">Add Yinzer1: </label>
                <select id="match-golfer1" v-model="selectedGolfer1">
                    <option :value="user.id" v-for="user in users" :key="user.id">{{ user.firstName + " " + user.lastName }}
                    </option>
                </select>
            </div>

            <div class="all-possible-golfers">
                <label for="golfer2">Add Yinzer2: </label>
                <select id="match-golfer2" v-model="selectedGolfer2">
                    <option :value="user.id" v-for="user in users" :key="user.id">{{ user.firstName + " " + user.lastName }}
                    </option>
                </select>
            </div>

            <button class="submitBtn" type="submit">Create Match</button>

        </form>

        <!-- <form class="new-match-form" v-on:submit.prevent="updateUsersInMatch">



            <button class="submitBtn" type="submit">Add Yinzers to Match</button>

        </form> -->


    </section>
    <section class="golfers-in-league" v-else>
        <GolfersInLeague></GolfersInLeague>
    </section>
</template>

        
<script>
// import CourseService from '../services/CourseService.js'
import GolfersInLeague from './GolfersInLeague.vue';
import LeagueService from '../services/LeagueService';

export default {
    props: {
        league: {
            type: Object,
            required: false,
        }
    },
    data() {
        return {
            isFormShowing: false,
            selectedGolfer1: null,
            selectedGolfer2: null,
            match: {
                leagueName: '', // will need to change to leagueID on the front
                player1: '',
                player2: '',
                teeDate: '',
                teeTime: '',
            },
        }
    },
    components: {
        GolfersInLeague,
    },

    methods: {
        createMatch() {
            // this.match.leagueName = this.currentLeague.leagueName;
            // this.match.leagueId = this.currentLeague.leagueId;
            this.match.matchLeague = this.currentLeague;

            const dto = {
                match: this.match,
                playersInMatch: [this.selectedGolfer1, this.selectedGolfer2]
            };

            LeagueService
                .createMatch(dto)
                .then((response) => {
                    if (response.status == 201) {
                        this.$store.commit('ADD_MATCH_TO_LEAGUE', dto.match);
                        this.match = response.data;

                        // this.$router.push({
                        //     path: '/league-organizer',
                        //     params: {leagueId: this.currentLeague.leagueId},
                        //     query: { registration: 'success' },
                        // });
                    }
                })
                .catch((error) => {
                    const response = error.response;
                    this.registrationErrors = true;
                    if (response.status === 400) {
                        this.registrationErrorMsg = 'Bad Request: Validation Errors';
                    }
                });
        },
        // updateUsersInMatch(){
        //     LeagueService
        //         .addUserToMatch(this.user.id, this.match.id)
        //         .then((response) => {
        //         if (response.status == 201) {
        //             this.$router.push({
        //                     path: '/league-organizer',
        //                     query: { registration: 'success' },
        //                 });
        //              }
        //         })
        //         .catch((error) => {
        //             const response = error.response;
        //             this.registrationErrors = true;
        //             if (response.status === 400) {
        //                 this.registrationErrorMsg = 'Bad Request: Validation Errors';
        //             }
        //         });
        //     }
    },
    computed: {
        currentLeague() {
            return this.$store.state.userLeagues.find((item) => { return item.leagueId == this.$route.params.leagueId })
        }
    },
    created() {
        LeagueService
            .getLeagueGolfers(this.$route.params.leagueId)
            .then((response) => this.users = response.data)
    }

}
</script>

<style scoped>
.new-course-maker {
    background-color: darkkhaki;
}
</style>