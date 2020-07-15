
public class Manhattan {

    public static int count = 0;

    public static void main (String[] argv)
    {
    for(int r = 1; r<=10; r++){
        int c=r;
        count=1;
        int n = countPaths (r, c);
 	    System.out.println ("r=" + r + " c=" + c + " => n=" + n);
        System.out.println ( "Total number of calls to countPaths: " + count);       
    }
}


    static int countPaths (int numRows, int numCols)
    {
	    // Bottom out case: there's only one way to (0,0). 
        // Note: it's || and not &&.
        // Increment count
	    count++;
        if ( (numRows == 0) || (numCols == 0) ) {
	        return 1;
	    }

	    // Otherwise, reduce to two sub-problems and add.
        int downCount = countPaths (numRows-1, numCols);
	    int rightCount = countPaths (numRows, numCols-1);
	    return (downCount + rightCount);
    }
}
