

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
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        String custName = request.getParameter("cust_name");
	        String custPhone = request.getParameter("cust_phone");
	        String custCity = request.getParameter("cust_city");

	        out.println("<!DOCTYPE html>");
	        out.println("<html lang=\"en\">");
	        out.println("<head>");
	        out.println("<title>Order Confirmation</title>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<h2><b>Thank you for ordering</b></h2>");
	        out.println("<h3>we cannot show items in this lab. Will do later:</h3>");
	        out.println("<ul>");
	        out.println("<li>Customer Name: " + custName + "</li>");
	        out.println("<li>Phone Number: " + custPhone + "</li>");
	        out.println("<li>City: " + custCity + "</li>");
	        out.println("</ul>");
	        out.println("<p><a href='index.html'>Back to Select Menu</a></p>");
	        out.println("</body></html>");

	        out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
