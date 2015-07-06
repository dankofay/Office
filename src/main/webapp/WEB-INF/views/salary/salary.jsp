<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="<c:url value="/resources/css/salary.css" />"
	rel="stylesheet">

<table class="table table-striped" style="border: 1px solid black;" cellpadding="6" cellspacing="8">
  <tr valign="baseline" bgcolor="#404060">
    <th align="center"> User </th>
    <th align="left"> Value </th>
    <th align="right"> Role </th>
	<c:forEach items="${salarysList}" var="salary">
		<tr>
			<td><a>${salary.userName}</a></td>
			<td><a>${salary.salaryValue}</a></td>
			<td><a>${salary.roles}</a></td>
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

	<button type="submit">Create</button>

</form>