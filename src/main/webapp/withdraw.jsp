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
	 <form action="withdraw.do" method="post">
	
	Account#:<input type="text" name=accountNumber required="required">
	Balance To withdraw: <input type="text" name= balance required="required">
	
	
	<input type="submit">
	
	</form>

</body>
</html>