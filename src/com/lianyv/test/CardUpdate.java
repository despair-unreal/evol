package com.lianyv.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qjm.jdbc.MysqlUtil;

/**
 * Servlet implementation class CardUpdate
 */
@WebServlet("/CardUpdate")
public class CardUpdate extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		boolean isAdmin = IdentityValidate.IdentityValidateUser(request,response);
		if(isAdmin) {
			String id = request.getParameter("id");
			String cardTitle = request.getParameter("cardTitle");
			String cardType = request.getParameter("cardType");
			String cardPath = request.getParameter("cardPath");
			String coverImgPath = request.getParameter("coverImgPath");
			String cardDate = request.getParameter("cardDate");
			
			MysqlUtil mu = new MysqlUtil("evol", "root", "root");
			String sql = "update showCard set coverImgPath='"+coverImgPath+"',cardPath='"+cardPath+"',cardTitle='"+cardTitle+"',cardType='"+cardType+"',cardDate='"+cardDate+"'  where id = " + id;
			mu.executeSQL(sql);
			response.sendRedirect("IndexQuery");
		}
	}

}
