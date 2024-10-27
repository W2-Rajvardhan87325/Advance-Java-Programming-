<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration Page</title>
</head>
<body>

    <h2>Registration</h2>

    <sf:form modelAttribute="cust" action="register">
        <label for="name">Full Name:</label><br>
		<sf:input path="name" placeholder="Enter your full name"/>
		<sf:errors path="name"/><br><br>
		
        <label for="email">Email:</label><br>
        <sf:input path="email" placeholder="Enter your email"/>
        <sf:errors path="email"/><br><br>

        <label for="password">Password:</label><br>
        <sf:password path="password" placeholder="Create a password"/>
        <sf:errors path="password"/><br><br>

        <label for="mobile">Mobile Number:</label><br>
        <sf:input path="mobile" placeholder="Enter your mobile number"/>
        <sf:errors path="mobile"/><br><br>

        <label for="address">Address:</label><br>
        <sf:textarea path="address" placeholder="Enter your address" rows="4" cols="50"/>
        <sf:errors path="address"/><br><br>

        <label for="birthdate">Date of Birth:</label><br>
        <sf:input type="date" path="birth"/>
        <sf:errors path="birth"/><br><br>

        <input type="submit" value="Register">
    </sf:form>
    <sf:errors path="*"/>
	<p>${message}</p>
    <p>Already have an account? <a href="index">Login here</a></p>
</body>
</html>
