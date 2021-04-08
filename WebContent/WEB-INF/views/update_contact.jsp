<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update contact • simpleSchedule</title>
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
					<h1>update ${viewPatient.pFirstName} ${viewPatient.pLastName}'s contact info:</h1>
				</div>
				<div>
					<form:form action="./update_contact" method="post"
						modelAttribute="updateContact">
						<form:hidden path="cPatientId" value="${viewPatient.pId}"/>
						<div class="form_row">
							<h4>Email:</h4>
							<form:input class="form_input_large" path="cEmail" type="email"
								placeholder="${viewContact.cEmail}" />
							<p>
								<form:errors path="cEmail" />
							</p>
						</div>
						<div class="form_row">
							<h4>Primary Phone:</h4>
							<form:input class="form_input_large" path="cPhone1" type="text"
								placeholder="${viewContact.cPhone1}" />
						</div>
						<div class="form_row">
							<h4>Phone 2:</h4>
							<form:input class="form_input_large" path="cPhone2" type="text"
								placeholder="${viewContact.cPhone2}" />
							<h4>Phone 3:</h4>
							<form:input class="form_input_large" path="cPhone3" type="text"
								placeholder="${viewContact.cPhone3}" />
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