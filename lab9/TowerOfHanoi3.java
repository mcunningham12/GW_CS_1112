
public class TowerOfHanoi3 {

    private static int count = 0;

    public static void main (String[] argv)
    {
        // A 5-disk puzzle:
	    solveHanoi (4, 0, 1);
    }

    static void solveHanoi (int n, int i, int j)
    {
	    // Bottom-out.
	    if (n == 0) {
            // The smallest disk.
	        move (0, i, j);
	        return;
	    }

	    int k = other (i, j);
	    solveHanoi (n-1, i, k);    // Step 1.
	    move (n, i, j);            // Step 2.
	    solveHanoi (n-1, k, j);    // Step 3.
    }


    static void move (int n, int i, int j)
    {
        // INSERT YOUR CODE HERE.
        // Before printing, convert n=0 to 'A', n=1 to 'B' etc.
        
	//create character, convert it, and print out the day and the disk used
        char ch = (char) (n + 'A');
        System.out.println("Day " + count + " - use Disk " + ch);
        count++;
    }


    static int other (int i, int j)
    {
        return 3-(i+j);
    }

}
