package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import model.Category;
import model.Course;

public class CourseDAOImpl implements CourseDAO {

	
	static ServletContext context;
	
	
	public CourseDAOImpl (ServletContext cont) {
	 context = cont;
	}
	
	public CourseDAOImpl () {
		 ;
	}
	
	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException ex) {
		}
	}

	private Connection getConnection() throws SQLException {
		
		String absP = context.getRealPath("/lt2_Courses.db"); 
		return DriverManager.getConnection("jdbc:sqlite:" + absP);
	}

	private void closeConnection(Connection connection) {
		if (connection == null)
			return;
		try {
			connection.close();
		} catch (SQLException ex) {
		}
	}

	
	// find courses of given category, from the database
	// hint: you may need to do inner join of two tables.
	  public List<Course> findCoursesByCategory(int categoryID) { 
		List<Course> result = new ArrayList<Course>(); 
		String sqlCourse = "SELECT * FROM course WHERE categoryID = ?";
        String sqlCategory = "SELECT * FROM category WHERE ID = ?";
	
	  
	    //. ...
		try (Connection con = this.getConnection();
	             PreparedStatement psCourse = con.prepareStatement(sqlCourse);
	             PreparedStatement psCategory = con.prepareStatement(sqlCategory)){
			psCourse.setInt(1, categoryID);
            ResultSet rsCourse = psCourse.executeQuery();

            psCategory.setInt(1, categoryID);
            ResultSet rsCategory = psCategory.executeQuery();
            rsCategory.next();
            String desc = rsCategory.getString("description");

            while (rsCourse.next()) {
                String code = rsCourse.getString("code");
                String title = rsCourse.getString("title");
                String sections = rsCourse.getString("sections");

                Course course = new Course(code, title, categoryID);
                course.setCategoryDescription(desc);
                course.setSelectedSection(sections);
                result.add(course);	
			}
			
			
		} catch (SQLException ex1) {
			ex1.printStackTrace();
		} finally {
			
		}
		return result;}
	
	  
     //find course of given course code, from the database
	  public Course findCourseByCode(String cod) { 
	        String sqlCourse = "SELECT * FROM course WHERE code = ?";
	        String sqlCategory = "SELECT * FROM category WHERE ID = ?";
			try (Connection con = this.getConnection();
		             PreparedStatement psCourse = con.prepareStatement(sqlCourse);
		             PreparedStatement psCategory = con.prepareStatement(sqlCategory))
			
			{
				psCourse.setString(1, cod);
	            ResultSet rsCourse = psCourse.executeQuery();
	            if (rsCourse.next()) {
	                String title = rsCourse.getString("title");
	                String sections = rsCourse.getString("sections");
	                int categoryID = rsCourse.getInt("categoryID");

	                Course course = new Course(cod, title, categoryID);

	                psCategory.setInt(1, categoryID);
	                ResultSet rsCategory = psCategory.executeQuery();
	                if (rsCategory.next()) {
	                    String desc = rsCategory.getString("description");
	                    course.setCategoryDescription(desc);
	                }
	                course.setSelectedSection(sections);
	                return course;
	            }
				
			} catch (SQLException ex) {
				ex.printStackTrace();
			} 
			return null;
			
		}
	 

}