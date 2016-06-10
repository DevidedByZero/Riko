<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body dir=rtl>

<p>הוסף בהצלחה ${message}</p>

	<form action="welcome" method="post">
		שם פרטי: <input type="text" name="firstName">
		<br> שם משפחה: <input type="text" name="lastname">
		<br> <br> <input type="submit" value="הוסף">
	</form>


</body>
</html>