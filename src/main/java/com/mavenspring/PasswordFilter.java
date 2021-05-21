package com.mavenspring;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter("/Signup")
public class PasswordFilter implements Filter {

    
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpRequest=(HttpServletRequest) request;
		HttpServletResponse httpResponse=(HttpServletResponse) response;
		
		PrintWriter printWriter = response.getWriter();
		Logger log=Logger.getLogger(PasswordFilter.class.getName());
		DisplayAlert displayAlert=new DisplayAlert();
		
		try {
		String password=httpRequest.getParameter("password");
		
		//String regex = "^[a-zA-Z0-9+_.-][!@#$%^&*()][a-zA-Z0-9.-]+$";
		 
		if(password.length()>=8){		
			chain.doFilter(request, response);
		} 
		
		else {
			displayAlert.displayAlert("Password should be Minimum 8 Characters.",httpResponse);
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/signup.jsp");
			requestDispatcher.include(request, response);
		}
		}
		
		catch(Exception errorMessage){
			displayAlert.displayAlert("errorMessage.",httpResponse);
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/signup.jsp");
			requestDispatcher.include(request, response);
		}
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
