package com.seiryo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import com.seiryo.dao.OrderDao;
import com.seiryo.dao.OrderDetailDao;
import com.seiryo.dao.imp.OrderDaoImp;
import com.seiryo.dao.imp.OrderDetailDaoImp;
import com.seiryo.entity.Order;
import com.seiryo.entity.OrderDetail;
import com.seiryo.util.JSONUtil;

/**
 * Servlet implementation class OrderServlet
 */
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private OrderDetailDao detailDao = new OrderDetailDaoImp();
	 private OrderDao dao = new OrderDaoImp();
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String flag = request.getParameter("flag");
		if("updateState".equals(flag)){
			updateState(request,response);
		}else if("showTable2".equals(flag)){
			showTable2(request,response);
		}else{
			List<Order> orderList = dao.queryAllOrder();
			request.setAttribute("orderList", orderList);
			request.getRequestDispatcher("admin.jsp").forward(request, response);
		}
		
	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void showTable2(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String orderId = request.getParameter("orderId");
		List<OrderDetail> detail = detailDao.queryOrderDetailByOrderId(orderId);
		PrintWriter out = response.getWriter();
		try {
			out.print(JSONUtil.toJSONString(detail));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void updateState(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String orderId = request.getParameter("orderId");
		String state = request.getParameter("state");
		dao.updateOrderState(orderId, state);
		response.sendRedirect("OrderServlet");
	}
	
}
