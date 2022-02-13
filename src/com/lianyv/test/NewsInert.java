package com.lianyv.test;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qjm.jdbc.MysqlUtil;

/**
 * Servlet implementation class NewsInert
 */
@WebServlet("/NewsInert")
public class NewsInert extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		boolean isAdmin = IdentityValidate.IdentityValidateUser(request,response);
		if(isAdmin) {
			MysqlUtil mu = new MysqlUtil("evol", "root", "root");
			String sql = "insert into newsList value(0,' ',' ',' ')";
			mu.executeSQL(sql);
			
			String sql2 = "select id from newsList order by id desc";
			List<String[]> list = mu.querySQL(sql2);
			String newsListId = list.get(0)[0];
			
			String sql3 = "insert into newsContent value(0,' ',"+newsListId+")";
			mu.executeSQL(sql3);
			
			response.sendRedirect("NewsQuery");
		}
	}

}
