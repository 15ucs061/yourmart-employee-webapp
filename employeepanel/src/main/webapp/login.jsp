<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
			<script src="https://www.google.com/recaptcha/api.js"></script>
</head>
<body>
<h3>Hey there!!</h3>
	<form action="/login" method="post">
		UserName: <input type="text" name="employeeId" /> <br> Password: <input
			type="password" name="password" /> <br>
			<div class="g-recaptcha" data-sitekey="6LcLDLYUAAAAAH5R2hQaBXqZh6FNCt4ztHyy7W3x"></div>
			<br>
			 <input type="submit" />
	</form>

</body>
</html>