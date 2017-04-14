<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<link href="${contextPath}/resources/css/style.css" rel="stylesheet">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" />
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${contextPath}/resources/js/location.js"></script>
<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?key=API_KEY"></script> 


<nav class="navbar navbar-inverse">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar-collapse-3">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${pageContext.request.contextPath}/">myapplication</a>
		</div>

		<div class="collapse navbar-collapse" id="navbar-collapse-3">
			<ul class="nav navbar-nav navbar-right">

				<form class="navbar-form navbar-right" method="get"
					action="${pageContext.request.contextPath}/artist"  commandName="artist" role="artist">
					<div class="form-group">


						<input type="text" name="artist" placeholder="Artist name"
							class="form-control" />
					</div>
					<button type="submit" class="btn btn-danger">
						<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
					</button>
				</form>
				
				<!--  HOME BUTTON -->
				<li><a href="${pageContext.request.contextPath}/">Home</a></li>

				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">
					<c:if
						test="${pageContext.request.userPrincipal.name != null}">
				        ${pageContext.request.userPrincipal.name}			
				    </c:if>
					<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li class="logout"><form id="logoutForm" method="POST"
						action="${contextPath}/logout">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form> <a onclick="document.forms['logoutForm'].submit()">Logout</a></li>

					</ul></li>
				<li class="divider-vertical"></li>
				
				<li><a><span class="glyphicon glyphicon-map-marker" id="locationIcon" aria-hidden="true" style="visibility: hidden;"></span><span id="locationText" style="padding-left:5px;"></span></a></li>
			</ul>
		</div>
	</div>
</nav>