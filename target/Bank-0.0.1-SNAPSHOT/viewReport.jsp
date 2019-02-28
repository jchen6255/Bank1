<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <jsp:include page="welcomeContext.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 <c:forEach items="${reports}"  var="report">
 	<c:out value="${report}"></c:out><br>
 </c:forEach>


<!-- <form action="page.do">
	Pages: <input type="number" name="page" required="required"><br>
	<input type="submit"><br>
</form> -->


</body>
</html>