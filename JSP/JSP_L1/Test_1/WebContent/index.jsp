<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="js/jquery-1.8.3.js"></script>
    <script>
        function validateUsername() {
        	$("#notice1").text('');
            var username = $('#username').val();
            $.ajax({
                url: 'UserServlet',
                type: 'POST',
                data: {flag:"queryIfExisted",username: username},
                success: function(response) {
                	console.log(response);
                    if(response === 'exists') {
                        $("#notice1").text('用户名已存在');
                        disableRegisterButton();
                    }else{
        				enableRegisterButton();
        			}
                }
            });
        }

        function validateCaptcha() {
        	$("#notice3").text('');
            var captcha = $('#captcha').val();
            $.ajax({
                url: 'UserServlet?flag=validateCaptcha',
                type: 'POST',
                data: {captcha: captcha},
                success: function(response) {
                    if(response !== 'success') {
                    	$("#notice3").text('图片验证码错误');
                    	disableRegisterButton();
                    }else{
        				enableRegisterButton();
        			}
                }
            });
        }

        function sendEmailVerification() {
        	$("#notice4").text('');
            var email = $('#email').val();
            if(email.trim() == ""){
            	$("#notice4").text('邮箱不能为空');
            	return;
            }
            $.ajax({
                url: 'UserServlet',
                type: 'POST',
                data: {flag: "sendEmailCode",email: email},
                success: function(response) {
                	$("#notice4").text('验证码已发送到您的邮箱');
                }
            });
        }
        function checkEmailCode(){
        	$("#notice4").text('');
        	var emailCode = $("#emailCode").val();
        	if(emailCode.trim() == ""){
        		disableRegisterButton();
        	}
        	$.ajax({
        		url: "UserServlet?flag=validateEmailCode",
        		type: "post",
        		data: {emailCode: emailCode},
        		success: function(response){
        			console.log(response);
        			if(response !== 'success'){
        				$("#notice4").text('邮箱验证码错误');
        				disableRegisterButton();
        			}else{
        				enableRegisterButton();
        			}
        		}
        	});
        }
        function register() {
            if (!validateForm()) {
                return;  // 如果验证未通过，不继续注册操作
            }

            // 如果所有验证通过，可以继续注册逻辑
            var username = $('#username').val();
            var password = $('#password').val();
            var captcha = $('#captcha').val();
            var email = $('#email').val();
            var emailCode = $('#emailCode').val();

            // 注册成功或其他操作后的跳转或提示
            alert('注册成功！');
            
        }
        function reloadImage(url){
			var img = document.getElementById("pic");
			img.src = url+"?" + Math.random();
        }
        function chk_image(){
     	   var img = document.getElementById("pic");
     	   img.src = "image.jsp?" + Math.random();
     	}
        function validateForm() {
            var username = $('#username').val();
            var password = $('#password').val();
            var captcha = $('#captcha').val();
            var email = $('#email').val();
            var emailCode = $('#emailCode').val();
            var isValid = true;

            // 检查用户名
            if (username.trim() === '') {
                $("#notice1").text('账号不能为空');
                isValid = false;
            } else {
                $("#notice1").text('');
            }

            // 检查密码
            if (password.trim() === '') {
                $("#notice2").text('密码不能为空');
                isValid = false;
            } else {
                $("#notice2").text('');
            }

            // 检查图片验证码
            if (captcha.trim() === '') {
                $("#notice3").text('图片验证码不能为空');
                isValid = false;
            } else {
                $("#notice3").text('');
            }

            // 检查邮箱
            if (email.trim() === '') {
                $("#notice4").text('邮箱不能为空');
                isValid = false;
            } else {
                $("#notice4").text('');
            }

            // 检查邮箱验证码
            if (emailCode.trim() === '') {
                $("#notice5").text('邮箱验证码不能为空');
                isValid = false;
            } else {
                $("#notice5").text('');
            }

            return isValid;
        }
        function disableRegisterButton() {
            $('input[type="submit"]').prop('disabled', true);  // 禁用注册按钮
        }

        function enableRegisterButton() {
            $('input[type="submit"]').prop('disabled', false);  // 启用注册按钮
        }
        $(function(){
        	$("form").submit(register);
        });
    </script>
</head>
<body>
	<h2>注册页面</h2>
	<form action="UserServlet?flag=regist" method="post">
		    账号: <input name="username" type="text" id="username" onblur="validateUsername()"/><span id="notice1"></span><br/>
		    密码: <input name="password" type="password" id="password"/><span id="notice2"></span><br/>
		    图片验证码: <input name="captcha" type="text" id="captcha" onblur="validateCaptcha()"/><span id="notice3"></span><br/>
		    <img id="pic" border=1 src="image.jsp?,Math.random();" onclick="return chk_image();"><a a href="javaScript:reloadImage('image.jsp');">点击刷新验证码</a><br/>
		    邮箱: <input name="email" type="text" id="email" "/><input type="button" onclick="sendEmailVerification()" value="发送验证码"><span id="notice4"></span><br/>
		    邮箱验证码: <input name="emailCode" type="text" id="emailCode" onblur="checkEmailCode()"/><span id="notice5"></span><br/>
		    <input onclick="register()" value="注册" type="submit">
	</form>
</body>
</html>