

<!-- The code in this file represents our Geolocation on the map -->

<template>
    <div></div>
  </template>

  <script>
  import GeoService from '../services/GeoCodeService.js'; // Update the path to the GeoService file
  
  export default {
    // Your Vue component options
    
        data() {
            return {
                lat: 40.44,
                lng: 90.44,
            };
        },
        
    // methods: {
    //   async getAddressCoordinates() {
    //     let address = 'Your Address Here'; // Replace with the address you want to look up
    //     try {
    //       const latLng = await GeoService.getLatLng(address);
    //       console.log('Latitude:', latLng.lat);
    //       console.log('Longitude:', latLng.lng);
    //     } catch (error) {
    //       // Handle error
    //       console.error('Error:', error);
    //     }
    //   },
    // },
      methods: {
       
      }
  };
  </script>
  
  <style>
    
  </style>
  