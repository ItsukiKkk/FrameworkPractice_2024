<%@page import="com.edu.seiryo.entity.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<% List<User> list =(List)request.getAttribute("list"); 
	String msg = (String)request.getAttribute("msg");
	if(msg == null){
		msg = "";
	}
%>
	<table border="1">
		<tr>
			<td>编号</td>
			<td>用户名</td>
			<td>密码</td>
			<td>操作</td>
		</tr>
		<%for(User user:list){%>
			<tr>
				<td><%=user.getId() %></td>
				<td><%=user.getAccount() %></td>
				<td><%=user.getPassword() %></td>
				<td><a href="EditServlet?opt=edit&id=<%= user.getId()%>">编辑</a>&nbsp;<a href="EditServlet?opt=delete&id=<%= user.getId()%>">删除</a></td>
			</tr>
		<%} %>
	</table>
	<a href="EditServlet?opt=deleteAll">删除所有用户</a>
	<%=msg %>
</body>
</html>