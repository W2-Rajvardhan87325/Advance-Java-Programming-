<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Customer</title>
</head>
<body>
	<c:choose>
		<c:when test="${pageContext.request.method =='GET'}">
			<hr>
			<h3 align="center">REGISTRATION FORM</h3>
			<hr>
			<div align="center">
				<fieldset style="width: 600px;">
					<form action="RegisterCustomer.jsp" method="POST">
						<table cellpadding='10'>
							<tbody>
								<tr>
									<td>Customer
										Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;::</td>
									<td><input type="text" placeholder="enter your name"
										autofocus="autofocus" name="name" required="required"></td>
								</tr>
								<tr>
									<td>Customer
										Password&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;::</td>
									<td><input type="password"
										placeholder="enter your password " autofocus="autofocus"
										name="password" required="required"></td>
								</tr>
								<tr>
									<td>Customer
										Mobile&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;::</td>
									<td><input type="number" placeholder="enter your mobile "
										autofocus="autofocus" name="mobile" required="required"></td>
								</tr>
								<tr>
									<td>Customer
										Address&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;::</td>
									<td><input type="text" placeholder="enter your address"
										autofocus="autofocus" name="address" required="required"></td>
								</tr>
								<tr>
									<td>Customer Email
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;::</td>
									<td><input type="email" placeholder="enter your email "
										autofocus="autofocus" name="email" required="required"></td>
								</tr>

								<tr>
									<td>BirthDate(yyyy-mm-dd)&nbsp;::</td>
									<td><input type="date" placeholder="enter your birthdate "
										autofocus="autofocus" name="birth" required="required"></td>
								</tr>
								<tr>
									<td></td>
									<td><input type="submit" value="Register"></td>
								</tr>
							</tbody>
						</table>
					</form>
				</fieldset>
			</div>
		</c:when>

		<c:when test="${pageContext.request.method =='POST'}">
			<jsp:useBean id="resObj" class="com.Rajvardhan.beans.RegisterCustomerBean"></jsp:useBean>
			<jsp:setProperty property="*" name="resObj" />
			<c:choose>
				<c:when test="${resObj.saveData()}">
					<hr>
					<h4 align="center">REGISTRATION SUCCESSFUL...!</h4>
					<hr>
					<p>Thank you for registering. You can now enjoy all the
						features available to registered users.</p>
					<p>
						Please <a href="Login.jsp">login here</a> to continue to your
						dashboard.
					</p>
					<p>If you have any questions, feel free to reach out to our
						support team.</p>
				</c:when>
				<c:otherwise>
					<hr>
					<h4 align="center">REGISTRARION FAILED</h4>
					<hr>
					<p>Unfortunately, your registration could not be completed due
						to an error.</p>
					<p>Please check the information you provided and try again.</p>
					<p>
						Click <a href="RegisterCustomer.jsp">(Register Again)</a> to go
						back to the registration page and try again.
					</p>
				</c:otherwise>
			</c:choose>

		</c:when>
	</c:choose>
</body>
</html>