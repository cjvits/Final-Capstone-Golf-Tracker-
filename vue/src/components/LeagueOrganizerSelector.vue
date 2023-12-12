<template>
    <h1>Leagues I Coordinate:</h1>
    <div v-for="league in leagues" :key="league.leagueId">  
        <router-link class="league-organizer-link" v-bind:to="{ name:'league-organizer', params: { leagueId: league.leagueId}}">
        {{ league.leagueName }}
        </router-link>
    </div>
</template>

<script>
import LeagueService from '../services/LeagueService';

export default {
    data (){
    
        return{
            isFormShowing: false,
            
            league: {
                leagueId: 0,
                leagueName: ''
        },

        leagues: []
        }
       
    },

    created () {
        LeagueService
            .getLeaguesByCoordinatorId(this.$store.state.user.id)
            .then((response) => {this.leagues = response.data; this.$store.commit("SET_LEAGUES",response.data)});

    }
}


</script>

<style scoped>
h1{
    text-decoration-line: underline;
    font-weight: bold;
    font-size: large;
}

.league-organizer-link {
  color: #093708;
  justify-self: center;
  margin-top: 4em;
}

.league-organizer-link:hover {
  color: #116110;
  text-decoration-line: underline;
}
</style>