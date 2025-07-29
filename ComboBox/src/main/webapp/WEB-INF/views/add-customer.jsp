<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Customer</title>
</head>
<body>
<h2>Add Customer</h2>
<form action="save-customer" method="post">
    Name: <input type="text" name="customername" required /><br>
    Address: <input type="text" name="address" required /><br>
    Phone No: <input type="text" name="phoneno" required /><br>
    <button type="submit">Add Customer</button>
</form>

<c:if test="${not empty success}">
  <p style="color:green;">${success}</p>
</c:if>

</body>
</html>