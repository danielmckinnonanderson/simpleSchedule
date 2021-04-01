<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find a patient • simpleSchedule</title>
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
					<h1>find an existing patient:</h1>
					<h4>fill out one or more forms to refine search:</h4>
				</div>
				<div>
					<form>
						<div class="form_row">
							<h4>First name: </h4>
							<input type="text" name="name_first" class="form_input_large" placeholder="Patient first name">
						</div>
						<div class="form_row">
							<h4>Last name: </h4>
							<input type="text" name="name_last" class="form_input_large" placeholder="Patient last name">
						</div>
						<div class="form_row">
							<h4>Birth Date: </h4>
							<input type="date" name="dob" id="form_dob">
							<h4>Primary Doctor:</h4>
							<select> <!-- NOTE: add java scriplet to make options dynamically reflect employees w title 'Doctor' -->
								<option>Select physician</option>
								<option>K. Bravo</option>
								<option>E. Leibowitz</option>
								<option>A. Pelham</option>
								<option>M. Watters</option>
								<option>L. Whitener</option>
								<option>E. Wolford</option>
							</select>
						</div>
						<div class="form_row" style="justify-content: center;">
							<input type="submit" name="search" id="form_submit">
						</div>
					</form>
				</div>
			</div>
		</section>

		<!-- FOOTER.HTML -->
		<%@ include file="html_resources/footer.html" %>
	</div>


</body>
</html>
