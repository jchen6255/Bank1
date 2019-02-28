<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="welcomeContext.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="report.do">
	
	
		Enter Transaction Year <input type="number" min ="2016" name = "year" required="required"><br> 
		Enter Transaction month (number): <input type="number" min = "1" max ="12" name = "month" required="required">
		
		<input type="submit">
	
	</form>

</body>
</html>