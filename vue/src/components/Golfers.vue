
<!-- THE GOLFER COMPONENT WILL BE USED FOR A LEAGUE ORGANIZER TO SELECT GOLFERS FOR THEIR LEAGUE -->

<template>
        <button v-on:click.prevent="isLeagueInProgress = !isLeagueInProgress">
            {{ isLeagueInProgress ?  "start league now!" : "add more yinzers" }}
        </button>
    <section class="golfers-to-add" v-if=isLeagueInProgress>
        Add some yinzers to your new league:
        <ul>
            <li v-for="user in users" :key="user.id">
                {{ user.firstName }}
                {{ user.lastName }} :
                {{ user.email }}
                <label for="chk-to-add">add golfer?</label><input type="checkbox" id="chk-to-add"
                    v-bind:checked="addToLeague">
            </li>
        </ul>

    </section>

    <section class="golfers-in-league" v-else>
        <ul>
            <li>
                list of users in league
            </li>
        </ul>
    </section>
</template>

<script>
import LeagueService from '../services/LeagueService.js';

export default {
    data() {
        return {
            isLeagueInProgress: false,
            users: []
        }
    },

    components: {

    },

    computed: {

    },

    methods: {
        addToLeague(league) {
            this.$store.commit('ADD_TO_LEAGUE', this.user); //THIS METHOD IS INCOMPLETE IN THE STORE!! WON'T WORK UNTIL FINISHED  
        },

        changeLeagueProgress() {
            this.isLeagueInProgress = !this.isLeagueInProgress
        },
        // addGolfer(user) {
        //     LeagueService
        //         .
        // }
    },

    created() {
        LeagueService
            .getAllGolfers()
            .then((response) => this.users = response.data)
    }
}
</script>

<style>
/* style to display a golfer */
</style>