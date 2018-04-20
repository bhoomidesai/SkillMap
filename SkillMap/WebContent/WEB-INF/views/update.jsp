<jsp:include page="/WEB-INF/views/Header.jsp"/>
<div class="col-md-3 col-sm-2 highlight">
    <div id="myContainer" style=" width: 100%;"></div></div></div>
<div class="col-md-6 col-sm-6 highlight">
<div id="myContainer" style=" width: 100%;">

    <h2><b>Welcome : ${requestScope.employee.employeeName}</b></h2>
    <form class="form-horizontal" method="get" action="updateProfile">
<fieldset>
    <div class="form-group">
    <label for="name">Employee ID :</label>
    <input id="eid" name="eid" class="form-control input-md" value="${requestScope.employee.employee_d}" type="text" readonly="true">
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
    <input type="date" class="form-control" name="doj" value="${requestScope.employee.doj}" required="true" placeholder="Birth Day" max="2000-01-01">
  </div>
    <div class="form-group">
    <label for="pno">Contact No. :</label>
    <input id="textinput" name="phone" value="${requestScope.employee.contact_no}" class="form-control input-md" required="" type="text">
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
  <input id="certification" name="certification" value="${requestScope.employee.placement_company}" class="form-control input-md" required="true" type="text">
  <span class="help-block"> </span>  
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" for="certification">Total students placed :</label>  
  <div class="col-md-4">
  <input id="certification" name="certification" value="${requestScope.employee.total_student_tought}" class="form-control input-md" required="true" type="text">
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