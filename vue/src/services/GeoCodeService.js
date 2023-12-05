import axios from 'axios';

export default {

    getLatLng(address) {
        const key = "AIzaSyChXcD4Ca6q3TZGs0A7NasDBKCLwM9q3lY";
        console.log('address' + address);
        return axios.get(`https://maps.googleapis.com/maps/api/geocode/json?address=${address}&key=${key}`);
    }
}