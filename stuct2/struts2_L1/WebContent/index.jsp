<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="action1">action1</a><br/>
<a href="action2">action2</a><br/>
<a href="redirectAction">redirectAction</a><br/>
<a href="redirect">redirect</a><br/>
<a href="ChainAction">ChainAction</a><br/>
<a href="sendMessage?name=name&phone=110">sendMessage</a><br/>
  <form action="sendMessage" method="post">
    <input type="hidden" name="name" value="name" />
    <input type="hidden" name="phone" value="110" />
    <input type="submit" value="Send" />
</form>
</body>
</html>