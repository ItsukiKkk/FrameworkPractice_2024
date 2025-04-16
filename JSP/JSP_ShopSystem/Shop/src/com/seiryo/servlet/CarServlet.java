package com.seiryo.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seiryo.dao.OrderDao;
import com.seiryo.dao.OrderDetailDao;
import com.seiryo.dao.imp.OrderDaoImp;
import com.seiryo.dao.imp.OrderDetailDaoImp;
import com.seiryo.entity.Order;
import com.seiryo.entity.OrderDetail;

/**
 * Servlet implementation class CarServlet
 */
public class CarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final AtomicInteger counter = new AtomicInteger(1);
	 private OrderDetailDao detailDao = new OrderDetailDaoImp();
	 private OrderDao dao = new OrderDaoImp();
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String flag = request.getParameter("flag");
		if("clearCar".equals(flag)){
			clearCar(request,response);
			return;
		}else if("updateQuantity".equals(flag)){
			updateQuantity(request,response);
		}else if("update".equals(flag)){
			update(request,response);
		}else if("deleteById".equals(flag)){
			deleteById(request,response);
		}else if("buy".equals(flag)){
			buy(request,response);
		}else{
			showInite(request, response);
		}
	}
	/**
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void buy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] shopIdArray = request.getParameterValues("shopId");
		String[] quantityArray = request.getParameterValues("quantity");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        boolean bo = false;
        String dateStr = dateFormat.format(new Date());
        HttpSession session = request.getSession();
        Object oCount =  session.getAttribute("orderCount");
        int orderCount  = 0;
        if (oCount == null) {
        	// 生成订单号
            orderCount = counter.getAndIncrement(); // 获取当前订单计数并自增
		}else{
			orderCount = (Integer) oCount+1;
		}
        session.setAttribute("orderCount", orderCount);
        String orderId = String.format("%s%06d", dateStr, orderCount);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        boolean bo0 = dao.insertOrder(orderId, timestamp, 0);
        for (int i = 0; i < quantityArray.length; i++) {
            System.out.println(bo0);
            bo = detailDao.insertOrderDetail(orderId, shopIdArray[i], quantityArray[i]);
		}
        if(bo){
        	request.setAttribute("orderId", orderId);
        	request.setAttribute("timestamp", timestamp);
        	request.getRequestDispatcher("success.jsp").forward(request, response);;
        }
	}
	/**
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void deleteById(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String index = request.getParameter("id");
		int i = Integer.parseInt(index);
		HttpSession session = request.getSession();
		List<OrderDetail> tempDetailList = (List<OrderDetail>) session.getAttribute("tempDetailList");
		tempDetailList.remove(i);
		session.setAttribute("tempDetailList", tempDetailList);
		response.sendRedirect("CarServlet");
	}
	private void clearCar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("car.jsp");
		
	}
	private void showInite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<OrderDetail> tempDetailList = (List<OrderDetail>) session.getAttribute("tempDetailList");
		if(tempDetailList == null){
			tempDetailList = new ArrayList<OrderDetail>();
		}
		request.getRequestDispatcher("car.jsp").forward(request, response);
	}
	/**
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderId = request.getParameter("orderId");
		String quantity = request.getParameter("quantity");
		detailDao.updateQuantityByOrderId(orderId, quantity);
		response.sendRedirect("CarServlet");
	}
	/**
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void updateQuantity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderId = request.getParameter("orderId");
		request.setAttribute("orderId", orderId);
		request.getRequestDispatcher("updateQuantity.jsp").forward(request, response);
	}

}
