<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>SHOPPING CART</title>
</head>
<body>
Hello, ${lbObj.cust.custName}
	<hr>
	<h3 align="center">CART ITEMS</h3>
	<hr>
	<table cellpadding='10'>
		<thead align='center'>
			<tr>
				<th>NAME</th>
				<th>AUTHOR</th>
				<th>SUBJECT</th>
				<th>PRICE</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="bk" items="${cartBeanObj.bkList}">
			<tr>
			<td>${bk.bookName}</td>
			<td>${bk.bookAuthor}</td>
			<td>${bk.bookSubject}</td>
			<td>${bk.bookPrice}</td>
			</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td>
					<p>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
							href='Logout.jsp'>
							<button>Log Out</button>
						</a>
					</p>
				</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>
