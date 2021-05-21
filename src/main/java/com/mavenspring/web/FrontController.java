package com.mavenspring.web;


import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mavenspring.SigninServlet;
import com.mavenspring.SignoutServlet;
import com.mavenspring.SignupServlet;

@Controller
public class FrontController {
	//Logger log=Logger.getLogger(FrontController.class.getName());
	
	@RequestMapping(value="/signin",method=RequestMethod.POST)
	public void signin(HttpServletRequest request,  HttpServletResponse response) throws IOException, ServletException {
		SigninServlet signinServlet=new SigninServlet();
		signinServlet.doPost(request,response);
		
	}
	
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public void signup(HttpServletRequest request,  HttpServletResponse response) throws IOException, ServletException {
		SignupServlet signupServlet=new SignupServlet();
		signupServlet.doPost(request,response);
		
	}
	
	@RequestMapping(value="/signout")
	public void signout(HttpServletRequest request,  HttpServletResponse response) throws IOException, ServletException {
		SignoutServlet signoutServlet=new SignoutServlet();
		signoutServlet.service(request,response);
		
	}
	
}
