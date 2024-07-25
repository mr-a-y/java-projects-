package model;

public class Category {
	private int id;
	private String description;

	
	public Category(int id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String categoryDescription) {
		this.description = categoryDescription;
	}

	public String toString() {
		return "Category - Id: " + id + ", Category Description: " + this.description;
	}

}
