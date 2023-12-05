import axios from 'axios';

export default {

    // method to get all courses from database => sending get request
    getAllCourses() {
        return axios.get('/allCourses');
    },

    filterCourses(search) {
        return axios.get('/findCourses?search=' + search);
    },

    
}