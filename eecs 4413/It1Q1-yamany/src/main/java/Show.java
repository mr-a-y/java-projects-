

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Show
 */
@WebServlet("/Show")
public class Show extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Show() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	   	response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out =response.getWriter();
    	

		double a = (double) request.getAttribute("a_value");
		String a_value = String.format("%.2f", a);
		double b = (double) request.getAttribute("b_value");
		String b_value = String.format("%.2f", b);
		double c = (double) request.getAttribute("c_value");
		String c_value = String.format("%.2f", c);
    	
    	
		double v = (double) request.getAttribute("v_value");
		String v_value = String.format("%.2f", v);

		
		out.println("<body>");
		out.println(" <form method ='get' action='index.html' class='resultForm'>");
		out.println("<h2> Calculated Volume: ");
		out.println(v_value+"<br><br>");
		out.println("<h2> Calculation used : ");
		out.println("<br><br>");
		
		out.println("<ul>");
		out.println("<li> Used A: "+a_value+"</li>");
		out.println("<li> Used B: "+b_value+"</li>");
		out.println("<li> Used C: "+c_value+"</li>");
		out.println("</ul>");
		
		
		out.println("<input type='submit' value='Re-calculate'  />");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.println("");
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
