<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<link href="<c:url value="/resources/css/event.css" />" rel="stylesheet">
<table>
	<tr background="yellow">
		<th >Date |</th>
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
</sec:authorize>
	
<hr>
	
	<jsp:include page="saveEvent.jsp"></jsp:include>	
	<hr>	
<jsp:include page="AddAllUsersToEvent.jsp"></jsp:include>
<hr>
	<jsp:include page="addPersonalBreak.jsp"></jsp:include>
<hr>
