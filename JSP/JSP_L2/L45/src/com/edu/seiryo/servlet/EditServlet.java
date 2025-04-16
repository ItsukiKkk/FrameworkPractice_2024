package com.edu.seiryo.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.seiryo.dao.UserDao;
import com.edu.seiryo.entity.User;
import com.edu.seiryo.service.UserService;
import com.edu.seiryo.service.imp.UserServiceImp;

/**
 * Servlet implementation class aa
 */
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService service = new UserServiceImp();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String opt = (String)request.getParameter("opt");
		if("edit".equals(opt)){
			queryById(request, response);
		}else if("delete".equals(opt)){
			deleteById(request,response);
			refresh(request, response);
		}else if("update".equals(opt)){
			updateById(request, response);
		}else if("deleteAll".equals(opt)){
			deleteAll(request, response);
		}
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}
	private void refresh(HttpServletRequest request, HttpServletResponse response){
		List<User> list = service.queryAll();
		request.setAttribute("list", list);
	}
	private void queryById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		User user = service.queryById(id);
		request.setAttribute("user", user);
		request.getRequestDispatcher("edit.jsp").forward(request, response);
	}
	private void updateById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		String account = request.getParameter("account");
		String pwd = request.getParameter("pwd");
		String sex = request.getParameter("sex");
		String email = request.getParameter("email");
		User user = new User();
		user.setId(id);
		user.setAccount(account);
		user.setPassword(pwd);
		boolean bo = service.updateById(user);
		if(bo){
			request.setAttribute("msg", "修改成功");
			refresh(request, response);
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}
	}
	private void deleteById(HttpServletRequest request, HttpServletResponse response){
		int id = Integer.parseInt(request.getParameter("id"));
		boolean bo = service.deleteById(id);
		if(bo){
			request.setAttribute("msg", "删除成功");
		}else{
			request.setAttribute("msg", "删除失败");
		}
		refresh(request, response);
	}
	private void deleteAll(HttpServletRequest request, HttpServletResponse response){
		boolean bo = service.deleteAll();
		if(bo){
			request.setAttribute("msg", "删除成功");
		}else{
			request.setAttribute("msg", "删除失败");
		}
		refresh(request, response);
	}
}
