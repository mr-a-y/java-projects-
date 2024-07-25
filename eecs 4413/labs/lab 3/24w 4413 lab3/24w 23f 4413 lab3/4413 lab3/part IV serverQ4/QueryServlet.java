
	
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		  
	// get author selections from index.html, and search for the books, get a arraylist of books
	 .....
		  
	// now generating dynamic page -- form and a table in form
	response.setContentType("text/html;charset=UTF-8");
	PrintWriter out = response.getWriter();
	 
	out.println("<html><head><title>Query Results</title></head><body>");
	out.println("<h2> Query Results</h2>");
	    	 
	                  
	// Print the result in an HTML form inside a table
	out.println("<form method='get' action='...your second servlet url ...'>");

	// table inside form, table header
	out.println("<table border='1' cellpadding='6'>");
	out.println("<tr>");
	out.println("<th>&nbsp;</th>");
	out.println("<th>Book ID</th>");
	out.println("<th>AUTHOR</th>");
	out.println("<th>TITLE</th>");
	out.println("<th>PRICE</th>");
 	out.println("</tr>");
	     
	// print each row of table 
	for(Book e: resulist) {
	  // Print each row with a checkbox identified by book's id
	  out.println("<tr>");
            
	  out.println("<td><input type='checkbox'   /> </td>");  // checkbox, not used in this lab but later
	  out.println("<td>" + e.getId() + "</td>");                    
	 // print author name, title, price .....  
				 
	  out.println("</tr>");
	}  
	out.println("</table><br />"); // end table
	// print name phone textbox,               
	out.println("Enter your Name: ");
	out.println("<input .... name='cust_name' <br>");
	                   
        .... 
	                   
	out.println("Choose your City: ");
	// print dropdown list for Toronto, Montreal, Vancouver
	out.println("<select name='cust_city' > ");
	....
	out.println("</select> <br><br>");
	                   
	                   
          
	// Submit and reset buttons
        ....

	out.println("</form>");  // end form
	     
	// Hyperlink to go back to search menu
	out.println("<p><a href='....");
       
	        
	out.println("</body></html>");
	     
		
	out.close();
	    
}
