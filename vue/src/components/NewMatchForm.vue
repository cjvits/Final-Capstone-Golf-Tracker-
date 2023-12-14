<template>
    <button v-on:click.prevent="isFormShowing = !isFormShowing">
        {{ isFormShowing ? "Hide Form" : "Create a new match" }}
    </button>

    <section id="button" class="golfers-to-add" v-if=isFormShowing>
        <form class="new-match-form" v-on:submit.prevent="createMatch">

            <div class="form-input-group">
                <label for="match-date">Match Date: </label>
                <input type="date" id="match-date" v-model="match.teeDate" />
            </div>
            <div class="form-input-group">
                <label for="match-time">Match Time: </label>
                <input type="time" id="match-time" v-model="match.teeTime" required autofocus />
            </div>
            
            <h1>Add some yinzers to your match:</h1>

            <div class="all-possible-golfers">
                <label for="golfer1">Add Yinzer1: </label>
                <select id="match-golfer1" v-model="selectedGolfer1">
                    <GolfersInLeague />
                </select>
            </div>

            <div class="all-possible-golfers">
                <label for="golfer2">Add Yinzer2: </label>
                <select id="match-golfer2" v-model="selectedGolfer2">
                    <GolfersInLeague />
                </select>
            </div>

            <button class="submitBtn" type="submit">Create Match</button>

        </form>

    </section>

</template>

        
<script>
import GolfersInLeague from './GolfersInLeague.vue';
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
            selectedGolfer1: null,
            selectedGolfer2: null,

            match: {
                player1: '',
                player2: '',
                teeDate: '',
                teeTime: '',
            },
        }
    },
    components: {
        GolfersInLeague,
    },

    methods: {
        createMatch() {
            this.match.matchLeague = this.currentLeague;

            const dto = {
                match: this.match,
                playersInMatch: [this.selectedGolfer1, this.selectedGolfer2]
            };

            LeagueService
                .createMatch(dto)
                .then((response) => {
                    if (response.status == 201) {
                        this.$store.commit('ADD_MATCH_TO_LEAGUE', dto.match);
                        this.match = response.data;
                        location.reload();
                    }
                })
                .catch((error) => {
                    const response = error.response;
                    this.registrationErrors = true;
                    if (response.status === 400) {
                        this.registrationErrorMsg = 'Bad Request: Validation Errors';
                    }
                });
        },

    },
    computed: {
        currentLeague() {
            return this.$store.state.userLeagues.find((item) => { return item.leagueId == this.$route.params.leagueId })
        }
    },
    created() {
        LeagueService
            .getLeagueGolfers(this.$route.params.leagueId)
            .then((response) => this.users = response.data)
    }

}
</script>

<style scoped>
.new-course-maker {
    background-color: darkkhaki;
}
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