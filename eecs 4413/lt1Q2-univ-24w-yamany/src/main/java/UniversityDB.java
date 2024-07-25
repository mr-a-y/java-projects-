import java.util.ArrayList;



public class UniversityDB {
	ArrayList <University> list;
	
	public UniversityDB() {
		list = new ArrayList<>();
		list.add( new University("yorku", "York University", "Ontario", "Toronto") );
		list.add( new University("uoft", "University of Toronto", "Ontario", "Toronto") );
		list.add( new University("queens", "Queens Univerity", "Ontario", "Kingston") );
		list.add( new University("mcMaster", "McMaster University", "Ontario", "Hamilton") );
		
		list.add( new University("mcgill", "McGill University", "Quebec", "Montreal") );
		list.add( new University("uMontreal", "University de Montreal", "Quebec", "Montreal") );
		
		list.add( new University("umanitoba", "University of Manitoba", "Manitoba","Winnipeg" ) );
		list.add( new University("uwinnipeg", "University of Winnipe", "Manitoba","Winnipeg" ) );
		
		list.add( new University("ubc", "University of British Columbia", "British Columbia","Vancouver") );
		list.add( new University("sfu", "Simon Fraser University", "British Columbia","Vancouver" ) );
		 
			
		
	}
	
	// given an array of provinces, return a list of universities in the province 
	public ArrayList<University> search (String provinces[]){
		ArrayList<University> a = new ArrayList<>();
		for(String province : provinces) {
			for(University b :list) {
				if(b.province.equals(province)) {a.add(b);}
			}
		}	
			
			return a;
	}
	}
	
	 

