<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home • simpleSchedule</title>
	<spring:url value=".//resources/styles/theme1/theme1.css" var="theme1CSS"/>
	<link href="${theme1CSS}" rel="stylesheet"/>
</head>
<body id='CONTAINER_MAIN' style="margin: 0px;">
	<div id='container_page'>

		<!-- HEADER.HTML -->
		<%@ include file="html_resources/header.html" %>

		<section id='container_body'>
			<div>

				<div id='list_body'>
					<div class="button_body">
						<a href="./patient_search"><h3>Find current patient</h3></a>
					</div>
					<div class="button_body">
						<a href="./patient_add"><h3>Add a first-time patient</h3></a>
					</div>
					<div class="button_body">
						<a href="./appointment_search"><h3>Find existing
								appointment</h3></a>
					</div>
				</div>
			</div>

		</section>

		<!-- FOOTER.HTML -->
		<%@ include file="html_resources/footer.html" %>
	</div>


</body>
</html>