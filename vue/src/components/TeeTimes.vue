<template>
    <div class="tee" v-for="teeTime in teeTimes" v-bind:key="teeTime.id">
        <h2>Upcoming tee times</h2>
        <div class="time">
            {{ teeTime.time }}
            <!-- This is where the Time goes -->
        </div>

        <div class="date">
            <!-- This is where the date goes -->
            {{ teeTime.date }}
        </div>

        <div class="user" v-for="user in users" v-bind:key="user.id">
            {{ user.username }}
            <!-- This is where the username goes -->
        </div>
        <div v-if="loading" class="loading-message">Loading tee times...</div>
    </div>
</template>

<script>
import LeagueService from '@/services/LeagueService';


export default {
  props: {
    teeTimes: {
      type: Array,
      required: true,
    },
  },
  data() {
    return {
        teeTime: [],
        loading: true, // loading state
    };
  },
  async mounted() {
    try {
      // Fetch tee time data from backend
      //INSTEAD OF CALLING THE METHOD we have all the league data in HOME VIEW we need to prop it over to TeeTimes
      const response = await LeagueService.getLeagueMatchesByUserId(this.userId);
      this.teeTime = response.data;
    } catch (error) {
        console.error("Error fetching tee time:", error);
    }
  },

};
</script>

<style scoped>

</style>
