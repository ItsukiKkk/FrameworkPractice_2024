<%@page import="com.edu.seiryo.entity.User"%>
<%@page import="com.edu.seiryo.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="js/jquery-1.8.0.js"></script>
</head>
<body>
<%	
	String msg = (String)request.getAttribute("msg");
	if(msg == null){
		msg = "";
	} 
	Cookie[] cookies = request.getCookies();
	String cookieAccount = "";
	String cookiePassword = "";
	if(cookies != null){
		for(Cookie ck:cookies){
			if("name".equals(ck.getName())){
				cookieAccount = ck.getValue();
			}
			if("pass".equals(ck.getName())){
				cookiePassword = ck.getValue();
			} 
		}
	}
%>
登录
<form action="LoginServlet" method="post">
	<input type="hidden" name="action" value="login">
	用户名：<input type="text" name="account" value="<%= cookieAccount %>"/><br/>
	密码：<input type="password" name="pwd" value="<%= cookiePassword %>"/><br/>
	有效期：<input type="radio" name="cookie" value="30"/>三十天有效<br/>
	<input type="submit">
</form>
<%= msg %>
</body>
<script>
	$(function(){
		var errorMsg;
		$("form").on("submit",function(){
			$("p").empty();
			var account = $("input[name='account']").val().trim();
			var pwd = $("input[name='pwd']").val().trim();
			if(account == "" || pwd == ""){
				errorMsg = "所有字段均为必填项，不能为空！";
				$("form").append("<p>"+errorMsg+"</p>");
				return false;
			}
			return true;
		});
	});
</script>
</html>
