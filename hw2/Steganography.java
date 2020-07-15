/*-----------------------------------------------------------------------------
GWU CSCI1112 Spring 2020
author: Maxwell Cunningham

This class encapsulates the logic necessary to perform simple steganography 
cyphering.
------------------------------------------------------------------------------*/
import java.awt.*;
import java.awt.image.*;
import java.lang.*;
import java.util.*;

public class Steganography {

    //------------------------------------------------------------------------- 
    // Base Problems
    //------------------------------------------------------------------------- 
    /// Performs a deep copy of the input pixels and returns the copy
    /// @param pixels the pixels from an image to copy
    /// @return the deep copy of the pixels that were copied
    public static int[][][] copy(int[][][] pixels) {
        
        int numRows = pixels.length;
        int numCols = pixels[0].length;

        // Make array of exactly the same size.
        int[][][] copied = new int [numRows][numCols][4];

        for(int i=0;i<numRows;i++){
            for(int j=0;j<numCols;j++){
               //do a deep copy of each element
               copied[i][j][0] = pixels[i][j][0];
               copied[i][j][1] = pixels[i][j][1];
               copied[i][j][2] = pixels[i][j][2];
               copied[i][j][3] = pixels[i][j][3]; 
            }
        }        
        return copied;  // change as needed
    }

    //------------------------------------------------------------------------- 
    /// Computes the error in the individual color channels (RGB only) between 
    /// a pixel in the key image and a pixel in the cypher image.  The pixels
    /// must be valid before attempting to carry out these operations.
    /// @param pxkey An array containing ARGB values that represents a pixel
    ///        in the key image    
    /// @param pxcypher An array containing ARGB values that represents a 
    ///        pixel in the cypher image
    /// @return An array containing the error (positive values only) between 
    ///         the RGB channels of the input pixels. 
    public static int[] colorError( int[] pxkey, int[] pxcypher ) {
        //null check
        if (pxkey == null || pxcypher == null) {
            return null;
        }
        //length check
        if (pxkey.length != pxcypher.length) {
            return null;
        }
        int[] e = new int[pxkey.length-1];
        for (int i=0; i<e.length;i++) {
            //check is ARGB values are appropriate
            if (pxkey[i]<0 || pxkey[i]>255){
                return null;
            }
            if (pxcypher[i]<0 || pxcypher[i]>255) {
                return null;
            }
            //put difference of respective elements into an array
            e[i] = Math.abs(pxkey[i]-pxcypher[i]);
        }
        return e;  // change as needed
    }

    //------------------------------------------------------------------------- 
    /// Computes the RGB error based on the position of a character in the 
    /// alphabet.  The error is represented using the same value in each
    /// cell of the array.
    /// @param chpos The characters ordinal position in the alphabet
    /// @return an array of three values that represents the error to introduce
    ///         into to a color 
    public static int[] positionToError( int chpos ) {
        //create a new array of size 3
        int[] p = new int[3];
        //offset the base 0 system so errors are from 1 to 26 instead of 0 to 25
        int error = chpos+1;
        //check if error is between 1 and 26
        //if so, add error to each value in the array
        if (error>0 && error<27) {
            p[0]=error;
            p[1]=error;
            p[2]=error; 
            return p;
        }
        return p;
    }

    //------------------------------------------------------------------------- 
    /// Computes the ordinal position of a character based on the error uniform
    /// represented in all cells in an input array of three values.
    /// @param error An array of RGB values (Note that this excludes the alpha 
    ///        channel).  
    /// @return The ordinal position of a character in the alphabet based on
    ///         the amount of error in the input 
    public static int errorToPosition( int[] error ) {
        //make sure the array can represent a letter
        if (error == null) {
            return -1;
        }
        //make sure values are the same
        for (int i=1;i<error.length;i++){
            if (error[i] != error[i-1]) {
                return -1;
            }
        }
        //account for base 0 system
        int x = error[0] - 1;
        return x;
    }

