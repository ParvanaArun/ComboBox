<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sale Report</title>
</head>
<body>
	<h1>Sale Report</h1>
	<c:if test="${not empty param.updated}">
		<p style="color: green;">Sale updated successfully....</p>
	</c:if>
	<c:if test="${not empty param.success}">
		<p style="color: green;">Sale added successfully....</p>
	</c:if>

	<c:if test="${not empty param.deleted}">
		<p style="color: red;">Sale deleted successfully....</p>
	</c:if>

	<form action="report" method="get">
		<label>Start Date :</label> <input type="date" name="from"
			value="${param.from}" /><br> <label>End Date :</label> <input
			type="date" name="to" value="${param.to}" /><br>
			 <label>Specific Sale Date :</label>
            <input type="date" name="saledate" value="${param.saledate}"/><br>
			
			 <label>Customer
			:</label> <select name="customerid">
			<option value="">--All--</option>
			<c:forEach var="c" items="${customers}">
				<option value="${c.customerid}"
					<c:if test="${param.customerid == c.customerid}">selected</c:if>>
					${c.customername}</option>
			</c:forEach>
		</select><br> <label>Item :</label> <select name="itemid">
			<option value="">--All--</option>
			<c:forEach var="i" items="${items}">
				<option value="${i.itemid}"
					<c:if test="${param.itemid == i.itemid}">selected</c:if>>
					${i.itemname}</option>
			</c:forEach>
		</select><br>

		<button type="submit">Search</button>
	</form>

	<table border="1">
		<thead>
			<tr>
				<th>Customer</th>
				<th>Item</th>
				<th>Total Amount</th>
				<th>Sale Date</th>
				<th>Expiry Date</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="sale" items="${sales}">
				<tr>
					<td>${sale.customer.customername}</td>
					<td>${sale.item.itemname}</td>
					<td>${sale.totalamount}</td>
					<td>${sale.saledate}</td>
					<td>${sale.item.expdate}</td>
					<td><a
						href="${pageContext.request.contextPath}/edit-sale?saleid=${sale.saleid}">Edit</a>
						| <a
						href="${pageContext.request.contextPath}/delete-sale?saleid=${sale.saleid}"
						onclick="return confirm('Are you sure?')">Delete</a></td>
				</tr>

			</c:forEach>
		</tbody>
	</table>

	<c:if test="${empty sales}">
		<p>No sales record found......</p>
	</c:if>
</body>
</html>