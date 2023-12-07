<template>
    <div id="google_map">
    </div>
  </template>
  
  <script>
  export default {
    name: "FindCourse",
    data() {
      return {
        selectedCourse: {},
        courses: [],
        search: "",
        center: {
          lat: 39.7837304,
          lng: -100.4458825,
        },
        locationMarkers: [],
        locPlaces: [],
        existingPlace: null,
      };
    },
    mounted() {
      this.existingPlace = this.$store.state.courses;
    },
    computed: {
      filteredCourses() {
        return this.courses.filter((course) => {
          return course.title.match(this.search);
        });
      },
    },
    methods: {
      initMarker(loc) {
        this.existingPlace = loc;
      },
      addLocationMarker() {
        if (this.existingPlace) {
          const marker = {
            lat: this.existingPlace.geometry.location.lat(),
            lng: this.existingPlace.geometry.location.lng(),
          };
          this.locationMarkers.push({ position: marker });
          this.locPlaces.push(this.existingPlace);
          this.center = marker;
          this.existingPlace = null;
        }
      },
    },
  };
  </script>
  
  <style>
  </style>
  