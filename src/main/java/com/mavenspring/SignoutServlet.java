package com.mavenspring;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SignoutServlet extends HttpServlet implements Instantiation{

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		
		try {
			
			if(session.getAttribute("email") == null) {
				dispatcher.requestDispatcherSignin(request, response);
			}
			else {
			session.removeAttribute("name");
			session.removeAttribute("age");
			session.removeAttribute("gender");
			session.removeAttribute("email");
			session.removeAttribute("password");
			session.invalidate();
			
			displayAlert.displayAlert("Signout Successfully.","Success",response);
			dispatcher.requestDispatcherSignin(request, response);
			}
		}
		catch(Exception errorMessage){
			displayAlert.displayAlert(errorMessage,response);
			dispatcher.requestDispatcherSignin(request, response);
		}
	}
}
