  <!-- TODO: Insert Logo
  TODO: Register <button></button>
  TODO: Search for courses by location search bar
    - should pop out a map when used 
  TODO: Login button in nav
-->

<template>

  <nav>
    <div id="loginDiv">
    <button type="button" id="loginBtn" @click="login">Login</button>
  
    <button type="button" id="registerBtn" @click="newAccount" >Register</button></div>
  </nav>

  <p id="appName">Tee Time N'at</p>
  
  <div id="div1">
    
    <img class="logo2" src="../assets\Tee Time N'At (Ya JAG)_2 (1).png" alt="">
  </div>
  <div class="api"><textarea name="" id="" cols="0" rows="1" placeholder="Search Courses"></textarea></div>

    <div></div>
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
nav {
  display: flex;
  justify-content: flex-end;
}

#div1 {
  display: flex;
  justify-content: center;
  align-items: center;
  padding-top: 2rem;
}

.api {
  display: flex;
  justify-content: center;
  padding-top: 1rem;
}

body {
  background-color: rgb(67, 67, 66);
}

p {
  display: flex;
  justify-content: center;
  
  color: rgb(244, 224, 7);
  font-size: x-large;
  font-family: cursive;
  
}
</style>