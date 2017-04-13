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
    <title>Artist</title>
</head>

<body onload="getArtist('${artist}')">

<jsp:include page="header.jsp" />
<script>initialize()</script>
<script type="text/javascript" src="${contextPath}/resources/js/artist.js"></script>

<div class="container">

<div class="artistInfo" style="position:relative;">
<h2>${artist}</h2>
<table>
<tr>
<td class="artistInfoCol">
<span class="artistImage"></span>
<span class="artistDescription">${description}</span>
<br><br>
<p>${disclaimer}</p>
</td>

<!--<button type="submit" class="btn btn-default btn-sm" id="favouriteArtist"><span class="glyphicon glyphicon-star"></span> </button>-->
<td class="events-col">
<div><img src="${contextPath}/resources/img/concerts-by-songkick.jpg" class="concertsBySongkick"/></div>
<ul class="events"></ul>
</td>
</tr>
</table>
</div>
</div>
</body>
</html>
