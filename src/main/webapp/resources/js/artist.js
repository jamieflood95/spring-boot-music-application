function getArtist(artist) {
	
	// find the artist id from songkick
	var artistUrl = 'http://api.songkick.com/api/3.0/search/artists.json?query='+decodeURI(artist)+'&apikey=API_KEY';
	
	$.getJSON(artistUrl, function(data) {
		// find the artists upcoming gigs
		var url = 'http://api.songkick.com/api/3.0/artists/'+data.resultsPage.results.artist["0"].id+'/calendar.json?apikey=API_KEY'
		 $('.artistImage').append('<img class="artistImage" src="http://images.sk-static.com/images/media/profile_images/artists/'+data.resultsPage.results.artist["0"].id+'/huge_avatar"/>');
		
		getArtistEvents(url);
	});
}

function getArtistEvents(url) {
	$.getJSON(url, function(data) {
		  var events = data.resultsPage.results.event;
		  
		  events.forEach(function(item, index, array) {
			// use moment.js to format dates
			var event_month = moment(array[index].start.datetime).format('MMM');
			var event_day = moment(array[index].start.datetime).format('D');
			var event_date = '<span class="month">'+ event_month +'</span><span class="day">'+ event_day +'</span>';
			
			var event_performer = array[index].performance[0].artist.displayName;
			var event_venue = array[index].venue.displayName;
			var event_city = array[index].location.city;
			var event_link = array[index].uri;
			var event_details = '<p>' + event_performer + ' @ ' + event_venue + '</p><p>' + event_city + '</p><p><a href="' + event_link + '">More details</a></p>';
			
			if(event_month != 'INVALID DATE' && event_day != 'Invalid date') {
			  $('.events').append('<li><div class="date">' + event_date + '</div>' + event_details + '</li>');
			}
		  });
	});
}