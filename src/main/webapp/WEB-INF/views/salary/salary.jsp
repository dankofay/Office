<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="<c:url value="/resources/css/salary.css" />"
	rel="stylesheet">

<table id="salaries_table" class="table table-striped"
	style="border: 1px solid black;">

	<thead>
		<tr valign="baseline" bgcolor="#404060">
			<th align="left">User</th>
			<th align="center">Value</th>
			<th align="right">Role</th>
		</tr>
	</thead>
	<tbody id="content">
	</tbody>

</table>

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

<button id="show-salaries">show</button>
<div id="salary_create">
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
			name="userId" class="form-control" placeholder="1">
	</div>

	<button id = "create-salary" class= "btn btn-sample">Submit</button>
	</div>

<script src="resources/js/salary.js"></script>