
import java.util.*;

public class TreeExample2 {

  public static void main (String[] argv)
  {
      // Make instances of a linked-list and a tree.
      LinkedList<Integer> intList = new LinkedList<Integer> ();
      TreeSet<Integer> intTree = new TreeSet<Integer> ();
    
      // Number of items in each set.
      int collectionSize = 100000;

      // How much searching to do.
      int searchSize = 1000;

      // Generate random data and place same data in each data structure.
      int intRange = 1000000;
      for (int i=0; i<collectionSize; i++) {
          int randInt = UniformRandom.uniform (1, intRange);
          intList.add (randInt);
          intTree.add (randInt);
      }
    
      // Now generate some random search terms.
      int[] searchTerms = new int [searchSize];
      for (int i=0; i<searchSize; i++) {
          searchTerms[i] = UniformRandom.uniform (1, intRange);
      }
    
      // First, perform search in tree and time it (see how long it takes).
      long startTime = System.currentTimeMillis ();
      int numFound = 0;
      for (int i=0; i<searchSize; i++) {
          if (intTree.contains (searchTerms[i])) {
              numFound ++;
          }
      }
      long endTime = System.currentTimeMillis ();
      long timeTaken = endTime - startTime;
      System.out.println ("Tree: numFound=" + numFound + " timetaken=" + timeTaken);

      // Now perform search in linked-list and see how long it takes.
      startTime = System.currentTimeMillis ();

      // INSERT YOUR CODE HERE
      int numFound1 = 0;
      for (int i=0; i<searchSize; i++) {
          if (intList.contains (searchTerms[i])) {
              numFound1 ++;
          }
      }
      endTime = System.currentTimeMillis ();
      timeTaken = endTime - startTime;
      System.out.println ("List: numFound=" + numFound + " timetaken=" + timeTaken);
  }
  
}
