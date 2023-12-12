<template>
  <div id="capstone-app">
    <div id="nav" class="constant-nav">
      <router-link class="link" v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link class="link" v-bind:to="{ name: 'landing' }">Map</router-link>&nbsp;|&nbsp;
      <router-link class="link" v-bind:to="{ name: 'admin' }" v-if="this.$store.state.user.authorities.some((obj) => obj.name === 'ROLE_ADMIN')">Admin  |  </router-link>
      <router-link class="link" v-bind:to="{ name: 'logout' }" v-if="this.$store.state.token != ''">Logout</router-link>
      
    </div>
    <router-view />
  </div>
</template>


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
