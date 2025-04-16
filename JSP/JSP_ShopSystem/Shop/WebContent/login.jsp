<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="js/jquery-1.8.3.js"></script>
<script>
	function reloadImage(url){
		var img = document.getElementById("pic");
		img.src = url+"?" + Math.random();
	}
	function chk_image(){
		   var img = document.getElementById("pic");
		   img.src = "image.jsp?" + Math.random();
		}
	function validateCaptcha() {
    	$("#notice3").text('');
        var captcha = $('#captcha').val();
        if(captcha.trim() == ""){
        	$("#notice3").text('验证码不能为空');
        	disabledSumbit();
        	return;
        }
        $.ajax({
            url: 'UserServlet?flag=validateCaptcha',
            type: 'POST',
            data: {captcha: captcha},
            success: function(response) {
                if(response !== 'success') {
                	$("#notice3").text('图片验证码错误');
                	disabledSumbit();
                }else{
                	 enableSumbit();
    			}
            }
        });
    }
	function disabledSumbit(){
		$("input[type='submit']").prop("disabled",true);
	}
	function enableSumbit(){
		$("input[type='submit']").prop("disabled",false);
	}
</script>
</head>

<body>
	 <h2>登录页面</h2>
	 <form action="UserServlet?flag=login" method="post">
	    账号: <input type="text" id="username" name="username"/><br/>
	    密码: <input type="password" id="password" name="password"/><br/>
	    图片验证码: <input name="captcha" type="text" id="captcha" onblur="validateCaptcha()"/><span id="notice3"></span><br/>
	    <img id="pic" border=1 src="image.jsp?,Math.random();" onclick="return chk_image();"><a a href="javaScript:reloadImage('image.jsp');">点击刷新验证码</a><br/>
	    <input type="submit" onclick="login()" value="登录">
	   <c:choose>
	   		<c:when test="${not empty msg}">
	   			<h5>${msg }</h5>
	   		</c:when>
	   </c:choose>
	    
	  </form>
</body>
</html>