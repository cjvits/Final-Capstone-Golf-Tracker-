<template>
    <option v-for="user in users" :key="user.id">{{ user.username }}>
    </option>
    

</template>

<script>
import LeagueService from '../services/LeagueService.js';

export default {
    // data() {
    //     users: []
    // },

    created() {
        LeagueService
            .getLeagueGolfers(this.leagueId)
            .then((response) => this.users = response.data)
    }
}


</script>