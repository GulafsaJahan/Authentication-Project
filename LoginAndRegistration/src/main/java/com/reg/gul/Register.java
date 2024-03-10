package com.reg.gul;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/regform")
public class Register extends HttpServlet
{
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		String myname = req.getParameter("name1");
		String myfname = req.getParameter("fname");
		String myemail = req.getParameter("email");
		String mypass = req.getParameter("password1");
		String mygender = req.getParameter("gender1");
		String address = req.getParameter("address");
		String city = req.getParameter("city");
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin", "root", "Gula@7860");
			PreparedStatement ps = con.prepareStatement("insert into register1 values(?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, myname);
			ps.setString(2, myfname);
			ps.setString(3, myemail);
			ps.setString(4, mypass);
			ps.setString(5, mygender);
			ps.setString(6, address);
			ps.setString(7, city);
			int count = ps.executeUpdate();
			if(count > 0)
			{
				out.println("<h3 style='color:green'> Registration Successfully !!</h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
				rd.forward(req, res);
			}
			else
			{
				out.println("<h3 style='color:red'> User doesn't register due to error!!</h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/registration.jsp");
				rd.include(req, res);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			out.println("<h3 style='color:red'> Exception occured : '"+e.getMessage()+"'</h3>");
			RequestDispatcher rd = req.getRequestDispatcher("/registration.jsp");
			rd.include(req, res);
		}
		
		
		
	}
}
