<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="<c:url value="/resources/css/event.css" />"
	rel="stylesheet">
	<form action="event/save" method="POST">
	
	<div>
	<label for="timeFrom">Time From<input id ="timeFrom" type="time"
	name="timeFrom" class="" placeholder="HH:MM:SS">
	</div>
	<div>
	<label for="duration">duration<input id ="duration" type="time"
	name="duration" class="" placeholder="HH:MM:SS">
	</div>
	<div>
	<label for="date">date<input id ="date" type="date"
	name="date" class="" placeholder="DD-MM-YYYY">
	</div>
	<div>
	<label for="type_id">type_id<input id ="type_id" type="number"
	name="type_id" class="" placeholder="number">
	</div>
	<button type="submit">Create</button>
	
	</form>