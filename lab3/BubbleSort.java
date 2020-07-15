
import java.util.*;

public class BubbleSort {

    public static void main (String[] argv)
    {
        int[] testData = makeRandomArray (70);
        
        System.out.println ("Before: " + Arrays.toString(testData));
        
	bubbleSort (testData);

        System.out.println ("After: " + Arrays.toString(testData));
    }

    static void bubbleSort (int[] A)
    {
    //add counter
    int count=0;
    // Each sweep, i=0...n-1, will put the i-th least element in place.
	for (int i=0; i<A.length-1; i++) {

            // Perform swaps from end-of-array down to i-th position.
	    for (int j=A.length-1; j>i; j--) {
            count++;
		if (A[j] < A[j-1]) {
                    // Out of order: swap needed.
		    int temp = A[j];
		    A[j] = A[j-1];
		    A[j-1] = temp;
		}

	    }
	}
    System.out.println("Count: " + count);
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
