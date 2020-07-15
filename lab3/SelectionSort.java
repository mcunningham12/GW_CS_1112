import java.util.*;

public class SelectionSort {

    public static void main (String[] argv)
    {
        int[] testData = makeRandomArray (100);
        
        System.out.println ("Before: " + Arrays.toString(testData));
        
	selectionSort (testData);

        System.out.println ("After: " + Arrays.toString(testData));
    }

    static void selectionSort (int[] A)
    {
    //add a counter    
    int count =0;
    // We don't need to find the n-th smallest, so stop at n-1.
	for (int i=0; i<A.length-1; i++) {

	    // Find i-th smallest and swap.
	    int smallest = A[i];
	    int pos = i;

            // Look from i+1 and up.
	    for (int j=i+1; j<A.length; j++) {
		count++;
        if (A[j] < smallest) {
		    smallest = A[j];
		    pos = j;
		}
	    }

	    // Swap into position i.
	    int temp = A[i];
	    A[i] = A[pos];
	    A[pos] = temp;

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
