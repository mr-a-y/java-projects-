

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add
 */
@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add() {
        super();
        // TODO Auto-generated constructor stub
    }

	private double calculatedVolume(double a, double b, double c) {
		// TODO Auto-generated method stub
		
		
		
		
		 return (4.0 / 3.0) * Math.PI * a * b * c;
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NumberFormatException {
		// TODO Auto-generated method stub
		
		ServletContext context = this.getServletContext();
		
		String a_value = request.getParameter("a_value");
		String b_value = request.getParameter("b_value"); 
		String c_value=request.getParameter("c_value");
		
		double a;
		double b;
		double c;
		
		
		
		
		
		if ( a_value== null || a_value.isEmpty()) {
			a_value = context.getInitParameter("default_a");
		}
		
		if (b_value == null || b_value.isEmpty()) {
			b_value = context.getInitParameter("default_b");
		}
		
		if (c_value == null || c_value.isEmpty()) {
			c_value = context.getInitParameter("default_c");
		}
		
		
		a = Double.parseDouble(a_value);
		b = Double.parseDouble(b_value);
		c = Double.parseDouble(c_value);
		
		double v = calculatedVolume(a, b, c);
		

	    try {
	        a = Double.parseDouble(a_value);
	        b = Double.parseDouble(b_value);	
	        c = Double.parseDouble(c_value);
	        if (a < 0 || b < 0 || c < 0) {
	            throw new IllegalArgumentException("Values cannot be negative.");
	        }
	    } catch (IllegalArgumentException e) {
	        response.sendRedirect("index.html?error=true"); // Redirect with error parameter
	        return;
	    }
		
		
		request.setAttribute("v_value",v);
		request.setAttribute("a_value",a);
		request.setAttribute("b_value",b);
		request.setAttribute("c_value",c);
		
		
		String target ="Show";
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
