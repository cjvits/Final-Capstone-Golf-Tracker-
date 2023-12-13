<template>
    <div id="button">
        <button v-on:click.prevent="isFormShowing = !isFormShowing">
            {{ isFormShowing ? "Hide Form" : "Update Score" }}
        </button>

        <form class="update-score" v-show="isFormShowing" v-on:submit.prevent="updateScore">
            <h1>Update player scores</h1>

            <!-- <div class="form-input-group">
                <label for="player1-score">Golfer1 score</label>
                <input type="int" id="player1-score" v-model="match.golfers" required autofocus />
            </div> -->

            <!-- <div class="form-input-group">
                <label for="player2-score">Golfer2 score</label>
                <input type="int" id="player2-score" v-model="match.golfers" required autofocus />
            </div> -->

            <!-- <div class="form-input-group">
                <label for="league-name">New League Name</label>
                <input type="text" id="league-name" v-model="league.username" required autofocus />
            </div> -->

    

           <button class="submitBtn" type="submit">Make it so!</button> 
        </form>
    </div>
</template>

<script>
import LeagueService from '../services/LeagueService';


export default {
    props: {
        league: {
            type: Object,
            required: false,
        }
    },
    data() {
        return {
            isFormShowing: false,
            score: {
                match: this.$store.state.match,
                player1: '',
                player2: '',
                player1Score: 0,
                player2Score: 0

            }
        }
    },
    methods: {
        updateScore() {
            LeagueService
            .updateScore(this.match)
            .then((response) => {
                
                    // unsure what to put here for now
            })
            .catch((error) => {
             const response = error.response;
                 this.registrationErrors = true;
                if (response.status === 400) {
                    this.registrationErrorMsg = 'Bad Request: Validation Errors';
                }
            });
            
        }  
    }    

}

</script>

<style>
    button {
    background-color: #093708;
    color: darkkhaki;
    border-radius: .5em;
    padding: .5em;
    margin: 1.5em;
    font-family: 'Hedvig Letters Serif', serif;
}

button:hover {
    background-color: #116110;
    color: wheat;
}
</style>
