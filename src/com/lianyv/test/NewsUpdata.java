package com.lianyv.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qjm.jdbc.MysqlUtil;

/**
 * Servlet implementation class NewsUpdata
 */
@WebServlet("/NewsUpdata")
public class NewsUpdata extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		boolean isAdmin = IdentityValidate.IdentityValidateUser(request,response);
		if(isAdmin) {
			MysqlUtil mu = new MysqlUtil("evol", "root", "root");
			String id = request.getParameter("id");
			int newsId = Integer.parseInt(id);
			String newsType = request.getParameter("newsType");
			String newsTitle = request.getParameter("newsTitle");
			String newsDate = request.getParameter("newsDate");
			
			String sql = "update newsList set newsType='"+newsType+"' , newsTitle='"+newsTitle+"' , newsDate='"+newsDate+"'  where id=" + newsId;
			mu.executeSQL(sql);
			
			response.sendRedirect("NewsQuery");
		}
	}
}
