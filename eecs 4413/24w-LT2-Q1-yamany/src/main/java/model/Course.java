package model;

import java.util.Comparator;

public class Course {
	
	String code;
	String title;
	//Double credit;
	int categoryID;
	String categoryDescription;
	String sections;
	
	String selectedSection;

	
	public Course(String cd, String title,  int cateID ) {
		
		super();
		this.code = cd;
		this.title = title;
		
		this.categoryID = cateID;
		 
	}
	
	
	 
	public String getCode() {
		return code;
	}
	public void setCode(String id) {
		this.code = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	
	public String getSelectedSection() {
		return selectedSection;
	}
	public void setSelectedSection(String selectedSection) {
		this.selectedSection = selectedSection;
	}

}



class CourseCodeComparator implements Comparator <Course>{

	@Override
	public int compare(Course o1, Course o2) {
		// TODO Auto-generated method stub
		return o1.code.compareTo( o2.code);
	}
}
class CourseCategoryComparator implements Comparator <Course>{

	@Override
	public int compare(Course o1, Course o2) {
		// TODO Auto-generated method stub
		return o1.categoryDescription.compareTo( o2.categoryDescription);
	}
}
