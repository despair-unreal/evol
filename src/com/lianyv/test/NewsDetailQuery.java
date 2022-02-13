package com.lianyv.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qjm.jdbc.MysqlUtil;

/**
 * Servlet implementation class NewsDetailQuery
 */
@WebServlet("/NewsDetailQuery")
public class NewsDetailQuery extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		String newsListId = request.getParameter("newsListId");
		
		MysqlUtil mu = new MysqlUtil("evol", "root", "root");
		String sql = "select * from newsContent a join newsList b on a.newsListId = b.id where a.newsListId =" + newsListId;
		List<String[]> newsList = mu.querySQL(sql);
		
		HttpSession session=request.getSession();
		Object obj = session.getAttribute("identity");
		int identity = 404;
		if(obj != null)
			identity = (Integer)session.getAttribute("identity");
		
		PrintWriter out = response.getWriter();
		String[] array1=newsList.get(0)[6].split("/");
		out.println("<div id=\"news_title\">\r\n" + 
				"							"+newsList.get(0)[5]+"\r\n" + 
				"						</div>\r\n" + 
				"						<div id=\"news_date\">\r\n" + 
				"							"+array1[0]+"Äê"+array1[1]+"ÔÂ"+array1[2]+"ÈÕ"+"&nbsp;&nbsp;\r\n" + "");
		if(identity == 0) {
			out.println("					<a class=\"newsContentEdit\" target=\"_blank\" href=\"NewsContentEditPage?newsListId="+newsListId+"\">[±à¼­]</a>\r\n" + "");
		}			
	out.println("						</div><input type=\"hidden\" name=\"newsListId\" value=\""+newsListId+"\" />\r\n" + 
				"						<div id=\"news_content\">\r\n" + 
				"							<div contenteditable=\"false\" class=\"froala-element not-msie f-basic\" style=\"outline: 0px;\" spellcheck=\"false\"\r\n" + 
				"							 data-placeholder=\"Type something\">" +
				"								"+newsList.get(0)[1]+"\r\n" + 
				"							</div>" +
				"						</div>");
	}


}
