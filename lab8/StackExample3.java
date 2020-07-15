import java.util.*;

public class StackExample3 {

    public static void main (String[] argv)
    {
	String s = "!skrow tI";
	printReverse (s);
    }

    static void printReverse (String str)
    {
	    Stack<Character> charStack = new Stack<Character> ();
        int count = 0;
        while (count < str.length()){
            charStack.push(str.charAt(count));
            count++;
        }
        while (! charStack.isEmpty() ) {
            System.out.print(charStack.pop());
        }
    }
    
}
