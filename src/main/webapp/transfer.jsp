<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <jsp:include page="welcomeContext.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transfer Money</title>
</head>
<body>


<%-- 	<form action="transfer.do" method="post">
		<h3 style="color: red">${errorMsg}</h3>
		from Account#:<input type="number" name="fromAccount"
			required="required"><br> To Account#:<input
			type="number" name="toAccount" required="required"><br>
		Amount: <input type="number" step="0.01" name="amount"
			required="required"> <br> <input type="submit">


	</form> --%>


<form action="transfer.do" method="post">
		<h3 style="color: red">${errorMsg}</h3>
		
		<c:if test="${accounts.size()==0}">
  			<h3>No Account available</h3>
  		</c:if>
				
		from Account#:<br> 
		<select>
			<c:forEach items="${accounts}" var="account">
				<option name = "fromAccount" value=${account}> ${account} </option>
			</c:forEach>
		</select> 
		<br> 
		To Account#:
		<br>
		<select>
			<c:forEach items="${payees}" var="payee">
				<option name = "toAccount" value=${payee}> ${payee} </option>
			</c:forEach>
		</select> 
		
				
		<br>
		Amount: <input type="number" step="0.01" name="amount" required="required">
			
			
		 <br> 
		 <input type="submit">
		 
	</form>
	
	<a href="addPayee.jsp"> add Payee</a>



</body>
</html>