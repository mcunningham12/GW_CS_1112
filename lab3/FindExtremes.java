
import java.util.*;

public class FindExtremes {
    static int indexL=0;
    static int indexS=0;
    public static void main (String[] argv)
    {
        // Fill an array with some random values - for testing.
        int[] testData = makeRandomArray (10);
	// Find largest and smallest elements.
	int smallest = findSmallest (testData);
	int largest = findLargest (testData);

        // Print.
	System.out.println ("Smallest=" + smallest + " at position " + indexS+ ", largest=" + largest + " at position " + indexL + " in array " + Arrays.toString(testData));

    }


    static int findSmallest (int[] A)
    {
        // Start by assuming first is smallest.
	int smallest = A[0];

        // Check against A[1], A[2] ... etc.
	for (int i=1; i<A.length; i++) {
	    if (A[i] < smallest) {
		smallest = A[i];
        indexS=i;
	    }
	}

	return smallest;
    }


    static int findLargest (int[] A)
    {
      // Similar to findSmallest except for if-condition.
	int largest = A[0];
	for (int i=1; i<A.length; i++) {
	    //inverse condition of findSmallest. if true, then swap and record index
        if (A[i] > largest) {
		largest = A[i];
        indexL = i;
	    }
	}

	return largest;
    }


    static int[] makeRandomArray (int length)
    {
        int[] A = new int [length];

	for (int i=0; i<A.length; i++) {
	    A[i] = UniformRandom.uniform (1, 100);
	}

        return A;
    }

}
