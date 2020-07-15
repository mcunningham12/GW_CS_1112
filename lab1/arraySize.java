import java.util.*;

public class arraySize {
	public static void main (String[] argv)
	{
		//Hard-coded size.
		int[] A = new int[5];
		System.out.println ("Array A has size " + A.length);

		//Use a variable, and assign the variable a value.
		int size = 6;
		int[] B = new int [size];
		System.out.println ("Array B has size " + B.length);

		//Have the size determinded elsewhere
		size = getSize ();
		int[] C = new int [size];
		System.out.println ("Array C has size " + C.length);

		int inf = 268435450;
		while (inf >0){
			inf = inf + 1; 
			int[] E = new int [inf];
			System.out.println("Array E has size " + E.length);
		}
	}

	static int getSize(){
		return 7;
	}
}
