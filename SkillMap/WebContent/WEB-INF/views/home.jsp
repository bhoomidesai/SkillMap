<jsp:include page="/WEB-INF/views/Header.jsp"/>
<div class="col-md-3 col-sm-2 highlight">
    <div id="myContainer" style=" width: 100%;"></div></div></div>
<div class="col-md-6 col-sm-6 highlight">
<div id="myContainer" style=" width: 100%;">

    <h2><b>My Data : </b></h2>
    <table border=1>
	<tr><th>Id:</th>
	<th>Name:</th>
	<th>Email:</th>
	<th>Phone:</th>
	<th>City:</th>
	<th>Qualification:</th>
	<th>Skill Set:</th>
	<th>Edit</th>
	
	<tr>
	<td>${employee.employee_id}</td>
	<td>${requestScope.employee.employee_name}</td>
	<td>${requestScope.employee.employee_email}</td>
	<td>${requestScope.employee.contact_no}</td>
	<td>${requestScope.employee.address}</td>
	<td>${requestScope.employee.qualification}</td>
	<td>${requestScope.employee.skills}</td>
	
	<td><a href="edit?employee_id=${requestScope.employee.employee_id}" >Edit</a></td>
	</tr>
	</table>
</div>
    <br/>
</div>

      
<jsp:include page="/WEB-INF/views/footer.jsp"/>