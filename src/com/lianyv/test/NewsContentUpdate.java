package com.lianyv.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qjm.jdbc.MysqlUtil;

/**
 * Servlet implementation class NewsContentUpdate
 */
@WebServlet("/NewsContentUpdate")
public class NewsContentUpdate extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		boolean isAdmin = IdentityValidate.IdentityValidate(request,response);
		if(isAdmin) {
			String newsId = request.getParameter("newsId");
			String newsDetailContent = request.getParameter("newsDetailContent");
			
			MysqlUtil mu = new MysqlUtil("evol", "root", "root");
			String sql = "update newsContent set newsContent='"+newsDetailContent+"' where newsListId=" + newsId;
			mu.executeSQL(sql);
			
			response.sendRedirect("IndexQuery");
		}
		
	}
}
