<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>网页换肤</title>
<link href="css/default.css" rel="stylesheet" type="text/css"/>
<link href="css/<%=request.getAttribute("sc") %>.css" rel="stylesheet" type="text/css" id="cssfile"/>
<script src="js/jquery-1.8.0.js"></script>
<script>
	$(function(){
		$("#skin li").on("click",function(){
			switchSkin(this.id)
		});
	});
	function switchSkin(skinName){
		$("#"+skinName).addClass("selected").siblings();
		$("#skincolor").attr("value","css/"+skinName+".css");
		$("#cssfile").attr("href","css/"+skinName+".css")
	}
</script>
</head>
<body>
	<form action="SinkColorServlet" method="post">
		<ul id="skin">
			<li id="skin_0" title="灰色">灰色</li>
			<li id="skin_1" title="紫色">紫色</li>
			<li id="skin_2" title="红色">红色</li>
			<li id="skin_3" title="天蓝色">天蓝色</li>
			<li id="skin_4" title="橙色">橙色</li>
			<li id="skin_5" title="淡绿色">淡绿色</li>
		</ul>
		<div id="div_side_0"><div id="news"><h1 class="title">时事新闻</h1></div></div>
		<div id="div_side_1"><div id="game"><h1 class="title">娱乐新闻</h1></div></div>
		<div><input type="submit" value="提交" /> </div>
		<input type="hidden" name="skincolor" id="skincolor"/>
	</form>
</body>
</html>