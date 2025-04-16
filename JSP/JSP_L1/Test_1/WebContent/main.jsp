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
	function searchUser(){
		var search = $("#searchUsername").val();
		$.ajax({
			url: "MainServlet",
			data: {flag:"main",search:search},
			type: "post",
			dataType: "json",
			success: function(data){
				var trs = "";
				$.each(data,function(index,user){
					 trs += "<tr>";
					 trs += "<td>"+user.userId+"</td>";
					 trs += "<td>"+user.account+"</td>";
					 trs += "<td>"+user.password+"</td>";
					 trs += "<td>"+user.email+"</td>";
					 trs += "</tr>";
				});
				$("#show tbody").empty().append(trs);
			}
		});
	}
	$(function(){
		$(window).on("load",function(){
			$.ajax({
				url: "MainServlet",
				type: "post",
				data: {flag : "main"},
				dataType: "json",
				success: function(data){
					var trs = "";
					$.each(data,function(index,user){
						 trs += "<tr>";
						 trs += "<td>"+user.userId+"</td>";
						 trs += "<td>"+user.account+"</td>";
						 trs += "<td>"+user.password+"</td>";
						 trs += "<td>"+user.email+"</td>";
						 trs += "</tr>";
					});
					$("#show tbody").empty().append(trs);
				}
			});
		});
	});
	//分页
	    var currentPage = 1;
    var totalPages = 1;

    function loadUsers(pageNumber) {
        $.ajax({
            url: "MainServlet",
            type: "post",
            data: { flag: "paged", pageNumber: pageNumber, pageSize: 2 }, // 每页显示 2 条数据
            dataType: "json",
            success: function(data) {
            	alert(data);
                var trs = "";
                $.each(data.list, function(index, user) {
                	
                    trs += "<tr>";
                    trs += "<td>" + user.userId + "</td>";
                    trs += "<td>" + user.account + "</td>";
                    trs += "<td>" + user.password + "</td>";
                    trs += "<td>" + user.email + "</td>";
                    trs += "</tr>";
                });
                $("#show tbody").empty().append(trs);
                // 更新当前页和总页数
                $("#currentPage").text(pageNumber);
                totalPages = calculateTotalPages(data.total); // 计算总页数
                $("#totalPages").text(totalPages);
                currentPage = pageNumber;
            }
        });
    }

    function previousPage() {
        if (currentPage > 1) {
            loadUsers(currentPage - 1);
        }
    }

    function nextPage() {
        if (currentPage < totalPages) {
            loadUsers(currentPage + 1);
        }
    }

    function calculateTotalPages(totalRecords) {
        // 每页显示 2 条数据
        return Math.ceil(totalRecords / 2);
    }

    $(function() {
        // 页面加载时加载第一页数据
        loadUsers(1);
    });
</script>
</head>
<body>
	 <h2>主页面</h2>
	    <p>当前登录用户名: <span id="currentUser">${username}</span></p>
	    <h3>根据用户名查询用户信息</h3>
	    用户名: <input type="text" id="searchUsername"/><button onclick="searchUser()">查询</button>
	    <h3>所有用户信息</h3>
	    <div id="allUsers">
	    	<table id="show">
	    		<thead>
	    			<tr>
	    				<th>userId</th>
	    				<th>account</th>
	    				<th>password</th>
	    				<th>email</th>
	    			</tr>
	    		</thead>
	    		<tbody>
	    			
	    		</tbody>
	    	</table>
	    </div>
	    <h3>分页显示用户信息</h3>
	    <div id="pagedUsers">
	        <div id="pagination">
    <!-- 分页控件 -->
				    <button onclick="loadUsers(1)">第一页</button>
				    <button onclick="previousPage()">上一页</button>
				    <span id="currentPage">1</span>/<span id="totalPages">1</span>
				    <button onclick="nextPage()">下一页</button>
				    <button onclick="loadUsers(totalPages)">最后一页</button>
			</div>
	    </div>
	    <h3>下载当前页面信息</h3>
	    <button onclick="downloadFile('excel')">下载为Excel</button>
	    <button onclick="downloadFile('txt')">下载为TXT</button>
	    <button onclick="downloadFile('word')">下载为Word</button>
	    
</body>
</html>