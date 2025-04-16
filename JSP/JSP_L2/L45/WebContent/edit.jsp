<%@page import="com.edu.seiryo.entity.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<% User user = (User)request.getAttribute("user"); %>
	<form method="post" action="EditServlet?opt=update">
		<input type="hidden" name="id" value="<%=user.getId() %>" readonly><br/>
		<input type="text" name="account" value="<%=user.getAccount() %>"><br/>
		<input type="text" name="pwd" value="<%=user.getPassword() %>"><br/>
		<input type="submit" value="提交">
	</form>
</body>
</html>