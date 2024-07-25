package model;
import java.util.ArrayList;
import java.util.Iterator;

//import restService.Plant;

public class UniversityDB {
	static ArrayList <University> list;
	
	static {
		list = new ArrayList<>();
		list.add( new University("yorku", "York University", "Ontario", "Toronto") );
		list.add( new University("uoft", "University of Toronto", "Ontario", "Toronto") );
		list.add( new University("queens", "Quees Univerity", "Ontario", "Kingston") );
		list.add( new University("mcMaster", "McMaster University", "Ontario", "Hamilton") );
		
		list.add( new University("mcgill", "McGill University", "Quebec", "Montreal") );
		list.add( new University("uMontreal", "University de Montreal", "Quebec", "Montreal") );
		
		list.add( new University("umanitoba", "University of Manitoba", "Manitoba","Winnipeg" ) );
		list.add( new University("uwinnipeg", "University of Winnipe", "Manitoba","Winnipeg" ) );
		
		list.add( new University("ubc", "University of British Columbia", "British Columbia","Vancouver") );
		list.add( new University("sfu", "Simon Fraser University", "British Columbia","Vancouver" ) );
		 
		// add some dummy univ for testing delete	
		list.add( new University("dummy1", "Dummy1 Univerity", "Ontario", "Simco") );
		list.add( new University("dummy2", "Dummy2 University", "Ontario", "Barrie") );
	}
	
	public UniversityDB() {}


	public University searchByCode (String id){
		for (University u:list) {
			if (u.code.equals(id) )
				return u;
		
		}
		return null;
		
	}
	
	public  ArrayList<University> getAll (){
		return this.list;
	}
	
	public ArrayList<University> searchByProvince (String provin){
		ArrayList<University> resu=new ArrayList<>();
		for (University u: this.list) {
				//String id=
			if (u.getProvince().equals(provin))
				resu.add(u);
		}
		
		return resu;
	}
	
	
	/* to be completed */
	// return all distinct provinces in the system
	public  ArrayList<String> getAllProvince (){
		ArrayList<String> prvs = new ArrayList();
		
		return prvs;
	}
	
	
	/* to be completed */
	// add a new university to the system
	public void addUniversity (String code, String name, String province, String city) {
		 list.add(new University(code, name, province, city));

	}
	
	
	/* to be completed*/
	// remove the univeristy by code
	public void removeUniversity(String code) {
        Iterator<University> iterator = list.iterator();
        while (iterator.hasNext()) {
            University u = iterator.next();
            if (u.code.equals(code)) {
                iterator.remove();
                break;
            }
        }
	}

}