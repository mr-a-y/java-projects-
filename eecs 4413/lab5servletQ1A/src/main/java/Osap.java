

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.Writer;

/**
 * Servlet implementation class Osap
 */
@WebServlet("/Osap")
public class Osap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Osap() {
        super();
        // TODO Auto-generated constructor stub
    }

	private double calculatedPayments(double p, double i, double l) {
		// TODO Auto-generated method stub
		
		double m=0;
		double a= (1+(i/1200));
		m= ((i*p)/1200)/(1-Math.pow(a, -l));
	
		return m;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		String clientQueryString = request.getQueryString();
		Writer out = response.getWriter();
		ServletContext context = this.getServletContext();
		

		String principal = request.getParameter("principal");
		String interest = request.getParameter("interest"); 
		String period=request.getParameter("period");
		
		double p;
		double l;
		double i;
		
	
		
		if (principal == null || principal.isEmpty()) {
			principal = context.getInitParameter("defaultPrincipal");
		}
		
		if (interest == null || interest.isEmpty()) {
			interest = context.getInitParameter("defaultInterest");
		}
		
		if (period == null || period.isEmpty()) {
			period = context.getInitParameter("defaultPeriod");
		}
		
		
		p = Double.parseDouble(principal);
		l = Double.parseDouble(period);
		i = Double.parseDouble(interest);
		double monthlyPaymentFormated = calculatedPayments(p,i,l);
		
		double monthlyPayment = calculatedPayments(p, i, l);
		
		request.setAttribute("monthlyPayment", monthlyPayment);
		request.setAttribute("principal",principal);
		request.setAttribute("interest",interest);
		request.setAttribute("period",period);
		
		
		
		HttpSession session = request.getSession(true);
		session.setMaxInactiveInterval(30 * 60);
		Integer itemCount =(Integer)session.getAttribute("count");
		if (itemCount==null) {
		itemCount=1;	
		}
		else {
			int c =itemCount;
			itemCount = c+1;
		}
		
		
		
		session.setAttribute("count",itemCount);
		String target ="ResultView.jsp";
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
