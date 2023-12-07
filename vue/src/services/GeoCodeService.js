import axios from 'axios';

// This is the API Key for our google map

const apiKey = "AIzaSyChXcD4Ca6q3TZGs0A7NasDBKCLwM9q3lY"; // Replace with your API key

const GeoService = {
  async getLatLng(address) {
    try {
      const response = await axios.get(`https://maps.googleapis.com/maps/api/geocode/json?address=${address}&key=${apiKey}`);
      return response.data.results[0].geometry.location; // Extract latLng from the response
    } catch (error) {
      console.error('Error while fetching geolocation:', error);
      throw error;
    }
  }
};

export default GeoService;

