package com.edu.seiryo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.seiryo.dao.UserDao;
import com.edu.seiryo.entity.User;
import com.edu.seiryo.service.UserService;
import com.edu.seiryo.service.imp.UserServiceImp;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private UserService dao = new UserServiceImp();
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account = request.getParameter("account");
		String pwd = request.getParameter("pwd");
		boolean bo = dao.loginQuery(account, pwd);
		if(!bo){
			request.setAttribute("msg", "用户名或密码错误");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		String rememberMe = request.getParameter("cookie");
		if ("30".equals(rememberMe)) {
            Cookie accountCookie = new Cookie("name", account);
            Cookie passwordCookie = new Cookie("pass", pwd);

            accountCookie.setMaxAge(30 * 24 * 60 * 60); 
            passwordCookie.setMaxAge(30 * 24 * 60 * 60);

            response.addCookie(accountCookie);
            response.addCookie(passwordCookie);
        }
		List<User> list = dao.queryAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

}
