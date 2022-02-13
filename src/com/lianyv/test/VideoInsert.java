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
 * Servlet implementation class videoInsert
 */
@WebServlet("/videoInsert")
public class VideoInsert extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		boolean isAdmin = IdentityValidate.IdentityValidate(request,response);
		if(isAdmin) {
			String videoTitle = request.getParameter("videoTitle");
			String videoPath = request.getParameter("videoPath");
			String coverImgPath = request.getParameter("coverImgPath");
			String videoDate = request.getParameter("videoDate");
			
			MysqlUtil mu = new MysqlUtil("evol", "root", "root");
			String sql = "insert into showVideo value(0,'"+coverImgPath+"','"+videoPath+"','"+videoTitle+"','"+videoDate+"')";
			mu.executeSQL(sql);
			
			PrintWriter out = response.getWriter();
			out.print("<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"	<head>\r\n" + 
					"		<meta charset=\"utf-8\">\r\n" + 
					"		<title></title>\r\n" + 
					"	</head>\r\n" + 
					"	<body>\r\n" + 
					"		<script type=\"text/javascript\">\r\n" + 
					"			alert(\"Ìí¼Ó³É¹¦£¡\");\r\n" + 
					"			window.location.href=\"IndexQuery\"\r\n" + 
					"		</script>\r\n" + 
					"	</body>\r\n" + 
					"</html>\r\n" + 
					"");
		}
		
	}

}
