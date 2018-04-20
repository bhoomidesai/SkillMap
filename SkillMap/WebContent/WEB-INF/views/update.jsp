<jsp:include page="/WEB-INF/views/Header.jsp"/>
<div class="col-md-3 col-sm-2 highlight">
    <div id="myContainer" style=" width: 100%;"></div></div></div>
<div class="col-md-6 col-sm-6 highlight">
<div id="myContainer" style=" width: 100%;">

    <h2><b>Welcome : ${requestScope.employee.employee_name}</b></h2>
    <form class="form-horizontal" method="get" action="updateProfile">
<fieldset>
    <div class="form-group">
    <label for="name">Employee ID :</label>
    <input id="eid" name="eid" class="form-control input-md" value="${requestScope.employee.employee_id}" type="text" readonly="true">
  </div>
    <div class="form-group">
    <label for="name">Name :</label>
    <input id="name" name="name" value="${requestScope.employee.employee_name}" class="form-control input-md" required="" type="text">
  </div>
  <div class="form-group">
    <label for="email">Email address :</label>
   <input id="email" name="email" value="${requestScope.employee.employee_email}" class="form-control input-md" required="" type="text">
  </div>
    <div class="form-group">
    <label for="email">Joining Date :</label>
    <input type="date" class="form-control" name="doj" value="${requestScope.employee.employee_DOJ}" required="true" >
  </div>
    <div class="form-group">
    <label for="pno">Contact No. :</label>
    <input id="textinput" name="phone" value="${requestScope.employee.contact_no}" class="form-control input-md" required="" type="text">
  </div>
    <div class="form-group">
    <label for="pno">Role :</label>
    <div class="radio">
  <label><input type="radio" name="role" value = "hr">HR</label>
  <label><input type="radio" name="role" value = "employee">Employee</label>
  <label><input type="radio" name="role" value = "employer">Employer</label>
  
</div>
</div>
    <div class="form-group">
    <label for="cno">Address :</label>
    <input id="city" name="city" value="${requestScope.employee.address}" class="form-control input-md" required="true" type="text">
  </div>
  <div class="form-group">
  <label class="col-md-4 control-label" for="qualification">Qualification:</label>  
  <div class="col-md-4">
  <input id="qualification" name="qualification" value="${requestScope.employee.qualification}" class="form-control input-md" required="true" type="text">
  <span class="help-block"> </span>  
  </div>
  <div class="form-group">
  <label class="col-md-4 control-label" for="qualification">Centre Code:</label>  
  <div class="col-md-4">
  <input id="centercode" name="centercode" value="${requestScope.employee.centre_Code}" class="form-control input-md" required="true" type="text">
  <span class="help-block"> </span>  
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="skill">Skill Set:</label>  
  <div class="col-md-4">
  <input id="skill" name="skill" value="${requestScope.employee.skills}" class="form-control input-md" required="true" type="text">
  <span class="help-block"> </span>  
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="certification">Certification:</label>  
  <div class="col-md-4">
  <input id="certification" name="certification" value="${requestScope.employee.certifications}" class="form-control input-md" required="true" type="text">
  <span class="help-block"> </span>  
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" for="certification">placement Companies :</label>  
  <div class="col-md-4">
  <input id="plcomp" name="plcomp" value="${requestScope.employee.placement_companies}" class="form-control input-md" required="true" type="text">
  <span class="help-block"> </span>  
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" for="certification">Total students trained :</label>  
  <div class="col-md-4">
  <input id="tst" name="tst" value="${requestScope.employee.total_student_tought}" class="form-control input-md" required="true" type="text">
  <span class="help-block"> </span>  
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" for="certification">Placement % :</label>  
  <div class="col-md-4">
  <input id="per" name="per" value="${requestScope.employee.placement_per}" class="form-control input-md" required="true" type="text">
  <span class="help-block"> </span>  
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" for="certification">Rating :</label>  
  <div class="col-md-4">
  <input id="rate" name="rate" value="${requestScope.employee.rating}" class="form-control input-md" required="true" type="text">
  <span class="help-block"> </span>  
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" for="certification">No of hours trained :</label>  
  <div class="col-md-4">
  <input id="tht" name="tht" value="${requestScope.employee.total_hours_tought}" class="form-control input-md" required="true" type="text">
  <span class="help-block"> </span>  
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"> </label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-success">update Profile</button>
  </div>
</div>

</fieldset>
</form>
</div>
    <br/>
</div>

      
<jsp:include page="/WEB-INF/views/footer.jsp"/>