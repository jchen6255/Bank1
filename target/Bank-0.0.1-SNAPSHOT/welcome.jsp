<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <jsp:include page="context.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="Welcome"/></title>
</head>
<body>		
		
<div>
  <nav class="navbar navbar-expand-lg bg-dark">
    <div class="container">
      <div class="navbar-translate">
          <a class="navbar-brand text-light" href="createAccount.jsp"><spring:message code="AddAccount"/></a>
          <a class="navbar-brand text-light" href="delete.jsp"><spring:message code="DeleteAccount"/></a>
          <a class="navbar-brand text-light" href="deposit.jsp"><spring:message code="DepositMoney"/></a>
          <a class="navbar-brand text-light" href="withdraw.jsp"><spring:message code="WithdrawMoney"/></a>
          <a class="navbar-brand text-light" href="transfer.jsp"><spring:message code="TransferMoney"/></a>
          <a class="navbar-brand text-light" href="transcations.jsp"><spring:message code="ViewTranscation"/></a>
      </div>

      <div class="collapse navbar-collapse justify-content-end">
           <a class="navbar-brand text-light" href="index.jsp"><spring:message code="Logout"/></a>
      </div>
    </div>
  </nav>
</div>
		
  
  <h3><spring:message code="Welcome"/> <%= session.getAttribute("username") %> </h3>
  	<a href="./welcome.do?language=en">English</a>
  	<a href="./welcome.do?language=zh">中文</a>
	
	  
</body>
</html>