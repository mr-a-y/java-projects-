

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
	     
	      
	      
	      Cookie c[] = request.getCookies();
	       
	      for (Cookie c0 : c) {
	    	  //pwriter.println(c0.getName()+ ": "+ c0.getValue()+"<br>");
	    	  if(c0.getName().equals("uname"))
	    		  pwriter.println("Name: <b>"+ c0.getValue()+"</b><br>");
	    	  else if(c0.getName().equals("upass"))
	    		  pwriter.println("Passwd: <b>"+ c0.getValue()+"</b><br>");
	    	  else if(c0.getName().equals("uyear"))
	    		  pwriter.println("Year: <b>"+ c0.getValue()+"</b><br>");
	    	  else if(c0.getName().equals("ugroup"))
	    		  pwriter.println("Group: <b>"+ c0.getValue()+"</b><br>");
	    	  else if(c0.getName().equals("utr"))
	    		  pwriter.println("Transportation: <b>"+ c0.getValue()+"</b><br>");
	    	 }
	        
	     
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