    //------------------------------------------------------------------------- 
    /// Encrypts a string of characters into a copy of the key image
    /// @input s the string of characters to encrypt
    /// @input key the image to encrypt the string into
    /// @return the encrypted image
    public static int[][][] encrypt(String s, int[][][] key) {
        //TODO: FILL IN YOUR CODE HERE

        // NOTE: The approach used in this algorithm reflects the requirements;
        // however, this approach is very simple and can more easily be detected
        // than a more sophisticated approach.  I would like to encourage 
        // students to be more sophisticated, but I am not requiring it.  If a 
        // student goes beyond the requirements by say encoding using a 
        // fibonacci sequence rather than the 10 pixel offset, they should not
        // be penalized.  We are also using a very simple encoding in the pixel
        // itself, adding the same value to all channels.  The more 
        // sophisticated approach would be to distribute the difference over all
        // the channels so that the change in color is much smaller.

        // copy the key image into the cypher image.  must copy at the
        // color channel level; otherwise, the original is modified by encoding

        // NOTE: this implementation always subtracts which means we assume that
        // the image is essentially white.  If the image was black, this 
        // approach would corrupt the image (values would go negative).  The
        // decryption only cares about the difference between cyphered and key
        // pixels, so encoding can be more sophisticated by adding or 
        // subtracting depending on whether the operation stays inside the legal
        // range of color values [0,255].  This implementation represents the
        // minimum work necessary, but the implementation is allowed to be more
        // robust.

        // iterate over the image and encode the current pixel with the current
        // numerical value
        
        //make a copy of the image to encrypt
        int[][][] imNew = Steganography.copy(key);
        if (imNew == null) {
            return null;
        }
        //turn all of the characters in the string to integers that can be easily accessed
        s=Utilities.clean(s);
        int[] charVal = new int[s.length()];
        for (int k=0;k<s.length();k++) {
             //get the integer value of each element in the string
             //subtract by 65 to offset ASCII code
             charVal[k] = (int) s.charAt(k)-65;
        }
        int counter = 0;
        //double for loop to access the pixels
        for (int i = 0;i<imNew.length;i+=10){
            for(int j = 0; j<imNew[0].length;j+=10){
                //null check
                if (imNew[i][j] == null || counter>=charVal.length) {
                   break;
                }
                //get integer value of each character in the string
                int er = charVal[counter];
                //create a temp array in order to copy encryption values
                int[] temp  = Steganography.positionToError(er);
                for (int k = 1;k<4;k++) {
                    imNew[i][j][k]=imNew[i][j][k]-temp[k-1];
                }
                counter++;
           }
        }
        return imNew;
    }

    //------------------------------------------------------------------------- 
    /// Decrypts a string of characters encoded into an image by comparing
    /// pixels in the cypher with the key image
    /// @input cypher the encrypted image containing the message
    /// @input key the key image that was used for the encryption
    /// @return the decrypted string of characters
        
    public static String decrypt(int[][][] cypher, int[][][] key) {
         //create string
         String s = new String("");
         //null check
         if (key == null || cypher == null) {
                return "";
         }
         //double for loop to traverse pixels
         for (int i=0;i<cypher.length;i+=10){
            for(int j=0;j<cypher[0].length;j+=10){
                //null check
                if (cypher[i][j] == null || key[i][j] == null) {
                    break;
                }
                //create arrays and copy in the RGB values for cypher and pixel
                int[] x = new int[3];
                int[] y = new int[3];
                for (int p=0;p<3;p++){
                    x[p]=cypher[i][j][p+1];
                    y[p]=key[i][j][p+1];
                }
                //create new array for color errors and add to string if an error exists
                int[] d = new int[3];
                d = Steganography.colorError(x,y);
                if (d[0]> 0) {
                    int e = Steganography.errorToPosition(d);
                    e=(int) e + 'a';
                    s+= (char) e;
                }
           }
       }
       s = s.toUpperCase();
       return s;
    }

