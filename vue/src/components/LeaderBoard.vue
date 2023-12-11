<template>
    <div>
        <h2 class="leaderboard-title">Leaderboard for {{ league.leagueName }}</h2>
        <table class="leaderboard-table">
            <thead>
                <tr>
                    <th>Rank</th>
                    <th>Name</th>
                    <th>Score</th>
                    <th>Handicap</th>
                    <th>Course</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="(user, index) in league.golfersInLeague" :key="index" >
                    <td>{{ index + 1 }}</td>
                    <td>{{ user.username }}</td>
                    <td>{{ user.leagueScore }}</td>
                    <td>{{ user.handicap }}</td>
                    <td>{{ league.course?.courseName }}</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
    data(){
        return {
            // leaderBoard: [],

        }
    },

    props: {
        users: {
            type: Array,
            required: true,
        },
        league: {
            type: Object,
            required: true,
        }
    },
    computed: {
        ...mapState(['user']),
        // sortedUsers() {
        //     // Sort users by score in descending order
        //     return this.users.slice().sort((a, b) => b.score - a.score);
        //     // LeagueService
        //     //     .getLeaderBoard(this.$route.params.leagueId)
        //     //     .then(response => {
        //     //         this.card = response.data;
        //     //     });
        //     //issue with the route with needing the league ID with HOME
        // },
    },
    
};
</script>

<style scoped>

table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
}

th, td {
    border: 1px solid wheat;
    padding: 8px;
    text-align: left;
}

th {
    background-color: wheat;
}

/* .leaderboard-title {
    font-size: 1.5em;
    color: #607e1b;
    margin-bottom: 10px;
}

.leaderboard-table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
}

.leaderboard-table th, leaderboard-table td {
    border: 1px solid #ddd;
    padding: 10px;
    text-align: left;
}

.leaderboard-table th {
    background-color: rgb(251, 210, 157);
} */

</style>