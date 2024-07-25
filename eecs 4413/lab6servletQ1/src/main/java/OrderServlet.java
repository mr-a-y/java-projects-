import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lab5servletQ2B.Book;
import lab5servletQ2B.Cart;
import lab5servletQ2B.Table;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public OrderServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        request.getRequestDispatcher("/orderView.jsp").forward(request, response);
        cart.clear();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
