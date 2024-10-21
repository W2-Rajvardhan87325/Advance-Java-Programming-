<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<c:choose>
		<c:when test="${pageContext.request.method == 'GET'}">
			<div align="center">
				<hr>
				<h3>LOGIN PAGE</h3>
				<hr>
				<fieldset style="width: 400px;">
					<form action="Login.jsp" method="POST">
						<table cellpadding='5'>
							<tbody>
								<tr>
									<td>Enter
										Email&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;::</td>
									<td><input type="email" placeholder="enter your email"
										autofocus="autofocus" name="email" required="required"></td>
								</tr>
								<tr>
									<td>Enter Password&nbsp;::</td>
									<td><input type="password"
										placeholder="enter your password " autofocus="autofocus"
										name="password" required="required"></td>
								</tr>
								<tr>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td><input type="submit" value="Login"></td>
								</tr>
							</tbody>
						</table>
					</form>
				</fieldset>
				<p>
					Don't have an account? <a href="RegisterCustomer.jsp"><b>Sign
							up</b></a>
				</p>
			</div>
		</c:when>

		<c:when test="${pageContext.request.method == 'POST'}">
			<jsp:useBean id="lbObj" class="com.Rajvardhan.beans.LoginBean" scope="session" />
			<jsp:setProperty name="lbObj" property="*" />
			${lbObj.authenticate()}
			
			<c:choose>
				<c:when test="${lbObj.cust.custPsswd == 'admin' and lbObj.cust.custName == 'admin'}">
					<c:redirect url="BookList.jsp" />
				</c:when>

				<c:when test="${not empty lbObj.cust.custName}">
					<c:redirect url="Subjects.jsp" />
				</c:when>

				<c:otherwise>
					<c:redirect url="LoginFailed.jsp" />
				</c:otherwise>
			</c:choose>
		</c:when>
		
	</c:choose>
</body>
</html>
