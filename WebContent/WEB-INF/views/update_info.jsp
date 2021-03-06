<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update patient info • simpleSchedule</title>
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
					<h1>update ${viewPatient.pFirstName} ${viewPatient.pLastName}'s info:</h1>
				</div>
				<div>
					<form:form action="./update_info" method="post"
						modelAttribute="updatePatient">
						<form:hidden path="pId" value="${viewPatient.pId}"/>
						<div class="form_row">
							<h4>First name:</h4>
							<form:input path="pFirstName" type="text"
								class="form_input_large" placeholder="First Name" />
							<p>
								<form:errors path="pFirstName" />
							</p>
						</div>
						<div class="form_row">
							<h4>Last name:</h4>
							<form:input path="pLastName" type="text" class="form_input_large"
								placeholder="Last Name" />
							<p>
								<form:errors path="pLastName" />
							</p>
						</div>
						<div class="form_row">
						<!-- 
							<h4>Birth Date:</h4>
							<form:input path="pDob" type="date" name="dob" id="form_dob" placeholder="${viewPatient.pDob}" />
							<p>
								<form:errors path="pDob" />
							</p>
						-->
							<h4>Primary Doctor:</h4>
							<form:select path="pPrimary">
								<option value=""> Select </option>
								<c:forEach items="${doctorList}" var="doctor">
									<option value="${doctor.sId}">${doctor.sLastName}</option>
								</c:forEach>
							</form:select>
							<p>
								<form:errors path="pPrimary" />
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