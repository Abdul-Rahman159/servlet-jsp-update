package com.company.servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Util.DBUtil;
import com.company.dao.User;
import com.company.dao.UserDao;
import com.company.dao.UserDaoImpl;
 

@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDao usrDao= new UserDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        
	       
	        
	       
	        	   if (usrDao.isValidUser(username, password)) {
	        		   int i = 0;
	        		   ArrayList<String> userData = new ArrayList<String>();
	        		   ArrayList<String> userEmail = new ArrayList<String>();
	        		   HttpSession session = request.getSession();
	        		   System.out.print(username+"is really smart");
	    	           String query = "SELECT * FROM users";
	    		    	 try (Connection connection = DBUtil.getConnection()){
	    		    			 Statement stmt = connection.createStatement();
	    		    			 ResultSet rs = stmt.executeQuery(query);
	    		    			 while (rs.next()) 
	    		                 {  
	    		    				 
	    		    				 userData.add(rs.getString("username"));
	    		    				 
	    		    				 userEmail.add( rs.getString("email"));
	    		    				 
	    		    				i++;
	    		                      
	    		                 } 
	    		    			 System.out.print(userData.getClass());
	    		    			 
	    		    			
	    		                 
	    			        } catch (SQLException e) {
	    			            e.printStackTrace();
	    			        } 	   
	    		    	 session.setAttribute("data",userData);
	    		    	 session.setAttribute("email",userEmail);
	   	            session.setAttribute("username", username);
	   	            response.sendRedirect("Welcome.jsp");
	   	            
	   	        } else {
	   	            response.sendRedirect("login.jsp?error=1");
	   	        	System.out.println("Error A gya");
	   	        }
	        	
	        	
	        

	     
}

}
