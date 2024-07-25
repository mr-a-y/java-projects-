<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order View</title>
</head>
<body>
    <h2>Order View</h2>
    <table border="1" cellpadding="6">
        <tr>
            <th>Book ID</th>
            <th>Author</th>
            <th>Title</th>
            <th>Price</th>
            <th>Quantity</th>
        </tr>
        <c:forEach items="${sessionScope.cart.items}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.author}</td>
                <td>${item.title}</td>
                <td>${item.price}</td>
                <td>${item.quantity}</td>
            </tr>
        </c:forEach>
    </table>
    <p>Total Price: ${sessionScope.totalPrice}</p>
    <p>Customer Name: ${param.cust_name}</p>
    <p>Phone Number: ${param.cust_phone}</p>
    <p>City: ${param.cust_city}</p>
    <p><a href='index.html'>Back to Select Menu</a></p>
</body>
</html>
