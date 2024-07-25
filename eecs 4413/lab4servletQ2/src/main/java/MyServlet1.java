import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyServlet1")
public class MyServlet1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MyServlet1() {
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

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"ISO-8859-1\">");
        out.println("<title>Insert title here</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("Hello " + name + "<br>");
        out.println("You have been registered.<br>");
        out.println("<form action=\"MyServlet2\" method=\"post\">");
        out.println("<input type='hidden' name='userName' value='" + name + "'>");
        out.println("<input type='hidden' name='userPassword' value='" + password + "'>");
        out.println("<input type='hidden' name='year' value='" + year + "'>");
        out.println("<input type='hidden' name='group' value='" + group + "'>");
        if (hobbies != null) {
            for (String hobby : hobbies) {
                out.println("  <input type=\"hidden\" name=\"hobby\" value=\"" + hobby + "\">");
            }
        }
        out.println("  <input type=\"submit\" value=\"submit\"/>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");

        out.close();
    }

}
