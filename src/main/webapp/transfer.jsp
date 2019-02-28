<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="welcomeContext.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transfer Money</title>
</head>
<body>
	
	
	 <form action="transfer.do" method="post">
	from Account#:<input type="number" name="fromAccount" required="required"><br>
	To Account#:<input type="number" name="toAccount" required="required"><br>
	Amount: <input type="number" step="0.01" name="amount" required="required"> <br>	
	
	<input type="submit">
	
	
	</form>
	
</body>
</html>