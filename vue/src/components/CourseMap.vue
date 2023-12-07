<template>
    <div id="google_map">
      <gmap-map :zoom="10" :center="center" style="width: 80vh; height: 60vh">
        <gmap-marker
          :key="index"
          v-for="(m, index) in locationMarkers"
          :position="m.position"
          @click="center = m.position"
        ></gmap-marker>
      </gmap-map>
    </div>
  </template>
  
  <script>
  import { gmapApi } from "./GoogleMap.vue";
  export default {
    name: "CourseMap",
    data() {
      return {
        center: {
          lat: 39.7837304,
          lng: -100.4458825,
        },
        locationMarkers: [],
      };
    },
    methods: {
      addLocationMarker(marker) {
        this.locationMarkers.push({ position: marker });
      },
    },
    created() {
      // Fetch golf course data from the API (you can use axios here)
      // Loop through the data and call this.addLocationMarker for each course
      // Example:
      // axios.get("/allCourses").then((response) => {
      //   response.data.forEach((course) => {
      //     this.addLocationMarker({ lat: course.latitude, lng: course.longitude });
      //   });
      // });
    },
  };
  </script>
  