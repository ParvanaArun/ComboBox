<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Item</title>
</head>
<body>
<h2>Add Item</h2>
<form action="save-item" method="post">
    Name: <input type="text" name="itemname" required /><br>
    Price: <input type="number" name="price" step="0.01" required /><br>
    Tax: <input type="number" name="tax" step="0.01" required /><br>
    Discount: <input type="number" name="discount" step="0.01" required /><br>
    Manufacture Date: <input type="date" name="manufactdt" required /><br>
    Expiry Date: <input type="date" name="expdate" required /><br>
    <button type="submit">Add Item</button>
</form>

<c:if test="${not empty success}">
  <p style="color:green;">${success}</p>
</c:if>

</body>
</html>