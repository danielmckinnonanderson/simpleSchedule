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
				<h3 style="color: #2f451d;">Patient details</h3>
				<div id="patient_details_header">
					<h1 id="patient_details_name"><c:out value="${viewPatient.pFirstName} ${viewPatient.pLastName}"/></h1>
					<a href="./appointment_add"><button class="form_button">Schedule Appointment</button></a>
				</div>
				<div>
					<div class="details_section_header">
						<h3 class="details_section_title">Patient information</h3>
						<p><a href="update_info"><button class="details_button">Update Patient Info</button></a></p>
					</div>
					<div class="details_section_body">
						<h4>Birth Date</h4><p><fmt:formatDate value="${viewPatient.pDob}" type="date" pattern="MM-dd-YYYY" /></p>
						<!-- TO DO: add 'preferred location' -->
						<h4>Primary Care</h4><p>${doctorList.get(viewPatient.pPrimary-1).sLastName}</p>
					</div>
					<div class="details_section_header">
						<h3 class="details_section_title">Contact</h3>
						<p><a href="./update_contact"><button class="details_button">Update Contact</button></a></p>
					</div>
 					<div class="details_section_body">
						<h4>Phone 1</h4><p> ${viewContact.cPhone1}</p>
						<c:if test="${viewContact.cPhone2 != null}"><h4>Phone 2:</h4><p> ${viewContact.cPhone2}</p></c:if>
						<c:if test="${viewContact.cPhone3 != null}"><h4>Phone 3:</h4><p> ${viewContact.cPhone3}</p></c:if>
						<h4>Email</h4><p>${viewContact.cEmail}</p>
					</div>
					<div class="details_section_header">
						<h3 class="details_section_title">Insurance</h3>
						<p><a href="./update_insurance"><button class="details_button">Update Insurance</button></a></p>
					</div>
					<div class="details_section_body">
						<h4>Insurance Provider</h4><p>${viewInsurance.iProvider}</p>
						<h4>Insurance ID</h4><p> ${viewInsurance.iId}</p>
						<h4>Group ID</h4><p> ${viewInsurance.iGroupId}</p>
						<h4>Plan ID</h4><p> ${viewInsurance.iPlanId}</p>
					</div>
				</div>
				<div>
					<div style="display: flex; justify-content: center;">
						<h3 style="color: #917640;">Upcoming appointments</h3>
					</div>
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
							<c:if test="${viewAppointments.size() == 0}">
								<tr>
									<td colspan="6"><p style="text-align: center;">No appointments scheduled!</p></td>
								</tr>
							</c:if>
							<c:forEach var="appointment" items="${viewAppointments}">
								<tr>
									<form:form path="delete_appointment" method="get" action ="./delete_appointment">
										<td><p><fmt:formatDate value="${appointment.value.aDate}" type="date" pattern="MM-dd-YY"/></p></td>
										<td><p><fmt:formatDate value="${appointment.value.aTimeStart}" type="time" pattern="hh:mm a"/></p></td>
										<td><p><fmt:formatDate value="${appointment.value.aTimeEnd}" type="time" pattern="hh:mm a"/></p></td>
										<td><p><c:out value="${locationMap.get(appointment.value.aLocationId).lCity}, ${locationMap.get(appointment.value.aLocationId).lState}" /></p></td>
										<td><p><c:out value="${doctorList.get(appointment.value.aPrimaryId-1).sLastName}"/></p></td>
										<input type="hidden" value="${appointment.key}" name="appointmentId"/>
										<td><input type="submit" value="Delete" class="results_button_delete"/></td>
									</form:form>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div style="margin-top: 60px; display: flex; justify-content: center;">
					<a href="./delete_patient"><button type="button" class="form_button_delete">Delete Patient</button></a>
				</div>
			</div>
		</section>

		<!-- FOOTER.HTML -->
		<%@ include file="html_resources/footer.html"%>
	</div>


</body>
</html>
