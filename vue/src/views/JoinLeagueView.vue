<template>
    <div class="page-container">
        <div id="not-logged-in" v-if="this.$store.state.token != ''">
            <div class="content">
                <p>Hello! You've been invited to join the {{ this.leagueName }} golf league!</p>
                <p>Click the button below to join the league!</p>
                <button v-on:click="joinLeague">
                    Put me in the league!
                </button>
            </div>
        </div>
        <div id="logged-in" v-else>
            <div class="content">
                <p>Hello! You've been invited to join the {{ this.leagueName }} golf league!</p>
                <p>If you'd like to accept the invite, you must first sign in: </p>
                <p><router-link :to="`/login?redirect=${$route.path}`" class="link">Login Here</router-link></p>
                <p><router-link :to="`/register?redirect=${$route.path}`" class="link">Register Here</router-link></p>
            </div>

        </div>
    </div>
</template>

<script>
import LeagueService from '../services/LeagueService';

export default {

    data() {
        return{
        leagueName: '',
        }

    },
    methods: {
        joinLeague(leagueId, userId) {
            LeagueService
                .addGolferToLeague(this.$route.params.leagueId, this.$store.state.user.id)
                .then((response) => {
                    if (response.status == 201) {
                        this.$router.push({
                            path: '/home/',
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
        },
        
        },
        created(){
            LeagueService
            .getLeagueName(this.$route.params.leagueId)
                .then((response) => 
                    this.leagueName = response.data);
                }
    }



</script>

<style scoped> .page-container {
     padding-top: 5%;
     background-image: url("../assets/goldenGolf.jpeg");
     background-color: #312917;
     height: 100vh;
     background-size: 100%;
     background-repeat: no-repeat;
     background-position: center;
     font-family: 'Hedvig Letters Serif', serif;
     color: #093708;
     font-weight: 600;
     text-align: center;
 }

 .content {
     background-color: darkkhaki;
     height: auto;
     padding: 5%;
     margin: 5% 30%;
 }

 .link {
    color:#093708;
    text-decoration-line: underline;
 }

 .link:hover {
    color: #116110;
 }
</style>