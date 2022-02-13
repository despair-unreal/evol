package com.lianyv.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qjm.jdbc.MysqlUtil;

/**
 * Servlet implementation class NewsQuery
 */
@WebServlet("/NewsQuery")
public class NewsQuery extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		boolean isAdmin = IdentityValidate.IdentityValidateUser(request,response);
		if(isAdmin) {
			MysqlUtil mu = new MysqlUtil("evol", "root", "root");
			String sql = "select * from newsList order by newsDate desc";
			List<String[]> newsList = mu.querySQL(sql);
			PrintWriter out = response.getWriter();
			
			out.print("<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"	<head>\r\n" + 
					"		<meta charset=\"utf-8\">\r\n" + 
					"		<title></title>\r\n" + 
					"		<link rel=\"stylesheet\" type=\"text/css\" href=\"./css/webCss/edit.css\" />\r\n" + 
					"	</head>\r\n" + 
					"	<body>\r\n" + 
					"		<script type=\"text/javascript\" src=\"./js/edit.js\"></script>\r\n" + 
					"		<div id=\"cont\">\r\n" + 
					"			<img id=\"newsImg\" src=\"img/news_title.png\" />\r\n" + 
					"				<table id=\"newsTable\" cellpadding=\"0\" cellspacing=\"0\">\r\n" + 
					"					<tr>\r\n" + 
					"						<td colspan=\"2\" style=\"font-size: 45px;padding-left: 20px;font-weight: 300;text-shadow: 0 0 15px #95A3D6;\">What's New</td>\r\n" + 
					"						<td colspan=\"2\" align=\"center\" valign=\"center\" style=\"font-weight: 300;cursor: pointer;\">\r\n" + 
					"							<a id=\"add\" href=\"NewsInert\" onclick=\"tableAT()\">添加一行</a>\r\n" + 
					"						</td>\r\n" + 
					"					</tr>");
			for(int i=0;i<newsList.size();i++) {
				out.print("<tr>\r\n" + 
						"						<td><span>"+newsList.get(i)[1]+"</span></td>\r\n" + 
						"						<td>"+newsList.get(i)[2]+"</td>\r\n" + 
						"						<td>"+newsList.get(i)[3]+"</td>\r\n" + 
						"						<td><img src=\"img/edit.png\" class=\"edit\"><img onclick=\"editOkOnclick("+newsList.get(i)[0]+",this)\" class=\"editOk\" src=\"img/ok.png\">&nbsp;&nbsp;<img onclick=\"deleteTips("+newsList.get(i)[0]+")\" class=\"delete1\" id=\"delete4\" src=\"img/delete.png\"></td>\r\n" + 
						"					</tr>");
			}
			out.print("</table>\r\n" + 
					"		</div>\r\n" + 
					"	</body>\r\n" + 
					"</html>");
		}
	}
}
