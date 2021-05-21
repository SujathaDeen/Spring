package com.mavenspring;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NextDispatcher {

	public void requestDispatcherSignin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("/signin.jsp");
		requestDispatcher.include(request, response);
	}
	
	public void requestDispatcherSignup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("/signup.jsp");
		requestDispatcher.include(request, response);
	}
}
