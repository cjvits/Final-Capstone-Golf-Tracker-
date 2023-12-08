import axios from "axios";


export default {
    //you cannot know the league id on the front end, you only know who is logged in
    getLeagueIdByUserId(userId){
        return axios.get(`/home/${userId}`)
    },

    newLeague(league){
        return axios.post(`/home`, league)
    },

    getLeagueMatches(leagueId){
        return axios.get(`/home/${leagueId}/match`)
    },

    getLeagueMatch(leagueId, matchId){
        return axios.get(`/home/${leagueId}/match/${matchId}`)
    },

    getAllCourses(){
        return axios.get(`/course`)
    },

    newMatch(leagueId, match){
        return axios.get(`/home/${leagueId}/match`, match)
    },

    getLeaderBoard(userId){
        return axios.get(`/league/${userId}`)
    },

    updateMatchScore(leagueId, matchId){
        return axios.put(`/home/${leagueId}/match/${matchId}`)
    },

    addGolferToLeague(leagueId, user){
        return axios.post(`/home/${leagueId}`, user)
    },

    addGolferToMatch(leagueId, matchId, user){
        return axios.post(`/home/${leagueId}/match/${matchId}`, user)
    },

    deleteFromLeague(leagueId, user){
        return axios.delete(`/home/${leagueId}`, user)
    }
}