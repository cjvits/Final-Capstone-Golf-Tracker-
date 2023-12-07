import axios from 'axios';

const BASE_URL = '/api'; // Assuming your server API is available at '/api'

export default {
  // Method to get all courses from the database
  getAllCourses() {
    return axios.get(`${BASE_URL}/allCourses`);
  },

  // Method to filter courses based on a search query
  filterCourses(search) {
    return axios.get(`${BASE_URL}/findCourses?search=${search}`);
  },
};
