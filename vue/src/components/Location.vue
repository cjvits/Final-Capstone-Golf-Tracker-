<!-- This represents the Google Map display -->
<template>
    <div>
      <div id="grid-container">
        <div id="map"></div>
        
        <div id="latitude" class="coord-input">
          <span>Latitude:</span><br />
          <input v-model="latitude" type="text" /><br />
          <select v-model="latitudeDirection">
            <option>North</option>
            <option>South</option>
          </select><br />
        </div>
  
        <div id="longitude" class="coord-input">
          <span>Longitude:</span><br />
          <input v-model="longitude" type="text" /><br />
          <select v-model="longitudeDirection">
            <option>West</option>
            <option>East</option>
          </select>
          <br />
        </div>
  
        <div id="description" class="coord-input">
          <span class="menu-label">Description</span><br />
          <input v-model="description" type="text" /><br />
        </div>
  
        <div id="buttons" class="coord-input">
          <button @click="addPinViaInput">Add Marker</button><br /><br />
          <button @click="summarizeMarkers">Summarize All Markers</button>
        </div>
  
        <div id="report"></div>
      </div>
    </div>
  </template>
  
  <script>
export default {
  name: "Map",
  data() {
    return {
      map: null,
      latitude: "",
      longitude: "",
      latitudeDirection: "North",
      longitudeDirection: "West",
      description: "",
      mapCenter: { lat: 38.5948096, lng: -84.8355755 },
      locations: [
        { coord: { lat: 42.34, lng: -83.0456 }, name: "" },
        { coord: { lat: 42.3411, lng: -83.0553 }, name: "" },
        { coord: { lat: 42.339, lng: -83.0485 }, name: "" },
      ],
    };
  },
  methods: {
    initMap() {
  // Initialize the map
  this.map = new window.google.maps.Map(document.getElementById("map"), {
    center: this.mapCenter,
    zoom: 10,
  });

  // Add a click event listener to the map
  this.map.addListener('click', this.addMarkerOnClick);
},

    // Define your other methods as per your original code
    // ...
  },
  mounted() {
    this.initMap();
    // You may call any other initialization methods here
  },
};
</script>

  
<style>
#grid-container {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  grid-template-areas:
    "intro intro intro intro"
    "latitude longitude description buttons"
    "map map report report";
}
#intro {
  grid-area: intro;
}
#latitude {
  grid-area: latitude;
}
#longitude {
  grid-area: longitude;
}
#description {
  grid-area: description;
}
#buttons {
  grid-area: buttons;
}
#map {
  grid-area: map;
  width: 500px;
  height: 400px;
  padding: 25px;
  margin: 25px;
}
#report {
  grid-area: report;
  width: 500px;
  height: 400px;
  padding: 25px;
  margin: 25px;
  border: 1px dashed gray;
}
.coord-input {
  border: 1px dashed gray;
  padding: 25px;
  margin: 25px;
}
.input-cell {
  vertical-align: top;
}
</style>

