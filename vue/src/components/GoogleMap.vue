<template>
  <div class="map">
    <!-- This is where we render our map-->


    <div class="search-bar">
      <input type="text" id="autocomplete" placeholder="Search for a place" />
      <button id="search-button">Search</button>
    </div>
    <div id="map"></div>
    <button id="findLocationButton" @click="findMyLocation">Find My Location</button>
  </div>

  <!-- <div id = "nav-bar"> -->
  <!-- This is my "Find My Location" button -->
  <!-- <div id = 'get-distance'> -->
  <!-- <input id = 'start' type = 'text' placeholder = 'Travel From' />
                <input id = 'end' type = 'text' placeholder = 'Destination' />
                <button id = 'get-distance-button'>Get Distance N'At</button> -->
  <!-- </div>-->
  <!-- <div GoogleMap ></div> -->
</template>
  
<script>

export default {
  data() {
    return {
      map: null,
    };
  },

  mounted() {
    console.log("Google Maps loaded successfully"); // This should show up in the console if the maps are loading correctly.
    this.initMap(); // Initialize the map when the component is mounted.
  },

  methods: {
    initMap() {
      this.map = new window.google.maps.Map(document.getElementById("map"), {
        center: { lat: 40.4406, lng: -79.9959 }, // Coordinates for Pittsburgh, PA
        zoom: 10,
      });

      this.completeSearch();
      this.handleLocationError();
      this.findMyLocation();
      this.addMarker();
    },

    // Method for finding our current location (geolocation)
    findMyLocation() {
      if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(
          (position) => {
            const currentPos = {
              lat: position.coords.latitude,
              lng: position.coords.longitude,
            };
            this.map.setCenter(currentPos);
            this.addMarker(currentPos);
          },
          () => {
            this.handleLocationError(true, this.map.getCenter());
          }
        );
      } else {
        this.handleLocationError(false, this.map.getCenter());
      }
    },

    // This adds a marker to our current location.
    addMarker(coords) {
      const marker = new window.google.maps.Marker({
        position: coords,
        map: this.map,
        icon: "https://maps.google.com/mapfiles/kml/paddle/grn-circle.png",
      });
      this.map.setZoom(15);
    },

    // If the user does not have location services enabled.
    handleLocationError(browserHasGeolocation, infoWindow, pos) {
      infoWindow.setPosition(new window.google.maps.LatLng(pos.lat, pos.lng));
      infoWindow.setContent(
        browserHasGeolocation
          ? "Error: The Geolocation service failed."
          : "Error: Your browser doesn't support geolocation."
      );
      infoWindow.open(this.map);
    },

    // This method adds an autocomplete when the user begins typing in the search bar.
    completeSearch() {
      const options = {
        fields: ["place_id", "geometry", "name", "formatted_address"],
        strictBounds: false,
      };
      const autocomplete = new window.google.maps.places.Autocomplete(
        document.getElementById("autocomplete"),
        options
      );
      autocomplete.bindTo("bounds", this.map);
      const auto_marker = new window.google.maps.Marker({
        map: this.map,
        anchorPoint: new window.google.maps.Point(0, 50),
      });
      autocomplete.addListener("place_changed", () => {
        auto_marker.setVisible(false);
        const place = autocomplete.getPlace();
        this.search_pos = place.geometry.location;
        console.log(this.search_pos);
        if (!place.geometry || !place.geometry.location) {
          window.alert("No details available for input: '" + place.name + "'");
          return;
        }
        if (place.geometry.viewport) {
          this.map.fitBounds(place.geometry.viewport);
        } else {
          this.map.setCenter(place.geometry.location);
          this.map.setZoom(17);
        }
        auto_marker.setPosition(place.geometry.location);
        auto_marker.setVisible(true);
      });
    },
  },
};
</script>

<style>
    #map {
      height: 600px;
      width: auto;
      border: 10px solid green;
      margin: 15px;
      padding: 0px;
      position: relative;
    }

    #findLocationButton {
      background-color: #f0f7f0;
      border: solid 5px;
      color: rgb(28, 25, 25);
      padding: 10px 32px;
      text-align: center;
      text-decoration: none;
      display: inline-block;
      font-size: 16px;
      margin: px 2px;
      cursor: pointer;
      opacity: 75%;
      /*This is the position of the button*/
      position: absolute;
      top: 45%;
      left: 45%;
      transform: translate(-50, -50);
    }

    #search-area {
      background-color: white;
      border: none;
      width: 40%;
      height: 30px;
      color: rgb(28, 25, 25);
      padding: 1px;
      text-align: left;
      text-decoration: none;
      display: inline-block;
      font-size: 16px;
      margin: 4px 2px;
      image-rendering: auto;
    }

    .search-bar {
      text-align: left;
      padding-left: 10px;
    }

    .search-bar input[type="text"] {
      width: 80%;
      padding: 10px;
      border: none;
    }

    #search-button {
      height: 40px;
      width: 100px;
    }

    #autocomplete {
      background-color: aliceblue;
      width: 80%;
      height: 40px;
      text-align: middle;
    }

    #start,
    #end {
      background-color: #fff;
      font-family: Roboto;
      font-size: 15px;
      font-weight: 300;
      margin-left: 15px;
      padding: 5px;
      text-overflow: ellipsis;
      width: 200px;
    }

    #intro {
      padding-left: 0.3%;
    }

    #nav-bar {
      padding-left: 1%;
    }
</style>