<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<table class="table table-striped">
	<tr>
		<th>Name</th>
		<th>Age</th>
		<th>Email</th>
		<th>Roles</th>
		<th>Rate</th>
	</tr>
	<c:forEach items="${usersList}" var="user">
		<tr>
			<td>${user.fullName }</td>
			<td>${user.age}</td>
			<td><a href="users/email/${user.email}">${user.email }</a></td>
			<td><c:forEach items="${user.roles}" var="role">${role } </c:forEach></td>
			<td>${user.rateValue}</td>
		</tr>
	</c:forEach>
</table>

<form action="users" method="POST">

	<div>
		<label for="firstName">Name</label> <input id="firstName" type="text"
			name="firstName" class="form-control" placeholder="firstName">
	</div>
		<div>
		<label for="firstName">Name</label> <input id="lastName" type="text"
			name="lastName" class="form-control" placeholder="lastName">
	</div>
	<div>
		<label for="email">Email</label> <input id="email" type="email"
			name="email" class="form-control" placeholder="example@mail.com">
	</div>
	<div>
		<label for="password">Password</label> <input id="password"
			type="password" name="password" class="form-control"
			placeholder="password">
	</div>

	<button type="submit">Submit</button>

</form>