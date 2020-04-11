<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/SimpleAuth/loginProccess" method="POST" modelAttribute="loginData">
	<input type="text" name="userName">
	<input type="password" name="Password">
	<input type="submit">
</form>
</body>
</html>