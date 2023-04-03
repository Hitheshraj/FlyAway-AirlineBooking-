<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking</title>
</head>
<body>
<%out.println(request.getAttribute("user_name").toString()); %>
<table border=1>
		<tr>
			<th>Time</th>
			<th>Price</th>
			<th>Flight Name</th>
			<th>Source</th>
			<th>Destination</th>
			<th></th>
		</tr>
		<c:forEach var="detail" items="${Booking_detail}">
			<tr>
				<td>${detail[0]}</td>
				<td>${detail[1]}</td>
				<td>${detail[2]}</td>
				<td>${detail[3]}</td>
				<td>${detail[4]}</td>
			</tr>
		</c:forEach>
	</table>
<a href="Main.html">Home</a>
</body>
</html>