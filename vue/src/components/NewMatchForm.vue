<template>
    
        <button v-on:click.prevent="isFormShowing = !isFormShowing">
            {{ isFormShowing ? "Hide Form" : "Create a new match" }}
        </button>

        <section class="golfers-to-add" v-if=isFormShowing>
        <form class="new-match-form" v-on:submit.prevent="addGolfer">
            <h1>Add some yinzers to your match:</h1>

            <div class="all-possible-golfers">
                <label for="golfer1">Add Yinzer1: </label>
                <select id="match-golfer1" v-model="selectedGolfer1">
                    <option :value="user.id" v-for="user in users" :key="user.id">{{ user.firstName + " " + user.lastName }}</option>
                </select>
            </div>
            <div class="all-possible-golfers">
                <label for="golfer2">Add Yinzer2: </label>
                <select id="match-golfer2" v-model="selectedGolfer2">
                    <option :value="user.id" v-for="user in users" :key="user.id">{{ user.firstName + " " + user.lastName }}</option>
                </select>
            </div>
            <div class="form-input-group">
                <label for="match-date">Match Date: </label>
                <input type="date" id="match-date" v-model="match.date"  />
            </div>
            <div class="form-input-group">
                <label for="match-time">Match Time: </label>
                <input type="time" id="match-time" v-model="match.time" required autofocus />
            </div>

            <button class="submitBtn" type="submit">add yinzer(s) to match</button>
        
        </form>
     

    </section>
    <section class="golfers-in-league" v-else>
        <GolfersInLeague></GolfersInLeague>
    </section>
</template>

        
<script>
// import CourseService from '../services/CourseService.js'
import LeagueService from '../services/LeagueService.js';
import GolfersInLeague from './GolfersInLeague.vue';

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
            selectedGolfer1: null,
            selectedGolfer2: null,
            match: {
                id: 0,
                date: null,
                time: null,
            
            },
            users: [],

            user: {
                id: 0,
                firstName: '',
                lastName: '',
            }
        }
    },
         components: {
        GolfersInLeague,
    },

        methods: {
        addGolfer() {
            LeagueService
            .addGolferToMatch(this.$route.params.matchId, this.user.id, this.teeDate, this.teeTime)
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