
<!-- THE GOLFER COMPONENT WILL BE USED FOR A LEAGUE ORGANIZER TO SELECT GOLFERS FOR THEIR LEAGUE -->

<template>
    <section class="golfer">
        
        <ul>
            <li>{{ user.firstName }}</li>
            <li>{{ user.lastName }}</li>
            <li>{{ user.email }}</li>
            <li>{{ user.currentLeague }}</li>
            <!-- <li>{{ user.handicap }}</li> THIS WILL NEED TO BE COMPUTED - BUT HOW??--> 
        </ul>
        <label for="chk-to-add">add golfer?</label><input type="checkbox" id="chk-to-add" v-bind:checked="addToLeague"> 

    </section>
</template>

<script>
export default {
    props: ['user'],

    methods: {
        addToLeague(league) {
            this.$store.commit('ADD_TO_LEAGUE', this.user); //THIS METHOD IS INCOMPLETE IN THE STORE!! WON'T WORK UNTIL FINISHED  
        }
    }
}
</script>

<style>

/* style to display a golfer */

</style>