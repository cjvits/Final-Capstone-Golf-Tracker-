import axios from "axios";

export default {
    //you cannot know the league id on the front end, you only know who is logged in
    
    getLeaguesByUserId(userId){
        return axios.get(`/league/${userId}`)
    },

    
}