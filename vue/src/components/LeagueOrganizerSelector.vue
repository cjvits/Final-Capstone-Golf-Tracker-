<template>
    <div>
        <a href class="league-organizer-link" v-on:click.prevent="isFormShowing = !isFormShowing">
            {{ isFormShowing ? "Not a League Organizer" : "View Leagues that I Coordinate" }}
        </a>

        <form class="league-selector" v-show="isFormShowing" v-on:submit.prevent=this.$router.push(this.leagueId)> <!-- link might not work -->
            <div class="form-input-group">
                <label for="myLeague">Select League:</label>
                <select id="myLeague" v-model="league.leagueId">
                    <option :value="league.leagueId" v-for="league in leagues" :key="league.leagueId">{{ league.leagueName }}</option>
                </select>
            </div>
            <button class="submitBtn" type="submit">go to league</button>
        </form>
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
            .getLeaguesByCoordinatorId(this.$store.userId)
            .then((response) => this.leagues = response.data);

    }
}


</script>

<style scoped>
.league-organizer-link {
  color: #093708;
  justify-self: center;
  padding: 2rem;
}

.league-organizer-link:hover {
  color: #116110;
  text-decoration-line: underline;
}
</style>