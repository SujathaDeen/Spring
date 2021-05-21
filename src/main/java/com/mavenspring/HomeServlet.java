package com.mavenspring;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HomeServlet extends HttpServlet implements Instantiation{

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		Logger log=Logger.getLogger(HomeServlet.class.getName());
		
		try {
	
	}		
		catch(Exception errorMessage){
			displayAlert.displayAlert(errorMessage,response);
			dispatcher.requestDispatcherSignin(request, response);
	}
}
}
