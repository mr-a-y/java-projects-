

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
 * Servlet implementation class MyServlet1
 */
@WebServlet("/MyServlet1")
public class MyServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet1() {
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

	      String name = request.getParameter("userName");
	      String password = request.getParameter("userPassword");
	      String year = request.getParameter("year");
	      String group = request.getParameter("group");
	      String a[] = request.getParameterValues("hobby");
	      String tr = "";
	      for(int i=0; i<a.length;i++)
	      	 tr += a[i]+ ", ";
	      
	      HttpSession session=request.getSession();
	      session.setAttribute("uname",name);
	      session.setAttribute("upass",password+"xxx");
	      session.setAttribute("uyear", year);
	      session.setAttribute("ugroup", group);
	      session.setAttribute("utr", tr );
	     
	     
	        
	      pwriter.println("Hello "+name +"<br>");
	      pwriter.println("Your have been registered.  ");
	      pwriter.print("<a href='MyServlet2Cookie'>view details</a>");
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
