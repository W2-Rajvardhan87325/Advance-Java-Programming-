<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Books List Page</title>
</head>
<body>
<jsp:useBean id="blsObj" class="com.Rajvardhan.beans.BookListBean"></jsp:useBean>
<jsp:setProperty property="*" name="blsObj"/>
${blsObj.fetchBooks()}
	<hr>
	<h3 align="center">ADMIN PANEL</h3>
	<hr>
	<div align="center">
		<fieldset>
			<table border='1' cellpadding='10'>
				<thead>
					<tr>
						<th>ID</th>
						<th>NAME</th>
						<th>AUTHOR</th>
						<th>SUBJECT</th>
						<th>PRICE</th>
						<th>EDIT</th>
						<th>DELETE</th>
					</tr>
				</thead>
				<c:forEach var="bk" items="${blsObj.books}">
					<tr>
						<td>${bk.bookId}</td>
						<td>${bk.bookName}</td>
						<td>${bk.bookAuthor}</td>
						<td>${bk.bookSubject}</td>
						<td>${bk.bookPrice}</td>
						<td align='center'><a href='EditBook.jsp?bookId=${bk.bookId}'><img
								src='images/Edit.png' alt='Edit' width='26' height='26' /></a></td>
						<td align='center'><a href='DeleteBook.jsp?bookId=${bk.bookId}'><img
								src='images/Delete.png' alt='Delete' width='28' height='28' /></a></td>
					</tr>
				</c:forEach>
			</table>
		</fieldset>
	</div>
	<br>

	<table align='center' cellpadding='10'>
		<tr>
			<td>
				<p>
					<a href='Logout.jsp'>
						<button>Sign Out</button>
					</a>
				</p>
			</td>
			<td>
				<p>
					<a href='AddBook.jsp'>
						<button>Add Book</button>
					</a>
				</p>
			</td>
		</tr>
	</table>
</body>
</html>
