<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shopping Cart</title>
</head>
<body>
  orderView.jsp
  <h2>Your Orders</h2>

  <table border='1' cellpadding='6'>
  <tr><th>COURSE CODE</th><th>COURSE TITLE</th><th>CATEGORT</th> 
   
    
 
   <c:forEach items="${sessionScope.cart.items}" var="item"> 
     <tr>
		<td>${item.code}</td>
		<td>${item.title}</td>
		<td>${item.categoryDescription}</td>
	</tr>> 
    </c:forEach>
 		 
   </table><br />    
          
          
 
         
  <p><a href='Welcome.html'>Back to Select Menu</a></p>
          
          
      


</body>
</html>