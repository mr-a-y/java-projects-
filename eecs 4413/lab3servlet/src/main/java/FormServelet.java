
import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormServelet
 */
@WebServlet("/FormServelet")
public class FormServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	
		  response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        String firstName = request.getParameter("firstName");
	        String lastName = request.getParameter("lastName");
	        String email = request.getParameter("email");
	        String program = request.getParameter("program");
	        String year = request.getParameter("year");
	        String[] hobbies = request.getParameterValues("hobby[]");
	        String comment = request.getParameter("comment");

	        out.println("<!DOCTYPE html>");
	        out.println("<html lang=\"en\">");
	        out.println("<head>");
	        out.println("<title>Form Submission Result</title>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("Hi <b>" + firstName + "</b>, the server has received your form submission successfully. <hr>");
	        out.println("Welcome <b>" + firstName + "</b> <b>" + lastName + "</b> <br>");
	        out.println("Your email address is: <b>" + email + "</b><br><br>");
	        out.println("Your program is: <b>" + program + "</b> <br>");
	        out.println("You are in year: <b>" + (year != null ? year : "N/A") + "</b> <br>");
	        out.print("Your hobbies: <b>");
	        if (hobbies != null && hobbies.length > 0) {
	            for (String hobby : hobbies) {
	                out.print(hobby + " ");
	            }
	        } else {
	            out.print("N/A");
	        }
	        out.println("</b><br><br>");
	        out.println("Your comments: <b>" + comment + "</b><br><br>");
	        out.println("<hr>");
	        out.println("Good luck with your studies in the 2023-24 academic year, <b>" + firstName + "</b>! <hr>");
	        out.println("</body>");
	        out.println("</html>");

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
