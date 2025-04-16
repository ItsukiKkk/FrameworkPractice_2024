package com.seiryo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;

import com.seiryo.entity.Users;
import com.seiryo.service.UserService;
import com.seiryo.service.imp.UserServiceImp;
import com.seiryo.util.JSONUtil;
import com.seiryo.util.JavaEmail;
import com.seiryo.util.MD5;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	   private static final long serialVersionUID = 1L;
       private UserService service = new UserServiceImp();
       private MD5 md5 = new MD5();
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String flag = request.getParameter("flag");
		if("regist".equals(flag)){
			regist(request,response);
		}else if("queryIfExisted".equals(flag)){
			queryIfExisted(request,response);
		}else if("validateCaptcha".equals(flag)){
			validateCaptcha(request,response);
		}else if("sendEmailCode".equals(flag)){
			sendEmailCode(request,response);
		}else if("validateEmailCode".equals(flag)){
			validateEmailCode(request,response);
		}else if("login".equals(flag)){
			login(request,response);
		}
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
		String pwd = md5.getMD5ofStr(password);
		boolean bo = service.login(username, pwd);
		String msg = "";
		if(!bo){
			msg = "用户名或密码错误";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}


	/**
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void validateEmailCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Integer rand = (Integer) session.getAttribute("emailRand");
		Integer inputEmailCode = Integer.parseInt(request.getParameter("emailCode"));
		PrintWriter out = response.getWriter();
		if(rand.equals(inputEmailCode)){
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
	 */
	private void sendEmailCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Random random = new Random();
        int randomNumber = 1000 + random.nextInt(9000);
		HttpSession session = request.getSession();
		session.setAttribute("emailRand", randomNumber);
		String userEmail = request.getParameter("email");
		int res = JavaEmail.sendEmail("smtp.qq.com", "905711146@qq.com", "pbojnjcamydhbefc", "905711146@qq.com",new String[]{userEmail} 
				, "ValidateCode", String.valueOf(randomNumber), "text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(res == 1){
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
	 */
	private void queryIfExisted(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		boolean bo = service.queryUsername(username);
		PrintWriter out = response.getWriter();
		if(bo){
			out.print("exists");
		}else{
			out.print("not exists");
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
	private void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String pwd = md5.getMD5ofStr(password);
		String email = request.getParameter("email");
		boolean bo = service.regist(username, pwd, email);
		if (bo) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
