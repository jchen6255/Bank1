<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="context.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
</head>
<body>

	<div class="page-header header-filter pt-5">
		<div class="container">
			<div class="row">
				<div class="col-md-6 ml-auto mr-auto">

					<h2>SignUp Form</h2>
					<h3 style="color:red">${error}</h3> 
					<form action="signup.do" method="post">
					<div class="form-group">
							<label for="username">Username</label> 
							<input type="text"
								class="form-control" id="username" name="username"
								placeholder="username" required="required">
						</div>
						<div class="form-group">
							<label for="password">Password</label> 
							<input type="password"
								class="form-control" id="password" name="pwd"
								placeholder="Password" required="required">
						</div>
						
						<div class="form-group">
							<label for="confirmPassword">Confirm Password</label> 
							<input type="password"
								class="form-control" id="confirmPassword" name="cpwd"
								placeholder="Confirm Password" required="required">
						</div>
						
						 <div class="radio">
  							<label><input type="radio" name="type" value="customer" checked>Customer</label>
  							<label><input type="radio" name="type" value="admin">Admin</label>
						</div>
						
						<button type="submit" class="btn btn-primary">Submit</button>
					</form>
				</div>
			</div>
		</div>
	</div>


</body>
</html>