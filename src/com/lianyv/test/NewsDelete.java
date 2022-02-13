package com.lianyv.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qjm.jdbc.MysqlUtil;

/**
 * Servlet implementation class NewsDelete
 */
@WebServlet("/NewsDelete")
public class NewsDelete extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		boolean isAdmin = IdentityValidate.IdentityValidate(request,response);
		if(isAdmin) {
			String id = request.getParameter("id");
			
			MysqlUtil mu = new MysqlUtil("evol", "root", "root");
			String sql = "delete from newsList where id="+id;
			mu.executeSQL(sql);
			
			String sql2 = "delete from newsContent where newsListId="+id;
			mu.executeSQL(sql2);
			response.sendRedirect("NewsQuery");
		}
		
	}

}
