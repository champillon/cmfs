<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Language" content="th">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Title</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Birth Date</th>
			<th>Mobile</th>
			<th>e-Mail</th>
			<th>T-Shirt Size</th>
			<th>T-Shirt Pick-Up Point</th>
			<th>Uploaded Pay Slip</th>
		</tr>
		<c:forEach var="registedPerson" items="${requestScope.registedPeople}">
			<tr>
				<td><c:out value="${registedPerson.title}" /></td>
				<td><c:out value="${registedPerson.firstName}" /></td>
				<td><c:out value="${registedPerson.lastName}" /></td>
				<td><c:out value="${registedPerson.birthDate}" /></td>
				<td><c:out value="${registedPerson.mobile}" /></td>
				<td><c:out value="${registedPerson.email}" /></td>
				<td><c:out value="${registedPerson.tShirtSize}" /></td>
				<td><c:out value="${registedPerson.tShirtPickUpPoint}" /></td>
				<td><c:out value="${registedPerson.payInSlipPath}" /></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>