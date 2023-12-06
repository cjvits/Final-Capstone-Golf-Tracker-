<template>
    <div>
        <h2>Leaderboard</h2>
        <table>
            <thead>
                <tr>
                    <th>Rank</th>
                    <th>Name</th>
                    <th>Score</th>
                    <th>Handicap</th>
                    <th>Course</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="(user, index) in sortedUsers" :key="index" >
                    <td>{{ index + 1 }}</td>
                    <td>{{ user.name }}</td>
                    <td>{{ user.score }}</td>
                    <td>{{ user.handicap }}</td>
                    <td>{{ user.course }}</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
export default {
    props: {
        users: {
            type: Array,
            required: true,
        },
    },
    computed: {
        sortedUsers() {
            // Sort users by score in descending order
            return this.users.slice().sort((a, b) => b.score - a.score);
        },
    },
};
</script>

<style scoped>

table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
}

th, td {
    border: 1px solid #ddd;
    padding: 8px;
    text-align: left;
}

th {
    background-color: #f2f2f2;
}
</style>