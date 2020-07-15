public class PrintPattern {

    public static void main (String[] argv)
    {
        printPattern (5);
	System.out.println("");
        printPattern (7);
    }
    
    static void printPattern (int N)
    {
        for (int i = 0; i < N; i++) {
		for (int j = i+1; j> 0; j--) {
			System.out.print(j);
			if (j>1){
				System.out.print(" ");
			} 
		}
		System.out.println(" ");
	  }	
    }
}
