<template>
    <div>
        <form class="new-match-maker" v-on:submit.prevent="createNewMatch">
            <h1>Create a New Match</h1>

            <div class="form-input-group">
                <label for="select-league">Select a League</label>
                <input type="text" id="select-league" v-model="course.streetAddress" required autofocus />
            </div>

            <div class="form-input-group">
                <label for="match-players">New Match Players</label>
                <input type="text" id="match-player-names" v-model="course.courseName" required autofocus />
            </div>

            <div class="form-input-group">
                <label for="match-date">New Match Date</label>
                <input type="text" id="match-date" v-model="course.streetAddress" required autofocus />
            </div>

            <div class="form-input-group">
                <label for="match-time">New Match Time</label>
                <input type="text" id="match-time" v-model="course.streetAddress" required autofocus />
            </div>

            

            <button class="submitBtn" type="submit">create new match</button>
        </form>
    </div>
</template>


<script>
// import CourseService from '../services/CourseService.js'
import LeagueService from '../services/LeagueService.js';

export default {
    props: {
        league: {
            type: Object,
            required: false,
        }
    },
    data () {
        return {
            match: {
                league: '',
                players: '',
                date: '',
                time: '',
            }
        }
    },

}
</script>

<style scoped>
.new-course-maker {
    background-color: darkkhaki;
}
</style>