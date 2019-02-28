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

	<form action="delete.do" method="post">
	
		Enter account# for delete<input type="number" name="accountNumber" required="required"><br>
		
		<input type="submit">
	</form>

</body>
</html>