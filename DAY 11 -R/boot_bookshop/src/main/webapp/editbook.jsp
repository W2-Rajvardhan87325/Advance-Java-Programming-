<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Book</title>
</head>
<body>
	<h2>Edit Book</h2>
	<form method="post" action="editbook">
		Id: <input type="text" name="id" value="${bk.id}" readonly="readonly"/> <br/><br/>
		Name: <input type="text" name="name" value="${bk.name}"/> <br/><br/>
		Author: <input type="text" name="author" value="${bk.author}"/> <br/><br/>
		Subject: <input type="text" name="subject" value="${bk.subject}"/> <br/><br/>
		Price: <input type="text" name="price" value="${bk.price}"/> <br/><br/>
		<input type="submit" value="Update Book"/>
		<p>
			<a href="booklist">Back</a>
		</p>
	</form>
</body>
</html>

