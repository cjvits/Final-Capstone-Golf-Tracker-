<template>
    <div>

        <button v-on:click.prevent="isFormShowing = !isFormShowing">
            {{ isFormShowing ? "Hide Form" : "Create a new match" }}
        </button>

        <form class="new-match-maker" v-show="isFormShowing" v-on:submit.prevent="createNewMatch">
            <h1>Create a New Match</h1>

            <div class="form-input-group">
                <label for="match-players">New Match Player1</label>
                <!-- <option v-for="user in users" :key="user.id">{{ user.username }}></option> -->
                <input type="text" id="match-player-names" v-model="match.player1" required autofocus />
            </div>

            <div class="form-input-group">
                <label for="match-players">New Match Player2</label>
                <input type="text" id="match-player-names" v-model="match.player2" required autofocus />
            </div>

            <div class="form-input-group">
                <label for="match-date">New Match Date</label>
                <input type="date" id="match-date" v-model="match.date" required autofocus />
            </div>

            <div class="form-input-group">
                <label for="match-time">New Match Time</label>
                <input type="time" id="match-time" v-model="match.time" required autofocus />
            </div>

            

            <button class="submitBtn" type="submit">create new match</button>
        </form>
    </div>
</template>


<script>
// import CourseService from '../services/CourseService.js'
import LeagueService from '../services/LeagueService.js';

export default {
    props: {
        league: {
            type: Object,
            required: false,
        }
    },
    data () {
        return {
            isFormShowing: false,
            match: {
                league: this.$store.state.league, // will need to change to leagueID on the front
                player1: '',
                player2: '',
                date: '',
                time: '',
            }
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

        LeagueService
            .getAllGolfers()
            .then((response) => this.matches = response.data)
        }

}
</script>

<style scoped>
.new-course-maker {
    background-color: darkkhaki;
}
</style>