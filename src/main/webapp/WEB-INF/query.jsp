<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Language" content="th">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Colour Miles for Smiles: Query Registed People</title>
</head>
<body>
	<h2><a href="http://newsletter.operationsmile.or.th/summary/" target="_blank">Download CSV</a></h2><br/>
	<br/>
	<table border="1">
		<tr>
			<th>#</th>
			<th>Title</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>First Name (Eng)</th>
			<th>Last Name (Eng)</th>
			<th>Birth Date</th>
			<th>Mobile</th>
			<th>e-Mail</th>
			<th>Uploaded Pay Slip</th>
			<th>Confirm PaySlip</th>
		</tr>
		<c:forEach var="registedPerson" items="${requestScope.registedPeople}">
			<tr>
				<td><c:out value="${registedPerson.runningId}" /></td>
				<td><c:out value="${registedPerson.title}" /></td>
				<td><c:out value="${registedPerson.firstName}" /></td>
				<td><c:out value="${registedPerson.lastName}" /></td>
				<td><c:out value="${registedPerson.firstNameEn}" /></td>
				<td><c:out value="${registedPerson.lastNameEn}" /></td>
				<td><c:out value="${registedPerson.birthDate}" /></td>
				<td><c:out value="${registedPerson.mobile}" /></td>
				<td><c:out value="${registedPerson.email}" /></td>
				<td>
					<a href="http://newsletter.operationsmile.or.th/uploaded/${registedPerson.payInSlipPath}" 
						target="_blank">
						<c:out value="${registedPerson.payInSlipPath}" />
					</a>
				</td>
				<td>
					<form action="./Update" method="post">
						<input type="hidden" name="runningId" value="${registedPerson.runningId}">
						<c:if test="${empty registedPerson.runnerId }">
							<input type="submit" value="Confirm Payment">
						</c:if>
					</form>
				</td>
			</tr>
			<tr>
				<td colSpan="14">
					ผู้วิ่งร่วม: <c:out value="${registedPerson.coRunner}" />
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>