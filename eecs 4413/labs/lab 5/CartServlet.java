

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 
		response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	 
	      // Retrieve current HTTPSession object. If none, create one.
	      HttpSession session = request.getSession(true);
	      Cart cart;
	      synchronized (session) {  // synchronized to prevent concurrent updates
	         // Retrieve the shopping cart for this session, if any. Otherwise, create one.
	         cart = (Cart) session.getAttribute("cart");
	         if (cart == null) {  // No cart, create one.
	            cart = new Cart();
	            session.setAttribute("cart", cart);  // Save it into session
	         }
	      }
	 
	      
	      try {
	    
	 
	         out.println("<html><head><title>Shopping Cart</title></head><body>");
	         out.println("<h2>Your Shopping Cart</h2>");
	 
	         // This servlet handles 3 cases:
	         // (1 from QueryServlet) todo=add id=1001 qty1001=5 [id=1002 qty1002=1 ...]
	         // (2 from update button in this page) todo=update id=1001 qty1001=5
	         // (3 from remove button in this page) todo=remove id=1001
	         
	 
	         String todo = request.getParameter("todo");
	        	         
	         if (todo.equals("add") ) {
		    // (1) todo=add id=1001 qty1001=5 [id=1002 qty1002=1 ...]
		            
		    String[] ids = request.getParameterValues("id");
		              
		    if (ids == null) {
		       out.println("<h3>Please Select a Book!</h3></body></html>");
		       return;
		     }
		     for (String id : ids) {
		         // get the book b by id
					   
			  ......
			 // get title, author, price, qtyQrder
			  .....
						
		        int idInt = Integer.parseInt(id);
		        cart.add(idInt, title, author, price, qtyOrdered);
		               
		      }
	      
	         } 
	         else if (todo.equals("update")) {// (2) todo=update id=1001 qty1001=5
	            String id = request.getParameter("id");  // Only one id for update case
	            int idInt = Integer.parseInt(id);
	            int qtyNew = Integer.parseInt(request.getParameter("qty" + id));
	            System.out.println("cart update new");
	            .... //update the cart item with qtyNew
	         }
	         else if (todo.equals("remove")) { // (3) todo=remove id=1001
	            String id = request.getParameter("id");  // Only one id for remove case
	            System.out.println("cart remove");
	            .... //remove the book from the cart
	         }
	 
	         // All cases - Always display the shopping cart
	         if (cart.isEmpty()) {
	            out.println("<p>Your shopping cart is empty</p>");
	         } else {
	            out.println("<table border='1' cellpadding='6'>");
	            out.println("<tr>");
	            out.println("<th>Book ID</th>");
	            out.println("<th>AUTHOR</th>");
	            out.println("<th>TITLE</th>");
	            out.println("<th>PRICE</th>");
	            out.println("<th>QTY</th>");
	            out.println("<th>REMOVE</th></tr>");
	 
	            float totalPrice = 0f;
	            for (Book item : cart.getItems()) {
	               int id = item.getId();
	               String author = item.getAuthor();
	               String title = item.getTitle();
	               float price = item.getPrice();
	               int qtyOrdered = item.getOrderedQty();
	 
	               out.println("<tr>");
	               // output id, author, title, price
				   ....


	               // small form to do update
	               out.println("<td><form method='get'>");
	               out.println("<input type='text' size='3' name='todo' value='update' />"); //should be hidden
	               out.println("<input type='text' size='3' name='id' value='" + id + "' />"); // should be hidden
	               out.println("<input type='text' size='3' name='qty"
	                       + id + "' value='" + qtyOrdered + "' />" );
	               out.println("<input type='submit' value='Update' />");
	               out.println("</form></td>");
	 
	               // a small form to do remove
	               out.println("<td><form method='get'>");
	               out.println("<input type='text' size='3' name='todo' value='remove' >"); //should be hidden
	               out.println("<input type='text' size='3' name='id' value='" + id + "'>"); // should be hidden
	               out.println("<input type='submit' value='Remove'>");
	               out.println("</form></td>");
	               out.println("</tr>");
	               totalPrice += price * qtyOrdered;
	            }
	            out.println("<tr><td colspan='6' align=''>Total Price: $");
	            out.printf("%.2f</td></tr>", totalPrice);
	            out.println("</table>");
	         }
	 
	         out.println("<p><a href='index.html'>Select More Books...</a></p>");
	 
	         // Display the Checkout
	         if (!cart.isEmpty()) {
	            out.println("<br />");
	            out.println("<form method='get' action='checkout'>");
	            out.println("<input type='submit' value='CHECK OUT'>");
	            out.println("<p>Please fill in your particular before checking out:</p>");
	            
	            //allow user to input user information
				.....
	         	 
	            out.println("</table>");
	            
	            out.println("</form>");
	         }
	 
	         out.println("</body></html>");
	 
	      }/finally {
	         out.close();
	         
	        
	      }
	}

	