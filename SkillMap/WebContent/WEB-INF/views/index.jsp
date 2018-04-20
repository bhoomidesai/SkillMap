
<jsp:include page="/WEB-INF/views/Header.jsp"/>

<div class="col-md-7 col-sm-6 highlight">
	<div id="myContainer" style=" width: 100%;">

 		
		
	<div ></div>
	
        </div>	
		
    <div  style="height: 350px; width: 100%; overflow: hidden; cursor: pointer">
	<div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="2000">

		<!-- Indicators -->
		
		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img src="images/1.jpg" alt="Vote1"
					style="height: 350px; width: 100%; overflow: hidden; cursor: pointer">
			</div>

			<div class="item active">
				<img src="images/2.jpg" alt="Chania"
					style="height: 350px; width: 100%; overflow: hidden; cursor: pointer">
			</div>
			<div class="item">
				<img src="images/3.jpg" alt="Chania"
					style="height: 350px; width: 100%; overflow: hidden; cursor: pointer">
			</div>

			<div class="item">
				<img src="images/1.jpg" alt="Flower"
					style="height: 350px; width: 100%; overflow: hidden; cursor: pointer">
			</div>

		</div>

		<!-- Left and right controls -->
		
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