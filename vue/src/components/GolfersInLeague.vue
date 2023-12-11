<template>
    <option v-for="user in users" :key="user.id">{{ user.firstName }} {{ user.lastName }}
    </option>
    

</template>

<script>
import LeagueService from '../services/LeagueService.js';

export default {
    data() {
        return{
             users: []  
        }
    },

    created() {
        LeagueService
            .getLeagueGolfers(this.$route.params.leagueId)
            .then((response) => this.users = response.data)
    }
}


</script>