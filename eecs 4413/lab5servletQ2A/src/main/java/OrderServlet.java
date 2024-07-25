

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lab5servletQ2A.Book;
import lab5servletQ2A.Cart;
import lab5servletQ2A.Table;

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

	        HttpSession session = request.getSession(true);
	        Cart cart;
	        synchronized (session) {
	            cart = (Cart) session.getAttribute("cart");
	           
	        }

	        
	        String custName = request.getParameter("cust_name");
	        String custPhone = request.getParameter("cust_phone");
	        String custCity = request.getParameter("cust_city");
	        Table t = new Table();
	        double total = 0;

	        out.println("<!DOCTYPE html>");
	        out.println("<html lang=\"en\">");
	        out.println("<head>");
	        out.println("<title>Order Confirmation</title>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<h2><b>Thank you for ordering</b></h2>");
	        out.println("<table border='1' cellpadding='6'>");
	        out.println("<tr>");
	        out.println("<th>Book ID</th>");
	        out.println("<th>AUTHOR</th>");
	        out.println("<th>TITLE</th>");
	        out.println("<th>PRICE</th>");
	        out.println("<th>QUANTITY</th>");
	        out.println("</tr>");

	        String[] bookIds = request.getParameterValues("book_id");
	        
	        
	        for (Book item : cart.getItems()) {
                int id = item.getId();
                String author = item.getAuthor();
                String title = item.getTitle();
                float price = item.getPrice();
                int qtyOrdered = item.getQuantity();
                out.println("<tr>");
                out.println("<td>" + id + "</td>");
                out.println("<td>" + author + "</td>");
                out.println("<td>" + title + "</td>");
                out.println("<td>" + price + "</td>");
                out.println("<td>" + qtyOrdered + "</td>");
                out.println("</tr>");
                
                total += price * qtyOrdered;
	        }
	        
	        

			out.println("<tr>");
			out.println("<td colspan='6' style='text-align: left;'><strong>Total Order Price: " + total + "</strong></td>");
			out.println("</tr>");
	        out.println("</table><br>");

	        
	        out.println("<ul>");
	        out.println("<li>Customer Name: " + custName + "</li>");
	        out.println("<li>Phone Number: " + custPhone + "</li>");
	        out.println("<li>City: " + custCity + "</li>");
	        out.println("</ul>");
	        out.println("<p><a href='index.html'>Back to Select Menu</a></p>");
	        out.println("</body></html>");
cart.clear();
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
