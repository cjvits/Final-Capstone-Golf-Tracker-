import axios from "axios";

const http = axios.create({
    baseURL: "http://localhost:5173"
});

export default {

    getAllCourses(){
        return http.get(`/course`)
    },

    createCourse(course){
        return http.post(`/course`, course)
    },

    updateCourse(courseId, course){
        return http.put(`/course/${courseId}`, course)
    }

}