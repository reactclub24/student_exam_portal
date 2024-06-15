package com.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.student.entity.Student;

public class StudentDAO {

	private Connection conn;

	public StudentDAO(Connection conn) {
		super();
		this.conn = conn;

	}

	public boolean signUp_Student(Student student) {
		boolean f = false;

		try {
			String query = "insert into sign_up(fname,lname,age,mobile,Gender,email,password,Verifypassword) values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, student.getFname());
			ps.setString(2, student.getLname());
			ps.setString(3, student.getAge());
			ps.setString(4, student.getMobile());
			ps.setString(5, student.getGender());
			ps.setString(6, student.getEmail());
			ps.setString(7, student.getPassword());

			// ps.setString(8, VerifyPassword);

			int result = ps.executeUpdate();

			f = true; // if query execute successfully f becomes true otherwise false

		} catch (Exception e) {
			e.printStackTrace();

		}

		return f;
	}

	public Student login_student(String email, String Password) {

		Student student = null;

		try {
			String sql = "select *from sign_up where email=? Password=?";
			PreparedStatement ps = this.conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, Password);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				// if any row available, then fetch the data of that row...

				// create new user object
				student = new Student();

				// fetch data one by one from db table and set it/bind it to student's objects.
				// e.g fetch id and set to user object
				// student.setId(resultSet.getInt(1));or below line both are same
				// (1) means db table colm index number 1 which is id
				// getString() takes both column indexNumber or columnLabel name...

				student.setId(rs.getInt("id"));
				student.setFname(rs.getString("fname"));
				student.setLname(rs.getString("lname"));
				student.setAge(rs.getString("Age"));
				student.setMobile(rs.getString("mobile"));
				student.setEmail(rs.getString("Email"));
				student.setPassword(rs.getString("password"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return student;
	}

	// Checking old password

	public boolean checkOldPassword(int id, String oldPassword) {

		boolean f = false;

		try {

			String sql = "select * from sign_up where id=? and password=?";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, oldPassword);

			ResultSet resultSet = pstmt.executeQuery();
			// System.out.println(resultSet);
			while (resultSet.next()) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	// change password
	public boolean changePassword(int id, String newPassword) {

		boolean f = false;

		try {

			String sql = "update sign_up set password=? where id=?";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, newPassword);
			pstmt.setInt(2, id);

			pstmt.executeUpdate();

			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

}

