<template>
    <div>
        <h1>Welcome to Tee Time N'at, {{ username }}!</h1>
        <LeaderBoard :users="users" />
    </div>
</template>

<script>
import LeaderBoard from "@/components/LeaderBoard";

export default {
    data() {
        return {
            username: "User321", // get info from db/login
            users: [
                {name: "Soul Snatcher", score: 70, handicap: 8, course: "Green Acres"},
                {name: "Two Thumbs Tony", score: 56, handicap: 5, course: "Your Mom's Yard"},
                {name: "Bugz Almost", score: 63, handicap: 7, course: "Left field"},
                // add as they get populated
            ],
        };
    },
    components: {
        LeaderBoard,
    },
};
</script>