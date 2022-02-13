package com.lianyv.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServerlet
 */
@WebServlet("/RegisterServerlet")
public class RegisterServerlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		String userName=request.getParameter("inputName");
		String passWd=request.getParameter("inputPwd");
		UserInfo u=new UserInfo(userName,passWd);
		
		boolean IsSuccess = Register.Register(u);
		PrintWriter out = response.getWriter();
		if(IsSuccess) {
			out.append("<script>alert('×¢²áÊ§°Ü')</script>");
			response.sendRedirect("login.html");
		}
		else {
			out.append("<script>alert('×¢²áÊ§°Ü')</script>");
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
