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
	<jsp:useBean id="cartBeanObj" class="com.Rajvardhan.beans.CartBean" scope="session"></jsp:useBean>
	<jsp:setProperty name="cartBeanObj" property="*" />
	<c:choose>
		<c:when test="${cartBeanObj.addToCart()}">
			<c:redirect url="Subjects.jsp"></c:redirect>
		</c:when>
		<c:otherwise>
		Hello, ${lbObj.cust.custName}
			<hr>
			<h3 align="center">NO SUBJECT SELECTED</h3>
			<hr>
			<p>You did not select any subject. Please go back to the subject
				page and select a subject to view the books.</p>
			<p>
				<a href="Subject.jsp">Go to Subject Page</a>
			</p>
		</c:otherwise>
	</c:choose>

</body>
</html>