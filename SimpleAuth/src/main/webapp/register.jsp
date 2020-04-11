<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/SimpleAuth/registerProcess" method="POST" modelAttribute="registerData">
	<input type="text" name="userName">
	<input type="password" name="Password">
	<input type="password" name="CPassword">
	<input type="submit">
</form>
</body>
</html>