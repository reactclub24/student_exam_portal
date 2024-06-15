package com.examportal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;


@WebServlet(urlPatterns = "/SignUp")

public class Signup extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		Connection conn;
		PreparedStatement ps;
		PrintWriter out = res.getWriter();
		
		
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String age = req.getParameter("age");
		String mobile = req.getParameter("mobile");
		String Gender = req.getParameter("Gender");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String VerifyPassword = req.getParameter("Verifypassword");
	

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam_portal", "root", "Naresh@2002");
			String query = "insert into sign_up(fname,lname,age,mobile,Gender,email,password,Verifypassword) values(?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, age);
			ps.setString(4, mobile);
			ps.setString(5, Gender);
			ps.setString(6, email);
			ps.setString(7, password);
			ps.setString(8, VerifyPassword);
			int result = ps.executeUpdate();
			
			conn.close();
			
		
			
			
		/*	out.println("FirstName is"+ fname);
			out.println();
			out.println();
			out.println();
			out.println();
			out.println(); */
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	}


}
