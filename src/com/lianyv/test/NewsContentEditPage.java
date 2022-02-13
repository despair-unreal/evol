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
 * Servlet implementation class NewsContentEditPage
 */
@WebServlet("/NewsContentEditPage")
public class NewsContentEditPage extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		boolean isAdmin = IdentityValidate.IdentityValidate(request,response);
		if(isAdmin) {
			String newsListId = request.getParameter("newsListId");
			
			MysqlUtil mu = new MysqlUtil("evol", "root", "root");
			String sql = "select a.newsContent,b.newsTitle from newsContent a join newsList b on a.newsListId = b.id where a.newsListId =" + newsListId;
			List<String[]> list = mu.querySQL(sql);
			
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"	<head>\r\n" + 
					"		<meta charset=\"utf-8\">\r\n" + 
					"		<title>编辑新闻内容</title>\r\n" + 
					"		<link rel=\"stylesheet\" type=\"text/css\" href=\"./css/webCss/edit.css\" />\r\n" + 
					"		<link rel=\"stylesheet\" type=\"text/css\" href=\"css/font-awesome.min.css\">\r\n" + 
					"		<link href=\"css/froala_editor.min.css\" rel=\"stylesheet\" type=\"text/css\">\r\n" + 
					"	</head>\r\n" + 
					"	<body>\r\n" + 
					"		<script type=\"text/javascript\" src=\"./js/edit.js\"></script>\r\n" + 
					"		<div id=\"cont\">\r\n" + 
					"			<h1>"+list.get(0)[1]+"</h1>\r\n" + 
					"			<section id=\"editor\">\r\n" + 
					"				<div id='edit' style=\"margin-top: 30px;\">");
			out.println(list.get(0)[0]);
			out.println("</div>\r\n" + 
					"			</section>\r\n" + 
					"			<form method=\"post\" id=\"updateForm\" action=\"NewsContentUpdate\">\r\n" + 
					"				<input type=\"hidden\" name=\"newsId\" value=\""+newsListId+"\" />\r\n" + 
					"				<input type=\"hidden\" id=\"newsDetailContent\" name=\"newsDetailContent\" value=\"\" />\r\n" + 
					"				<button type=\"button\">提交修改</button>\r\n" + 
					"			</form>\r\n" + 
					"\r\n" + 
					"			<script src=\"js/jquery-1.10.2.min.js\"></script>\r\n" + 
					"			<script src=\"js/froala_editor.min.js\"></script>\r\n" + 
					"			<!--[if lt IE 9]>\r\n" + 
					"				    <script src=\"../js/froala_editor_ie8.min.js\"></script>\r\n" + 
					"				  <![endif]-->\r\n" + 
					"			<script src=\"js/plugins/tables.min.js\"></script>\r\n" + 
					"			<script src=\"js/plugins/lists.min.js\"></script>\r\n" + 
					"			<script src=\"js/plugins/colors.min.js\"></script>\r\n" + 
					"			<script src=\"js/plugins/media_manager.min.js\"></script>\r\n" + 
					"			<script src=\"js/plugins/font_family.min.js\"></script>\r\n" + 
					"			<script src=\"js/plugins/font_size.min.js\"></script>\r\n" + 
					"			<script src=\"js/plugins/block_styles.min.js\"></script>\r\n" + 
					"			<script src=\"js/plugins/video.min.js\"></script>\r\n" + 
					"\r\n" + 
					"			<script>\r\n" + 
					"				$(function() {\r\n" + 
					"					$('#edit').editable({\r\n" + 
					"						inlineMode: false,\r\n" + 
					"						alwaysBlank: true\r\n" + 
					"					})\r\n" + 
					"					$(\"#updateForm button\").click(function(){\r\n" + 
					"						if(confirm(\"确认修改？\")){\r\n" + 
					"							$(\"#edit>div:eq(1)\").prop(\"contenteditable\",\"false\");\r\n" + 
					"							var newsDetailContent = $(\"#edit>div:eq(1)\").html();\r\n" + 
					"							$(\"#newsDetailContent\").val(newsDetailContent);\r\n" + 
					"							$(\"#updateForm\").submit();\r\n" + 
					"						}\r\n" + 
					"					});\r\n" + 
					"					window.onscroll = function() {scrollFunction()};\r\n" + 
					"					function scrollFunction() {\r\n" + 
					"					    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {\r\n" + 
					"					        document.getElementById(\"myBtn\").style.opacity = \"1\";\r\n" + 
					"					    } else {\r\n" + 
					"					        document.getElementById(\"myBtn\").style.opacity = \"0\";\r\n" + 
					"					    }\r\n" + 
					"					}\r\n" + 
					"				});\r\n" + 
					"			</script>\r\n" + 
					"		</div>\r\n" + 
					"	</body>\r\n" + 
					"	<style>\r\n" + 
					"		body {\r\n" + 
					"			text-align: center;\r\n" + 
					"			font-family: 'Microsoft Yahei';\r\n" + 
					"		}\r\n" + 
					"		#edit{\r\n" + 
					"			background: rgba(29, 69, 123, .4);\r\n" + 
					"			border: 1px solid #fff;\r\n" + 
					"			box-shadow: 0 0 8px 0 #8a90ff, inset 0 0 8px 0 #8a90ff;\r\n" + 
					"		}\r\n" + 
					"		section {\r\n" + 
					"			color: #fff;\r\n" + 
					"			font-size: 15.8125px;\r\n" + 
					"			line-height: 2;\r\n" + 
					"			margin-bottom: 94.875px;\r\n" + 
					"			width: 80%;\r\n" + 
					"			margin: auto;\r\n" + 
					"			text-align: left;\r\n" + 
					"		}\r\n" + 
					"		form button{\r\n" + 
					"			position:fixed;" +
					"			bottom:5px;" +
					"			right:5px;" +
					"			margin-top: 30px;\r\n" + 
					"			height: 40.6px;\r\n" + 
					"			width: 140.88px;\r\n" + 
					"			background-color:transparent;\r\n" + 
					"			border: 1px solid #809edf;\r\n" + 
					"			color: #fff;\r\n" + 
					"			cursor: pointer;\r\n" + 
					"			border-radius: 5px;\r\n" + 
					"		}\r\n" + 
					"		form button:hover {\r\n" + 
					"			background-color: #809edf;\r\n" + 
					"		}\r\n" + 
					"		#cont>h1{\r\n" + 
					"			color: #fff;\r\n" + 
					"			font-weight: 400;\r\n" + 
					"			font-size: 45px;\r\n" + 
					"			margin-top: 20px;\r\n" + 
					"		}" +
					"	</style>\r\n" + 
					"</html>\r\n" + 
					"");
		}
		
	}

}
