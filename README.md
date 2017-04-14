# spring-boot-music-application
This is the first application I have developed using Spring Boot. I was interested in seeing how easy it was to set up. There is a basic UI which uses bootstrap and data is shown by using the Songkick API and JSoup.

# Prerequisites

- JDK 1.7 or later
- Maven 3 or later

# Stack
- Spring Boot
- Spring Security
- JPA
- Maven
- JSP
- MySql
- Songkick API
- JSoup
- JQuery
- Google Geocoding

# Set Up
- Define your database in ```application.properties```

```spring.datasource.url = jdbc:mysql://localhost:3306/mydatabase```

```spring.datasource.username = root```

```spring.datasource.password = root```


- Add your Songkick API key to ```artist.js``` and ```index.js```

```var url = 'http://api.songkick.com/api/3.0/events.json?location=geo:'+lat+','+lng+'&apikey=API_KEY&per_page=30';```


- Add your Google API key to ```header.jsp```

```<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?key=API_KEY"></script>```

# Run

```mvn clean spring-boot:run```

# Resources
- https://github.com/hellokoding/registration-login-spring-hsql
- https://projects.spring.io/spring-boot/
- http://www.songkick.com/developer
