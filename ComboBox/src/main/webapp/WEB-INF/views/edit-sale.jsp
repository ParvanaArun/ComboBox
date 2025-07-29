<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Sale</title>
<script>
var customerMap ={};
var itemMap ={};

function loadData(){
	  <c:forEach var= "c" items ="${customers}">
	  customerMap["${c.customerid}"]={
			  address: "${c.address}"
	  };
	  </c:forEach>
	  
	  <c:forEach var= "i" items ="${items}">
	  itemMap["${i.itemid}"]={
			  price: ${i.price},
			  tax: ${i.tax},
			  discount: ${i.discount},
			  manufactdt: "${i.manufactdt}",
			  expdate: "${i.expdate}"
	  };
	  </c:forEach>
	  
}

function fillCustomerDetails(){
	  var customerId =document.getElementById("customerid").value;
	  if(customerMap[customerId]){
		  let customer = customerMap[customerId];
		  document.getElementById("address").value =customer.address;
	  }else{
		  document.getElementById("customerid").value='';
	  }
	  
}

function fillItemDetails(){
	  var itemId =document.getElementById("itemid").value;
	  if(itemMap[itemId]){
		  let item = itemMap[itemId];
		  document.getElementById("manufactdt").value =item.manufactdt;
		  document.getElementById("expdate").value =item.expdate;
		  document.getElementById("price").value =item.price;
		  document.getElementById("tax").value =item.tax;
		  document.getElementById("discount").value =item.discount;
		  let total = item.price + item.tax -item.discount;
		  document.getElementById("totalamount").value =total.toFixed(2);
	  }else{
		  document.getElementById("manufactdt").value ='';
		  document.getElementById("expdate").value ='';
		  document.getElementById("price").value ='';
		  document.getElementById("tax").value ='';
		  document.getElementById("discount").value ='';
		  document.getElementById("totalamount").value ='';
		  
	  }
}

window.onload = function (){
	  loadData();
};

</script>
</head>
<body>
	<form action="update-sale" method="post">
	<input type="hidden" name="saleid" value="${sale.saleid}" />
	<table>
		<tr>
			<th>Customer :</th>
			<td><select name="customerid" id="customerid" onchange="fillCustomerDetails()" required>
				<option value="">---Select---</option> 
				<c:forEach var="c" items="${customers}">
					<option value="${c.customerid}"
						<c:if test="${c.customerid == sale.customer.customerid}">selected</c:if>>${c.customername}</option>
				</c:forEach>
				</select>
				</td>
		</tr>
         <tr>
			<th>Address :</th>
			<td><input type="text" name="address" id="address" readonly></td>
		</tr>
        <tr>
			<th>Item :</th>
			<td><select name="itemid" id="itemid" onchange="fillItemDetails()" required>
				<option value="">---Select---</option>
				 <c:forEach var="i" items="${items}">
					<option value="${i.itemid}"
						<c:if test="${i.itemid==sale.item.itemid}">selected</c:if>>${i.itemname}</option>
				</c:forEach>
				</select>
				</td>
		</tr>
        <tr>
        <th>Price</th>
        <td><input type="text" id="price" readonly></td>
        </tr>
        <tr>
			    <th>Tax:</th>
			    <td><input type="text" id="tax" readonly></td>
			</tr>
			<tr>
			    <th>Discount:</th>
			    <td><input type="text" id="discount" readonly></td>
			</tr>
			<tr>
			    <th>Total Amount:</th>
			    <td><input type="text" id="totalamount" name="totalamount" readonly></td>
			</tr>
			<tr>
			    <th>Sale Date:</th>
			    <td><input type="date"  name="saledate" value="${sale.saledate}" required></td>
			</tr>
             <tr>
			    <th>Manufacture Date:</th>
			    <td><input type="date" id="manufactdt" readonly></td>
			</tr>
			<tr>
			    <th>Expiry Date:</th>
			    <td><input type="date" id="expdate" readonly></td>
			</tr>
             <tr>
			    <th></th>
			    <td><button type="submit">Update Sale</button></td>
			</tr>
</table>
</form>

</body>
</html>