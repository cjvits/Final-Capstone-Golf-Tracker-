<template>
    <div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        map: null,
        search_pos: null,
      };
    },

    mounted() {
        this.initMap(); // Initialize the map when the component is mounted
    },

    methods: {
      initMap() {
        this.map = new window.google.maps.Map(document.getElementById("map"), {
            center: { lat: 40.4406, lng: -79.9959 },
            zoom: 10,
        });
        this.writeIntro();
        this.completeSearch();
      },
      writeIntro() {
      const content = "Interactive Map N'At.";
      document.getElementById("intro").innerHTML = content;
    },
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
    addMarker(coords) {
      const marker = new window.google.maps.Marker({
        position: coords,
        map: this.map,
        icon: "https://maps.google.com/mapfiles/kml/paddle/grn-circle.png",
      });
      this.map.setZoom(15);
    },
    handleLocationError(browserHasGeolocation, infoWindow, pos) {
      infoWindow.setPosition(pos);
      infoWindow.setContent(
        browserHasGeolocation
          ? "Error: The Geolocation service failed."
          : "Error: Your browser doesn't support geolocation."
      );
      infoWindow.open(this.map);
    },
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
  