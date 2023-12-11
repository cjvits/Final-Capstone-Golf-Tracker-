<template>

<div class="landing">
  <section class="content-container">
    <div class="title">
       <h1 id="appName">Tee Time N'at</h1>
    </div>
    <!-- <p class="api"><textarea name="" id="" cols="0" rows="1" placeholder=" Search Courses"></textarea></p> -->
  <GoogleMap></GoogleMap>
  <GeoCode></GeoCode>
  </section>
</div>

</template>

<script>
import RegisterView from './RegisterView.vue';
import LoginView from './LoginView.vue';
import GoogleMap from '../components/GoogleMap.vue';
import GeoCode from '../components/GeoCode.vue';

export default {
  name: "App",
  data() {
    return {
    };
  },

  components: {
    GoogleMap,
    GeoCode
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
  background-image: url("../assets/goldenGolf.jpeg");
  height: 100vh;
  background-size: cover;
  background-position: center;
  justify-content: center;
  align-items: center;
  padding: 0 20px;
  text-align: center;
  font-family: 'Caveat', cursive;
  color: #093708;
  font-weight: 600;
  display: flex;
  position: static;
}
/* .title {
  background-color: white;
  opacity: .8;
  width: 100%;
}  */

h1 {
  color:#093708;
  text-align: center;
  flex-grow: 1;
  /* font-size: 2em; */
  font-size: 3em;
  font-weight: 700;
  font-family: 'Caveat', cursive;
  padding-top: 1rem;
  padding-left: 10rem;
  padding-right: 10rem;
  padding-bottom: 1rem;
}

.content-container {
  justify-content: center;
  align-items: center;
}

</style>