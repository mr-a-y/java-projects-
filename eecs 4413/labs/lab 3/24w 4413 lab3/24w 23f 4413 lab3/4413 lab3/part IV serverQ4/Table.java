import java.util.ArrayList;

public class Table {
	ArrayList<Book> list;
	
	public Table() { // in real life, this should be loaded from database
		list = new ArrayList<>();
		list.add(new Book(1, "Sue Lee", "A cup of Java", 22));
		list.add(new Book(2, "Sue Lee", "Java IO", 72));
		list.add(new Book(3, "Tan Ah Teck", "Java for Dummy", 22));
		list.add(new Book(4, "Tan Ah Teck", "More Java for Dummies", 42));
		list.add(new Book(5, "Joe Suh", "Good Java Style", 12));
		
	}
	
	// complete this method, 
	// given array of author names, return a list of books of the authors
	public ArrayList<Book> search (String names[]){
		...
	}
	
	// complete this method, 
	// given a book id, return the book of this id
	public Book searchByID (int id){
		 ...
	}

}