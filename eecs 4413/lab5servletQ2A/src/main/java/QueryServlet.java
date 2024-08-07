import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab5servletQ2A.Book;
import lab5servletQ2A.Table;

@WebServlet("/QueryServlet")
public class QueryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public QueryServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String authors[] = request.getParameterValues("author");

        Table t = new Table();
        ArrayList<Book> resultList = t.search(authors);

        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("<title>Query Result</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Query Result</h2>");

        out.println("<form method='get' action='CartServlet'>");
        out.println("<table border='1' cellpadding='6'>");
        out.println("<tr>");
        out.println("<th>&nbsp;</th>");
        out.println("<th>Book ID</th>");
        out.println("<th>AUTHOR</th>");
        out.println("<th>TITLE</th>");
        out.println("<th>PRICE</th>");
        out.println("<th>QTY</th>");
        out.println("</tr>");

        for (Book e : resultList) {
            out.println("<tr>");
            out.println("<td><input type='checkbox' name='id' value='" + e.getId() + "' /></td>");
            out.println("<td>" + e.getId() + "</td>");
            out.println("<td>" + e.getAuthor() + "</td>");
            out.println("<td>" + e.getTitle() + "</td>");
            out.println("<td>" + e.getPrice() + "</td>");
            out.println("<td><input type='number' name='qty_" + e.getId() + "' min='1' value='1'/></td>");
            out.println("</tr>");
        }
        out.println("</table><br />");

        out.println("<input type='hidden' name='todo' value='add' />");
        out.println("<input type='submit' value='Add to my SHOPPING CART' />");
        out.println("<input type='reset' value='CLEAR' />");
        out.println("</form>");

        out.println("<p><a href='index.html'>Back to Select Menu</a></p>");

        out.println("</body></html>");

        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
