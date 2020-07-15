
import java.util.*;

public class TowerOfHanoi2 {

    // stacks[0], stacks[1] and stacks[2] are the three stacks.
    static Stack<Integer>[] towers;

    static int count;

    public static void main (String[] argv)
    {
        // A 3-disk puzzle:
        count=0;
        System.out.println ("3-Disk solution: ");
    	solveHanoi (2, 0, 1);
        System.out.println("Count: " + count);
        // A 4-disk puzzle:
        count=0;
        System.out.println ("4-Disk solution: ");
    	solveHanoi (3, 0, 1);
        System.out.println("Count: " + count);
    }


    static void solveHanoi (int n, int i, int j)
    {
        // Create the three stacks.
    	towers = new Stack [3];
    	for (int k=0; k<3; k++) {
    	    towers[k] = new Stack<Integer>();
    	}

        // Put disks 0,...,n on stack 0.
    	for (int k=n; k>=0; k--) {
    	    towers[0].add (k);
    	}

        // Print the initial stack.
    	printTowers ();

        // Now solve recursively. Note: this is the method below.
    	solveHanoiRecursive (n, i, j);
    }
    

    static void solveHanoiRecursive (int n, int i, int j)
    {
    	// Bottom-out.
    	if (n == 0) {
            count++;
    	    move (0, i, j);
    	    return;
    	}
    	int k = other (i, j);
    	solveHanoiRecursive (n-1, i, k);   // Step 1.
        count++;
    	move (n, i, j);                    // Step 2.
    	solveHanoiRecursive (n-1, k, j);   // Step 3.
    }


    static void move (int n, int i, int j)
    {
        // Pull out the top disk on stack i.
    	int topVal = towers[i].pop();
        // Put it on stack j.
    	towers[j].push (topVal);
        // Print status.
        System.out.println ("Towers after moving " + n + " from tower " + i + " to tower " + j);
    	printTowers ();
    }


    static int other (int i, int j)
    {
       return 3-(i+j);
    }


    static void printTowers ()
    {
    	for (int i=0; i<towers.length; i++) {
    	    System.out.print ("Tower " + i + ": ");
    	    if ( ! towers[i].isEmpty() ) {
        		for (Integer I: towers[i]) {
    		    System.out.print (" " + I);
        		}
	        }
	        System.out.println ();
    	}
    }

}
