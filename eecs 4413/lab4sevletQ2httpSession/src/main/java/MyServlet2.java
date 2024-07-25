

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class MyServlet2
 */
@WebServlet("/MyServlet2Cookie")
public class MyServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		  response.setContentType("text/html");
	      PrintWriter pwriter = response.getWriter();
	     
	      HttpSession session=request.getSession(false);
	      String name=(String)session.getAttribute("uname");
	      String pass=(String)session.getAttribute("upass");
	      String year=(String)session.getAttribute("uyear");
	      String group=(String)session.getAttribute("ugroup");
	      String tr=(String)session.getAttribute("utr");
	      
	      pwriter.println("Name: <b>"+ name+"</b><br>");
	      pwriter.println("Passwd: <b>"+ pass+"</b><br>");
	      pwriter.println("Year: <b>"+ year+"</b><br>");
	      pwriter.println("Group: <b>"+ group+"</b><br>");
	      pwriter.println("Transportation: <b>"+ tr+"</b><br>");
	    	 
	     
	      pwriter.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
