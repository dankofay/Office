<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="<c:url value="/resources/css/event.css" />"
	rel="stylesheet">
	<form action="event/save" method="POST">
	
	<div>
	
	<label for="date">date<input id ="date" type="date"
	name="date" class="" placeholder="DD-MM-YYYY">
	</div>
	<div>
	<label for="type">type_id<input id ="type" type="text"
	name="type" class="" placeholder="enter type">
	</div>
	<button type="submit">Add all users</button>
	
	</form>