package Roboservlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SkilServlet
 */
@WebServlet("/SkilServlet")
public class SkilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SkilServlet() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
	     Statement stmt = null;
	     PreparedStatement pstmt = null;
	     ResultSet rs = null;
	     String skill, ratings, name, email, userID = null;
	     
	     String skillAll = "";
	     HttpSession session = request.getSession();
	     
	     String nextURL ="/skill.jsp";
	     String[] skills;
	     skills = new String[20];
	     int i2 = 1;
	     
	     try{
	    	 
			 Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost/Resumebuilder?user=root&password=password");
		     
			//Insert skills
		
			 userID = request.getParameter("userID");
		     skill = request.getParameter("skill");
    		 ratings = request.getParameter("rating");
    		 skills[i2] = skill+"\n"+ ratings+"\n";
    		 skills[i2] = skillAll;
		      
    		 pstmt = con.prepareStatement("update Resume set skillAll = ? where userID = ? ");
			 pstmt.setString(1, skillAll);
			 pstmt.setString(2, userID);
			 pstmt.executeUpdate();
			while(i2<21)
		     { 
			 String choice2 = request.getParameter("group3");
		    	 if(choice2.equals("Yeah"))
		    	 {   
		    		 nextURL = "/skill.jsp";
		    		 skill = request.getParameter("skill");
		    		 ratings = request.getParameter("rating");
		    		 skills[i2] = skill+"\n"+ ratings+"\n";
		    		 skills[i2] = skillAll;
		    		 i2++;
		    		 
		    		 getServletContext().getRequestDispatcher(nextURL).forward(request, response);
		    		 
		    	 }
		    	 else 
		    		 if(choice2.equals("Nah"))
		    		 {
		               nextURL = "/Resume.jsp";
		               getServletContext().getRequestDispatcher(nextURL).forward(request, response);
		    		 }		 
		     }
		    	 
		    	 
		    	 
				 
				 getServletContext().getRequestDispatcher(nextURL).forward(request, response);
		     }
		     
		    	 catch (SQLException e) {
		 			// TODO Auto-generated catch block
		 			e.printStackTrace();
		 		} catch (ClassNotFoundException e) {
		 			// TODO Auto-generated catch block
		 			e.printStackTrace();
		 		} catch (ServletException e) {
		 			// TODO Auto-generated catch block
		 			e.printStackTrace();
		 		} catch (IOException e) {
		 			// TODO Auto-generated catch block
		 			e.printStackTrace();
		 		} 
		 	  finally
		 	  {
		 		  
		 	  }
		  
		 
	}
}
	


