package dao;

import java.util.List;

import model.Category;
import model.Course;

public interface CourseDAO {
 	
	public Course findCourseByCode(String keyWord);
	
	 
	
	 public List<Course> findCoursesByCategory(int categoryID) ;
	 
	

}
