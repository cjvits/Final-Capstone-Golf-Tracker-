
<!-- THE GOLFER COMPONENT WILL BE USED FOR A LEAGUE ORGANIZER TO SELECT GOLFERS FOR THEIR LEAGUE -->

<template>
    <div class="container">

        <section class="golfers-to-add" v-if=isLeagueInProgress>

            <section class="invite-container">
                <p>wanna play with non-registered yinzers? copy the link below and send it to your yinzers, so they can
                    com'on
                    dahn and join the fun!</p>
                <p><router-link class="invite"
                        v-bind:to="{ name: 'join-league', params: { leagueId: this.$route.params.leagueId } }">copy invite
                        link</router-link></p>
            </section>

            <div class="new-member-form">
                <h1>Add some yinzers to your new league:</h1>

                <div class="all-possible-golfers">

                    <label for="golfers">add a yinzer:</label>
                    <input id="searchbar" @keyup.enter="searchGolfers" type="text" name="search"
                        placeholder="search yinzers..." />

                    <!-- <div v-for="album in allAlbumObjs" :key="album['id']">
                        <input type="checkbox" v-model="checkedAlbums" :value="album['id']" />
                        <label>
                            {{ album["name"] }} by {{ album["artists"] }}
                        </label>
                    </div> -->
                    <ul id="list">
                        <button @click="addAllUsers">Add all yinzers</button>
                        <button v-if="checkedUsers.length != 0" @click="checkedUsers = []">Reset</button>
                        <li class="golfers" v-for="user in users" :key="user.id">
                            <label class="checkbox">
                                <input type="checkbox" v-model="checkedUsers" :value="user" />
                                {{ user.firstName }} {{ user.lastName }}
                            </label>
                        </li>
                    </ul>
                </div>
            </div>
        </section>


        <section class="golfers-in-league" v-else>
            <h3>Yinzers In My League</h3>
            <GolfersInLeague></GolfersInLeague>
        </section>
        <button @click="addGolfersToLeague">
            {{ isLeagueInProgress ? "start league now!" : "add more yinzers" }}
        </button>
    </div>
</template>

<script>
import LeagueService from '../services/LeagueService.js';
import GolfersInLeague from './GolfersInLeague.vue';

export default {
    data() {
        return {

            isLeagueInProgress: false,
            checkedUsers: [],
            users: [],

            user: {
                id: 0,
                firstName: '',
                lastName: '',
                email: '',
                username: ''
            }
        }
    },

    components: {
        GolfersInLeague,
    },


    methods: {
        changeLeagueProgress() {
            this.isLeagueInProgress = !this.isLeagueInProgress
        },

        addAllUsers() {
            this.checkedUsers = [...this.users];
        },

        addGolfersToLeague() {
            this.isLeagueInProgress = !this.isLeagueInProgress
            LeagueService
                .addGolfersToLeague(this.$route.params.leagueId, this.checkedUsers)
                .then((response) => {
                    this.$store.commit('ADD_GOLFERS_TO_LEAGUE', this.checkedUsers)
                    if (response.status == 201) {
                        console.log("Golfers were successfully added to the league! Good job, yinzer!")
                    }
                    this.checkedUsers = [];
                })
                .catch((error) => {
                    const response = error.response;
                    this.registrationErrors = true;
                    if (response.status === 400) {
                        this.registrationErrorMsg = 'Bad Request: Validation Errors';
                    }
                });
        },

        searchGolfers() {
            let input = document.getElementById('searchbar').value
            input = input.toLowerCase();
            let x = document.getElementsByClassName('golfers');

            for (let i = 0; i < x.length; i++) {
                if (!x[i].innerHTML.toLowerCase().includes(input)) {
                    x[i].style.display = "none";
                } else {
                    x[i].style.display = "list-item";
                }
            }
        },

    },


    created() {
        LeagueService
            .getAllGolfers()
            .then((response) => this.users = response.data);


        LeagueService
            .getLeagueGolfers(this.$route.params.leagueId)
            .then((response) => this.$store.commit('SET_LEAGUE_GOLFERS', response.data));
    }
}


</script>

<style scoped>
h3 {
    font-weight: bold;
    font-size: large;
    text-decoration-line: underline;
    padding-top: 1.5rem;
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

.invite-container {
    padding-top: 1.5rem;
    padding-bottom: 2em;
    font-size: small;
}

.invite {
    color: #116110;
    text-decoration-line: underline;
    font-size: larger;
}


.invite:hover {
    background-color: khaki;
}

.names {
    color: #093708
}

.names:hover {
    color: #116110;
    text-decoration-line: underline;
}
</style>