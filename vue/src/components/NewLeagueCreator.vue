<template>
    <div>
        <button v-on:click.prevent="isFormShowing = !isFormShowing">
            {{ isFormShowing ? "Hide Form" : "Become a League Organizer!" }}
        </button>

        <form class="new-league-maker" v-show="isFormShowing" v-on:submit.prevent="createNewLeague">
            <h1>Create a New League</h1>

            <div class="form-input-group">
                <label for="league-name">New League Name</label>
                <input type="text" id="league-name" v-model="league.leagueName" required autofocus />
            </div>

            <div class="form-input-group">
                <label for="course">Select League Golf Course:</label>
                <select id="course" v-model="league.leagueCourseId">
                    <option :value="course.courseId" v-for="course in courses" :key="course.courseId">{{ course.courseName }}</option>
                </select>
            </div>

            <button class="submitBtn" type="submit">create new league</button>
        </form>
    </div>
</template>

<script>
import leagueService from '../services/LeagueService.js';

export default {
    data() {
        return {
            isFormShowing: false,
            league: {
                leagueName: '',
                leagueCoordinatorId: this.$store.state.user.id,
                leagueCourseName: '',
                leagueCourseId: 0, 
            },

            courses: [],
        }
    },

    methods: {
        createNewLeague() {
            leagueService
                .newLeague(this.league)
                .then((response) => {
                    if (response.status == 201) {
                        this.$router.push({
                            path: '/league-organizer',
                            query: { registration: 'success' },
                        });
                    }
                })
                .catch((error) => {
                    const response = error.response;
                    this.registrationErrors = true;
                    if (response.status === 400) {
                        this.registrationErrorMsg = 'Bad Request: Validation Errors';
                    }
                });
        }
    },
    created() {

        leagueService
            .getAllCourses()
            .then((response) => this.courses = response.data)
    }
}


</script>

<style scoped>
.new-league-maker {
    background-color: darkkhaki;
}

button {
    background-color: #093708;
    color: darkkhaki;
    border-radius: .5em;
    padding: .5em;
    margin: .5em;
    font-family: 'Hedvig Letters Serif', serif;
}

button:hover {
    background-color: #116110;
    color: wheat;
}
</style>