import java.util.*;

public class LargestAtBack {

    public static void main (String[] argv)
    {
        // Some test data (a subset of Java's reserved words).
	String[] reservedWords = {"if", "else", "while", "do", "return", 
				  "true", "false", "instanceof", "class"};
        
        System.out.println ( "Before: " + Arrays.toString(reservedWords) );

	largestAtBack (reservedWords);

        System.out.println ( "After: " + Arrays.toString(reservedWords) );
    }
 
 static void largestAtBack (String[] A) {
    // Start by assuming first is largest
    String largest = A[0];
    // Record position of largest string
    int pos = 0;
    // Check against A[1], A[2] ... etc.
    for (int i=1; i < A.length; i++) {
        if (A[i].length()>largest.length()) {
            largest = A[i];
            pos = i;
        }
    }
     // Swap with what's in back
     String temp = A[A.length-1];
     A[A.length-1] = A[pos];
     A[pos] = temp;
 }

   
}
