<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="mc.css" type="text/css" title="cse4413" media="screen, print"/>
    <meta charset="UTF-8">
    <title>Loan Calculator Result</title>
</head>
<body>
    <header>Student Loan Application</header>
    <p class='subtitle'>Client Protocol: <%= request.getProtocol() %> </p>
    <p class='subtitle'>Client Method: <%= request.getMethod() %> </p>
    <p class='subtitle'>Query String: <%= request.getQueryString() %> </p>
    <p class='subtitle'>Entered principal: ${loan.principal }</p> 
    <p class='subtitle'>Entered interest: ${loan.interest }</p>
    <p class='subtitle'>Entered period: ${loan.period }</p>
    <hr>
    <c:choose>
        <c:when test= "${sessionScope.count > 1}">
            <p class='subtitle'>Welcome back, Calculation count: ${count} </p>
        </c:when>
        <c:otherwise>
            <p class='subtitle'>Welcome. This is first time calculation for you.</p>
        </c:otherwise>
    </c:choose>
    <form method='get' action='index.html' class='resultForm'>
        <h2>Monthly Payment: ${loan.payment} <br><br>
        Calculation used: </h2>
        <ul>
            <li> principal: ${loan.principal} </li>
            <li> Interest: ${loan.interest} </li>
            <li> Period: ${loan.period} </li>
        </ul>
        <input type='submit' value='Re-calculate' />
    </form>
</body>
</html>
