<template>
  <div id="capstone-app">
    <div id="nav" class="constant-nav">
      <router-link class="link" v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link class="link" v-bind:to="{ name: 'landing' }">Map</router-link>&nbsp;|&nbsp;
      <router-link class="link" v-bind:to="{ name: 'admin' }" v-if="this.$store.state.user.authorities != null && this.$store.state.user.authorities.some((obj) => obj.name === 'ROLE_ADMIN')">Admin  |  </router-link>
      <router-link class="link" v-bind:to="{ name: 'logout' }" v-if="this.$store.state.token != ''">Logout</router-link>
      
    </div>
    <router-view />
  </div>
</template>

<script>
import LeagueService from './services/LeagueService';


export default{

  methods: {
    // logOut(){
    //   this.$store.commit("LOGOUT");
    //   this.$router.push("/");
    // },
    //send to logout view in order to logout. Code written for us already in LogoutView
    retrieveLeagues() {
      if (this.$store.state.user == null) { // don't call service if not logged in
        return;
      }

      LeagueService
        .getLeaguesByUserId(this.$store.state.user.id)
        .then(response => {
          this.leagues = this.$store.commit("SET_USER_LEAGUES", response.data);
        })
        .catch(error => {
          this.handleErrorResponse(error, 'getting');
        });
    }
  },
  created() {
    this.retrieveLeagues();
  },
  computed: {
    userLoggedIn() {
      return this.$store.state.user;
    }
  },

  watch: {
    userLoggedIn() {
      this.retrieveLeagues();
    }
  }

}

</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Hedvig+Letters+Serif:opsz@12..24&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Caveat:wght@500&display=swap');


.constant-nav {
  background-color: #093708;
  padding: 7px;
  color: darkkhaki;
}

.link {
  color: darkkhaki;
}

.link:hover {
  color: wheat;
  text-decoration-line: underline;
}
</style>
