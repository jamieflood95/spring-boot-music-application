
var geocoder;

if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(success);
} 

function success(position) {
    var lat = position.coords.latitude;
    var lng = position.coords.longitude;
    setLocation(lat, lng)
}

function initialize() {
	geocoder = new google.maps.Geocoder();
}

function setLocation(lat, lng) {
	var latlng = new google.maps.LatLng(lat, lng);
	geocoder.geocode({latLng: latlng}, function(results, status) {
	if (status == google.maps.GeocoderStatus.OK) {
		if (results[1]) {
			if(document.getElementsByTagName("title")[0].innerHTML == 'Home') {
				displayEventsNearYou(lat, lng);
			}
			var arrAddress = results;
			$.each(arrAddress, function(i, address_component) {
			  if (address_component.types[0] == "locality") {
				$("#locationIcon").css("visibility", "visible");
				$("#locationText").html(address_component.address_components[0].long_name);
			  }
			});
		}
    }
	});
}