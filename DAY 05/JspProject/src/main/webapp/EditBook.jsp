<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>New Book</title>
</head>
<body>
	<c:choose>
		<c:when test="${pageContext.request.method == 'GET'}">
			<jsp:useBean id="edObj" class="com.Rajvardhan.beans.EditBookBean"
				scope="session"></jsp:useBean>
			<jsp:setProperty property="*" name="edObj" />
		${edObj.displayBook()}
			<hr>
			<h3 align='center'>UPDATE BOOK DETAILS</h3>
			<table cellpadding='10'>
				<tr>
					<td><button>
							<a href='booklist'>Go Back</a>
						</button></td>
					<td></td>
				</tr>
			</table>

			<form method='post' action='EditBook.jsp'>
				<fieldset>
					<table cellpadding='10'>
						<tr>
							<td><b>Book ID</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</td>
							<td><input type='text' name='id' value='${edObj.bk.bookId}'
								readonly /></td>
						</tr>
						<tr>
							<td><b>Book Name</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</td>
							<td><input type='text' name='name'
								value='${edObj.bk.bookName}' /></td>
						</tr>
						<tr>
							<td><b>Book Author</b>&nbsp;&nbsp;&nbsp;:</td>
							<td><input type='text' name='author'
								value='${edObj.bk.bookAuthor}' /></td>
						</tr>
						<tr>
							<td><b>Book Subject</b>&nbsp;&nbsp;:</td>
							<td><input type='text' name='subject'
								value='${edObj.bk.bookSubject}' /></td>
						</tr>
						<tr>
							<td><b>Book Price</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</td>
							<td><input type='text' name='price'
								value='${edObj.bk.bookPrice}' /></td>
						</tr>
						<tr>
							<td></td>
							<td><input type='submit' value='Update Book' /></td>
						</tr>
					</table>
				</fieldset>
				<br />
			</form>
		</c:when>
		<c:when test="${pageContext.request.method == 'POST'}">
			<jsp:useBean id="upObj" class="com.Rajvardhan.beans.EditBookBean"></jsp:useBean>
			<jsp:setProperty property="*" name="upObj" />
		 	${upObj.updateBook()}
			<jsp:forward page="BookList.jsp"></jsp:forward>
		</c:when>
	</c:choose>
</body>
</html>
