<template>
  <div v-if="loading" class="loading-message">Loading tee times...</div>
    <div v-else class="tee" v-for="match in league.matchesInLeague" v-bind:key="match.id">
        <h2>{{ league.leagueName }}</h2>
        <div class="time">
            {{ match.teeTime }}
            <!-- This is where the Time goes -->
        </div>

        <div class="date">
            <!-- This is where the date goes -->
            {{ match.teeDate }}
        </div>

        <div class="user" v-for="user in users" v-bind:key="user.id">
            {{ user.username }}
            <!-- This is where the username goes -->
        </div>
        
    </div>
</template>

<script>
import LeagueService from '../services/LeagueService';


export default {
  props: {
    // teeTimes: {
    //   type: Array,
    //   required: true,
    // },
    league: {
      type: Object,
      required: false,
    }
  },
  data() {
    return {
        teeTime: [],
        loading: false, // loading state
    };
  },
  async mounted() {
    try {
      // Fetch tee time data from backend
      //INSTEAD OF CALLING THE METHOD we have all the league data in HOME VIEW we need to prop it over to TeeTimes
      //const response = await LeagueService.getLeagueMatchesByUserId(this.userId);
      //this.teeTime = response.data;
    } catch (error) {
        console.error("Error fetching tee time:", error);
    }
  },

};
</script>

<style scoped>

h2{
  font-weight: bold;
  padding-top: .8em;
}

</style>
