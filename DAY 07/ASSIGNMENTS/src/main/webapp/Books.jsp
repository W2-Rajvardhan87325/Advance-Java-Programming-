<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Page</title>
</head>
<body>
	<jsp:useBean id="bookBeanObj" class="com.Rajvardhan.beans.BooksBeans"></jsp:useBean>
	<jsp:setProperty name="bookBeanObj" property="*" />
	<c:choose>
		<c:when test="${bookBeanObj.fetchBooks()}">
		Hello, ${lbObj.cust.custName}
				<hr>
			<h3 align="center">DISPLAYLING BOOKS</h3>
			<hr>
			<form action='AddToCart.jsp' method='GET'>
				<table cellpadding='10'>
					<thead align='center'>
						<tr>
							<th>SELECT</th>
							<th>NAME</th>
							<th>AUTHOR</th>
							<th>SUBJECT</th>
							<th>PRICE</th>
						</tr>
					</thead>
					<c:forEach var="bk" items="${bookBeanObj.books}">
						<tr>
							<td align='center'><input type='checkbox' name='bookId'
								value='${bk.bookId}'></td>
							<td>${bk.bookName}</td>
							<td>${bk.bookAuthor}</td>
							<td align='center'>${bk.bookSubject}</td>
							<td align='center'>${bk.bookPrice}</td>
						</tr>
					</c:forEach>
					<tr>
						<td><input type='submit' value='Add to Cart'></td>
					</tr>
				</table>
			</form>

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