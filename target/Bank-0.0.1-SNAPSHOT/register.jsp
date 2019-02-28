<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="context.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Customer</title>
</head>
<body>

	<div class="page-header header-filter pt-5">
		<div class="container">
			<div class="row">
				<div class="col-md-6 ml-auto mr-auto">

					<h2>Register Form</h2>
					<h3 style="color:red">${error}</h3> 
					<form action="register.do" method="post">
						<div class="form-group">
							<label for="firstName">First Name</label> 
							<input type="text"
								class="form-control" id="firstName" name="firstName"
								placeholder="enter your first name" required="required">
						</div>
						<div class="form-group">
							<label for="lastName">Last Name</label> 
							<input type="text"
								class="form-control" id="lastName" name="lastName"
								placeholder="enter your last name" required="required">
						</div>
					
					
						 <div class="radio">
  							<label><input type="radio" name="gender" value="male" checked>Male</label>
  							<label><input type="radio" name="gender" value="female">Female</label>
						</div>

						<div class="form-group">
							<label for="age">Age</label>
							<input type="number" class="form-control" id="age" name="age" min= 10 max = 150>
						</div>

						<div class="form-group">
							<label for="Street">Street</label> 
							<input type="text"
								class="form-control" id="Street" name="street"
								placeholder="enter your street" required="required">
						</div>
						
						<div class="form-group">
							<label for="city">City</label> 
							<input type="text"
								class="form-control" id="city" name="city"
								placeholder="enter your city" required="required">
						</div>
						
						<div class="form-group">
							<label for="state">State</label> 
							<input type="text"
								class="form-control" id="state" name="state"
								placeholder="enter your state" required="required">
						</div>
						
						<div class="form-group">
							<label for="zip">Zip Code</label> 
							<input type="text"
								class="form-control" id="zip" name="zip" required="required">
						</div>
						
						<div class="form-group">
							<label for="phone">Phone number</label> 
							<input type="text"
								class="form-control" id="phone" name="phone">
						</div>						
						
						<div class="form-group">
							<label for="email">Email</label> 
							<input type="email"
								class="form-control" id="email" name="email">
						</div>
						
						<button type="submit" class="btn btn-primary">Submit</button>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>