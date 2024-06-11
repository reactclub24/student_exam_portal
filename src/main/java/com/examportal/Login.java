package com.examportal;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/Login")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String Password = req.getParameter("Password");
		
		Connection conn;
		PreparedStatement ps ;
		

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam_portal", "root", "Naresh@2002");
			String query = "select *from sign_up where email=? and Password=?";
			
			ps = conn.prepareStatement(query);
			
			ps.setString(1, email);
			ps.setString(2, Password);
			
			ResultSet res1 = ps.executeQuery();
			
			if(res1.next()) {
				resp.sendRedirect("/Exam_portal2/home.html");
				System.out.println(" Login successfull welcome to Learning portal");
				
			}else {
				resp.sendRedirect("/Exam_portal2/SignUp.html");
				System.out.println("failed to login");
			}
			
			conn.close();
		}catch(Exception e) {
			
		}
	}

}
