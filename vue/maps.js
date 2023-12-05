let map;
let autocomplete

//


function initMap() {
    map = new google.maps.Map(document.getElementById('map'),
    {
        center: {lat: 41.85, lng: -87.65},
        zoom: 10,
    });
    

    const locationButton = document.getElementById('button');

    locationButton.textContent = 'Go to My Location';
    locationButton.classList.add("map-button");
    map.controls[google.maps.ControlPosition.TOP_CENTER].push(locationButton);
    locationButton.addEventListener('click', ()=> {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(
                (position) => {
                    const pos = {
                    lat: position.coords.latitude,
                    lng: position.coords.longitude,
                };
                map.setCenter(pos);
                let marker = new google.maps.Marker({
                    position: pos,
                    map: map,
                });
                map.setZoom(17);
            }
            
            )
        }
    });


    AutoComplete(map);

}

function AutoComplete() {
    autocomplete = new google.maps.places.AutoComplete(document.getElementById('autocomplete'));
    autocomplete.bindTo('bounds', map);
    const auto_marker = new google.maps.Marker ({
        map,
        anchorPoint: new google.maps.Point(0, -29),
    });

    autocomplete.addEventListener('place_changed', () => {
        auto_marker.setVisible(false);
        const place = autocomplete.getPlace();
        const position = place.geometry.location;
        if (!place.geometry || ! place.geometry.location) {
            window.alert("No information found for "+ place.name + ".");
        } else {
            if (place.geometry.viewport) {
                map.fitBounds(place.geometry.viewport);
            } else {
                map.setCenter(position);
                map.setZoom(17);
            }
        }
        auto_marker.setPosition(position);
        auto_marker.setVisible(true);
    })
}

window.initMap = initMap;