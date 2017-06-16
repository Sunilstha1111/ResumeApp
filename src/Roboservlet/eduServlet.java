package Roboservlet;
import java.sql.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/eduServlet")
public class eduServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public eduServlet() {
        super();
        
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Connection con = null;
	     Statement stmt = null;
	     PreparedStatement pstmt = null;
	     ResultSet rs = null;
	     String degree, university, gradD, Edu, name, email, userID = null;
	     
	     String eduAll = "" ;
	     String[] edu_Achievement;
	     edu_Achievement = new String[10];
	     int i = 1;
	     
	     HttpSession session = request.getSession();
	     
	     String nextURL = "/work.jsp";
	     
	     try{
	    	 
			 Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost/Resumebuilder?user=root&password=password");
		     
			 userID = request.getParameter("userID");
			 name = request.getParameter("name");
			 email = request.getParameter("email");
			 degree = request.getParameter("degree");
    		 university = request.getParameter("university");
    		 gradD = request.getParameter("gradD");
    		 edu_Achievement[i] = degree +"\n"+university+", "+gradD+"\n";
    		  eduAll = edu_Achievement[i] ;
			 
    		 pstmt = con.prepareStatement("Update Resume set eduAll = ? where userID = ?");
			 pstmt.setString(1, eduAll);
			 pstmt.setString(2, userID);
			 pstmt.executeUpdate();
		    while (i< 11)
		    {
		    	 String choice = request.getParameter("group1");
		    	 if(choice.equals("Yes"))
		    	 {
		    		
		    	     nextURL = "/edu.jsp";
		    		 degree = request.getParameter("degree");
		    		 university = request.getParameter("university");
		    		 gradD = request.getParameter("gradD");
		    		 edu_Achievement[i] = degree +"\n"+university+", "+gradD+"\n";
		    		 edu_Achievement[i] = eduAll;
		    		 i++;
		    		 getServletContext().getRequestDispatcher(nextURL).forward(request, response);
		    	 }
		    	 else
		    		 if(choice.equals("No"))
		    		 {
		    			 nextURL = "/work.jsp";
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


