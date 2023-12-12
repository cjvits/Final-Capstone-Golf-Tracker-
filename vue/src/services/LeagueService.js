import axios from "axios";

export default {
    //you cannot know the league id on the front end, you only know who is logged in
    
    getLeaguesByUserId(userId){
        return axios.get(`/league/${userId}`)
    },

    getAllCourses() {
        return axios.get(`/course`)
    },

    newLeague(league) {
        return axios.post(`/league`, league)
    }, 

    getAllGolfers() {
        return axios.get(`/users`)
    },

    addGolferToLeague(leagueId, userId) {
        return axios.post(`/${leagueId}/${userId}`)
    },

    getLeagueGolfers(leagueId) {
        return axios.get(`/users/${leagueId}`)
    },

    getLeaguesByCoordinatorId(userId) {
    return axios.get(`/league-organizer/${userId}`)
    }
    
}