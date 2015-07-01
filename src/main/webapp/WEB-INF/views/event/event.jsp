<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<link href="<c:url value="/resources/css/event.css" />" rel="stylesheet">
<table>
	<tr>
		<th>Date |</th>
		<th>Type |</th>
		<th>Starts |</th>
		<th>Duration |</th>
		<th>is Confirmed</th>
	</tr>
	<c:forEach items="${eventList}" var="event">
		<tr>
			<td><a>${event.schedule.date}}</a></td>
			<td><a>${event.type.nameType}}</a></td>
			<td><a>${event.timeFrom}</a></td>
			<td><a>${event.duration}</a></td>
			<td><a>${event.isConfirmed}</a></td>
		</tr>
	</c:forEach>
</table>
<sec:authorize access="isAuthenticated()">
	<form action="event/save" method="POST">

		<div>
			<h2>Add all users to event</h2>
			<label for="date">date<input id="date" type="date"
				name="date" class="form-control" placeholder="DD-MM-YYYY">
		</div>
		<div>
			<label for="type">type_id<input id="type" type="text"
				name="type" class="form-control" placeholder="enter type">
		</div>
		<button type="submit">Add all users</button>

	</form>

	<form action="event/save" method="POST">

		<h2>Add break</h2>
		<div>
			<label for="timeFrom">Time From<input id="timeFrom"
				type="time" name="timeFrom" class="form-control"
				placeholder="HH:MM:SS">
		</div>
		<div>
			<label for="duration">duration<input id="duration"
				type="time" name="duration" class="form-control"
				placeholder="HH:MM:SS">
		</div>
		<div>
			<label for="date">date<input id="date" type="date"
				name="date" class="form-control" placeholder="DD-MM-YYYY">
		</div>
		<div>

			<jsp:include page="AddAllUsersToEvent.jsp"></jsp:include>

			<button type="submit">Add Break</button>
	</form>

	<form action="event" method="POST">
		<h2>Create event</h2>
		<div>
			<label for="timeFrom">Time From<input id="timeFrom"
				type="time" name="timeFrom" class="form-control"
				placeholder="HH:MM:SS">
		</div>
		<div>
			<label for="duration">duration<input id="duration"
				type="time" name="duration" class="form-control"
				placeholder="HH:MM:SS">
		</div>
		<div>
			<label for="date">date<input id="date" type="date"
				name="date" class="form-control" placeholder="DD-MM-YYYY">
		</div>
		<div>
			<label for="type_id">type_id<input id="type_id" type="number"
				name="type_id" class="form-control" placeholder="number">
		</div>
		<button type="submit">Create</button>

	</form>

</sec:authorize>