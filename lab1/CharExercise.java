import java.util.*;

public class CharExercise {

    public static void main (String[] argv)
    {
        char[] letters = {'f', 'a', 'c', 'e', 't', 'i', 'o', 'u', 's'};

        String s = "facetious";
        char[] letters2 = s.toCharArray ();

        char[] letters3 = new char [4];
        letters3[0] = 'f';
        letters3[1] = 'a';
        letters3[2] = 'c';
        letters3[3] = 'e';

        if ( checkEqual (letters, letters2) ) {
            System.out.println ( Arrays.toString(letters) + " = " + Arrays.toString(letters2) );
        }
        else {
            System.out.println ( Arrays.toString(letters) + " != " + Arrays.toString(letters2) );
        }

        if ( checkEqual (letters, letters3) ) {
            System.out.println ( Arrays.toString(letters) + " = " + Arrays.toString(letters3) );
        }
        else {
            System.out.println ( Arrays.toString(letters) + " != " + Arrays.toString(letters3) );
        }

    }

    // INSERT YOUR CODE HERE
	 static boolean checkEqual(char[]A, char[]B) {
		//checks if the lengths of the arrays are the same
		if (A.length !=  B.length) {
			return false;
		}
		//checks every element in A and B and if one of them is not the same, return false
		for (int i = 0; i<A.length; i++){
			if(A[i] != B[i]){
				return false;
			}
		}
		return true;
	}
}
