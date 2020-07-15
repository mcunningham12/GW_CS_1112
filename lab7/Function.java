public class Function {

    public static void main(String[] args) {

    int x = 1;
    double B = 4*x*x*x;
    double A = (3*x*x*x)+(5*x*x)+100*x;
    while (B < A) {
        x++;
        B = 4*x*x*x;
        A = (3*x*x*x)+(5*x*x)+100*x;
    }
    System.out.println("function passes at: " + x);
    }
}
