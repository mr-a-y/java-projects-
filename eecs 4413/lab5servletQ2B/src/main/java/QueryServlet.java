import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lab5servletQ2B.Book;
import lab5servletQ2B.Table;

@WebServlet("/QueryServlet")
public class QueryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public QueryServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String authors[] = request.getParameterValues("author");
        Table t = new Table();
        ArrayList<Book> resultList = t.search(authors);


        HttpSession session = request.getSession();
        session.setAttribute("bookList",resultList);
        
        //request.setAttribute("bookList", resultList);
        request.getRequestDispatcher("bookResultView.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
