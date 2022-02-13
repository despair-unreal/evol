package com.lianyv.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qjm.jdbc.MysqlUtil;

/**
 * Servlet implementation class AddCard
 */
@WebServlet("/AddCard")
public class AddCard extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		boolean isAdmin = IdentityValidate.IdentityValidate(request,response);
		
		if(isAdmin) {
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"	<head>\r\n" + 
					"		<meta charset=\"utf-8\">\r\n" + 
					"		<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + 
					"		<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
					"		<title>添加羁绊图</title>\r\n" + 
					"		<link rel=\"stylesheet\" type=\"text/css\" href=\"./css/webCss/edit.css\" />\r\n" + 
					"		<link rel=\"stylesheet\" type=\"text/css\" href=\"./css/webCss/addVideo.css\" />\r\n" + 
					"		<link rel=\"stylesheet\" href=\"./css/bootstrap.min.css\">\r\n" + 
					"		<script type=\"text/javascript\" src=\"./js/jquery-3.3.1.js\"></script>\r\n" + 
					"		<script src=\"./js/bootstrap.min.js\"></script>\r\n" + 
					"		<script type=\"text/javascript\" src=\"js/showVideo.js\"></script>\r\n" + 
					"	</head>\r\n" + 
					"	<body>\r\n" + 
					"		<div id=\"cont\">\r\n" + 
					"			<div class=\"container\">\r\n" + 
					"				<form style=\"width: 95%;\" action=\"cardInsert\">\r\n" + 
					"					<table class=\"table\" cellspacing=\"\" cellpadding=\"\">\r\n" + 
					"						<tr>\r\n" + 
					"							<td>羁绊图标题</td>\r\n" + 
					"							<td>日期</td>\r\n" + 
					"							<td>羁绊图类型</td>\r\n" + 
					"							<td>羁绊图路径</td>\r\n" + 
					"							<td>封面图路径</td>\r\n" + 
					"						</tr>\r\n" + 
					"						<tr>\r\n" + 
					"							<td>\r\n" + 
					"								<input class=\"form-control\" type=\"text\" name=\"cardTitle\"\r\n" + 
					"									placeholder=\"请输入羁绊图标题\" />\r\n" + 
					"							</td>\r\n" + 
					"							<td width=\"15%\">\r\n" + 
					"								<input class=\"form-control\" type=\"text\" name=\"cardDate\"\r\n" + 
					"									placeholder=\"请输入日期\" />\r\n" + 
					"							</td>\r\n" + 
					"							<td>\r\n" + 
					"								<select class=\"form-control\" name=\"cardType\">\r\n" + 
					"									<option value=\"手机壁纸\">手机壁纸</option>\r\n" + 
					"									<option value=\"电脑壁纸\">电脑壁纸</option>\r\n" + 
					"								</select>\r\n" + 
					"							</td>\r\n" + 
					"							<td>\r\n" + 
					"								<input style=\"width: 80%;display: inline-block;\" class=\"form-control\" type=\"text\"\r\n" + 
					"									name=\"cardPath\" placeholder=\"请输入羁绊图路径（img/showCard/xx.*）\" />\r\n" + 
					"								<button class=\"cardShow form-control\" style=\"width: 15%;display: inline-block;\"\r\n" + 
					"									type=\"button\">预览</button>\r\n" + 
					"							</td>\r\n" + 
					"							<td>\r\n" + 
					"								<input style=\"width: 80%;display: inline-block;\" class=\"form-control\" type=\"text\"\r\n" + 
					"									name=\"coverImgPath\" placeholder=\"���������ͼ·����img/showVideo/xx.*��\" />\r\n" + 
					"								<button class=\"cardShow form-control\" style=\"width: 15%;display: inline-block;\"\r\n" + 
					"									type=\"button\">预览</button>\r\n" + 
					"							</td>\r\n" + 
					"						</tr>\r\n" + 
					"						<tr style=\"width: 100%;display: none;\" id=\"tdShow\">\r\n" + 
					"							<td valign=\"middle\" colspan=\"5\">\r\n" + 
					"								<table class=\"table\" width=\"100%\">\r\n" + 
					"									<tr>\r\n" + 
					"										<td>羁绊图</td>\r\n" + 
					"										<td>封面图</td>\r\n" + 
					"									</tr>\r\n" + 
					"									<tr>\r\n" + 
					"										<td width=\"50%\">\r\n" + 
					"											<img class=\"imgshow\" src=\"img/loadingPhoto.gif\" >\r\n" + 
					"											<img src=\"img/loadingPhoto.gif\" >\r\n" + 
					"										</td>\r\n" + 
					"										<td width=\"50%\">\r\n" + 
					"											<img class=\"imgshow\" src=\"img/loadingPhoto.gif\" >\r\n" + 
					"											<img src=\"img/loadingPhoto.gif\" >\r\n" + 
					"										</td>\r\n" + 
					"									</tr>\r\n" + 
					"								</table>\r\n" + 
					"							</td>\r\n" + 
					"						</tr>\r\n" + 
					"						<tr>\r\n" + 
					"							<td align=\"center\" colspan=\"5\">\r\n" + 
					"								<button style=\"width: 10%;\" class=\"form-control\" type=\"submit\">增加</button>\r\n" + 
					"							</td>\r\n" + 
					"						</tr>\r\n" + 
					"					</table>\r\n" + 
					"				</form>\r\n" + 
					"			</div>\r\n" + 
					"		</div>\r\n" + 
					"	</body>\r\n" + 
					"</html>\r\n" + 
					"");
		}
	}

}
