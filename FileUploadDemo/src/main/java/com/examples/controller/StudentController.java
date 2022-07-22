package com.examples.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentController
 */
public class StudentController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int roll_no = Integer.parseInt(request.getParameter("studentId"));
		
		StudentDao dao = new StudentDao();
		Student student = dao.getStudentData(roll_no);
		request.setAttribute("student", student);
		RequestDispatcher rd = request.getRequestDispatcher("Display.jsp"); 
		rd.forward(request, response);
	}


}
