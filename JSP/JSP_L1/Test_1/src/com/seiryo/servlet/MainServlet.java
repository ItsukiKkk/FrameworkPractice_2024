package com.seiryo.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.seiryo.entity.Users;
import com.seiryo.service.UserService;
import com.seiryo.service.imp.UserServiceImp;
import com.seiryo.util.ExcelCreate;
import com.seiryo.util.FileUtils;
import com.seiryo.util.JSONUtil;
import com.seiryo.util.PageHelper;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private UserService service = new UserServiceImp();  
	 private ExcelCreate excelCreate = new ExcelCreate();
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String flag = request.getParameter("flag");
		if("main".equals(flag)){
			main(request,response);
		}else if ("excel".equalsIgnoreCase(flag)) {
            generateExcel(response);
        } else if ("txt".equalsIgnoreCase(flag)) {
            generateTxt(request,response);
        } else if ("word".equalsIgnoreCase(flag)) {
            generateWord(response);
        } else if ("paged".equals(flag)) {
	           try {
				paged(request,response);
			} catch (JSONException e) {
				e.printStackTrace();
			}
        }
	}
	 private void paged(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, JSONException {
	        PrintWriter out = response.getWriter();

	        int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
	        int pageSize = Integer.parseInt(request.getParameter("pageSize"));

	        // 计算需要查询的起始位置
	        int start = (pageNumber - 1) * pageSize;

	        // 假设这里调用 Service 层查询分页数据
	        List<Users> pagedList = service.queryUserByPage(start, pageSize);

	        // 假设还需要返回总记录数，这里使用 PageHelper 封装数据
	        PageHelper pageHelper = new PageHelper();
	        pageHelper.setCurrentPage(pageNumber);
	        pageHelper.setRow(pageSize);
	        pageHelper.setTotal(service.getTotalUserCount()); // 获取总记录数
	        pageHelper.setTotalPage((int) Math.ceil(1.0 * pageHelper.getTotal() / pageSize));
	        pageHelper.setList(pagedList);

	        // 将分页信息转换为 JSON 格式
	        out.print(JSONUtil.toJSONString(pageHelper));

	        out.flush();
	        out.close();
	    
	}
	private void generateExcel(HttpServletResponse response) throws IOException {
        ExcelCreate excelCreate = new ExcelCreate();
        excelCreate.createSheet("用户信息");
        List<Users> list = service.queryAllUserInfo();
        for(Users user: list){
        	List<String> list0 = new ArrayList<String>();
        	list0.add(String.valueOf(user.getUserId()));
        	list0.add(user.getAccount());
        	list0.add(user.getPassword());
        	list0.add(user.getEmail());
        	excelCreate.addRow(list0);
		}
        // 生成文件
        String filePath = "/path/to/generatedExcel.xls";
        try {
            excelCreate.exportExcel(filePath);
            // 下载生成的 Excel 文件
            excelCreate.download(filePath, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error generating Excel file.");
        }
    }

    private void generateTxt(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 生成 TXT 文件的逻辑
    	try {
			String savePath = this.getServletContext().getRealPath("");
			ExcelCreate excelCreate = new ExcelCreate();
			FileUtils fileUtils = new FileUtils();
			//将要写入到txt的内容
			List<Users> list = service.queryAllUserInfo();
			String[] arrRentType = { "userId", "account","password", "email" };
			List<String[]> lstRentType = new ArrayList<String[]>();
			lstRentType.add(arrRentType);
			for(Users user: list){
				lstRentType.add(new String[] { String.valueOf(user.getUserId()), user.getAccount(),user.getPassword(),user.getEmail() });
			}
			String name = "txt";
			// 写TXT文件
			fileUtils.writeFile(lstRentType, "\\"+name,savePath);
			SmartUpload su = new SmartUpload();
			//上传初始化
			su.initialize(getServletConfig(),request,response);
			//下载
			try {
				String path = savePath+"\\"+name+".txt";
				System.out.println(path);
				su.downloadFile(path);
			} catch (SmartUploadException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("文件传输错误" + e);
		}
    }

    private void generateWord(HttpServletResponse response) throws IOException {
        try {
            String content = "userId\taccount\tpassword\temail\n" +
                             "1\tuser1\tpassword1\tuser1@example.com\n" +
                             "2\tuser2\tpassword2\tuser2@example.com\n";
            
            // 生成文件
            String filePath = "/path/to/generatedWord.doc";
            // 下载生成的 Word 文件
            excelCreate.download(filePath, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error generating Word file.");
        }
    }
	/**
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String search = request.getParameter("search");
		if(search == null){
			List<Users> list = service.queryAllUserInfo();
			try {
				out.print(JSONUtil.toJSONString(list));
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}else{
			List<Users> list = service.queryUserInfoByUsername(search);
			try {
				out.print(JSONUtil.toJSONString(list));
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		out.flush();
		out.close();
	}

}
