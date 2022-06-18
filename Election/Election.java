/**
 * @author Anubhab
 */

// Importing necessary classes
import java.rmi.*;

public interface Election extends Remote{
	public void castVote(String vote) throws RemoteException;
	public String getResult() throws RemoteException;
}

