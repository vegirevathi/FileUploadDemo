package com.examples.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {

	public Student getStudentData(int roll_no) {
		
		Student student = new Student();
		
		String url = "jdbc:mysql://localhost:3306/students";
		String username = "root";
		String password = "Revs@1996";
		String query = "select * from students_data where roll_no="+roll_no;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			if(rs.next()) {
				student.setRoll_no(rs.getInt("roll_no"));
				student.setName(rs.getString("name"));
				student.setAge(rs.getString("age"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}
}
