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
<title>Patient details • simpleSchedule</title>
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
				<h3>patient details</h3>
				<h1><c:out value="${viewPatient.pFirstName} ${viewPatient.pLastName}"/></h1>
				<div class="form_row">
					<h5><a href="./appointment_add"><button class="form_button">Schedule Appointment</button></a></h5>
					<h5><a href="./delete_patient"><button type="button" class="form_button">Delete Patient</button></a></h5>
				</div>
				<div>
					<div class="form_row">
						<h3>patient info</h3>
						<p><a href="update_info">Update Patient Info</a></p>
					</div>
					<ul>
						<li class="form_row"><h4>Birth Date:</h4><p><fmt:formatDate value="${viewPatient.pDob}" type="date" pattern="MM-dd-YYYY" /></p></li>
						<!-- TO DO: add 'preferred location' -->
						<li class="form_row"><h4>Primary Care:</h4><p>${doctorList.get(viewPatient.pPrimary-1).sLastName}</p>
					</ul>
					<div class="form_row">
						<h3>contact info</h3>
						<p><a href="./update_contact">Update Contact</a></p>
					</div>
					<ul>
						<li class="form_row"><h4>Phone 1:</h4><p> ${viewContact.cPhone1}</p></li>
						<li class="form_row"><h4>Phone 2:</h4><p> ${viewContact.cPhone2}</p></li>
						<li class="form_row"><h4>Phone 3:</h4><p> ${viewContact.cPhone3}</p></li>
						<li class="form_row"><h4>Email:</h4><p>${viewContact.cEmail}</p>
					</ul>
					<div class="form_row">
						<h3>insurance info</h3>
						<p><a href="./update_insurance">Update Insurance</a></p>
					</div>
					<ul>
						<li class="form_row"><h4>Insurance Provider:</h4><p>${viewInsurance.iProvider}</p></li>
						<li class="form_row"><h4>Insurance ID:</h4><p> ${viewInsurance.iId}</p></li>
						<li class="form_row"><h4>Group ID:</h4><p> ${viewInsurance.iGroupId}</p></li>
						<li class="form_row"><h4>Plan ID:</h4><p> ${viewInsurance.iPlanId}</p></li>
					</ul>
				</div>
				<div>
				<h3>upcoming appointments</h3>
				<table id='results_table'>
					<thead id='results_header'>
						<tr>
							<th><p>Date</p></th>
							<th><p>Start Time</p></th>
							<th><p>End Time</p></th>
							<th><p>Location</p></th>
							<th><p>Provider</p></th>
							<th><p>Delete</p></th>
						</tr>
					</thead>
					<tbody id='results_body'>
						<c:forEach var="appointment" items="${viewAppointments}">
							<tr>
								<form:form path="./delete_appointment" method="get" action ="./delete_appointment">
									<td><p><fmt:formatDate value="${appointment.value.aDate}" type="date" pattern="MM-dd-YY"/></p></td>
									<td><p><fmt:formatDate value="${appointment.value.aTimeStart}" type="time" pattern="hh:mm a"/></p></td>
									<td><p><fmt:formatDate value="${appointment.value.aTimeEnd}" type="time" pattern="hh:mm a"/></p></td>
									<td><p><c:out value="${locationMap.get(appointment.value.aLocationId).lCity}, ${locationMap.get(appointment.value.aLocationId).lState}" /></p></td>
									<td><p><c:out value="${doctorList.get(appointment.value.aPrimaryId-1).sLastName}"/></p></td>
									<input type="hidden" value="${appointment.key}" name="appointmentId"/>
									<td><input type="submit" value="Delete"/></td>
								</form:form>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				</div>
			</div>
		</section>

		<!-- FOOTER.HTML -->
		<%@ include file="html_resources/footer.html"%>
	</div>


</body>
</html>
