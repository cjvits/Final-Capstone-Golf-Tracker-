import { createApp } from 'vue'
import CapstoneApp from './App.vue'
import { createStore } from './store'
import router from './router'
import axios from 'axios'
// import * as VueGoogleMaps from 'vue3-google-maps';
import GoogleMap from './components/GoogleMap.vue';
import MyContainer from './components/MyContainer.vue'
import GeoCode from './components/GeoCode.vue'

/* sets the base url for server API communication with axios */
axios.defaults.baseURL = import.meta.env.VITE_REMOTE_API;

/*
 * The authorization header is set for axios when you login but what happens when 
 * you come back or the page is refreshed. When that happens you need to check 
 * for the token in local storage and if it exists you should set the header 
 * so that it will be attached to each request.
 */
let currentToken = localStorage.getItem('token');
let currentUser = {};

try {
  currentUser = JSON.parse(localStorage.getItem('user'));
} catch {
  localStorage.removeItem('token');
  localStorage.removeItem('user');
  currentToken = '';
}

if (currentToken) {
  // Set token axios requests
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

// Create the Vuex store passing in the stored credentials
const store = createStore(currentToken, currentUser);

const app = createApp(CapstoneApp);

app.use(GoogleMap, {
  load: {
    key: "AIzaSyChXcD4Ca6q3TZGs0A7NasDBKCLwM9q3lY",
    libraries: "places"
  }
});
app.component('GoogleMaps', GoogleMap);
app.use(store);
app.use(router);
app.mount('#app');

