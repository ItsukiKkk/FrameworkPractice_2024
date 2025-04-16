package com.edu.seiryo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlet
 */
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		Cookie cookie = new Cookie("cookieName", "cookieServlet");
		cookie.setMaxAge(60);
		PrintWriter pWriter = response.getWriter();
		response.addCookie(cookie);
		Cookie[] cookies = request.getCookies();
		if(cookie == null){
			pWriter.print("<html><title>查看cookie</title><div style='width:400px;height:200px border=1px solid;'>");
			pWriter.print("第一次访问cookieSevlet还没有cookie实例</div></html>");
		}else{
			pWriter.print("<html><title>查看cookie</title><div style='width:400px;height:200px border=1px solid;'>");
			pWriter.print("cookie列表<br/>");
			for (int i = 0; i < cookies.length; i++) {
				pWriter.print("cookie名称"+cookies[i].getName()+"，对应的Cookie值："+cookies[i].getValue());
				pWriter.print("<br/>");
			}
			pWriter.print("</div></html>");
			pWriter.close();
		}
	}


}
