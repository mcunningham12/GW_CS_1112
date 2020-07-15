public class Difference {

    public static void main(String[] args) {

        for (int i = 10; i<= 100; i+=10){
            System.out.println(i + "^4 = " + fourthPower(i));
            System.out.println("2^" + i + "=" +  exponent(2,i));
            double ratio = (double) fourthPower(i)/exponent(2,i);
            System.out.println("ratio: " + ratio);
        }
    }
    
    public static int fourthPower(int i){
        return i*i*i*i;
    }

    public static int exponent(int a, int b){
        int x;
        if (b == 0){
            return 1;
        }
        else {
            x = a*exponent(a,b-1);
        }
        return x;
    }

}
