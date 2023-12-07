<template>
    <div id="find-course">
      <h1 id="find-course-h1">Find a Course Near You</h1>
      <input
        id="search"
        type="text"
        v-model="search"
        placeholder="Search by course name"
      />
      <button id="button" @click="findCourse">Search</button>
  
      <!-- Display course details -->
      <div id="details" v-if="selectedCourse">
        <h4 id="coursedetails-h4">Course Details:</h4>
        Course Name: {{ selectedCourse.courseName }} <br />
        Address: {{ selectedCourse.address }} <br />
        City: {{ selectedCourse.city }} <br />
        State: {{ selectedCourse.stateName }} <br />
        Zipcode: {{ selectedCourse.zipcode }} <br />
        Course ID: {{ selectedCourse.courseId }}
      </div>
  
      <!-- Display the map component -->
      <course-map></course-map>
    </div>
  </template>
  
  <script>
  import CourseService from "../services/CourseService.js";
  import CourseMap from "../components/CourseMap.vue"; // Import the CourseMap component
  
  export default {
    components: {
      CourseMap, // Register the CourseMap component
    },
    name: "FindCourse",
    data() {
      return {
        selectedCourse: null,
        search: "",
      };
    },
    methods: {
      findCourse() {
        CourseService.filterCourses(this.search).then((response) => {
          console.log(response.data);
          this.selectedCourse = response.data;
  
          // If you want to pass data to the map component, you can emit an event or use props.
          // For example, emit an event like this:
          // this.$root.$emit("setMarker", {
          //   lat: parseFloat(response.data.latitude),
          //   lng: parseFloat(response.data.longitude),
          // });
        });
      },
    },
  };
  </script>
  