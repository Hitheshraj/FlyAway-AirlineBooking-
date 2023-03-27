
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
	
	</p>
	<table border=1>
		<tr>
			<th>name</th>
			<th>Time</th>
			<th>Price</th>
			<th></th>
		</tr>
		<c:forEach var="detail" items="${flight_detail}">
			<tr>
				<td>${detail[0]}</td>
				<td>${detail[1]}</td>
				<td>${detail[2]}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="index.html">Home</a>
</body>
</html>