<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Logged Out</title>
</head>
<body>

	<hr>
	<h2 align="center">You have successfully logged out!</h2>
	<hr>
	<p>Thank you for using our service. You can log in again by
		clicking the link below.</p>
	<%session.invalidate();%>
	<p>
		<a href="Login.jsp">Login again</a>
	</p>

</body>
</html>