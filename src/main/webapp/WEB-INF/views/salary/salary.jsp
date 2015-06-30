<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="<c:url value="/resources/css/salary.css" />"
	rel="stylesheet">

<table>
	<tr>
		<th>User</th>
		<th>Amount</th>
		<th>Role</th>
	</tr>
	<c:forEach items="${salarysList}" var="salary">
		<tr>
			<td><a>${salary.user.firstName} ${salary.user.lastName }</a></td>
			<td><a>${salary.value}</a></td>
		    <td><c:forEach items="${salary.user.roles}" var="role">${role} </c:forEach></td>  
		</tr>
	</c:forEach>
</table>

<form action="salaries/find" method="get">

	<div>
		<label for="dateFrom">Month</label> <input id="dateFrom" type="date"
			name="dateFrom" class="" placeholder="from">
	</div>
	<div>
		<label for="dateTo">Month</label> <input id="dateTo" type="date"
			name="dateTo" class="" placeholder="to">
	</div>
	<div>
		<label for="userId">User</label> <input id="userId" type="number"
			name="userId" class="" placeholder="1">
	</div>

	<button type="submit">Find</button>

</form>


<form action="salaries/create" method="POST">

	<div>
		<label for="dateFrom">Month</label> <input id="dateFrom" type="date"
			name="dateFrom" class="" placeholder="from">
	</div>
	<div>
		<label for="dateTo">Month</label> <input id="dateTo" type="date"
			name="dateTo" class="" placeholder="to">
	</div>
	<div>
		<label for="userName">User</label> <input id="userName" type="text"
			name="userName" class="" placeholder="user name">
	</div>
     <div>
		<label for="userRole">Role</label> <input id="role" type="text"
			name="role" class="" placeholder="role">
	</div>
	<button type="submit">Create</button>

</form>