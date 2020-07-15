public class OurSortedLinkedListExample {

    public static void main (String[] argv)
    {
        OurSortedLinkedList intList = new OurSortedLinkedList();

        // Put 10 integers.
        for (int k=0; k<10; k++) {
            intList.add (k);
            intList.printWithAddresses();
            System.out.println();
        }
        
        int M = 5;
        if ( intList.contains(M) ) {
            System.out.println ("List contains " + M);
        }

    }
    
}
