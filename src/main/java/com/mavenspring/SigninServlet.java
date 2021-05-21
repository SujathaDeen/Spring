package com.mavenspring;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SigninServlet extends HttpServlet implements Instantiation {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		response.setContentType("text/html");
		HttpSession session=request.getSession();
		
		try 
		{
		Statement statement=dbConnection.connection();
		
		String email = request.getParameter("email");
		String password=request.getParameter("password");
		
		boolean checkString=stringMethods.isNullOrEmpty(email)||stringMethods.isNullOrEmpty(password);
		
		if(checkString) {
			displayAlert.displayAlert("Please Enter the Credentials.",response);
			dispatcher.requestDispatcherSignin(request, response);
		}
		
		else {
			String query="Select * from profile where Email=\"" +email+ "\" and Password=\"" +password+ "\" ";
			ResultSet resultSet=statement.executeQuery(query);
			
			if(resultSet!=null) {
				if(resultSet.next()){
						session.setAttribute("name", resultSet.getString("Name"));
						session.setAttribute("age",resultSet.getString("Age"));
						session.setAttribute("gender", resultSet.getString("Gender"));
						session.setAttribute("email", resultSet.getString("Email"));
						session.setAttribute("password", resultSet.getString("Password"));
						
						response.sendRedirect("home.jsp");
						
					}
				else {
				displayAlert.displayAlert("Invalid Credentials.",response);
				dispatcher.requestDispatcherSignin(request, response);
				}
			}
			else {
					displayAlert.displayAlert("Data Not Available.",response);
					dispatcher.requestDispatcherSignin(request, response);
				}
		}
		}
		catch(Exception errorMessage) 
		{
			displayAlert.displayAlert(errorMessage,response);
			dispatcher.requestDispatcherSignin(request, response);
		}
		
	}
	
}







