import java.util.*;

public class InsertionSort4 {

    public static void main (String[] argv)
    {
        int[] testData = {51, 24, 63, 73, 42, 85, 71, 41, 87, 32};
        
        System.out.println ("Before: " + Arrays.toString(testData));
        
	insertionSort (testData);

        System.out.println ("After: " + Arrays.toString(testData));
    }

    static void insertionSort (int[] A)
    {
	for (int i=0; i<A.length; i++) {

            for (int j=i; (j>0) && (A[j]<A[j-1]); j--) {
                int temp = A[j];
                A[j] = A[j-1];
                A[j-1] = temp;
            }
            
	}

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
