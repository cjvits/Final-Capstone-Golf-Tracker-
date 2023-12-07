<template>
    <div>
      <vue3-google-maps :center="center" :zoom="zoom">
        <gmap-marker :position="center"></gmap-marker>
      </vue3-google-maps>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        center: { lat: 40.7128, lng: -74.0060 }, // Adjust to your desired initial map center
        zoom: 10, // Adjust the initial zoom level
      };
    },
  };
  </script>
  
  <style scoped>
    div {
        width: 100%;
        height: 400px;
    }
  </style>
  