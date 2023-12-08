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
                <select id="course" v-model="league.leagueCourse">
                    <option value="1">Test Data Course 1</option>
                    <option value="2">Test Data Course 2</option>
                    <option value="3">Test Data Course 3</option>
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
                leagueCourse: '',
                leagueOrganizer: this.user // HOW DO YOU MAKE THIS THE PERSON SUBMITTING THE FORM?
            },
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
}


</script>

<style scoped>
.new-league-maker {
    background-color: darkkhaki;
}
</style>