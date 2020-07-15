
import java.util.*;

public class ParenBalancing {

    public static void main (String[] argv)
    {
	// Test 1.
	String s = "()(())()";
	checkParens (s);

	// Test 2.
	s = "((())";
	checkParens (s);

	// Test 3.
	s = ")(";
	checkParens (s);
    }

    static void checkParens (String inputStr)
    {
	// Extract letters from String.
	char[] letters = inputStr.toCharArray();

	// We'll need a Character stack.
	Stack<Character> stack = new Stack<Character> ();

	boolean unbalanced = false;

	for (int i=0; i<letters.length; i++) {
        if(letters[0] == ')') {
            unbalanced = true;
            break;
        }
	    if (letters[i] == '(') {
    		// Push left paren.
    		stack.push (letters[i]);
	    }
	    else if (letters[i] == ')') {
    		// Right paren: we should have a match on the stack.
    		char ch = stack.pop ();
    		if (ch != '(') {
    		    // Not a match.
    		    unbalanced = true;
	    	    break;
    		}
	    }

	} //end-for
	
	if ( (unbalanced) || (! stack.isEmpty()) ) {
	    System.out.println ("String " + inputStr + " has unbalanced parens");
	}
	else {
	    System.out.println ("String " + inputStr + " has balanced parens");	
	}

    }

}
