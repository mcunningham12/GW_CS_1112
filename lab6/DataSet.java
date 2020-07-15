
import java.util.*;

public class DataSet {

    // Name associated with the data.
    String name;

    // The data is just a list of strings.
    LinkedList<String> strings;



    // The toString() method for ease of printing.

    public String toString ()
    {
	String s = name + ": ";
	if (strings == null) {
	    return (s + "empty");
	}
	for (int i=0; i<strings.size(); i++) {
	    s += "\n  " + strings.get(i);
	}
	return s;
    }

}



