  <!-- TODO: Insert Logo
  TODO: Register <button></button>
  TODO: Search for courses by location search bar
    - should pop out a map when used 
  TODO: Login button in nav
-->

<template>

  <!-- <nav>
    <div id="loginDiv">
    <button type="button" id="loginBtn" @click="login">Login</button>
    <button type="button" id="registerBtn" @click="newAccount" >Register</button></div>
  </nav> -->

<div class="landing">
  <router-link to="/location">Go to Location Page</router-link>
  <div class="subdiv">
  <transition name="fade">
    <h1 id="appName">Tee Time N'at</h1>
  </transition>
  </div>
  <p class="api"><textarea name="" id="" cols="0" rows="1" placeholder=" Search Courses"></textarea></p>
</div>

</template>

<script>
import RegisterView from './RegisterView.vue';
import LoginView from './LoginView.vue';

export default {
  name: "App",
  data() {
    return {
    };
  },
  methods: {
    login() {
      this.$router.push({name: 'login'});
    },
    newAccount() {
      this.$router.push({name: 'register'})
    }
  },
  
};
</script>

<style scoped>

 .api {
  display: flex;
  justify-content: center;
  align-items: flex-end; 
  padding-top: 3rem;
} 

.landing {
  flex-direction: column;
  display: flex;
  /* align-items: center; */
  justify-content: center;
  padding-top: 15%;
  background-image: url("../assets/goldenGolf.jpeg");
  height: 100vh;
  background-size: 100%;
  background-repeat: no-repeat;
  background-position: center;
  font-family: 'Hedvig Letters Serif', serif;
  color: #06612f;
  font-weight: 600;
  font-size: x-large;
}
.subdiv {
  /* display: flex-content;
  justify-content: center;
  align-items: center; */
  display: flex;
  background-color: white;
  opacity: .3;
  position: sticky;
  width: 100%;
  flex-grow: .1;
  flex-basis: auto;
} 

h1 {
  text-align: center;
  justify-self: center;
  flex-grow: 1;
  font-size: 2em;
  font-weight: 700;
  font-family: 'Hedvig Letters Serif', serif;
  padding-top: 1rem;
}

</style>