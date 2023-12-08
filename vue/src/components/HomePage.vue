<template>
    <div>
        <h1>Welcome to Tee Time N'at, {{ username }}!</h1>
        <LeaderBoard users="users" />
    </div>
</template>

<script>
import LeaderBoard from "../components/LeaderBoard";

export default {
    data() {
        return {
            username: "User321", // get info from db/login
            users: [
                {name: "Soul Snatcher", score: 70, handicap: 8, course: ""},
                {name: ""}
            ]
        }
    }
}
</script>