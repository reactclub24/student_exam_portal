package com.student.entity;

public class Student {

	private int id;
	private String fname;
	private String lname;
	private String age;
	private String mobile;
	private String Gender;
	private String email;
	private String password;
	// private String VerifyPasword;

	public Student(int id, String fname, String lname, String age, String mobile, String Gender, String email,
			String password, String verifyPasword) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.mobile = mobile;
		this.Gender = Gender;
		this.email = email;
		this.password = password;
		// VerifyPasword = verifyPasword;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String fname, String lname, String age, String mobile, String Gender, String email, String password,
			String verifyPasword) {

		super();
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.mobile = mobile;
		this.Gender = Gender;
		this.email = email;
		this.password = password;
		// VerifyPasword = verifyPasword;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		this.Gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", fname=" + fname + ", lname=" + lname + ", age=" + age + ", mobile=" + mobile
				+ ", Gender=" + Gender + ", email=" + email + ", password=" + password + "]";
	}

}
