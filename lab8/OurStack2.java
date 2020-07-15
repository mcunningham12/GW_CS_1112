
import java.util.*;

public class OurStack2 {

    ArrayList<Character> array;
    int top;

    public OurStack2 ()
    {
    	// Can be unlimited in size now.
    	array = new ArrayList<Character>();
    	top = 0;
    }

    public void push (char ch)
    {
        array.add(ch);
        top++;
    }

    public char pop ()
    {
        // INSERT YOUR CODE
        top--;
        return array.get(top);
    }


    public boolean isEmpty ()
    {
        // INSERT YOUR CODE
        if(top == 0){
            return true;
        }
        return false;
    }

}
