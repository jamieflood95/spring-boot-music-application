function displayEventsNearYou(lat, lng) {
	var url = 'http://api.songkick.com/api/3.0/events.json?location=geo:'+lat+','+lng+'&apikey=io09K9l3ebJxmxe2&per_page=30';
	
	$.getJSON(url, function(data) {
		  var events = data.resultsPage.results.event;
		  
		  events.forEach(function(item, index, array) {
			var event_performer = array[index].performance[0].artist.displayName;
			var event_venue = array[index].venue.displayName;
			var event_city = array[index].location.city;
			var event_link = array[index].uri;
			var event_month = moment(array[index].start.datetime).format('MMM');
			var event_day = moment(array[index].start.datetime).format('D');
			var href= "/artist/"+event_performer.replace(' ', '_').toLowerCase();
			var event_details = '<a href='+href+' id="artistName">'+event_performer + '</a> @ ' + event_venue + '<br>' + event_city + '<br>' + event_day + ' ' + event_month + '<br><a href="' + event_link + '">More details</a>';
			var artist_image = '<img class="artistImage" src="http://images.sk-static.com/images/media/profile_images/artists/'+array[index].performance[0].artist.id+'/huge_avatar"/>';
			var remainder = index % 3;
			if(index == 0) {
				$('#upcomingEvents').append('<table><tr>');
			}
			if (remainder == 0 && index != 0){
				$('#upcomingEvents').append('</tr><tr>');
			}
			$('#upcomingEvents').append('<td style="padding:30px;">' + artist_image + '<br>' + event_details + '</td>');
		  
		  });
	});
}

	