
public class DuplicateDetection {

    public static void main (String[] argv)
    {
        // Make a large array and test.
        int[] X = makeData (10000);
    	detectDuplicates (X);

        // We'll do this for data sizes of 10K, 30K, 50K, 70K and 90K.
        X = makeData (30000);
    	detectDuplicates (X);

        X = makeData (50000);
    	detectDuplicates (X);

        X = makeData (70000);
    	detectDuplicates (X);

        X = makeData (90000);
    	detectDuplicates (X);
    }


    static void detectDuplicates (int[] A)
    {
	// Check for duplicates.
	long startTime = System.currentTimeMillis();
    boolean dupExists = false;
	for (int i=0; i<A.length; i++) {
	    for (int j=i+1; j<A.length; j++) {
		    if ( (i != j) && (A[i] == A[j]) ) {
		        // Duplicates exist.
                dupExists = true;
		    }
	    }
	}
	double timeTaken = System.currentTimeMillis() - startTime;
	System.out.println ("Time taken for size=" + A.length + ": " + timeTaken);
    double propConst = timeTaken/(A.length*A.length);
    System.out.println("Constant of proportionality: " + propConst);    

    }


    static int[] makeData (int size)
    {
	int[] A = new int [size];
	for (int i=0; i<A.length; i++) {
	    A[i] = i;
	}
        return A;
    }

}
