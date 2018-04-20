<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/views/Header.jsp" />
<div class="col-md-3 col-sm-2 highlight">
	<div id="myContainer" style="width: 100%;"></div>
</div>
</div>
<div class="col-md-6 col-sm-6 highlight">
	<div id="myContainer" style="width: 100%;">

		<h2>
			<b>User Data : </b>
		</h2>
		
	</div>
	
	<br />
	<table border=1>
	<tr><th>Id:</th> <th>Name:</th> <th>Email:</th> <th>Phone:</th><th>City:</th>
	<th>Status:</th> <th>Skill Set:</th> <th>Certification:</th> <th>Pending Action:</th></tr>
	 <c:forEach var="employee" items="${requestScope.employeeList}" varStatus="status">
	<tr>
		<td>${employee.employee_id}</td>
		<td>${employee.employee_name}</td>
		<td>${employee.employee_email}</td>
		<td>${employee.contact_no}</td>
		<td>${employee.address}</td>
		<td>${employee.status}</td>
		<td>${employee.skills}</td>
		<td>${employee.certifications}</td>
		<td><a href="approve?employee_id=${employee.employee_id}">Approve</a></td>
	</c:forEach>
	</table>
</div>


<jsp:include page="/WEB-INF/views/footer.jsp" />