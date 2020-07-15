
import java.util.*;

public class SetExample2 {

    public static void main (String[] argv)
    {
	LinkedList<String> favoriteShows1 = new LinkedList<String>();
	favoriteShows1.add ("Yes minister");
	favoriteShows1.add ("Seinfeld");
	favoriteShows1.add ("Cheers");
	favoriteShows1.add ("Frasier");
	favoriteShows1.add ("Simpsons");

	LinkedList<String> favoriteShows2 = new LinkedList<String>();
	favoriteShows2.add ("Mad about you");
	favoriteShows2.add ("Seinfeld");
	favoriteShows2.add ("Frasier");
	favoriteShows2.add ("Cosby show");

	computeUnion (favoriteShows1, favoriteShows2);
    }

    // INSERT YOUR CODE HERE.
    public static LinkedList<String> computeUnion(LinkedList<String> a, LinkedList<String> b){
        //make new linkedList
        LinkedList<String> c = new LinkedList<String>();
        //add all of the first LinkedList to the new one
        for (int i=0;i<a.size();i++) {
            c.add(a.get(i));
        }
        //add every element of the second LinkedList that is not
        //in the first one to the new one
        for (int j=0;j<b.size();j++){
            if (!(c.contains(b.get(j)))){
                c.add(b.get(j));
            }
        }
        //print the union
        System.out.println("Union: ");
        for(int k=0;k<c.size();k++){
            System.out.println(c.get(k));
        }
        return c;
    }

}
