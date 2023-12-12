import axios from "axios";

// const http = axios.create({
//     baseURL: "http://localhost:5173"
// });

export default {

    getAllCourses(){
        return axios.get(`/course`)
    },

    createCourse(course){
        return axios.post(`/course`, course)
    },

    updateCourse(courseId, course){
        return axios.put(`/course/${courseId}`, course)
    }

}