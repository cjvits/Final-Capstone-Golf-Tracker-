<template>
  <div id="capstone-app">
    <div id="nav" class="constant-nav">
      <router-link class="link" v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link class="link" v-bind:to="{ name: 'logout' }" v-if="this.$store.state.token != ''">Logout</router-link>
      <!-- <router-link class="link" v-bind:to="{ name: 'admin '}" v-if="this.$store.user.role === 'admin'">Add Courses</router-link> -->
    </div>
    <router-view />
  </div>
</template>


<style>
@import url('https://fonts.googleapis.com/css2?family=Hedvig+Letters+Serif:opsz@12..24&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Caveat:wght@500&display=swap');


.constant-nav {
  background-color: #093708;
  opacity: .85;
  padding: 7px;
  color: wheat;
}

.link {
  color: darkkhaki;
}
</style>
