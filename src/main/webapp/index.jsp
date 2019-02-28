<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <jsp:include page="context.jsp"></jsp:include>

<html>
<body>
<% session.invalidate(); %>
<%-- <form action="login.do" method="post">

	
	Username: <input type="text" name="username" required="required"><br> 
	password: <input type="password" name= "pwd" required="required"><br>
	
	<input type="submit" value="Login">

</form> --%>



<div class="page-header header-filter pt-5" >
  <div class="container">
    <div class="row">
				<div class="col-md-6 ml-auto mr-auto">

					<h2>Login Form</h2>
					<h3 style="color:red">${error}</h3> 
					<form action="login.do" method="post">
						<div class="form-group">
							<label for="username">Username</label> 
							<input type="text"
								class="form-control" id="username" name="username"
								placeholder="username">
						</div>
						<div class="form-group">
							<label for="password">Password</label> 
							<input type="password"
								class="form-control" id="password" name="pwd"
								placeholder="Password">
						</div>
						<div class="form-group">
							<div class="form-check">
								<input type="checkbox" class="form-check-input"
									id="dropdownCheck"> 
									<label class="form-check-label"
									for="dropdownCheck"> Remember me </label>
							</div>
						</div>
						<button type="submit" class="btn btn-primary">Log in</button>
					</form>

					<div>
						Dont have an account? <a href="signup.jsp">Sign Up</a>  
					</div>
				</div>
			</div>
  </div>
</div>

 
  

<script>

</script>


</body>
</html>
