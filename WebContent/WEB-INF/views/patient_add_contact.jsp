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
					<h3 id="patient_add_header">Contact Information</h3>
					<form:form action="./patient_add_contact" method="post"
						modelAttribute="newContact">
						<div class="form_row">
							<h4>* Email:</h4>
							<form:input class="form_input_large" id="form_input_email" path="cEmail" 
							type="email" placeholder="johndoe@example.com" />
						</div>
						<div class="form_row" style="justify-content: flex-start;">
							<h4>* Primary Phone (Home):</h4>
							<form:input class="form_input_large" id="form_input_phone1" path="cPhone1"
								placeholder="5559990000" />
						</div>
						<div class="form_row">
							<h4>Phone 2 (Work):</h4>
							<form:input class="form_input_large" id="form_input_phone2" path="cPhone2"
								placeholder="5559990000" />
							<h4>Phone 3:</h4>
							<form:input class="form_input_large" id="form_input_phone3" path="cPhone3"
								placeholder="5559990000" />
						</div>
						<c:if test ="${hasErrors}">
							<div id="form_errorbox">
								<p><form:errors path="cEmail"/></p>
								<p><form:errors path="cPhone1"/></p>
								<p><form:errors path="cPhone2"/></p>
								<p><form:errors path="cPhone3"/></p>
							</div>
						</c:if>
						<div class="form_row" style="justify-content: center; margin-top: 30px;">
							<input type="submit" value="Submit New Patient" class="form_button">
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