    //------------------------------------------------------------------------- 
    // Extension Problems
    //------------------------------------------------------------------------- 
    /// Computes the RGB error based on the position of a character in the 
    /// alphabet.  The error is spread across each cell in the array.
    /// @param chpos The characters ordinal position in the alphabet
    /// @return an array of three values that represents the error to introduce
    ///         into to a color 
    public static int[] positionToError2( int chpos ) {
        //TODO: FILL IN YOUR CODE HERE
        int[] a = new int[3];
        a[0]=0;
        a[1]=0;
        a[2]=0;
        int b = chpos+1;
        int c=0;
        if (b>0 && b<27) {
            while (b>=c) {
              a[0]++;
              c++;
              a[1]++;
              c++;
              a[2]++;
              c++;
        }
        return a;
    }
    return null;
    }

    //------------------------------------------------------------------------- 
    /// Computes the ordinal position of a character based on the error spread
    /// across different cells in an input array of three values.
    /// @param error An array of RGB values (Note that this excludes the alpha 
    ///        channel).  
    /// @return The ordinal position of a character in the alphabet based on
    ///         the amount of error in the input 
    public static int errorToPosition2( int[] error ) {
        //TODO: FILL IN YOUR CODE HERE
        if (error == null) {
            return -1;
        }
        for (int i=0;i<error.length;i++){
            if (error[i]>9||error[i]<0){
                return -1;
            }
        }
        //add up the error values
        int x=0;
        for (int j=0;j<error.length;j++){
            x+=error[j];
        }
        return x;  // change as needed
    }

    //------------------------------------------------------------------------- 
    /// Encrypts a string of characters into a copy of the key image
    /// @input s the string of characters to encrypt
    /// @input key the image to encrypt the string into
    /// @return the encrypted image
    public static int[][][] encrypt2(String s, int[][][] key) {
        //TODO: FILL IN YOUR CODE HERE
        int[][][] imNew = Steganography.copy(key);
        if (imNew == null) {
            return null;
        }
        //turn all of the characters in the string to integers that can be easily accessed
        s=Utilities.clean(s);
        int[] charVal = new int[s.length()];
        for (int k=0;k<s.length();k++) {
             //get the integer value of each element in the string
             //subtract by 65 to offset ASCII code
             charVal[k] = (int) s.charAt(k)-65;
        }
        int counter = 0;
        //double for loop to access the pixels
        for (int i = 0;i<imNew.length;i+=10){
            for(int j = 0; j<imNew[0].length;j+=10){
                //null check
                if (imNew[i][j] == null || counter>=charVal.length) {
                   break;
                }
                //get integer value of each character in the string
                int er = charVal[counter];
                //create a temp array in order to copy encryption values
                int[] temp  = Steganography.positionToError2(er);
                for (int k = 1;k<4;k++) {
                    imNew[i][j][k]=imNew[i][j][k]-temp[k-1];
                }
                counter++;
           }
        }
        return imNew;
    }

    //------------------------------------------------------------------------- 
    /// Decrypts a string of characters encoded into an image by comparing
    /// pixels in the cypher with the key image
    /// @input cypher the encrypted image containing the message
    /// @input key the key image that was used for the encryption
    /// @return the decrypted string of characters
    public static String decrypt2(int[][][] cypher, int[][][] key) {
        //TODO: FILL IN YOUR CODE HERE
        //create string
         String s = new String("");
         //null check
         if (key == null || cypher == null) {
                return "";
         }
         //double for loop to traverse pixels
         for (int i=0;i<cypher.length;i+=10){
            for(int j=0;j<cypher[0].length;j+=10){
                //null check
                if (cypher[i][j] == null || key[i][j] == null) {
                    break;
                }
                //create arrays and copy in the RGB values for cypher and pixel
                int[] x = new int[3];
                int[] y = new int[3];
                for (int p=0;p<3;p++){
                    x[p]=cypher[i][j][p+1];
                    y[p]=key[i][j][p+1];
                }
                //create new array for color errors and add to string if an error exists
                int[] d = new int[3];
                d = Steganography.colorError(x,y);
                if (d== null) {
                    break;
                }
                if (d[0]> 0) {
                    int e = Steganography.errorToPosition2(d);
                    e=(int) e + 'a';
                    s+= (char) e;
                }
           }
       }
       s = s.toUpperCase();
       return s;
    }
}
