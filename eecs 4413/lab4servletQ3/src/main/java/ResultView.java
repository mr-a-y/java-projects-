

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ResultView
 */
@WebServlet("/ResultView")
public class ResultView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out =response.getWriter();
    	
    	
    	
    	String pay = String.format("%.2f", request.getAttribute("monthlyPayment"));
    	String principal = request.getAttribute("principal").toString();
    	String inter = request.getAttribute("interest").toString(); 
    	String period = request.getAttribute("period").toString();
    	
    	String clientProtocol = request.getProtocol();
    	String clientMethod = request.getMethod();
    	String originalPrincipal = request.getParameter("principal");
    	String originalInterest = request.getParameter("interest");
    	String originalPeriod = request.getParameter("period");
		
		//out.println("");
		out.println("<head>");
		out.println("<link rel='StyleSheet' href='mc.css' type='text/css'/>");
		out.println("<head>");
		
		out.println("<body>");
		out.println("<header>Student Loan Application </header>");
	
		out.println("<p class='subtitle'>Client Protocal: "+clientProtocol+"</p>\n");

		
		out.println("<p class='subtitle'>Client Method: "+clientMethod+"</p>\n");
		
		out.println("<p class='subtitle'>Query String: "+request.getQueryString()+"</p>\n");
		
		
		out.println("<p class='subtitle'>Entered principal: "+originalPrincipal+"</p>\n");
		
		
		out.println("<p class='subtitle'>Entered interest: "+originalInterest+"</p>\n");

		
		out.println("<p class='subtitle'>Entered period: "+originalPeriod+"</p>\n");
		
		int c = (Integer)request.getSession().getAttribute("count") ;
		
		//out.println("");
		
		if (c==1) {
			out.println("<p class='subtitle'>Welcome. this is the first calculation for you. </p>\n");
		}
		else {
			out.println("<p class='subtitle'>Welcome back. Calculation: "+c+"</p>\n");
		}
		
		out.println(" <form method ='get' action='index.html' class='resultForm'>");
		out.println("<h2> Monthly Payment: ");
		out.println(pay+"<br><br>");
		out.println("<h2> Calculation used : ");
		out.println("<br><br>");
		
		out.println("<ul>");
		out.println("<li> Principal: "+principal+"</li>");
		out.println("<li> Interest: "+inter+"</li>");
		out.println("<li> Period: "+period+"</li>");
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
