<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<table>
	<tr>		
		<th>Name</th>
		<th>aGE</th>
		<th>Email</th>
	</tr>
	<c:forEach items="${users}" var="user">
		<tr>			
            <td>${user.firstName} ${user.lastName }</td>
             <td>${user.age}</td>
			<td><a href="users/email/${user.email}">${user.email }</a></td>
		</tr>
	</c:forEach>
</table>

<form action="users/create" method="POST">

	<div>
		<label for="firstName">Name</label> <input id="firstName" type="text"
			name="firstName" class="form-control" placeholder="name">
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