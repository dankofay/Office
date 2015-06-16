<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="<c:url value="/resources/css/salary.css" />" rel="stylesheet">

<table>
	<tr>
		<th>User</th>
		<th>Amount</th>
	</tr>
	<c:forEach items="${salarysList}" var="salary">
		<tr>
		<%-- 	<td><a>${salary.user.firstName} ${salary.user.lastName }</a></td> --%>
			<td><a>${salary.value}</a></td>
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