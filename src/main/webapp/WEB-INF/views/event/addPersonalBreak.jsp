<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="<c:url value="/resources/css/event.css" />"
	rel="stylesheet">
	<form action="event/save" method="POST">
	<h1><tt>Add Personal Break</tt></h1>
	
	<div>
	<label for="timeFrom">Time From<input id ="timeFrom" type="time"
	name="timeFrom" class="form-control" placeholder="HH:MM:SS">
	</div>
	<div>
	<label for="duration">Duration<input id ="duration" type="time"
	name="duration" class="form-control" placeholder="HH:MM:SS">
	</div>
	<div>
	<label for="date">Date<input id ="date" type="date"
	name="date" class="form-control" placeholder="DD-MM-YYYY">
	</div>
	<div>
	<button type="submit">Add Break</button>
	
	
	</form>