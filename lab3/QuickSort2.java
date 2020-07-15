
import java.util.*;

public class QuickSort2 {

    //make the count a global variable
    static int count=0;

    public static void main (String[] argv)
    {
        int[] testData = makeRandomArray (100);
        
        System.out.println ("Before: " + Arrays.toString(testData));
        
	quickSort (testData);
        System.out.println(count);
        System.out.println ("After: " + Arrays.toString(testData));
    }


    static void quickSort (int[] A)
    {
        quickSortRecursive (A, 0, A.length-1);
    }
    

    static void quickSortRecursive (int[] data, int left, int right)
    {
        if (left < right) {
            // Partition to find the "right place" for the leftmost element.
            int partitionPosition = quickSortPartition (data, left, right);
            // Recurse on the left side:
            quickSortRecursive (data, left, partitionPosition-1);
            // Recurse on the right side:
            quickSortRecursive (data, partitionPosition+1, right);
        }
        // Else: left==right so we're done.
    }


    static int quickSortPartition (int[] data, int left, int right)
    {
        if (left == right)
            return left;
        int partitionElement = data[right];
        int currentSwapPosition = right; 
        for (int i=right-1; i>=left; i--) {
            // Examine everything between left and right-1 inclusive.
            //this is where the comparisons occur
            count++;
            if (data[i] > partitionElement) {
                // Switch with swap position
                currentSwapPosition--;
                swap (data, currentSwapPosition, i);
                // Shift swap position rightwards:
            }
        }
        // Last one:
        swap (data, currentSwapPosition, right);
        return currentSwapPosition;
    }


    static void swap (int[] data, int i, int j)
    {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
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

