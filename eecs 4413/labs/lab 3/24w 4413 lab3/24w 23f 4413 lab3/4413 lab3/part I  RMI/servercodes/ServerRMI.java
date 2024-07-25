import java.rmi.registry.Registry; 
import java.rmi.registry.LocateRegistry;  
import java.rmi.RemoteException; 
import java.rmi.server.UnicastRemoteObject; 

public class ServerRMI {
    public static void main(String args[]) {

	try {

	int port = 2345;
	System.out.println("Server ready at port" +port );
	

	ProcessorImpl c = new ProcessorImpl();
	Processor stub = (Processor)UnicastRemoteObject.exportObject(c,0);

	Registry registry = LocateRegistry.getRegistry(port);
	registry.rebind("Process", c);

	   }
	
	catch (Exception e){
	   System.out.println("Trouble : " + e);
	}


  }

}
