<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <jsp:include page="welcomeContext.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



<div class="page-header header-filter pt-5" >
  <div class="container">
    <div class="row">
      <div class="col-md-6 ml-auto mr-auto">

					<form action="create.do" method="post">

						Account Type: <input type="text" name="accountType"
							required="required"> <br> Balance:<input
							type="number" step="0.01" name="amount" required="required"><br>


						<input type="submit">

					</form>
				</div>
    </div>
  </div>
</div>


</body>
</html>