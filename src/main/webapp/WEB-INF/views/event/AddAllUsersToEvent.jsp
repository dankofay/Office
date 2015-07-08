<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="<c:url value="/resources/css/event.css" />"
	rel="stylesheet">
	
	<form action="event/save" method="POST">
	<h1><tt>Add all users to event</tt></h1>
	<div>
	
	<label for="date">Date<input id ="date" type="date"
	name="date" class="form-control" placeholder="DD-MM-YYYY">
	</div>
	<div>
	<label for="type">Type<input id ="type" type="text"
	name="type" class="form-control" placeholder="enter type">
	</div>
	<button type="submit">Add all users</button>
	
	</form>