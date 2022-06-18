/**
 * @author Anubhab
 */

// Importing necessary classes
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.rmi.*;  
import java.rmi.server.*; 

public class RemoteElection extends UnicastRemoteObject implements Election {  
	
	private static final long serialVersionUID = 1L;
	private static int Smith_Votes;
	private static int Jones_Votes;
	private String resultFile;
	
	RemoteElection(String fileName) throws RemoteException{
		super();
		Smith_Votes = 0;
		Jones_Votes = 0;
		resultFile = fileName;
	}  
	
	public void castVote(String vote)	{	// handles each vote casted
		System.out.println("Voted for : " + vote);
		if(vote.equalsIgnoreCase("Smith")) {
			RemoteElection.Smith_Votes++;
		}
		else if (vote.equalsIgnoreCase("Jones")) {
			RemoteElection.Jones_Votes++;
		}
		else {
			System.out.println("Invalid vote!");
		}
		// display current standings
		System.out.println(RemoteElection.Smith_Votes + " " + RemoteElection.Jones_Votes);
	}  
	
	public String getResult() {	// serializes the result into a file
		try {
			ResultHelper t1 = new ResultHelper("Smith", "Jones", Smith_Votes, Jones_Votes);			
			 
	        // Serialization of object
	        FileOutputStream fos = new FileOutputStream(resultFile);
	 
	        ObjectOutputStream oos = new ObjectOutputStream(fos);
	 
	        oos.writeObject(t1);
	        oos.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return resultFile;
	}
}  