/**
 * @author Anubhab
 */

// Importing necessary classes
public class ElectorsHandler {
	
	public static void main(String args[]){  
		if (args.length != 1) {
			System.out.println("Provide number of electors as argument!");
			return;
		}
		int electionSize = Integer.parseInt(args[0]);	// number of voters participating
		Elector electorObjects[] = new Elector[electionSize];
		// instantiate voters and make them vote
		for(int i = 0; i < electionSize; i++) {
			electorObjects[i] = new Elector(i+1);
			electorObjects[i].vote();
		}
		System.out.println("\n\nResults : \n\n");	// display election results
		for(int i = 0; i < electionSize; i++)
			electorObjects[i].getResult();
	}  
}

