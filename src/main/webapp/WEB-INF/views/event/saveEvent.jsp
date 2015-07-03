<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="<c:url value="/resources/css/event.css" />"
	rel="stylesheet">
	<form action="event" method="POST">
	<h2>Create event</h2>
	<div>
	<label for="timeFrom">Time From<input id ="timeFrom" type="time"
	name="timeFrom" class="form-control" placeholder="HH:MM:SS">
	</div>
	<div>
	<label for="duration">duration<input id ="duration" type="time"
	name="duration" class="form-control" placeholder="HH:MM:SS">
	</div>
	<div>
	<label for="date">date<input id ="date" type="date"
	name="date" class="form-control" placeholder="DD-MM-YYYY">
	</div>
	<div>
	<label for="type_id">type_id<input id ="type_id" type="number"
	name="type_id" class="form-control" placeholder="number">
	</div>
	<button type="submit">Create</button>
	
	</form>