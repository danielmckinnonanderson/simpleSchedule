<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find an appointment • simpleSchedule</title>
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
				
				<table id='results_table'>
					<thead id='results_header'>
						<tr>
							<th><p>Date</p></th>
							<th><p>Patient</p></th>
							<th><p>Start Time</p></th>
							<th><p>End Time</p></th>
							<th><p>Location</p></th>
							<th><p>Physician</p></th>
							<th><p>Actions</p></th>
						</tr>
					</thead>
					<tbody id='results_body'>
						<c:forEach var="appointment" items="${resultsList}">
								<tr>
									<td><p><fmt:formatDate value="${appointment.aDate}" type="date" pattern="MM-dd-YY"/></p></td>
									<td><p><c:out value="${appointment.aPatientId}" /></p></td>
									<td><p><fmt:formatDate value="${appointment.aTimeStart}" type="time" pattern="HH:mm a"/></p></td>
									<td><p><fmt:formatDate value="${appointment.aTimeEnd}" type="time" pattern="HH:mm a"/></p></td>
									<td><p><c:out value="${locationMap.get(appointment.aLocationId).lCity}, ${locationMap.get(appointment.aLocationId).lState}" /></p></td>
									<td><p><c:out value="${doctorList.get(appointment.aPrimaryId -1).sLastName}"/></p></td>
									<td><p> Button </p></td>
								</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</section>

		<!-- FOOTER.HTML -->
		<%@ include file="html_resources/footer.html"%>
	</div>


</body>
</html>
