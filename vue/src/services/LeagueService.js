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

    // for selecting golfers for a league .... but just realized there is a method in the USER backend code that was given to us... probably better
    getAllGolfers() {
        return axios.get(`users`)
    }

    // addGolferToLeague() {
    //     return axios.post()
    // }

}