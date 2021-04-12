<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add a new patient • simpleSchedule</title>
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
				<div id="container_field_header">
					<h1>Add a first-time patient</h1>
					<h4>*Starred fields are required*</h4>
				</div>
				<div>
					<h3 id="patient_add_header">Patient Information</h3>
					<form:form action="./patient_add" method="post"
						modelAttribute="newPatient">
						<div class="form_row">
							<h4>* First name:</h4>
							<form:input path="pFirstName" type="text" id="form_input_namef"
								class="form_input_large" placeholder="Patient first name" />
						</div>
						<div class="form_row">
							<h4>* Last name:</h4>
							<form:input path="pLastName" type="text" id="form_input_namel"
								class="form_input_large" placeholder="Patient last name" />
						</div>
						<div class="form_row">
							<div class="form_row">
								<h4>* Birth Date:</h4>
								<form:input path="pDob" type="date" name="dob" id="form_dob" />
							</div>
							<div class="form_row">
								<h4>Primary Doctor:</h4>
								<form:select path="pPrimary" id="form_doctor">
									<option value="">Select</option>
									<c:forEach items="${doctorList}" var="doctor">
										<option value="${doctor.sId}">${doctor.sLastName}</option>
									</c:forEach>
								</form:select>
							</div>
						</div>
						<c:if test ="${hasErrors}">
							<div id="form_errorbox">
								<p><form:errors path="pFirstName"/></p>
								<p><form:errors path="pLastName"/></p>
								<p><form:errors path="pDob"/></p>
								<p><form:errors path="pPrimary"/></p>
							</div>
						</c:if>
						<div class="form_row" style="justify-content: center; margin-top: 30px;">
							<input type="submit" value="Next: Insurance Info" class="form_button">
						</div>
					</form:form>
				</div>
			</div>
		</section>

		<!-- FOOTER.HTML -->
		<%@ include file="html_resources/footer.html"%>
	</div>


</body>
</html>