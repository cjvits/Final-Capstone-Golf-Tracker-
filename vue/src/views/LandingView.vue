  <!-- TODO: Insert Logo
  TODO: Register <button></button>
  TODO: Search for courses by location search bar
    - should pop out a map when used 
  TODO: Login button in nav
-->

<template>
  <div id="div1">
    <p id="AppName">Tee Time N'at</p>
    <img class="logo2" src="../assets\Tee Time N'At (Ya JAG)_2 (1).png" alt="">
  </div>
  <div id="loginDiv">
    <button type="button" id="loginBtn" @click="login">Login</button></div>
  <div id="registerBtn"><button>Register</button></div>
  <div class="api"><textarea name="" id="" cols="0" rows="1" placeholder="Search Courses"></textarea></div>
    <div></div>
</template>
<script>
import LoginView from './LoginView.vue';

export default {
  name: "App",
  data() {
    return {
    };
  },
  methods: {
    login() {
      LoginView
    }
  },
  
};
</script>
<style>

</style>