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
  <div class="subdiv">
  <h1 id="appName">Tee Time N'at</h1>
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
  display: flex;
  align-items: center;
  justify-content: center;
  background-image: url("../assets/goldenGolf.jpeg");
  height: 100vh;
  background-size: 100%;
  background-repeat: no-repeat;
  background-position: center;
  font-family: 'Hedvig Letters Serif', serif;
  color: #093708;
  font-weight: 600;
  font-size: x-large;
}
.subdiv {
  background-color: white;
  opacity: .3;
  position: sticky;
  flex-grow: 1;
} 

h1 {
  text-align: center;
  justify-self: center;
  flex-grow: 1;
  font-size: 2em;
  font-weight: 700;
  font-family: 'Hedvig Letters Serif', serif;
}

</style>