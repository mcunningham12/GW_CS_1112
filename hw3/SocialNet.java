/*-----------------------------------------------------------------------------
GWU CSCI1112 Fall 2019
author: Maxwell Cunningham

This class encapsulates the logic necessary to sort social networking data
based on differentials.
------------------------------------------------------------------------------*/
import java.awt.*;
import java.awt.image.*;
import java.lang.*;
import java.util.*;
import java.text.*;

public class SocialNet {
    //------------------------------------------------------------------------- 
    // Base Problems
    //------------------------------------------------------------------------- 
    /// A referential copy (shallow copy of each row) and not an element-wise 
    /// copy (deep copy).  We are sorting elements with respect to the original
    /// data rather than generating a new set of data.
    /// @param posts data containing the rows to reference
    /// @return the shallow copy of rows
    public static int[][] createView(int[][] posts) {
        // TODO : Implement Here
        int[][]a = new int[posts.length][];
        for (int i =0;i<posts.length;i++){
            a[i]=posts[i];
        }
        return a;
    }
 
    //------------------------------------------------------------------------- 
    /// Compute the differential between "ups" (at index 1) and "downs" 
    /// (at index 2). The differential is not maintained in the data but is a 
    /// virtual field derived by the calculation performed here
    public static int differential(int[] post) {
        int d=0;
        d = post[1]-post[2];
        return d;
    }

    //------------------------------------------------------------------------- 
    /// Performs a comparison between two posts that is equivalent to a less
    /// than operation so that a sort can use this function to order posts.
    /// The less than criteria is an evaluation between the differentials of
    /// two posts.
    /// @param post1 a post record that is used as the "left" operand for a
    ///        less than comparison 
    /// @param post2 a post record that is used as the "right" operand for a
    ///        less than comparison 
    /// @return returns true if the computed differential for post1 is less than
    ///         the computed differential for post2; otherwise, returns false 
    ///         (false implies that differential for post1 is greater than or
    ///         equal to post2)
    public static boolean lessThan(int[] post1, int[] post2) {
        // TODO : Implement Here
        int a=SocialNet.differential(post1);
        int b=SocialNet.differential(post2);
        if (a<b) {
            return true;
        }
        return false;
    }
    //------------------------------------------------------------------------- 
    /// Swaps references to posts.  Note that this is a "shallow" swap and not 
    /// a "deep" swap
    /// @param view A shallow copy of a set of posts 
    /// @param i the index of the first reference to swap
    /// @param j the index of the second reference to swap
    public static void swapPosts(int[][] view, int i, int j) {
        // TODO : Implement Here
        int[] temp = view[i];
        view[i]=view[j];
        view[j]=temp;
    }

    //------------------------------------------------------------------------- 
    /// Sorts (shallow) a set of references to posts in descending order 
    /// subject to the differential between ups and downs using one of
    /// the iterative sorts we discussed in class, i.e. selection, bubble, or 
    /// insertion sort
    /// @param view A shallow copy of a set of posts 
    /// @return a set of profile information containing a count of 
    ///         0: allocations, 1:comparisons, and 2: swaps
    public static int[] iterativeSort(int[][] view) {
        // profile[0:allocs (ignore profile), 1:comparisons, 2:swaps]
        if (view == null) {
            return null;
        }
        int alloc=0;
        int comp=0;
        int swap=0;
        int largest;
        int pos;
        //in relation to alloc, comp, swap, largest, pos, and i
	alloc+=6;
	    for (int i=0; i<view.length-1; i++) {
                // Find smallest and swap
	        largest = SocialNet.differential(view[i]);
	        pos = i;
           	//check if any elements after i have a greater differential
            	for (int j=i+1; j<view.length; j++) {
                	comp++;
                	//this gives a very high number, but is less than n^2
                	//n^2 is 100 million and I got 49 million comparisons
                	//this is roughly n^2/2
                	if (SocialNet.differential(view[j]) > largest) {
                            largest = SocialNet.differential(view[j]);
		            pos = j;
		        }
	        }
                //swap into i-th position
	        if (largest != SocialNet.differential(view[i])){
                	SocialNet.swapPosts(view,i,pos);
                	swap++;
                	//there are roughly n swaps because I implemented selection sort
	        }
        }
        //adding an allocation for j
        alloc++;
        int[]b = new int[]{alloc,comp,swap};
        return b;
    }

    //------------------------------------------------------------------------- 
    // Extension Problems
    //------------------------------------------------------------------------- 
    /// Sorts (shallow) a set of references to posts in descending order 
    /// subject to the differential between ups and downs using a recursive
    /// approach, i.e. quicksort.
    /// @param view A shallow copy of a set of posts 
    /// @return a set of profile information containing a count of 
    ///         0: allocations, 1:comparisons, and 2: swaps
    static int a=0;
    static int c=0;
    static int s=0;
    //these counter variables are stored in global 
    //so they can traverse multiple methods
    public static int[] recursiveSort(int[][] view) {
        // profile[0:allocs (ignore profile), 1:comparisons, 2:swaps]
        if (view == null || view.length == 0) {
            return null;
        }
        sortRecursive (view, 0, view.length-1);
        int[] profile = new int[]{a,c,s};
        //add an allocation for profile, a, c, and s
        a+=4;
        return profile;
    }

    static void sortRecursive (int[][] view, int left, int right) {
        if (left < right) {
            // Partition to find the "right place" for the leftmost element.
            int partitionPosition = sortPartition (view, left, right);
            //allocation of partition position needs to be counted
            a++;
            // left side recursion
            sortRecursive (view, left, partitionPosition-1);
            // right side recursion
            sortRecursive (view, partitionPosition+1, right);
        }
    }
    
    static int sortPartition (int[][] view, int left, int right) {
        if (left == right){
            return left;
        }
        int currentSwapPosition = right; 
        //in relation to currentSwapPosition and i
        a+=2;
        for (int i=right-1; i>=left; i--) {
            // check between left and right-1 inclusive.
            c++;
            if (!(SocialNet.lessThan(view[right],view[i]))) {
                // Switch with swap position
                currentSwapPosition--;
                SocialNet.swapPosts(view, currentSwapPosition, i);
                s++;
                // Shift swap position rightwards:
            }
        }
        SocialNet.swapPosts(view, currentSwapPosition, right);
        s++;
        return currentSwapPosition;
    }
}

//the allocation number is very high for the recursive sort 
//because it reallocates i and currentSwapPosition every time sortPartition is called//while this is certainly not ideal, I could not find a better way
