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
					<h1>update ${viewPatient.pFirstName} ${viewPatient.pLastName}'s insurance info:</h1>
				</div>
				<div>
					<form:form action="./update_insurance" method="post"
						modelAttribute="updateInsurance">
						<div class="form_row">
							<form:hidden path="iPatientId" value="${viewInsurance.iPatientId}" />
							<h4>Insurance Provider:</h4>
							<form:select path="iProvider" type="select" id="provider_select">
								<option value="">Select an option:</option>
								<option value="Blue Cross Blue Shield">Blue Cross Blue
									Shield</option>
								<option value="HealthPartners">HealthPartners</option>
								<option value="Medica">Medica</option>
								<option value="PreferredOne">PreferredOne</option>
								<option value="United">United Healthcare</option>
							</form:select>

							<h4>Insurance ID:</h4>
							<form:input path="iId" type="text" class="form_input_large"
								placeholder="${viewInsurance.iId}" />
							<p>
								<form:errors path="iId" />
							</p>
						</div>
						<div class="form_row">
							<h4>Group ID:</h4>
							<form:input path="iGroupId" type="text" class="form_input_large"
								placeholder="${viewInsurance.iGroupId}" />
							<p>
								<form:errors path="iGroupId" />
							</p>
							<h4 style="color: red;">*</h4>
							<h4>Plan ID:</h4>
							<form:input path="iPlanId" type="text" class="form_input_large"
								placeholder="${viewInsurance.iPlanId}" />
							<p>
								<form:errors path="iPlanId" />
							</p>
						</div>
						<div class="form_row" style="justify-content: center;">
							<input type="submit" value="Update" id="form_add">
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