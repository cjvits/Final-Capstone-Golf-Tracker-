
<!-- WE NEED TO DISPLAY ALL THE MATCHES FOR A LEAGUE -->
<template>
    <div class="match-info">
        <section class="match-container" v-for="match in $store.state.matches" :key="match.id">
              <h1>Match Number:  {{ match.matchId }} </h1> 
            <div v-for="golfer in match.golfers" :key="golfer.id">
                {{ golfer.username }} | 
                Score: {{ golfer.matchScore }}
                <div>
                    <button @click="editScore(golfer)">Edit Score</button>
                    <input type="text" v-model="scoreToUpdate" v-show="isEditingScore && golfer === editedGolfer">
                    <button v-show="isEditingScore && golfer === editedGolfer" @click="saveMatchScore(match, golfer)">Save</button>
                    {{ match.matchScore }}
                </div>
            </div>
        </section>
    </div>
</template>

<script>
import LeagueService from '../services/LeagueService.js';

export default {

    data() {
        return {
            matches: [],
            isEditingScore: false,
            scoreToUpdate: null,
            editedGolfer: null
        }
    },

    created() {
        this.loadMatches();
    },

    methods: {
        loadMatches() {
            LeagueService.getAllMatches(this.$route.params.leagueId)
                .then((response) => {
                    this.matches = response.data;
                });
        },

        editScore(golfer) {
            this.editedGolfer = golfer;
            this.scoreToUpdate = golfer.matchScore; 
            this.isEditingScore = true;
        },

        saveMatchScore(match, golfer) {
            LeagueService.updateScore(match.matchId, golfer.id, this.scoreToUpdate)
                .then(() => {
                    this.isEditingScore = false;
                    this.editedGolfer = null;
                    this.scoreToUpdate = null;
                    this.loadMatches(); 
                    location.reload();
                });
                
        }
    }

}

</script>

<style scoped>
.match-container {
    background-color: darkolivegreen;
    border-radius: 5%;
    margin-top: 1.25em;
    margin-left: 3em;
    margin-right: 2.5em;
    padding-top: 1em;
    font-size: medium;
    color: khaki;
    font-weight: 100;
}

h1{
    text-decoration-line: underline;
    font-size: large;
}
button{
    margin: 2%;
}
</style>

