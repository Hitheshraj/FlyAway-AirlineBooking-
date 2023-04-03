
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flights</title>
</head>
<body>
	
	<table border=1>
		<tr>
			<th>name</th>
			<th>Time</th>
			<th>Price</th>
			<th></th>
		</tr>
		<c:forEach var="detail" items="${flight_detail}">
			<tr>
				<td>${detail[1]}</td>
				<td>${detail[2]}</td>
				<td>${detail[3]}</td>
			</tr>
		</c:forEach>
	</table>
	<p>Total price is :<%out.println(request.getAttribute("total").toString()); %></p>
	<p>Conform booking</p>
	<a href="Payment.html"><input type="button" onclick="Payment.html" value="Book Now"/></a>
	<a href="Main.html">Home</a>
</body>
</html>