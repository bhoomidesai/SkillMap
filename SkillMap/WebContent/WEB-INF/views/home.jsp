<jsp:include page="/WEB-INF/views/Header.jsp"/>
<div class="col-md-3 col-sm-2 highlight">
    <div id="myContainer" style=" width: 100%;"></div></div></div>
<div class="col-md-6 col-sm-6 highlight">
<div id="myContainer" style=" width: 100%;">

    <h2><b>My Data : </b></h2>
    <table border=1>
	<tr><th>Id:</th><td>${requestScope.employee.employee_id}</td></tr>
	<tr><th>Name:</th><td>${requestScope.employee.employee_name}</td></tr>
	<tr><th>Email:</th><td>${requestScope.employee.employee_email}</td></td></tr>
	<tr><th>Phone:</th><td>${requestScope.employee.contact_no}</td></td></tr>
	<tr><th>City:</th><td>${requestScope.employee.address}</td></tr>
	<tr><th>Qualification:</th><td>${requestScope.employee.qualification}</td></tr>
	<tr><th>Skill Set:</th><td>${requestScope.employee.skills}</td></tr>
	<tr><td colspan=2><a href="edit?employeeId=${requestScope.employee.employee_id}">Edit</a></td></tr>
	</table>
</div>
    <br/>
</div>

      
<jsp:include page="/WEB-INF/views/footer.jsp"/>