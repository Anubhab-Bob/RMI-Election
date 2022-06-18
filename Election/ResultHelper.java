/**
 * @author Anubhab
 */
// Importing necessary classes
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ResultHelper implements Externalizable {
	String candidate1;
	String candidate2;
	int votesFor1, votesFor2;
	
	public ResultHelper() {
		// default constructor
	}
	
	public ResultHelper(String c1, String c2, int v1, int v2) {
		candidate1 = c1;
		candidate2 = c2;
		votesFor1 = v1;
		votesFor2 = v2;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {	// write serialized data
		out.writeObject(candidate1);
        out.writeInt(votesFor1);
        out.writeObject(candidate2);
        out.writeInt(votesFor2);
		
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, 
			ClassNotFoundException {	// read searialized data
		candidate1 = (String)in.readObject();		 
        votesFor1 = in.readInt();
        candidate2 = (String)in.readObject();		 
        votesFor2 = in.readInt();
	}
}

