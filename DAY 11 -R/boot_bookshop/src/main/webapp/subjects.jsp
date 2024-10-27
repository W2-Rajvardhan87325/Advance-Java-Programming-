<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subjects</title>
</head>
<body>	
	<h2>Subjects</h2>
	<form method="post" action="books">
		<c:forEach var="subject" items="${subjectList}">
			<input type="radio" name="subject" value="${subject}"/> ${subject} <br/>
		</c:forEach>
		<input type="submit" value="Show Books"/>
	</form>
	<p>
		<a href="showcart">Show Cart</a>
	</p>
</body>
</html>
