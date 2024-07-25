package restService;

import java.util.HashMap;
import java.util.List;

//import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
 


import model.University;
import model.UniversityDB;

 

//this class is a simple implementation of a REST service
 

public class UnivServiceFront {

	 
	UniversityDB univDao;

	public UnivServiceFront() {
		this.univDao = new UniversityDB();
	}

	
	/* GET all the universities */
	// by  GET   /rest/Univ
	// return the collection of universities as JSON
	
	public List<University>  getAllUniversities() {
		//... 
		return null;
	}
	
	
	/* GET all the provinces */
	// by  GET   /rest/Univ/provinces
	// return the collection of provinces, as JSON
	
	public List<String> getProvinceNames() {
		//... 
		return null;
	}
	
	
	// search university by code
	// by GET    /rest/Univ/searchByCode/searchCode
	// return the university, as JSON
			
  	 public University getUnivByCode(        ) { 
  		//... 
 		return null;
  	 }
  	  
  	// search university by provinces
	// by GET  /rest/Univ/searchByProvince/provinceName
  	// return the list of universities, as JSON  
	 
  	 public List<University> getUnivByPrivince(             ) { 
  		//... 
 		return null;
	 }
  	 
  	
  	// add a university by url parameter
	// by POST   /rest/Univ?code=XX&name=yy&province=pp&city=cc
	
	public void createUniv(                      ) {
		 ;
	}
  	
	// delete a university by code
	// by DEETE   /rest/Univ/code
	 
	public void deleteUniv(@PathParam("code") String id) {
		 ;
	}


}
