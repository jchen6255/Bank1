<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="welcomeContext.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Deposit</title>
</head>
<body>

	<form action="deposit.do" method="post">
		Account# : <input type="number" name="accountNumber" required="required"><br>
		Deposit Amount:" <input type="number" step="0.01" name="balance" required><br>
		
	
		<input type="submit">
	</form>

</body>
</html>