

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/result")
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultServlet() {
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
	    out.println("<h3>Univeristy visit plan  </h3>");
		out.println("<table border='1' cellpadding='6'>");
	    out.println("<tr><th>University</th><th>Visit Month</th></tr>");
	    
	     //print user selected university code and visit month
	    // bonus if display university name instead of code
	    {
		
		}
		 
	     
		out.println("</table>"); 
		
		 
        
        out.println("<ul>"); 
        out.println("<li> Visitor Name: "    + "</li>");
       	//determine if first time connection, and output message accordingly.  
        //if not first time, also output 'connection count'.
		  
         out.println("</ul>");
         
         out.println("<p><a href='     '>Back to Select Menu</a></p>");
      
         out.println("</body></html>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
