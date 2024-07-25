

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	 
	      
	       
	    	 // based on user province selections, get a list of universities
	       String[] uni = request.getParameterValues("area");
	         UniversityDB t = new UniversityDB();
	    	 ArrayList <University> resu = t.search(uni);  
	    	 
	    	 out.println("<html><head><title>Query Results</title></head><body>");
	         out.println("<h2> Query Results</h2>");
	    	 try {
	                // Print the result in an HTML form inside a table
	                   out.println("<form method='get' action='  ResultServlet   '>");
	                   out.println("<table border='1' cellpadding='6'>");
	                   out.println("<tr>");
	                   out.println("<th>&nbsp;</th>");
	                   out.println("<th>U CODE</th>");
	                   out.println("<th>NAME</th>");
	                   out.println("<th>PROVINCE</th>");
 	                   out.println("<th>CITY</th>");
 	                  out.println("<th>VISIT MONTH</th>");
 	                   
	                   out.println("</tr>");
	     
	                    
	                   for(University e : resu ) {
	                      // Print each row start with a checkbox 
	                     out.println("<tr>");
	                     // checkbox with univ code as name
	                     out.println("<td><input type='checkbox' name=      value= '"+e.getCode()+"' /></td>");
	                      
	                     // output code, title, province, city
	                
	                     out.println("<td>" + e.getCode() + "</td>");
	                     out.println("<td>" + e.getTitle() + "</td>");
	                     out.println("<td>" + e.getProvince() + "</td>");
	                     out.println("<td>" + e.getCity() + "</td>");
	                     out.println("</tr>");
	                    
	                      out.println("<td>");
	                     // radio button use 'time'+ code as name 
	                     out.println("<input type='radio' name="+"'time'"+ "' value='May' /> May");
	             
	                      
		                  out.println("</td>");
	                      out.println("</tr>");
	                   } 
	                   out.println("</table><br />");
	     
	                    
	                   
	                   //out.println("<table>");
	                   out.println("Enter your Name: ");
	                   //.....
	                   
	                   // Submit and reset buttons
	          
	                   out.println("<input type='reset' value='CLEAR' /></form>");
	                   
	                   out.println("/form>");
	     
	                   // Hyperlink to go back to search menu
	                   out.println("<p><a href='index.html  '>Back to Select Menu</a></p>");
	                
	             out.println("</body></html>");
	      }  
	    	 finally {out.close();
	    	 }
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
