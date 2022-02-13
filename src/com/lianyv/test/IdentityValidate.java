package com.lianyv.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class IdentityValidate {
	public static boolean IdentityValidate(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		PrintWriter out = response.getWriter();
		Object obj = session.getAttribute("identity");
		int identity = 404;
		boolean isAdmin =false;
		if(obj != null) {
			identity = (Integer)session.getAttribute("identity");
			if(identity != 0) {
				out.print("<!DOCTYPE html>\r\n" + 
						"<html>\r\n" + 
						"	<head>\r\n" + 
						"		<meta charset=\"utf-8\">\r\n" + 
						"		<title></title>\r\n" + 
						"	</head>\r\n" + 
						"	<body>\r\n" + 
						"		<script type=\"text/javascript\">\r\n" + 
						"			alert(\"ÔÝÎÞÈ¨ÏÞ£¡\");\r\n" + 
						"			window.location.href=\"IndexQuery\"\r\n" + 
						"		</script>\r\n" + 
						"	</body>\r\n" + 
						"</html>\r\n" + 
						"");
			}else
				isAdmin = true;
		}else {
			out.print("<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"	<head>\r\n" + 
					"		<meta charset=\"utf-8\">\r\n" + 
					"		<title></title>\r\n" + 
					"	</head>\r\n" + 
					"	<body>\r\n" + 
					"		<script type=\"text/javascript\">\r\n" + 
					"			alert(\"ÇëµÇÂ¼£¡\");\r\n" + 
					"			window.location.href=\"login.html\"\r\n" + 
					"		</script>\r\n" + 
					"	</body>\r\n" + 
					"</html>\r\n" + 
					"");
		}
		return isAdmin;
	}
}
