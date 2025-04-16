package com.edu.seiryo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SinkColorServlet
 */
public class SinkColorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SinkColorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private Cookie tempCookie;
	private int count;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String skinCss = request.getParameter("skincolor");
		System.out.println(skinCss);
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(Cookie cookie: cookies){
				if("skinCss".equals(cookie.getName())){
					tempCookie = cookie;
					if(skinCss != null){
						tempCookie.setValue(skinCss);
					}
					break;
				}
			}
		}
		if(tempCookie == null){
			tempCookie = new Cookie("skinCss", skinCss);
		}
		tempCookie.setMaxAge(3600*24*60);
		//如果没点击存入cookie的value是空
		response.addCookie(tempCookie);
		String sc = "css/skin_0.css";
		if(tempCookie != null && count != 0){
			sc = tempCookie.getValue();
		}
		count++;
		sc = sc.split("/")[1].split("\\.")[0];
		request.setAttribute("sc", sc);
		request.getRequestDispatcher("Skin.jsp").forward(request, response);
	}
}
