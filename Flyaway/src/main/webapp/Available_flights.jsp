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
	<%
	String source = request.getAttribute("source").toString();
	String destination = request.getAttribute("destination").toString();
	response.setContentType("text/html");
	%>
	<p>
		<%
		out.println(source);
		%>-------------><%
		out.println(destination);
		%>
	</p>

	<table border=1>
		<tr>
			<th>Flight_id</th>
			<th> </th>
			<th>name</th>
			<th> </th>
			<th>Time</th>
			<th> </th>
			<th>Price</th>
			<th> </th>
			<th> </th>
		</tr>
		<c:forEach var="detail" items="${flight_detail}">
			<tr>
				<td>${detail[0]}</td>
				<td> </td>
				<td>${detail[1]}</td>
				<td> </td>
				<td>${detail[2]}</td>
				<td> </td>
				<td>${detail[3]}</td>
				<td> </td>
			</tr>
		</c:forEach>
	</table>
	<a href="index.html">Home</a>
</body>
</html>