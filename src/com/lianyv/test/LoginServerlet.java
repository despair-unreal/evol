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
 * Servlet implementation class LoginServerlet
 */
@WebServlet("/LoginServerlet")
public class LoginServerlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");

		String name = request.getParameter("inputName");
		String pwd = request.getParameter("inputPwd");
		UserInfo u = new UserInfo(name, pwd);
		boolean IsSuccess = LoginValidate.validate(u);

		PrintWriter out = response.getWriter();

		if (IsSuccess) {
			MysqlUtil mu = new MysqlUtil("evol", "root", "root");
			String sql = "select identity from userInfo where username='" + name +"'";
			List<String[]> list = mu.querySQL(sql);

			HttpSession session = request.getSession();
			session.setAttribute("name", name);
			if(list.get(0)[0].equals("admin"))
				session.setAttribute("identity", 0);
			else
				session.setAttribute("identity", 1);
			out.print("<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"	<head>\r\n" + 
					"		<meta charset=\"utf-8\">\r\n" + 
					"		<title></title>\r\n" + 
					"	</head>\r\n" + 
					"	<body>\r\n" + 
					"		<script type=\"text/javascript\">\r\n" + 
					"			alert(\"登陆成功，用户："+name+"\");\r\n" + 
					"			window.location.href=\"IndexQuery\"\r\n" + 
					"		</script>\r\n" + 
					"	</body>\r\n" + 
					"</html>\r\n" + 
					"");
		}

		else {
			out.print("<html>");
			out.print("<body>");
			out.print("<a href='login.html'>账号或密码错误，点击重新登陆</a>");
			out.print("</body>");
			out.print("</html>");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
