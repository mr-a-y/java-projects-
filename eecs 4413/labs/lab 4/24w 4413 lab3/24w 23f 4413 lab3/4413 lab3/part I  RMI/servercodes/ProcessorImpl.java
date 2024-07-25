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
          ...
        }

        public String reverse(String s) throws RemoteException
        {
          ...
        }

        public String sort(String s) throws RemoteException
        {
          ....
        }

        public boolean isPalindrome(String s) throws RemoteException
        {
          ...




}
