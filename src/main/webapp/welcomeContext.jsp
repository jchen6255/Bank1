<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="context.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>		
		
<div>
  <nav class="navbar navbar-expand-lg bg-dark">
    <div class="container">
      <div class="navbar-translate">
          <a class="navbar-brand text-light" href="createAccount.jsp">Add Account</a>
          <a class="navbar-brand text-light" href="delete.jsp">Delete Account</a>
          <a class="navbar-brand text-light" href="deposit.jsp">Deposit Money</a>
          <!-- <a class="navbar-brand text-light" href="withdraw.jsp">Withdraw Money</a> -->
          <a class="navbar-brand text-light" href="transfer.jsp">Transfer Money</a>
          <a class="navbar-brand text-light" href="transcations.jsp">View Transcation</a>
      </div>

      <div class="collapse navbar-collapse justify-content-end">
           <a class="navbar-brand text-light" href="index.jsp">Log out</a>
      </div>
    </div>
  </nav>
</div>
		
  
  <h3>Welcome <%= session.getAttribute("username") %> </h3>