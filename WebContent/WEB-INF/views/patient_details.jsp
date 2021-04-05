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
<title>Patient details • simpleSchedule</title>
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

				<h1><c:out value="${viewPatient.pFirstName} ${viewPatient.pLastName}"/></h1>
				<div>
					<h3>patient info</h3>
					<ul>
						<li class="form_row"><h4>Birth Date:</h4><p><fmt:formatDate value="${viewPatient.pDob}" type="date" pattern="MM-dd-YYYY" /></p></li>
						<!-- TO DO: add 'preferred location' -->
						<li class="form_row"><h4>Primary Care:</h4><p>${doctorList.get(viewPatient.pPrimary-1).sLastName}</p>
					</ul>
					<h3>contact info</h3>
					<ul>
						<li class="form_row"><h4>Phone 1:</h4><p> ${viewContact.cPhone1}</p></li>
						<li class="form_row"><h4>Phone 2:</h4><p> ${viewContact.cPhone2}</p></li>
						<li class="form_row"><h4>Phone 3:</h4><p> ${viewContact.cPhone3}</p></li>
						<li class="form_row"><h4>Email:</h4><p>${viewContact.cEmail}</p>
					</ul>
					<h3>insurance info</h3>
					<ul>
						<li class="form_row"><h4>Insurance ID:</h4><p> ${viewInsurance.iId}</p></li>
						<li class="form_row"><h4>Group ID:</h4><p> ${viewInsurance.iGroupId}</p></li>
						<li class="form_row"><h4>Plan ID:</h4><p> ${viewInsurance.iPlanId}</p></li>
					</ul>
				</div>
				<div>
				<h3>upcoming appointments</h3>
				<table id='results_table'>
					<thead id='results_header'>
						<tr>
							<th><p>Date</p></th>
							<th><p>Start Time</p></th>
							<th><p>End Time</p></th>
							<th><p>Location</p></th>
							<th><p>Provider</p></th>
							<th><p>Modify</p></th>
						</tr>
					</thead>
					<tbody id='results_body'>
						<!-- IMPLEMENT APPOINTMENT TABLE LATER -->
					</tbody>
				</table>
				</div>
			</div>
		</section>

		<!-- FOOTER.HTML -->
		<%@ include file="html_resources/footer.html"%>
	</div>


</body>
</html>
