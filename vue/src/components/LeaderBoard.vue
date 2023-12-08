<template>
    <div>
        <h2>Leaderboard</h2>
        <table>
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
                    <td>{{ user.firstName }}</td>
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
    border: 1px solid #ddd;
    padding: 8px;
    text-align: left;
}

th {
    background-color: #f2f2f2;
}
</style>