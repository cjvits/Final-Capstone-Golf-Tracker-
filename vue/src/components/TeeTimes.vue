<template>
    <div class="tee" v-for="teeTime in teeTimes" v-bind:key="teeTime.id">
        <div class="time">
            {{ teeTime.time }}
            <!-- This is where the Time goes -->
        </div>

        <div class="date">
            <!-- This is where the date goes -->
            {{ teeTime.date }}
        </div>

        <div class="user" v-for="user in users" v-bind:key="user.id">
            {{ user.username }}
            <!-- This is where the username goes -->
        </div>
    </div>
</template>

<script>
export default {
    

};
</script>

<style scoped>

</style>
