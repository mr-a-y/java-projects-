import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyServlet2")
public class MyServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MyServlet2() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("userName");
        String password = request.getParameter("userPassword");
        String year = request.getParameter("year");
        String group = request.getParameter("group");
        String[] hobbies = request.getParameterValues("hobby");

        out.println("Name: <b>" + name + "</b><br>");
        out.println("Password: <b>" + password + "</b><br>");
        out.println("Year: <b>" + year + "</b><br>");
        out.println("Group: <b>" + group + "</b><br>");
        out.println("Transportation: <b>");
        if (hobbies != null) {
            for (String hobby : hobbies) {
                out.println(hobby + "</b><b>, ");
            }
        }
        out.println("</b>");
        out.close();
    }
}
