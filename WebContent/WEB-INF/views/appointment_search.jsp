<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search for an appointment • simpleSchedule</title>
	<spring:url value=".//resources/styles/theme1/theme1.css" var="theme1CSS"/>
	<link href="${theme1CSS}" rel="stylesheet"/>
</head>
<body id='CONTAINER_MAIN' style="margin: 0px;">
	<div id='container_page'>

		<!-- HEADER.HTML -->
		<%@ include file="html_resources/header.html" %>

		<!-- PAGE BODY -->
		<section id='container_body'>
			<div class="container_field">
				<div id="container_field_header">
					<h1>find an appointment:</h1>
					<h4>fill out one or more forms to refine search:</h4>
				</div>
								<div>
					<form:form action="./appointment_search" method="post" modelAttribute="searchAppointment">
						<div class="form_row">
							<h4>Date:</h4>
							<form:input path="aDate" type="date"/>
							<h4>Start Time:</h4>
							<form:input path="aTimeStart" type="time" min="08:00" max="04:30" step="900"/>			
						</div>
						<div class="form_row">
							<h4>Location:</h4>
							<form:select path="aLocationId">
								<option value=""> Select </option>
								<c:forEach items="${locationMap}" var="location">
									<option value="${location.key}">${location.value.lCity}, ${location.value.lState}</option>
								</c:forEach>
							</form:select>
							<h4>Physician:</h4>
							<form:select path="aPrimaryId">
								<option value=""> Select </option>
								<c:forEach items="${doctorList}" var="doctor">
									<option value="${doctor.sId}">${doctor.sLastName}</option>
								</c:forEach>
							</form:select>
						</div>
						<c:if test ="${hasErrors}">
							<div id="form_errorbox">
								<p><form:errors path="aDate"/></p>
								<p><form:errors path="aTimeStart"/></p>
								<p><form:errors path="aLocationId"/></p>
								<p><form:errors path="aPrimaryId"/></p>
							</div>
						</c:if>
						<div class="form_row" style="justify-content: center;">
							<input type="submit" value="Search" id="form_submit">
						</div>
					</form:form>
				</div>
			</div>
		</section>

		<!-- FOOTER.HTML -->
		<%@ include file="html_resources/footer.html" %>
	</div>
</body>
</html>