package model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Cart {
 
   private List<Course> cart;  // List of Books
 
   // constructor
   public Cart() {
      cart = new ArrayList<Course>();
   }
 
    
   public void add(Course c) {
	      this.cart.add(c);
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
   public List<Course> getItems() {
      return cart;
   }
 
   // Remove all the items in this Cart
   public void clear() {
      cart.clear();
   }
   
   
   public void sortByCode() {
	   
	   Collections.sort(this.cart, new CourseCodeComparator() );
   }
   public void sortByCategory() {
	   
	   Collections.sort(this.cart, new CourseCategoryComparator() );
   }
}