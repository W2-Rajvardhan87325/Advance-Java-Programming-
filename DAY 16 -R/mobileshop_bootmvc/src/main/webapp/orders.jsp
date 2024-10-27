<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Orders</title>
</head>
<body>
	<h2>Mobiles Ordered by ${user.name}</h2>
	<c:forEach var="m" items="${mobileList}">
		<div style="display: flex; border: 2px solid black; padding: 5px; margin: 5px;">
			<div style="margin: 10px">
				<input type="radio" name="mobile" value="${m.id}"/> 
			</div>
			<div>
				<img alt="Mobile:${m.image}" width="100" src="/images/${m.image}"/>
			</div>
			<div style="margin: 10px">
				${m.name} <br/>
				${m.company} <br/>
				${m.price} <br/>
				RAM: ${m.ram} <br/>
				Storage: ${m.storage}
			</div>
		</div>
	</c:forEach>
	<p>
		<a href="mobiles">All Mobiles</a>
	</p>
</body>
</html>

