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
 * Servlet implementation class CardUpdatePage
 */
@WebServlet("/CardUpdatePage")
public class CardUpdatePage extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		boolean isAdmin = IdentityValidate.IdentityValidate(request,response);
		if(isAdmin) {
			String id = request.getParameter("id");
			MysqlUtil mu = new MysqlUtil("evol", "root", "root");
			String sql = "select * from showCard where id = " + id;
			List<String[]> showCard = mu.querySQL(sql);
			
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"	<head>\r\n" + 
					"		<meta charset=\"utf-8\">\r\n" + 
					"		<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + 
					"		<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
					"		<title>����ͼ</title>\r\n" + 
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
					"				<form style=\"width: 95%;\" action=\"CardUpdate\">\r\n" + 
					"					<input type=\"hidden\" name=\"id\" value=\""+id+"\" />" + 
					"					<table class=\"table\" cellspacing=\"\" cellpadding=\"\">\r\n" + 
					"						<tr>\r\n" + 
					"							<td>�ͼ����</td>\r\n" + 
					"							<td>����</td>\r\n" + 
					"							<td>�ͼ����</td>\r\n" + 
					"							<td>�ͼ·��</td>\r\n" + 
					"							<td>����ͼ·��</td>\r\n" + 
					"						</tr>\r\n" + 
					"						<tr>\r\n" + 
					"							<td>\r\n" + 
					"								<input class=\"form-control\" type=\"text\" name=\"cardTitle\"\r\n" + 
					"									value=\""+showCard.get(0)[3]+"\" placeholder=\"�������ͼ����\" />\r\n" + 
					"							</td>\r\n" + 
					"							<td width=\"15%\">\r\n" + 
					"								<input class=\"form-control\" type=\"text\" name=\"cardDate\"\r\n" + 
					"									value=\""+showCard.get(0)[5]+"\" placeholder=\"����������\" />\r\n" + 
					"							</td>" +
					"							<td>\r\n" + 
					"								<select class=\"form-control\" name=\"cardType\">\r\n" + 
					"");
		if(showCard.get(0)[4].equals("�ֻ���ֽ")) {
			out.println("<option selected=\"selected\" value=\"�ֻ���ֽ\">�ֻ���ֽ</option>\r\n" + 
					"									<option value=\"���Ա�ֽ\">���Ա�ֽ</option>");
		}else {
			out.println("<option value=\"�ֻ���ֽ\">�ֻ���ֽ</option>\r\n" + 
					"									<option selected=\"selected\" value=\"���Ա�ֽ\">���Ա�ֽ</option>");
		}
		out.println("								</select>\r\n" + 
					"							</td>\r\n" + 
					"							<td>\r\n" + 
					"								<input style=\"width: 80%;display: inline-block;\" class=\"form-control\" type=\"text\"\r\n" + 
					"									value=\""+showCard.get(0)[2]+"\" name=\"cardPath\" placeholder=\"�������ͼ·����img/showCard/xx.*��\" />\r\n" + 
					"								<button class=\"cardShow form-control\" style=\"width: 15%;display: inline-block;\"\r\n" + 
					"									type=\"button\">Ԥ��</button>\r\n" + 
					"							</td>\r\n" + 
					"							<td>\r\n" + 
					"								<input style=\"width: 80%;display: inline-block;\" class=\"form-control\" type=\"text\"\r\n" + 
					"									value=\""+showCard.get(0)[1]+"\" name=\"coverImgPath\" placeholder=\"���������ͼ·����img/showVideo/xx.*��\" />\r\n" + 
					"								<button class=\"cardShow form-control\" style=\"width: 15%;display: inline-block;\"\r\n" + 
					"									type=\"button\">Ԥ��</button>\r\n" + 
					"							</td>\r\n" + 
					"						</tr>\r\n" + 
					"						<tr style=\"width: 100%;display: none;\" id=\"tdShow\">\r\n" + 
					"							<td valign=\"middle\" colspan=\"5\">\r\n" + 
					"								<table class=\"table\" width=\"100%\">\r\n" + 
					"									<tr>\r\n" + 
					"										<td>�ͼ</td>\r\n" + 
					"										<td>����ͼ</td>\r\n" + 
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
					"								<button style=\"width: 10%;\" class=\"form-control\" type=\"submit\">�޸�</button>\r\n" + 
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
