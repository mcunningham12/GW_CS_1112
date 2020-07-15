
import java.util.*;

public class ParenBalancing4 {

    public static void main (String[] argv)
    {
	String s = "if ((x < y) && (Math.abs(x)>0)) { if(x==5) {x += 3;}}";
	checkParens (s);

	s = "I think (I mean thought (but do I really mean think?)) ...";
	checkParens (s);

	s = "if ((x < y) && (Math.abs(x)>0) { if(x==5) {x += 3;}";
	checkParens (s);

	s = "I think (I mean thought )but do I really mean think?)) ...";
	checkParens (s);
    }

    static void checkParens (String inputStr)
    {
        char[] letters = inputStr.toCharArray();
        Stack<Character> stack = new Stack<Character> ();
        boolean unbalanced = false;
        for (int i=0; i<letters.length; i++) {
 
            if ( (letters[i] == '(') || (letters[i] == '[')|| (letters[i] == '{')) {
                // Push every left paren of each kind.
                stack.push (letters[i]);
             }
             else if (letters[i] == ')') {
                // We should have a '(' match on the stack
                char ch = ')';
                if (! stack.isEmpty() ) {
                     ch = stack.pop ();
                }
                if (ch != '(') {
                     // Not matched ⇒ unbalanced.
                     unbalanced = true;
                     break;
                }
            }
            else if (letters[i] == ']') {
                // We should have a '[' match on the stack
                char ch = ']';
                if (! stack.isEmpty() ) {
                   ch = stack.pop ();
                }
                if (ch != '[') {
                    // Not matched.
                    unbalanced = true;
                    break;
                }
            }
            else if (letters[i] == '}') {
                // We should have a '{' match on the stack
                char ch = '}';
                if (! stack.isEmpty() ) {
                    ch = stack.pop();
                }
                if (ch != '{') {
                    // Not matched.
                    unbalanced = true;
                    break;
                }
            }
        } // end-for
        if ( (unbalanced) || (! stack.isEmpty()) ) {
            System.out.println ("String " + inputStr + " has unbalanced parens");
        }
        else {
            System.out.println ("String " + inputStr + " has balanced parens");
        }
    }
 }
