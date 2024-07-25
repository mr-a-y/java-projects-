package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Loan;

@WebServlet("/OsapServlet")
public class Osap extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String principal = request.getParameter("principal");
        String interest = request.getParameter("interest"); 
        String period = request.getParameter("period");
        
        double p, l, i;
        
        if (principal == null || principal.isEmpty()) {
            principal = getServletContext().getInitParameter("defaultPrincipal");
        }
        
        if (interest == null || interest.isEmpty()) {
            interest = getServletContext().getInitParameter("defaultInterest");
        }
        
        if (period == null || period.isEmpty()) {
            period = getServletContext().getInitParameter("defaultPeriod");
        }
        
        p = Double.parseDouble(principal);
        l = Double.parseDouble(period);
        i = Double.parseDouble(interest);
        
        Loan loan = new Loan();
        loan.setPrincipal(p);
        loan.setInterest(i);
        loan.setPeriod(l);
        loan.calculatePayment();
        
        request.setAttribute("loan", loan);
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
		
        RequestDispatcher dispatcher = request.getRequestDispatcher("ResultView.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
