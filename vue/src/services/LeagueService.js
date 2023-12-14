import axios from "axios";

export default {

    getLeaguesByUserId(userId) {
        return axios.get(`/league/${userId}`);
    },

    getAllCourses() {
        return axios.get(`/course`);
    },

    newLeague(league) {
        return axios.post(`/league`, league);
    },

    getAllGolfers() {
        return axios.get(`/users`);
    },

    addGolferToLeague(leagueId, userId) {
        return axios.post(`/${leagueId}/${userId}`);
    },

    addGolfersToLeague(leagueId, users) {
        return axios.post(`/league/${leagueId}/users`, users)
    },

    getLeagueGolfers(leagueId) {
        return axios.get(`/users/${leagueId}`);
    },

    getLeaguesByCoordinatorId(userId) {
        return axios.get(`/league-organizer/${userId}`);
    },

    createMatch(match) {
        return axios.post(`/match`, match);
    },

    updateScore(matchId, userId, score){
        return axios.put(`/match/${matchId}/user/${userId}/score/${score}`);
    },

    getAllMatches(leagueId){
        return axios.get(`/match/${leagueId}`);
    },

};