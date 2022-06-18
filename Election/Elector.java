/**
 * @author Anubhab
 */

// Importing necessary classes
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.io.BufferedReader;
import java.io.FileInputStream;

class Elector {		// Handles the presentation logic for the electors
	
	int voter_Id;
	private Registry registry;
	private Election stub;
	
	public Elector(int id) {
		try {
			// Getting the registry 
	        registry = LocateRegistry.getRegistry(null); 	   
	        // Looking up the registry for the remote object 
	        stub = (Election) registry.lookup("Election");
	        voter_Id = id;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void vote() {	// receives vote from keyboard and sends to remote server
		try {			 
	        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
	        System.out.print("VoterID = " + voter_Id + "\nVote for : ");
	        String vote = br.readLine();
	        stub.castVote(vote);		
		}
		catch(Exception e) {
			e.printStackTrace();
		}  
	}
	
	public void getResult() {	// receives and displays the result of election from remote server
		try {
			FileInputStream fis = new FileInputStream(stub.getResult());
			 
	        ObjectInputStream ois = new ObjectInputStream(fis);
	 
	        ResultHelper t2 = (ResultHelper)ois.readObject();	// deserialize the data
	        System.out.println("\nVoterID = " + voter_Id);
	        System.out.println(t2.candidate1 + " : " + t2.votesFor1 + "\t" + t2.candidate2 + " : " + t2.votesFor2);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}  