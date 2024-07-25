import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry; 
import java.io.*;

public class ClientRMI {

    public static void main(String[] args) {
        try {
            InputStreamReader r = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(r);

            Registry registry = LocateRegistry.getRegistry("localhost", 2345);
            Processor stub = (Processor) registry.lookup("Process");
            System.out.println("Enter your String :");
            String in;

            while (!(in = br.readLine()).equals("stop")) {
                System.out.println("upper:\t" + stub.upper(in));
                System.out.println("sort:\t" + stub.sort(in));
                System.out.println("rever:\t" + stub.reverse(in));
                System.out.println("isPanl:\t" + stub.isPalindrome(in) + "\n");
                System.out.println("Enter your String:  ");
            }
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
