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
					<h1>add a first-time patient:</h1>
					<h5>*starred fields are required*</h5>
				</div>
				<div>
					<h3>Contact Information</h3>
					<form:form action="./patient_add_contact" method="post"
						modelAttribute="newContact">
						<div class="form_row">
							<h4 style="color: red;">*</h4>
							<h4>Email:</h4>
							<form:input class="form_input_large" path="cEmail" type="email"
								placeholder="johndoe@example.com" />
							<p>
								<form:errors path="cEmail" />
							</p>
						</div>
						<div class="form_row">
							<h4 style="color: red;">*</h4>
							<h4>Primary Phone:</h4>
							<form:input class="form_input_large" path="cPhone1" type="text"
								placeholder="5559990000" />
						</div>
						<div class="form_row">
							<h4>Phone 2:</h4>
							<form:input class="form_input_large" path="cPhone2" type="text"
								placeholder="5559990000" />
							<h4>Phone 3:</h4>
							<form:input class="form_input_large" path="cPhone3" type="text"
								placeholder="5559990000" />
						</div>
						<div class="form_row" style="justify-content: center;">
							<input type="submit" value="Submit New Patient" id="form_add">
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