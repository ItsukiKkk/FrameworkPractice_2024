package com.seiryo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.ListModel;
import com.seiryo.dao.OrderDao;
import com.seiryo.dao.OrderDetailDao;
import com.seiryo.dao.ShopInfoDao;
import com.seiryo.dao.imp.OrderDaoImp;
import com.seiryo.dao.imp.OrderDetailDaoImp;
import com.seiryo.dao.imp.ShopInfoDaoImp;
import com.seiryo.entity.Order;
import com.seiryo.entity.OrderDetail;
import com.seiryo.entity.ShopInfo;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
/**
 * Servlet implementation class ShopServlet
 */
public class ShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private ShopInfoDao dao = new ShopInfoDaoImp();
       private OrderDao orderDao = new OrderDaoImp();
       private OrderDetailDao detailDao = new OrderDetailDaoImp();
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String flag = request.getParameter("flag");
		if("queryShop".equals(flag)){
			queryShop(request,response);
		}else if("queryOrder".equals(flag)){
			queryOrder(request,response);
		}else if("intoCar".equals(flag)){
			intoCar(request,response);
			return;
		}else{
			
			List<ShopInfo> shopInfoList = dao.queryAllShopInfo();
			request.setAttribute("shopInfoList", shopInfoList);
			request.getRequestDispatcher("Shop.jsp").forward(request, response);
		}
	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void intoCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String shopId = request.getParameter("shopId");
		ShopInfo shopInfo = dao.queryShopInfoByShopId(shopId);
		HttpSession session = request.getSession();
		List<OrderDetail> tempDetailList = (List<OrderDetail>) session.getAttribute("tempDetailList");
		if(tempDetailList == null){
			tempDetailList = new ArrayList<OrderDetail>();
		}
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setShopId(shopId);
		orderDetail.setQuantity(1);
		orderDetail.setTotalPrice(shopInfo.getPrice());
		orderDetail.setShopInfo(shopInfo);
		tempDetailList.add(orderDetail);
		session.setAttribute("tempDetailList", tempDetailList);
		request.getRequestDispatcher("car.jsp").forward(request, response);
	}
	

	/**
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void queryOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderId = request .getParameter("orderId");
		Order order = orderDao.queryOrderByOrderId(orderId);
		if(order == null){
			request.setAttribute("state", "无对应订单");
			request.getRequestDispatcher("Shop.jsp").forward(request, response);
			return;
		}
		int state = order.getState();
		String out = "";
		if(state == 0){
			out = "待审核 "; 
		}else if(state == 1){
			out = "已审核 ";
		}else if(state == 2){
			out = "已付款";
		}else if(state == 3){
			out = "已发货";
		}
		request.setAttribute("state", out);
		request.getRequestDispatcher("Shop.jsp").forward(request, response);
	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void queryShop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String shopName = new String(request .getParameter("shopName").getBytes("iso-8859-1"),"utf-8");
		String descr = new String(request .getParameter("descr").getBytes("iso-8859-1"),"utf-8");
		if("all".equals(descr)){
			descr = null;
		}
		List<ShopInfo> shopInfoList = dao.queryShopInfoByNameAndDescr(shopName, descr);
		request.setAttribute("shopInfoList", shopInfoList);
		request.getRequestDispatcher("Shop.jsp").forward(request, response);
	}

}
