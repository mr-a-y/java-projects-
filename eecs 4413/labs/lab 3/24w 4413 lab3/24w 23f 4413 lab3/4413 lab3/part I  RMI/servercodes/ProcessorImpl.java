import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.Arrays;

public class ProcessorImpl        implements Processor {
	// Implementations must have an explicit constructor
    	public ProcessorImpl() throws RemoteException {
		  super();
	    }
	 

        public String upper(String s) throws RemoteException
        {
          	return s.toUpperCase();
        }

        public String reverse(String s) throws RemoteException
        {
            String result="";
    		for(int i=s.length()-1; i>=0; i--) {
        		result = result + s.charAt(i);
    		}
	    return result;
        }

        public String sort(String s) throws RemoteException
        {
         	 char[] tempArray = s.toCharArray();
	      
	        // Sort the string S
	        Arrays.sort(tempArray);
	 
	     String result = String.valueOf(tempArray);

	return result;	 

        }

        public boolean isPalindrome(String s) throws RemoteException
        {
          
	 String result="";
	    for(int i=s.length()-1; i>=0; i--) {
	        result = result + s.charAt(i);
	    }


		return s.equals(result);
	}




}
