import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

        StringBuilder query = new StringBuilder("SELECT * FROM books WHERE author = ?");
        for (int i = 1; i < authors.length; i++) {
            query.append(" OR author = ?");
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab6", "root", "eecs4413");
                 PreparedStatement stmt = con.prepareStatement(query.toString())) {

                for (int i = 0; i < authors.length; i++) {
                    stmt.setString(i + 1, authors[i]);
                }

                ResultSet rs = stmt.executeQuery();
                ArrayList<Book> resu = new ArrayList<>();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String title = rs.getString("title");
                    String author = rs.getString("author");
                    float price = rs.getFloat("price");
                    Book b = new Book(id, author, title, price);
                    resu.add(b);
                }

                HttpSession session = request.getSession();
                session.setAttribute("bookList", resu);

                request.getRequestDispatcher("bookResultView.jsp").forward(request, response);

            } catch (SQLException e) {
                throw new ServletException("SQL error", e);
            }

        } catch (ClassNotFoundException e) {
            throw new ServletException("JDBC Driver not found", e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
