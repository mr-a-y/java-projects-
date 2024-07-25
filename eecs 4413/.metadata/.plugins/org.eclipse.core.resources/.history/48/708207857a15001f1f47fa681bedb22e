<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="lab5servletQ2B.Book" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Result View</title>
</head>
<body>
    <h2>Book Result View</h2>
    <form method="get" action="CartServlet">
        <table border="1" cellpadding="6">
            <tr>
                <th>&nbsp;</th>
                <th>Book ID</th>
                <th>Author</th>
                <th>Title</th>
                <th>Price</th>
                <th>Quantity</th>
            </tr>
            <c:forEach items="${bookList}" var="e">
                <tr>
                    <td><input type="checkbox" name="id" value="${e.id}" /></td>
                    <td>${e.id}</td>
                    <td>${e.author}</td>
                    <td>${e.title}</td>
                    <td>${e.price}</td>
                    <td><input type='number' size='5' value='1' name="qty_${e.id}" /></td>
                </tr>
            </c:forEach>
        </table>
        <input type="hidden" name="todo" value="add" />
        <input type="submit" value="Add to my SHOPPING CART" />
        <input type="reset" value="CLEAR" />
    </form>
    <p><a href='index.html'>Back to Select Menu</a></p>
</body>
</html>
