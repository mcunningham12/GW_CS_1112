public class Sum {

    public static void main (String[] argv)
    {
        int n = 3;
        int S = sum (n);
        System.out.println ("Sum 1 + ... + " + n + " = " + S);
        
        n = 10;
        S = sum (n);
        System.out.println ("Sum 1 + ... + " + n + " = " + S);
    }
    
    // INSERT YOUR CODE HERE.
    public static int sum(int n) {
        if (n>0) {
            return n+Sum.sum(n-1);
        } else {
            return 0;
        }
    }
}
