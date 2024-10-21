<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Insert</title>
</head>
<body>
	<c:choose>
		<c:when test="${pageContext.request.method == 'GET'}">
			<hr>
			<h3 align="center">ADD BOOK</h3>
			<hr>
			<div align="center">
				<fieldset style="width: 600px;">
					<form action="AddBook.jsp" method="POST">
						<table cellpadding='10'>
							<tbody>
								<tr>
									<td rowspan="1"><b></>DETAILS</b></td>
								</tr>

								<tr>
									<td>Book Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;::</td>
									<td><input type="text" placeholder="enter book name"
										autofocus="autofocus" name="name" required="required"></td>
								</tr>
								<tr>
									<td>Book Author&nbsp;&nbsp;&nbsp;::</td>
									<td><input type="text" placeholder="enter book author "
										autofocus="autofocus" name="author" required="required"></td>
								</tr>
								<tr>
									<td>Book Subject&nbsp;&nbsp;::</td>
									<td><input type="text" placeholder="enter book subject "
										autofocus="autofocus" name="subject" required="required"></td>
								</tr>
								<tr>
									<td>Book Price &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;::</td>
									<td><input type="text" placeholder="enter book price "
										autofocus="autofocus" name="price" required="required"></td>
								</tr>
								<tr>
									<td></td>
									<td><input type="submit" value="Add Book"></td>
								</tr>
							</tbody>
						</table>
					</form>
				</fieldset>
			</div>
		</c:when>

		<c:when test="${pageContext.request.method == 'POST'}">
			<jsp:useBean id="addbkObj" class="com.Rajvardhan.beans.AddBookBean"></jsp:useBean>
			<jsp:setProperty property="*" name="addbkObj"/>
			${addbkObj.addBooks()}
			<c:redirect url="BookList.jsp"></c:redirect>
		</c:when>
	</c:choose>
</body>
</html>