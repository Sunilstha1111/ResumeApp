package Roboservlet;
import java.sql.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class RoboServlet
 */
@WebServlet("/RoboServlet")
public class RoboServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RoboServlet() {
        super();
        
    }
	
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
		
		 Connection con = null;
	     Statement stmt = null;
	     PreparedStatement pstmt = null;
	     ResultSet rs = null;
	     
	     String name, email;
	     String Fullname, Email, Edu, Exp, Skil;
	     
	     HttpSession session = request.getSession();
	     
	     String nextURL = "/edu.jsp";
	     
 try{
	 
			 Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost/Resumebuilder?user=root&password=password");
		     
			 
			 //Insert name
			 name = request.getParameter("name");
			 session.setAttribute("name", name);
			 //Insert email
			 email = request.getParameter("email");
			 if (!(email.contains("@")&& email.contains("."))){
				  email = "Invalid email. Try again"; 
			 }
		     
			 session.setAttribute("email", email);
			 pstmt = con.prepareStatement("insert into Resume(name, email) values (?,?)");
	    	 pstmt.setString(1, name);
	    	 pstmt.setString(2, email);
	    	 pstmt.executeUpdate();
			 
	    	
	    	 //Output into the Web
			 
	    	 pstmt = con.prepareStatement("select * from Resume where name = ?");
			 pstmt.setString(1, name);
			 rs = pstmt.executeQuery();
			 rs.next();
			 
			 String userID = rs.getString("userID");
			 request.setAttribute("userID",userID);
			 
			 
			 
			 
			 
			 
			 
			 getServletContext().getRequestDispatcher(nextURL).forward(request, response);
			 
			 
			/* Fullname = rs.getString("name");
			 Email = rs.getString("email");
			 Edu = rs.getString("eduAll");
			 Exp = rs.getString("workAll");
			 Skil = rs.getString("skillAll");*/
			 
			 
			 /*session.setAttribute("name", Fullname);
			 session.setAttribute("email", Email);
			 session.setAttribute("edu", Edu);
			 session.setAttribute("exp", Exp);
			 session.setAttribute("skil", Skil);*/
			 
			 
			
			 
			 
			 
			  
			
			 
			 
		//doGet(request, response);
	
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
