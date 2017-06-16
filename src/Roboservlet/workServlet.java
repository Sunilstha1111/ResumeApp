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
 * Servlet implementation class workServlet
 */
@WebServlet("/workServlet")
public class workServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public workServlet() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Connection con = null;
	     Statement stmt = null;
	     PreparedStatement pstmt = null;
	     ResultSet rs = null;
	     
	     String degree, university, gradD, company, role, tenure, duty1, duty2, userID = null;
	     String Exp;
	     String workAll = "";
	     HttpSession session = request.getSession();
	     
	     String nextURL = "/skill.jsp";
	     String[] work_Experience;
	     work_Experience = new String[10];
	     int i1 = 1;
	     
	     try{
	    	 
			 Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost/Resumebuilder?user=root&password=password");
		     
			 //Insert Work Experience
			 userID = request.getParameter("userID");
			 company = request.getParameter("company");
    		 role = request.getParameter("role");
    		 tenure = request.getParameter("tenure");
    		 duty1 = request.getParameter("duty1");
    		 duty2 = request.getParameter("duty2");
    		 work_Experience[i1] = role+"\n"+company+", "+tenure+"\n"+"   Duty-1: "+duty1+"\n"+"   Duty-2: "+duty2 +"\n";
    		 workAll = work_Experience[i1] ; 
    		 
    		 pstmt = con.prepareStatement("update Resume set workAll = ? where userID = ?");
	    	 pstmt.setString(1, workAll);
	    	 pstmt.setString(2, userID);
	    	 pstmt.executeUpdate();
		     while (i1<11)
		     {
		    	 String choice1 = request.getParameter("group2");
		    	 if (choice1.equals("yes"))
		    	 {
		    		 nextURL = "/work.jsp";
		    		 
		    		 company = request.getParameter("degree");
		    		 role = request.getParameter("role");
		    		 tenure = request.getParameter("tenure");
		    		 duty1 = request.getParameter("duty1");
		    		 duty2 = request.getParameter("duty2");
		    		 work_Experience[i1] = role+"\n"+company+", "+tenure+"\n"+"   Duty-1: "+duty1+"\n"+"   Duty-2: "+duty2 +"\n";
		    		 work_Experience[i1] = workAll;
		    		 i1++;
		    		 getServletContext().getRequestDispatcher(nextURL).forward(request, response);
		    	 }
		    	 else
		    		 if(choice1.equals("no")) 
		    		 {
		    			 
		    			 nextURL = "/skill.jsp";
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
