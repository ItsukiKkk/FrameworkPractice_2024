<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:property value="@com.seiryo.action.FirstAction@staticShow()"/>
<s:property value="msg"/>
<s:property value="list"/><br/>
<s:iterator value="list" var="item"  status="sta" begin="0">
	<s:property value="#item.name"/>
	<s:property value="#item.phone"/><br/>
</s:iterator>
</body>
</html>