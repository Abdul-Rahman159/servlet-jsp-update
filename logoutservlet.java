package com.company.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logoutservlet")
public class logoutservlet extends HttpServlet {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logoutservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	   response.setContentType("text/html");        
           HttpSession session = request.getSession(false);
                        
           session.invalidate();    
           
           response.sendRedirect("index.html");
          } 
	      
}

