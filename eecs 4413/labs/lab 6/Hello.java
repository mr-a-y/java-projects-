package rest;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/hello")
public class Hello {
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String sayPlainTextHello() {
    return "Hello Jersey Plain ";
  }
  // This method is called if XML is request
  @GET
  @Produces(MediaType.TEXT_XML)
  public String sayXMLHello() {
    return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey xml" + "</hello>";
  }

  // This method is called if HTML is request
	
   @GET
   @Produces(MediaType.TEXT_HTML) 
   public String sayHtmlHello() {
	  System.out.println("in-html"); 
	  return "<html> " + "<title>" + "Hello Jersey"
	  + "</title>" + "<body><h1>" + "Hello Jersey HTML " +
	  "</h1></body>" + "</html> "; 
	}
	 
  
  
//This method is called if HTML is request
 @GET
 @Produces(MediaType.APPLICATION_JSON)
 public String sayJHello() { System.out.println("json");
   return "should be a JSON";
 }
 
 @POST
 @Produces(MediaType.TEXT_HTML) 
 public String sayPOSTHello() {
	  System.out.println("in-html"); 
	  return "<html> " + "<title>" + "Hello Jersey"
	  + "</title>" + "<body><h1>" + "POST.  should update resource" +
	  "</h1></body>" + "</html> "; 
	}

} 