package controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDAO;
import dao.CourseDAOImpl;
import model.Course;

/**
 * Servlet implementation class QueryServlet
 */
@WebServlet("/QueryServlet")
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		  response.setContentType("text/html;charset=UTF-8");
	      PrintWriter out = response.getWriter();
	 
	      
	      
	    	 int categoryID =  Integer.parseInt(request.getParameter("cat") );
	    	
	    	 CourseDAO courseDao = new CourseDAOImpl(this.getServletContext());
	    	 
	    	 	    	 
	 		 List <Course> resu = courseDao.findCoursesByCategory( categoryID );
	 		
	 			    	 
	    	 out.println("<html><head><title>Course Query Results</title></head><body>");
	         out.println("<h2> Query Results</h2>");
	    	 try {
	                 
	               
	                   // Print the result in an HTML form inside a table
	                   out.println("<form method='get' action='cart'>");
	                   
	                   out.println("<input type='hidden' name='todo' value='add' />" );
	                   
	                   out.println("<table border='1' cellpadding='6'>");
	                   out.println("<tr>");
	                   out.println("<th>&nbsp;</th>");
	                   out.println("<th>COURSE CODE</th>");
	                   out.println("<th>COURSE TITLE</th>");
	                   out.println("<th>CATEGORY</th>");
 	                   
	                   out.println("</tr>");
	     
	                   
	                   for(Course e: resu) {
	                      // Print each row with a checkbox identified by course's id
	                     String code = e.getCode();
	                     out.println("<tr>");
	                     out.println("<td><input type='checkbox'  name='code' value='" + code + "' /></td>");
	                      
	                     out.println("<td>" + e.getCode() + "</td>");                    
						
	                      out.println("<td>" + e.getTitle() + "</td>");
	                      out.println("<td>" + e.getCategoryDescription() + "</td>");
	                    
	                      
	                      out.println("</tr>");
	                   } 
	                   out.println("</table><br />");
	     
	       
	     
	                   // Submit and reset buttons
	                   out.println("<input type='submit' value='SELECT (add to wish list)' />");
	                   out.println("<input type='reset' value='CLEAR' /></form>");
	     
	                   // Hyperlink to go back to search menu
	                   out.println("<p><a href='Welcome.html'>Back to Select Menu</a></p>");
	             out.println("</body></html>");
	      }  finally {out.close();}
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
