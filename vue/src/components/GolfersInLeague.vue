<template>
    <option v-for="user in this.$store.state.golfersInLeague" :key="user.id">{{ user.firstName }} {{ user.lastName }}
    </option>

</template>

<script>
import LeagueService from '../services/LeagueService.js';

export default {
    data() {
        return{
             users: []  
        }
    },


}


</script>

<style scoped>
button {
    background-color: #093708;
    color: darkkhaki;
    border-radius: .5em;
    padding: .5em;
    margin: .5em;
    font-family: 'Hedvig Letters Serif', serif;
}

button:hover {
    background-color: #116110;
    color: wheat;
}
</style>