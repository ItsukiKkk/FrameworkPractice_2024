<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<table border="1px" id="table1">
	<thead>
		<tr>
			<th>订单编号</th>
			<th>日期</th>
			<th>状态</th>
			<th>修改状态</th>
			<th>查看明细</th>
		</tr>
	</thead>
	<c:set var="total" value="0"/>
	<tbody>
		<c:forEach var="detail" items="${orderList }" varStatus="status">
			<tr data-id=${detail.orderId }>
				<td>${detail.orderId }</td>
				<td>${detail.createDtm }</td>
				<td>${detail.stateOut }</td>
				<td>
					<a href="OrderServlet?flag=updateState&state=0&orderId=${detail.orderId }">待审核</a>&nbsp;
					<a href="OrderServlet?flag=updateState&state=1&orderId=${detail.orderId }">已审核</a>&nbsp;
					<a href="OrderServlet?flag=updateState&state=2&orderId=${detail.orderId }">已付款</a>&nbsp;
					<a href="OrderServlet?flag=updateState&state=3&orderId=${detail.orderId }">已发货</a>
				</td>
				<td><a href="#" onclick="checkDetail(${detail.orderId })">查明细</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
订单明细
<table border="1px" id="table2">
	<thead>
		<tr>
			<th>编号</th>
			<th>商品名称</th>
			<th>单价</th>
			<th>数量</th>
			<th>总金额</th>
		</tr>
	</thead>
	<tbody>
		
	</tbody>
</table>
<span></span>
<script src="js/jquery-1.8.3.js"></script>
<script>
	function checkDetail(orderId){
		alert(orderId);
		$.ajax({
			url:"OrderServlet?flag=showTable2",
			data:{orderId:orderId},
			type:"post",
			dataType:"json",
			success:function(data){
				var trs = "";
				var all = 0
				$.each(data,function(index,detail){
					console.log(detail.totalPrice);
					trs += "<tr>";
					trs += "<td>"+ index+1 +"</td>";
					trs += "<td>"+ detail.shopInfo.shopName +"</td>";
					trs += "<td>"+ detail.shopInfo.price +"</td>";
					trs += "<td>"+ detail.quantity +"</td>";
					trs += "<td>"+ detail.totalPrice +"</td>";
					trs +="</tr>";
					all += detail.totalPrice;
				})
				$("#table2 tbody").empty().append(trs);
				$("span").text("订单总金额:"+ all);
			}
		})
	}
	$(function(){
		$("#table1 tr").on("click",function(){
			
		});
	});
</script>
</body>
</html>