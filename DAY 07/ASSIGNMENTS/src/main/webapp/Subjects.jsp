<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Subject Page</title>
</head>

<body>
	<jsp:useBean id="sbObj" class="com.Rajvardhan.beans.SubjectBean" />
	<c:choose>
		<c:when test="${sbObj.fetchSubjects()}">
		Hello, ${lbObj.cust.custName}
			<hr>
			<h3 align="center">DISPLAY SUBJECTS</h3>
			<hr>
			<form action='Books.jsp' method='POST'>
				<fieldset>
					<legend>
						<b>Select a Subject:</b>
					</legend>
					<table cellpadding='10'>
						<tr>
							<td><c:forEach var="sub" items="${sbObj.subjects}">
									<input type="radio" name="subject" value="${sub}" /> ${sub} <br />
								</c:forEach></td>
						</tr>

					</table>
				</fieldset>
				<br>
				<table cellpadding='5'>
					<tr>
						<td><input type='submit' value='Get Books'></td>
					</tr>
					<tr>
						<td><button>
								<a href="ShowCart.jsp">Show Cart</a>
							</button></td>
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
