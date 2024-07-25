package lab5servletQ2A;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cart {
 
   private List<Book> cart;  // List of Books
 
   // constructor
   public Cart() {
      cart = new ArrayList<Book>();
   }
 
   // Add a Book into this Cart, with qtyOrdered. If the book of id already exists, update the qty ordered
   // if not, create a new book.
   public void add(int id, String title, String author, float price, int qtyOrdered) {
	   boolean found = false;
       for (Book book : cart) {
           if (book.getId() == id) {
               book.setQuantity(book.getQuantity() + qtyOrdered);  // Assuming you have a setter for quantity in Book
               found = true;
               break;
           }
       }
       if (!found) {
           cart.add(new Book(id, author, title, price, qtyOrdered));  // Assuming Book constructor accepts quantity
       }
   }
 
   // Update the quantity for the given id, of total orderqty
   public void update(int id, int newQty) {
	   for (Book book : cart) {
           if (book.getId() == id) {
               book.setQuantity(newQty);
               break;
           }
       }
   }
 
   // Remove a Book given its id
   public void remove(int id) {
	   Iterator<Book> iter = cart.iterator();
       while (iter.hasNext()) {
           Book book = iter.next();
           if (book.getId() == id) {
               iter.remove();
               break;
           }
       }
   }
 
   // Get the number of Books in this Cart
   public int size() {
      return cart.size();
   }
 
   // Check if this Cart is empty
   public boolean isEmpty() {
      return size() == 0;
   }
 
   // Return all the Books in a List<Book>
   public List<Book> getItems() {
      return cart;
   }
 
   // Remove all the items in this Cart
   public void clear() {
      cart.clear();
   }
}

