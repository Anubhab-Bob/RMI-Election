/**
 * @author Anubhab
 */
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


// Importing necessary classes
public class ElectionServer {  
	public static void main(String args[]){  
		if (args.length != 1) {
			System.out.println("Provide file name for storing result as argument!");
			return;
		}
		try{			
			Election stub = new RemoteElection(args[0].trim());
			
			// Binding the remote object (stub) in the registry 
	        Registry registry = LocateRegistry.getRegistry(); 
	         
	        registry.bind("Election", stub);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}  
	}  
} 