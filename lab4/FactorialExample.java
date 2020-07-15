public class FactorialExample {

    public static void main (String[] argv)
    {
        System.out.println ( "3! = " + factorial(3,0) );
        System.out.println ( "5! = " + factorial(5,0) );
        System.out.println ( "5! x 3! = " + (factorial(3,0) * factorial(5,0)) );
    }
    
    static int factorial (int n, int level) {
        System.out.println ( makeBlanks(level) + "Level " + level + ": n=" + n);
        int f;
        if (n == 1) {
            System.out.println ( makeBlanks(level) + "Level " + level + ": f=1");
            return 1;
        }
        f= n*factorial(n-1,level+1);
        System.out.println( makeBlanks(level) + "Level " + level + ": f=" + f);
        return f;
    }


    static String makeBlanks (int n) {
        //adds blanks
        String str = "";
        for (int i=0; i < n; i++) {
            str += "  ";
        }
        return str;
    }
}
