<template>
    <div>
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
            </div>

            <div class="form-input-group">
                <label for="course">Select League Golf Course:</label>
                <select id="course" v-model="league.leagueCourseId">
                    <option :value="course.courseId" v-for="course in courses" :key="course.courseId">{{ course.courseName }}</option>
                </select>
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
            // score: {
            //     match: this.$store.state.match,
            //     player1: '',
            //     player2: '',

            // }
        }
    },
    // methods: {
    //     updateScore() {
    //         LeagueService
    //         .updateScore(this.match)
    //         .then((response) => {
    //                 if (response.status == 201) {
    //                     this.$router.push({
    //                         path: '/league-organizer',
    //                         query: { registration: 'success' },
    //                     });
    //                 }
    //             })
    //             .catch((error) => {
    //                 const response = error.response;
    //                 this.registrationErrors = true;
    //                 if (response.status === 400) {
    //                     this.registrationErrorMsg = 'Bad Request: Validation Errors';
    //                 }
    //             });
    //         }
    //     },
    //     created() {

    //     LeagueService
    //         .getAllGolfers()
    //         .then((response) => this.matches = response.data)
    //     }

}

</script>

