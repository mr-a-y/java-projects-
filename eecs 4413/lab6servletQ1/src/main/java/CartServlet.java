import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lab5servletQ2B.Book;
import lab5servletQ2B.Cart;
import lab5servletQ2B.Table;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CartServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(true);
        Cart cart;
        synchronized (session) {
            cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
                session.setAttribute("cart", cart);
            }
        }

        try {
            out.println("<html><head><title>Shopping Cart</title></head><body>");
            out.println("<h2>Your Shopping Cart</h2>");

            String todo = request.getParameter("todo");

            if (todo.equals("add")) {
                String[] ids = request.getParameterValues("id");
                if (ids != null) {
                    Table t = new Table();
                    for (String id : ids) {
                        int bookId = Integer.parseInt(id);
                        int quantity = Integer.parseInt(request.getParameter("qty_" + bookId));
                        Book book = t.searchByID(bookId);
                        cart.add(book.getId(), book.getTitle(), book.getAuthor(), book.getPrice(), quantity);
                    }
                }
            } else if (todo.equals("update")) {
                String id = request.getParameter("id");
                int bookId = Integer.parseInt(id);
                int newQty = Integer.parseInt(request.getParameter("qty_" + id));
                cart.update(bookId, newQty);
            } else if (todo.equals("remove")) {
                String id = request.getParameter("id");
                int bookId = Integer.parseInt(id);
                cart.remove(bookId);
            }

            if (cart.isEmpty()) {
                out.println("<p>Your shopping cart is empty</p>");
            } else {
                out.println("<table border='1' cellpadding='6'>");
                out.println("<tr>");
                out.println("<th>Book ID</th>");
                out.println("<th>AUTHOR</th>");
                out.println("<th>TITLE</th>");
                out.println("<th>PRICE</th>");
                out.println("<th>QTY</th>");
                out.println("<th>REMOVE</th></tr>");

                float totalPrice = 0f;
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
                    out.println("<td><form method='get'>");
                    out.println("<input type='number' name='qty_" + id + "' min='1' value='"+qtyOrdered+"'/> ");
                    out.println("<input type='hidden' name='todo' value='update'>");
                    out.println("<input type='hidden' name='id' value='" + id + "'>");
                    out.println("<input type='submit' value='Update'>");
                    out.println("</form></td>");
                    
                    
                    out.println("<td><form method='get'>");
                    out.println("<input type='hidden' name='todo' value='remove'>");
                    out.println("<input type='hidden' name='id' value='" + id + "'>");
                    out.println("<input type='submit' value='Remove'>");
                    out.println("</form></td>");
                    out.println("</tr>");

                    totalPrice += price * qtyOrdered;
                }
                out.println("<tr><td colspan='6' align=''>Total Price: $" + totalPrice + "</td></tr>");
                out.println("</table>");
            }

            out.println("<p><a href='index.html'>Select More Books...</a></p>");

            if (!cart.isEmpty()) {
                out.println("<br />");
                
                out.println("<form method='get' action='OrderServlet'>");
                out.println("Enter your Name: <input type='text' name='cust_name' /><br>");
                out.println("Enter your Phone Number: <input type='text' name='cust_phone' /><br>");
                out.println("Choose your City: <select name='cust_city'>");
                out.println("<option value='Toronto'>Toronto</option>");
                out.println("<option value='Montreal'>Montreal</option>");
                out.println("<option value='Vancouver'>Vancouver</option>");
                out.println("</select><br><br>");
       
               
                out.println("<input type='submit' value='CHECK OUT'>");
                out.println("<p>Please fill in your particulars before checking out:</p>");
                // Add input fields for customer information here...
                out.println("</form>");
            }

            out.println("</body></html>");

        } finally {
            out.close();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
