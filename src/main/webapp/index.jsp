<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="${contextPath}/resources/css/artist.css" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment.js"></script>
    <script type="text/javascript" src="${contextPath}/resources/js/index.js"></script>
    <title>Home</title>
</head>

<body>
<jsp:include page="header.jsp" />
<script>initialize()</script>

<div class="container">
<h2 class=upcomingEventsHeading">Upcoming events near you</h2>
<div><img src="${contextPath}/resources/img/concerts-by-songkick.jpg" class="concertsBySongkick"/></div>
<div id="upcomingEvents">

</div>
</div>
</body>
</html>
