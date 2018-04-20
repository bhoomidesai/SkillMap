<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/views/Header.jsp"/>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script> 
</head>
<div class="col-md-3 col-sm-2 highlight">
    <div id="myContainer" style=" width: 100%;"></div>
    </div>
	<div class="col-md-6 col-sm-6 highlight">
	<div id="myContainer" style=" width: 100%;">

    <h2><b>Registration Form</b></h2>
	<div class="row">
        <c:forEach var="error" items="${requestScope.error}" varStatus="status">
   	 <div><font color="red">${error}</font></div>
	</c:forEach>
    <form action="register" method="get">
    <div class="form-group">
    <label for="name">Employee ID :</label>
    <input type="text" class="form-control" name="eid" placeholder="ie. 5 digit no." >
  </div>
    <div class="form-group">
    <label for="name">Name :</label>
    <input type="text" class="form-control" name="name" placeholder="ie. Firstname Middlename Lastname" >
  </div>
  <div class="form-group">
    <label for="email">Email address :</label>
    <input type="text" class="form-control" name="email"  placeholder="ie. example@gmail.com">
  </div>
    
    <div class="form-group">
    <label for="pno">Contact No. :</label>
    <input type="text" class="form-control" name="phone" placeholder="ie. 9101234567" >
     <div class="form-group">
  </div>
  </div>
   <div class="form-group">
    <label for="pno">Role :</label>
    <div class="radio">
  <label><input type="radio" name="role" value = "hr" required>HR</label>
  <label><input type="radio" name="role" value = "employee"required>Employee</label>
  <label><input type="radio" name="role" value = "employer"required>Employer</label>
</div>
</div>
    <div class="form-group">
    <label for="cno">Address :</label>
    <input type="text" class="form-control" name="city" placeholder="ie. City, State." >
  </div>
        
  <div class="form-group">
    <label for="pwd">Password:</label>
    <input type="password" class="form-control" name="password" >
  </div>
    <div class="form-group">
    <label for="pwd">Confirm Password:</label>
    <input type="password" class="form-control" name="cpwd" >
  </div>
  
  <button type="submit" class="btn btn-success">Register</button>
</form>
</div>
    <br/>
</div>

      
<jsp:include page="/WEB-INF/views/footer.jsp"/>