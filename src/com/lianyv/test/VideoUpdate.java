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
 * Servlet implementation class VideoUpdate
 */
@WebServlet("/VideoUpdate")
public class VideoUpdate extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		boolean isAdmin = IdentityValidate.IdentityValidate(request,response);
		if(isAdmin) {
			String id = request.getParameter("id");
			String videoTitle = request.getParameter("videoTitle");
			String videoPath = request.getParameter("videoPath");
			String coverImgPath = request.getParameter("coverImgPath");
			String videoDate = request.getParameter("videoDate");
			
			MysqlUtil mu = new MysqlUtil("evol", "root", "root");
			String sql = "update showVideo set coverImgPath='"+coverImgPath+"',videoPath='"+videoPath+"',videoTitle='"+videoTitle+"',videoDate='"+videoDate+"'  where id = " + id;
			mu.executeSQL(sql);
			response.sendRedirect("IndexQuery");
		}
		
	}

}
