public class Log {

    public static void main (String[] argv)
    {
        int K = 64;
        System.out.println ("K=" + K + " log2(K)=" + log2(K));

        K = 1024;
        System.out.println ("K=" + K + " log2(K)=" + log2(K));

        K = 1000;
        System.out.println ("K=" + K + " log2(K)=" + log2(K));
    }

    static int log2(int k) {
        int a = 2;
        int c = 1;
        while (a<k) {
            a=a*2;
            c++;
        }
        return c;
    }
}
