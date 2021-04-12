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
<title>Delete an appointment • simpleSchedule</title>
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

					<div id="form_errorbox" style="text-align: center;">
						<form action="./delete_appointment"  method="post">
							<h3>Are you sure you want to remove ${viewPatient.pFirstName} ${viewPatient.pLastName}'s appointment on 
							<fmt:formatDate value="${deleteAppointment.aDate}" type="date" pattern="MM-dd-YY"/> at 
							<fmt:formatDate value="${deleteAppointment.aTimeStart}" type="time" pattern="hh:mm a"/> 
							with Dr. ${doctorList.get(deleteAppointment.aPrimaryId -1).sLastName} from the system?</h3>
							<h3>This action cannot be undone!</h3>
							<input type = hidden name="aId" value="${aId}"/>
							<div class="form_row">
									<input type="button" class="results_button" onclick="history.go(-1);" value="No, go back"/>
									<button type="submit" class="results_button_delete">Yes, delete appointment</button>
							</div>
						</form>
					</div>
			</div>
		</section>

		<!-- FOOTER.HTML -->
		<%@ include file="html_resources/footer.html"%>
	</div>


</body>
</html>
