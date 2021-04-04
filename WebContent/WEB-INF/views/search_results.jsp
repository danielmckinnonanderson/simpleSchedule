<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find a patient • simpleSchedule</title>
<spring:url value=".//resources/styles/theme1/theme1.css"
	var="theme1CSS" />
<link href="${theme1CSS}" rel="stylesheet" />
</head>
<body id='CONTAINER_MAIN' style="margin: 0px;">
	<div id='container_page'>

		<!-- HEADER.HTML -->
		<%@ include file="html_resources/header.html"%>

		<!-- PAGE BODY -->
		<section id='container_body'>
			<div class="container_field">

				<h1>results:</h1>
				<table>
					<tr>
						<th><p>First Name</p></th>
						<th><p>Last Name</p></th>
						<th><p>D.O.B.</p></th>
						<th><p>Primary Care</p></th>
						<th><p>Details</p></th>
					</tr>
					
					<c:forEach var="patient" items="${resultsList}">
						<tr>
							<td><p><c:out value="${patient.pFirstName}"/></p></td>
							<td><p><c:out value="${patient.pLastName}"/></p></td>
							<td><p><c:out value="${patient.pDob}"/></p></td>
							<td><p><c:out value="${patient.pPrimary}"/></p></td>
							<td><p><a href=#>View More</a></p></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</section>

		<!-- FOOTER.HTML -->
		<%@ include file="html_resources/footer.html"%>
	</div>


</body>
</html>