
<!-- THE GOLFER COMPONENT WILL BE USED FOR A LEAGUE ORGANIZER TO SELECT GOLFERS FOR THEIR LEAGUE -->

<template>
    <button v-on:click.prevent="isLeagueInProgress = !isLeagueInProgress">
        {{ isLeagueInProgress ? "start league now!" : "add more yinzers" }}
    </button>
    <section class="golfers-to-add" v-if=isLeagueInProgress>
        <form class="new-member-form" v-on:submit.prevent="addGolfer">
            <h1>Add some yinzers to your new league:</h1>

            <div class="all-possible-golfers">
                <label for="golfers">add a yinzer:</label>
                <select id="league-golfer" v-model="user.id">
                    <option :value="user.id" v-for="user in users" :key="user.id">{{ user.firstName + user.lastname }}</option>
                </select>
            </div>

            <button class="submitBtn" type="submit">add yinzer to league</button>
        
        </form>
     

    </section>

    <section class="golfers-in-league" v-else>
        <GolfersInLeague></GolfersInLeague>
    </section>
</template>

<script>
import LeagueService from '../services/LeagueService.js';
import GolfersInLeague from './GolfersInLeague.vue';

export default {
    data() {
        return {
            isLeagueInProgress: false,
            users: [],

            user: {
                id: 0,
                firstName: '',
                lastName: '',
                email:'',
                username: ''
            }
        }
    },

    components: {
        GolfersInLeague,
    },

    methods: {
        changeLeagueProgress() {
            this.isLeagueInProgress = !this.isLeagueInProgress
        },

        addGolfer() {
            LeagueService
                .addGolferToLeague(this.league.id, this.user.id)
                .then((response) => {
                    if (response.status == 201) {
                        this.$router.push({
                            path: '/league-organizer/',
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
            .then((response) => this.users = response.data);
    }
}


</script>

<style>
/* style to display a golfer */
</style>