package com.seiryo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seiryo.dao.UserDao;
import com.seiryo.dao.imp.UserDaoImp;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String flag = request.getParameter("flag");
		if("validateCaptcha".equals(flag)){
			validateCaptcha(request,response);
		}else if("login".equals(flag)){
			login(request,response);
		}
		
	}


	/**
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void validateCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		String rand = (String) session.getAttribute("rand");
		String inputRand = request.getParameter("captcha");
		PrintWriter out = response.getWriter();
		if(rand.equals(inputRand)){
			out.print("success");
		}else{
			out.print("fail");
		}
		out.flush();
		out.close();
	}


	/**
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String msg = "";
		UserDao dao = new UserDaoImp();
		boolean bo = dao.login(username, password);
		if(!bo){
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		request.getRequestDispatcher("OrderServlet").forward(request, response);
	}

}
