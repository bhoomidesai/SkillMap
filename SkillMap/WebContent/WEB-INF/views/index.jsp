<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/views/Header.jsp"/>

<div class="col-md-7 col-sm-6 highlight">
	<div id="myContainer" style=" width: 100%;">

 		
		
	<div ></div>
	
        </div>	
		<form action="search">
    <div  style="height: 350px; width: 100%; overflow: hidden; cursor: pointer">
	 <div class="form-group">
    <label for="cno">Search :</label>
    <input id="word" name="word"  class="form-control input-md"  type="text">
  </div>
  <div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"> </label>
  <div class="col-md-4">
    <input type="submit" name="submit" value="Search" class="btn btn-success">Search
    <b>User Data : </b>
		</h2>
		
	</div>
	</form>
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
</div>

</div>
				
		

</div>
<br/>
		<div class="col-md-5 col-sm-3 highlight">
			<div class="panel panel-primary">
				<div class="panel-heading" style="background-color: #333 ">
                                    <h3  class="panel-title" style="text-align: center"><span class="glyphicon glyphicon-log-in"></span> Login</h3>
				</div>
				<div class="panel-body fixed-panel"
					style="text-align: justify; font-size: 15px; height: 310px;">
						<form class="form-horizontal" action="login" method="post">
                                                    <div class="form-group">
                                                      <label class="control-label col-sm-2" for="eid">Employee&nbsp;ID&nbsp;:</label>
                                                      <div class="col-sm-10">
                                                          <input type="text" class="form-control" name="eid" placeholder="Enter passport or Citizen card no." required="true">
                                                      </div>
                                                    </div>
                                                    <div class="form-group">
                                                      <label class="control-label col-sm-2" for="password">Password&nbsp;:</label>
                                                      <div class="col-sm-10"> 
                                                        <input type="password" class="form-control" name="password" placeholder="Enter password" required="true">
                                                      </div>
                                                    </div>
                                                    <div class="form-group"> 
                                                      <div class="col-sm-offset-2 col-sm-10">
                                                          <button type="submit" class="btn btn-success">Login</button>
                                                      </div>
                                                    </div>
                                                    <div class="form-group"> 
                                                      <div class="col-sm-offset-2 col-sm-10">
                                                        <h5><a>Forget password...!</a></h5>
                                                       <h5> <a href="reg" >Register</a>
                                                       <h5> <a href="hr" >HR</a>
                                                     </h5> </div>
                                                    </div>
                                                    <div class="form-group"> 
                                                      <div class="col-sm-offset-2 col-sm-10">
                                                          <h5 style="color: red"><%
                                                                    if(request.getAttribute("invalid")==null)
                                                                    {
                                                                     
                                                                    }else
                                                                    {
                                                                    out.print(request.getAttribute("invalid"));
                                                                    }
                                                                    %></h5>
                                                      </div>
                                                    </div>
                                                      
                                                  </form>
				</div>
			</div>
			<br/>
    <br/>
    <br/>
    <br/>
    <br/>
  
		</div>
                                                      
        <div>
       
<jsp:include page="/WEB-INF/views/footer.jsp"/>