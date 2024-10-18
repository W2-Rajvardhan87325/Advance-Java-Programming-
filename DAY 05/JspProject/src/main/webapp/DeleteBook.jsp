<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="delObj" class="com.Rajvardhan.beans.DeleteBookBean"></jsp:useBean>
	<jsp:setProperty property="*" name="delObj" />
	${delObj.deleteBook()}
	<jsp:forward page="BookList.jsp"></jsp:forward>
</body>
</html>