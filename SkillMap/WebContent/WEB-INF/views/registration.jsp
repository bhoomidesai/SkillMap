<jsp:include page="/WEB-INF/views/Header.jsp"/>
<div class="col-md-3 col-sm-2 highlight">
    <div id="myContainer" style=" width: 100%;"></div></div></div>
<div class="col-md-6 col-sm-6 highlight">
<div id="myContainer" style=" width: 100%;">

    <h2><b>Registration Form</b></h2>
    <form action="register" method="get">
    <div class="form-group">
    <label for="name">Employee ID :</label>
    <input type="text" class="form-control" name="eid" placeholder="ie. 5 digit no." required="true">
  </div>
    <div class="form-group">
    <label for="name">Name :</label>
    <input type="text" class="form-control" name="name" placeholder="ie. Firstname Middlename Lastname" required="true">
  </div>
  <div class="form-group">
    <label for="email">Email address :</label>
    <input type="email" class="form-control" name="email" required="true" placeholder="ie. example@gmail.com">
  </div>
    
    <div class="form-group">
    <label for="pno">Contact No. :</label>
    <input type="text" class="form-control" name="phone" placeholder="ie. 9101234567" required="true">
  </div>
    
    <div class="form-group">
    <label for="cno">Address :</label>
    <input type="text" class="form-control" name="city" placeholder="ie. City, State." required="true">
  </div>
        
  <div class="form-group">
    <label for="pwd">Password:</label>
    <input type="password" class="form-control" name="password" required="true">
  </div>
    <div class="form-group">
    <label for="pwd">Confirm Password:</label>
    <input type="password" class="form-control" name="cpwd" required="true">
  </div>
  
  <button type="submit" class="btn btn-success">Register</button>
</form>
</div>
    <br/>
</div>

      
<jsp:include page="/WEB-INF/views/footer.jsp"/>