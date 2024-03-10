package com.reg.gul;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginform")
public class SignIn extends HttpServlet
{
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		res.setContentType("text/html"); 
		PrintWriter out = res.getWriter();
		String lemail = req.getParameter("lemail");
		String lpass = req.getParameter("lpass");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin", "root", "Gula@7860");
			PreparedStatement ps = con.prepareStatement("select * from register1 where email = ? and password=?");
			ps.setString(1, lemail);
			ps.setString(2, lpass);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				HttpSession session = req.getSession();
				session.setAttribute("session_name", rs.getString("name"));
				out.println("<h3 style='color:green'> Login Successfully !!</h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/welcome.jsp");
				rd.forward(req, res);
			}
			else
			{
				out.println("<h3 style='color:red'> User doesn't register due to error!!</h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
				rd.include(req, res);
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			out.println("<h3 style='color:red'> Exception Occured '"+e.getMessage()+"'</h3>");
			RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
			rd.include(req, res);
		}
		
	}
}
