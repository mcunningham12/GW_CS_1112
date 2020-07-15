/*-----------------------------------------------------------------------------
GWU CSCI1112 Spring 2020
author: James Taylor

This program performs unit testing on the Steganography class.  
------------------------------------------------------------------------------*/
import java.awt.*;
import java.awt.image.*;
import java.lang.*;
import java.util.*;


public class StegUnitTest {
    static ImageTool imTool = new ImageTool ();

    // ------------------------------------------------------------------------
    // Entry Point
    // ------------------------------------------------------------------------
    /// Entry Point.  The main program executes a set of UnitTests on the 
    /// various methods in the Steganography class to test different levels of 
    /// functionality.
    public static void main (String[] argv) {
        boolean fail = false;

        if( baseTestCopy() ) {
            System.out.println("testCopy succeeded");
        } else {
            System.out.println("testCopy failed"); 
        }

        System.out.print("baseTestColorError::");
        if( !baseTestColorError() ) {
            fail = true;
        }

        System.out.print("baseTestColorPositionMapping::");
        if( !baseTestColorPositionMapping() ) {
            fail = true;
        }

        System.out.print("baseTestCypher::");
        if( !baseTestCypher() ) {
            fail = true;
        }

        System.out.print("extensionTestColorPositionMapping::");
        if( !extensionTestColorPositionMapping() ) {
            fail = true;
        }

        System.out.print("extensionTestCypher::");
        if( !extensionTestCypher() ) {
            fail = true;
        }
    }

    // ------------------------------------------------------------------------
    // UnitTests
    // ------------------------------------------------------------------------
    /// Tests the Steganography.copy function.
    /// @return Returns true if the function passes all defined tests; 
    ///         otherwise, returns false
    // TODO: Add line comments to this function by explain what each branch 
    // checks
    public static boolean baseTestCopy() {
        int[][][] src; 
        int[][][] dest; 

        src = imTool.imageToPixels( imTool.readImageFile( "gradient.png" ) );
        // deep copy from image in src to dest for the test
        dest = Steganography.copy( src );

        if( src == null || dest == null ) {
            return false;
        }
        if( src.length != dest.length ) {
            return false;
        }
        // iterate over all source rows
        for (int i=0; i < src.length; i++) {
            if( src[i] == dest[i] ) {
                return false;
            }
            if( src[i].length != dest[i].length ) {
                return false;
            }
            // iterate over all columns in this row
            for (int j=0; j < src[i].length; j++) {
                if( src[i][j] == dest[i][j] ) {
                    return false;
                }
                if( src[i][j].length != dest[i][j].length ) {
                    return false;
                }
                // iterate over each channel in the pixel 
                for (int k=0; k < 4; k++) {
                    if( src[i][j][k] != dest[i][j][k] ) {
                        return false;
                    }
                }
            }
        }
        // If we cannot disprove it is a deep copy, we assume it is
        return true;
    }

    //-------------------------------------------------------------------------
    //-------------------------------------------------------------------------
    /// Tests the Steganography.colorError function.
    /// @return Returns true if the function passes all defined tests; 
    ///         otherwise, returns false
    public static boolean baseTestColorError() {
        if( !baseColorErrorTest1() ) {
            System.out.println("failed::error code 1"); 
            return false;
        }

        if( !baseColorErrorTest2() ) {
            System.out.println("failed::error code 2"); 
            return false;
        }

        if( !baseColorErrorTest3() ) {
            System.out.println("failed::error code 3"); 
            return false;
        }

        if( !baseColorErrorTest4() ) {
            System.out.println("failed::error code 4"); 
            return false;
        }

        if( !baseColorErrorTest5() ) {
            System.out.println("failed::error code 5"); 
            return false;
        }

        if( !baseColorErrorTest6() ) {
            System.out.println("failed::error code 6"); 
            return false;
        }

        if( !baseColorErrorTest7() ) {
            System.out.println("failed::error code 7"); 
            return false;
        }

        if( !baseColorErrorTest8() ) {
            System.out.println("failed::error code 8"); 
            return false;
        }

        if( !baseColorErrorTest9() ) {
            System.out.println("failed::error code 9"); 
            return false;
        }

        if( !baseColorErrorTest10() ) {
            System.out.println("failed::error code 10"); 
            return false;
        }

        if( !baseColorErrorTest11() ) {
            System.out.println("failed::error code 11"); 
            return false;
        }

        if( !baseColorErrorTest12() ) {
            System.out.println("failed::error code 12"); 
            return false;
        }

        System.out.println("succeeded");
        return true;
    }

    /// Note that baseColorErrorTest1-8 verify that colorError validates that
    /// a pixel is correctly allocated and constrained to the expected range
    /// of intensities.  The is a utility function defined that can validate
    /// a pixel.  If you use that utility function to validate both parameters
    /// in colorError, you do not need to write extensive validation code
    /// yourself to pass tests 1-8.

    /// error of 0 indicates that there is no difference between pixels and
    /// therefore no character encoded.  If no error, then we have reached the
    /// end of the encrypted data.

    /// Validate that a null key pixel is handled 
    /// @returns true if the test passes (array returned is null); otherwise, 
    ///          returns false
    public static boolean baseColorErrorTest1() {
        int[] keypx = null;
        int[] cypherpx = { 0, 0, 0, 0 };
        int[] error;

        error = Steganography.colorError( keypx, cypherpx );
        
        if(error != null) {
            return false;
        }

        return true;
    }

    /// Validate that a null cypher pixel is handled 
    /// @returns true if the test passes (array returned is null); otherwise, 
    ///          returns false
    public static boolean baseColorErrorTest2() {
        int[] keypx = { 0, 0, 0, 0 };
        int[] cypherpx = null;
        int[] error;

        error = Steganography.colorError( keypx, cypherpx );
        
        if(error != null) {
            return false;
        }

        return true;
    }

    /// Validate that a malformed key pixel is handled 
    /// @returns true if the test passes (array returned is null); otherwise, 
    ///          returns false
    public static boolean baseColorErrorTest3() {
        int[] keypx = { 0, 0, 0 };
        int[] cypherpx = { 0, 0, 0, 0 };
        int[] error;

        error = Steganography.colorError( keypx, cypherpx );
        
        if(error != null) {
            return false;
        }

        return true;
    }

    /// Validate that a malformed cypher pixel is handled 
    /// @returns true if the test passes (array returned is null); otherwise, 
    ///          returns false
    public static boolean baseColorErrorTest4() {
        int[] keypx = { 0, 0, 0, 0 };
        int[] cypherpx = { 0, 0, 0 };
        int[] error;

        error = Steganography.colorError( keypx, cypherpx );
        
        if(error != null) {
            return false;
        }

        return true;
    }

    /// Validate that an invalid cypher pixel is handled 
    /// @returns true if the test passes (array returned is null); otherwise, 
    ///          returns false
    public static boolean baseColorErrorTest5() {
        int[] keypx = { 0, 0, 0, 0 };
        int[] cypherpx = { -1, -1, -1, -1 };
        int[] error;

        error = Steganography.colorError( keypx, cypherpx );
        
        if(error != null) {
            return false;
        }

        return true;
    }

    /// Validate that an invalid cypher pixel is handled 
    /// @returns true if the test passes (array returned is null); otherwise, 
    ///          returns false
    public static boolean baseColorErrorTest6() {
        int[] keypx = { 0, 0, 0, 0 };
        int[] cypherpx = { 256, 256, 256, 256 };
        int[] error;

        error = Steganography.colorError( keypx, cypherpx );
        
        if(error != null) {
            return false;
        }

        return true;
    }

    /// Validate that an invalid key pixel is handled 
    /// @returns true if the test passes (array returned is null); otherwise, 
    ///          returns false
    public static boolean baseColorErrorTest7() {
        int[] keypx = { -1, -1, -1, -1 };
        int[] cypherpx = { 0, 0, 0, 0 };
        int[] error;

        error = Steganography.colorError( keypx, cypherpx );
        
        if(error != null) {
            return false;
        }

        return true;
    }

    /// Validate that an invalid key pixel is handled 
    /// @returns true if the test passes (array returned is null); otherwise, 
    ///          returns false
    public static boolean baseColorErrorTest8() {
        int[] keypx = { 256, 256, 256, 256 };
        int[] cypherpx = { 0, 0, 0, 0 };
        int[] error;

        error = Steganography.colorError( keypx, cypherpx );
        
        if(error != null) {
            return false;
        }

        return true;
    }

    /// Validate that error is returned with valid pixels 
    /// @returns true if the test passes (array returned is not null); 
    ///          otherwise, returns false
    public static boolean baseColorErrorTest9() {
        int[] keypx = new int[4];
        int[] cypherpx = new int[4];
        int[] error;

        error = Steganography.colorError( keypx, cypherpx );
        
        if(error == null) {
            return false;
        }

        return true;
    }

    /// Validate that the size of the error array is correct 
    /// @returns true if the test passes (error array has three values); 
    ///          otherwise, returns false
    public static boolean baseColorErrorTest10() {
        int[] keypx = new int[4];
        int[] cypherpx = new int[4];
        int[] error;

        error = Steganography.colorError( keypx, cypherpx );

        if(error.length != 3) {
            return false;
        }

        return true;
    }

    /// Validate error between two matching pixels is zero 
    /// @returns true if the test passes; otherwise, returns false
    public static boolean baseColorErrorTest11() {
        int[] keypx = new int[4];
        int[] cypherpx = new int[4];
        int[] error;

        // by Java standard, arrays are initialized to zero by default, so this
        // test compares black to black. 
        error = Steganography.colorError( keypx, cypherpx );

        if( !(error[0] == 0 && error[1] == 0 && error[2] == 0) ) {
            return false;
        }

        return true;
    }

    /// Validate that the error between a colored pixel a black pixel has the 
    /// expected error (always a positive value)
    /// @returns true if the test passes (error is the expected value); 
    ///          otherwise, returns false (error is not expected value)
    public static boolean baseColorErrorTest12() {
        int[] keypx = new int[4];
        int[] cypherpx = new int[4];
        int[] error;

        // introduce some error by changing the key pixel color channels to 
        // non-black.  cypher pixel color is black
        int keyintensity = 8;
        int cypintensity = 0;
        // epsilon is another name for error.  error is an unsigned distance
        int epsilon = cypintensity - keyintensity;

        keypx[1] = keypx[2] = keypx[3] = keyintensity;
        cypherpx[1] = cypherpx[2] = cypherpx[3] = cypintensity;
        error = Steganography.colorError( keypx, cypherpx );
        if( error == null || error.length != 3 && (error[0] != epsilon || error[1] != epsilon || error[2] != epsilon) ) {
            return false;
        }
        return true;
    }

    /// Validate that the error between two colored pixels remains positive 
    /// regardless of the sign of the operation
    /// @returns true if the test passes (error is the expected value); 
    ///          otherwise, returns false (error is not expected value)
    public static boolean baseColorErrorTest13() {
        int[] keypx = new int[4];
        int[] cypherpx = new int[4];
        int[] error;

        // test error in the other direction by changing the cypher pixel
        // color channels 
        int keyintensity = 8;
        int cypintensity = 16;
        int epsilon = cypintensity - keyintensity;

        keypx[1] = keypx[2] = keypx[3] = keyintensity;
        cypherpx[1] = cypherpx[2] = cypherpx[3] = cypintensity;
        error = Steganography.colorError( keypx, cypherpx );
        if( error == null || error.length != 3 && (error[0] != epsilon || error[1] != epsilon || error[2] != epsilon) ) {
            return false;
        } 
        return true;
    }

    /// Validate that the values in the individual error channels reflects the 
    /// distance between values in the color channels for two pixels
    /// @returns true if the test passes (error is the expected value); 
    ///          otherwise, returns false (error is not expected value)
    public static boolean baseColorErrorTest14() {
        int[] keypx = new int[4];
        int[] cypherpx = new int[4];
        int[] error;

        // test different magnitude of error across the different channels
        int keyintensity = 8;

        keypx[1] = keypx[2] = keypx[3] = keyintensity;
        cypherpx[1] = 0;
        cypherpx[2] = 8;
        cypherpx[3] = 24;
        error = Steganography.colorError( keypx, cypherpx );
        if( error == null || error.length != 3 && (error[0]!= 8 || error[1] != 0 || error[2] != 16) ) {
            return false;
        } 
        return true;
    }

    //-------------------------------------------------------------------------
    //-------------------------------------------------------------------------
    /// For the base encrytion problem, the same value is encoded into all 
    /// color channels.  These tests validate that the correct magnitude for
    /// a color change is computed for encoding and the correct position is
    /// computed for decoding. 
    /// @return true if the function passes all defined tests; 
    ///         otherwise, returns false
    public static boolean baseTestColorPositionMapping() {
        if( !baseColorPositionTest1() ) {
            System.out.println("failed::error code 1"); 
            return false;
        }

        if( !baseColorPositionTest2() ) {
            System.out.println("failed::error code 2"); 
            return false;
        }

        if( !baseColorPositionTest3() ) {
            System.out.println("failed::error code 3"); 
            return false;
        }

        if( !baseColorPositionTest4() ) {
            System.out.println("failed::error code 4"); 
            return false;
        }

        if( !baseColorPositionTest5() ) {
            System.out.println("failed::error code 5"); 
            return false;
        }

        if( !baseColorPositionTest6() ) {
            System.out.println("failed::error code 6"); 
            return false;
        }

        System.out.println("succeeded");
        return true;
    }

    // position to error maps an int (single value) that represents the
    // position of the character in the alphabet (0 based) to an array that 
    // specifies an amount of color change for a character to each channel
    // 'A' yields a change of 1 to each channel 
    // 'Z' yields a change of 26

    /// Validate that the delta color array is not null given a valid character
    /// @returns true if the test passes (pixel change is not null); 
    ///          otherwise, returns false
    public static boolean baseColorPositionTest1() {
        int pos = (int)'A' - (int)'A';

        int[] delta = Steganography.positionToError( pos );

        // validate that delta is a valid pointer
        if( delta == null ) {
            return false;
        }

        return true;
    }

    /// Validate that the delta color array has the correct size given a valid
    /// character
    /// @returns true if the test passes (pixel change has three values); 
    ///          otherwise, returns false
    public static boolean baseColorPositionTest2() {
        int pos = (int)'A' - (int)'A';

        int[] delta = Steganography.positionToError( pos );

        // validate that delta has correct size
        if( delta.length != 3 ) {
            return false;
        }

        return true;
    }

    /// Validate that the delta color array contain the correct shift of color
    /// intensities for an 'A' character
    /// @returns true if the test passes (error of 1 in all channels); 
    ///          otherwise, returns false
    public static boolean baseColorPositionTest3() {
        int pos = (int)'A' - (int)'A';

        int[] delta = Steganography.positionToError( pos );

        // check that the amount of color change for an A produces the expected
        // amount of error 
        if( !(delta[0] == 1 && delta[1] == 1 && delta[2] == 1) ) {
            return false;
        }
        return true;
    }

    /// Validate that the delta color array contain the correct shift of color
    /// intensities for an 'A' character
    /// @returns true if the test passes (error of 26 in all channels); 
    ///          otherwise, returns false
    public static boolean baseColorPositionTest4() {
        int pos = (int)'Z' - (int)'A';
        int[] delta = Steganography.positionToError( pos );

        if( !(delta[0] == 26 && delta[1] == 26 && delta[2] == 26) ) {
            return false;
        }
        return true;
    }

    /// Validate that the error associated with 'A' is translated back into
    /// the corresponding position of 'A'
    /// @returns true if the test passes; otherwise, returns false
    public static boolean baseColorPositionTest5() {
        int pos = (int)'A' - (int)'A';

        int[] delta = Steganography.positionToError( pos );

        // check that a letter position is correctly mapped to the associated 
        // color change 
        int val = Steganography.errorToPosition( delta );
        if( val != pos ) {
            return false;
        }
        return true;
    }

    /// Validate that the error associated with 'Z' is translated back into
    /// the corresponding position of 'Z'
    /// @returns true if the test passes; otherwise, returns false
    public static boolean baseColorPositionTest6() {
        int pos = (int)'Z' - (int)'A';

        int[] delta = Steganography.positionToError( pos );

        // check that a letter position is correctly mapped to the associated 
        // color change 
        int val = Steganography.errorToPosition( delta );
        if( val != pos ) {
            return false;
        }
        return true;
    }

    //-------------------------------------------------------------------------
    //-------------------------------------------------------------------------
    /// Validate the encryption and decryption processes work using the base
    /// algorithms using a number of subtests
    /// @returns true if the test passes; otherwise, returns false
    public static boolean baseTestCypher() {
        if( !baseCypherTest1() ) {
            System.out.println("failed::error code 1"); 
            return false;
        }

        if( !baseCypherTest2() ) {
            System.out.println("failed::error code 2"); 
            return false;
        }

        if( !baseCypherTest3() ) {
            System.out.println("failed::error code 3"); 
            return false;
        }

        System.out.println("succeeded");
        return true;
    }

    /// Validate that 'HELLO' is correctly encoded and decoded
    /// @returns true if the test passes; otherwise, returns false
    public static boolean baseCypherTest1() {
        int[][][] key;
        int[][][] cypher;
        String msgin, msgout;

        // load the key image
        key = imTool.imageToPixels( imTool.readImageFile( "white.png" ) );
        
        // generate a message
        msgin = "Hello";
        // clean the string up so it meets the specification
        msgin = Utilities.clean( msgin );

        // encrypt the message to create a cypher image
        cypher = Steganography.encrypt( msgin, key );

        // if the cyphered message is null, the test fails
        if( cypher == null ) {
            return false;
        }

        // decrypt the message back out
        msgout = Steganography.decrypt( cypher, key );

        //System.out.println(msgout);

        // if the decrypted message is not the same as the encrypted message
        // the test fails
        if(!msgout.equals(msgin)) {
            return false;
        }

        // otherwise, the messages are the same and the test passes
        return true;
    }

    /// Validate that a pangram is correctly encoded and decoded
    /// @returns true if the test passes; otherwise, returns false
    public static boolean baseCypherTest2() {
        int[][][] key;
        int[][][] cypher;
        String msgin, msgout;

        // load the key image
        key = imTool.imageToPixels( imTool.readImageFile( "white.png" ) );
        
        // generate a message
        msgin = Utilities.pangram();
        // clean the string up so it meets the specification
        msgin = Utilities.clean( msgin );

        // encrypt the message to create a cypher image
        cypher = Steganography.encrypt( msgin, key );

        // if the cyphered message is null, the test fails
        if( cypher == null ) {
            return false;
        }

        // decrypt the message back out
        msgout = Steganography.decrypt( cypher, key );

        //System.out.println(msgout);

        // if the decrypted message is not the same as the encrypted message
        // the test fails
        if(!msgout.equals(msgin)) {
            return false;
        }

        // otherwise, the messages are the same and the test passes
        return true;
    }

    /// Validate that long text is correctly encoded and decoded
    /// @returns true if the test passes; otherwise, returns false
    public static boolean baseCypherTest3() {
        int[][][] key;
        int[][][] cypher;
        String msgin, msgout;

        // load the key image
        key = imTool.imageToPixels( imTool.readImageFile( "white.png" ) );
        
        // generate a message
        msgin = Utilities.loremipsum();
        // clean the string up so it meets the specification
        msgin = Utilities.clean( msgin );

        // encrypt the message to create a cypher image
        cypher = Steganography.encrypt( msgin, key );

        // if the cyphered message is null, the test fails
        if( cypher == null ) {
            return false;
        }

        // decrypt the message back out
        msgout = Steganography.decrypt( cypher, key );

        //System.out.println(msgout);

        // if the decrypted message is not the same as the encrypted message
        // the test fails
        if(!msgout.equals(msgin)) {
            return false;
        }

        // otherwise, the messages are the same and the test passes
        return true;
    }

    //-------------------------------------------------------------------------
    // Extension
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    /// Validate the changes to position and error mapping in the extension
    /// @return Returns true if the function passes all defined tests; 
    ///         otherwise, returns false
    public static boolean extensionTestColorPositionMapping() {
        if( !extensionColorPositionTest1() ) {
            System.out.println("failed::error code 1"); 
            return false;
        }

        if( !extensionColorPositionTest2() ) {
            System.out.println("failed::error code 2"); 
            return false;
        }

        if( !extensionColorPositionTest3() ) {
            System.out.println("failed::error code 3"); 
            return false;
        }

        if( !extensionColorPositionTest4() ) {
            System.out.println("failed::error code 4"); 
            return false;
        }

        if( !extensionColorPositionTest5() ) {
            System.out.println("failed::error code 5"); 
            return false;
        }

        if( !extensionColorPositionTest6() ) {
            System.out.println("failed::error code 6"); 
            return false;
        }

        if( !extensionColorPositionTest7() ) {
            System.out.println("failed::error code 7"); 
            return false;
        }

        if( !extensionColorPositionTest8() ) {
            System.out.println("failed::error code 8"); 
            return false;
        }

        System.out.println("succeeded");
        return true;
    }

    /// Validate that the delta color array is not null given a valid character
    /// @returns true if the test passes (pixel change is not null); 
    ///          otherwise, returns false
    public static boolean extensionColorPositionTest1() {
        int pos = (int)'A' - (int)'A';

        int[] delta = Steganography.positionToError2( pos );

        // validate that delta is a valid pointer
        if( delta == null ) {
            System.out.println("null");
            return false;
        }
        return true;
    }

    /// Validate that the delta color array has correct length given a valid 
    /// character
    /// @returns true if the test passes; otherwise, returns false
    public static boolean extensionColorPositionTest2() {
        int pos = (int)'A' - (int)'A';

        int[] delta = Steganography.positionToError2( pos );

        // validate that delta has correct size
        if( delta.length != 3 ) {
            System.out.println("length");
            return false;
        }

        return true;
    }

    /// Validate that the delta color array for 'A' encodes its change into
    /// the red channel only and the correct value can be recovered when
    /// evaluating that error
    /// @returns true if the test passes; otherwise, returns false
    public static boolean extensionColorPositionTest3() {
        int pos = (int)'A' - (int)'A';

        int[] delta = Steganography.positionToError2( pos );

        // check that the amount of color change for an A produces the expected 
        // amount of error 
        if( !(delta[0] == 1 && delta[1] == 0 && delta[2] == 0) ) {
            return false;
        }

        int val = Steganography.errorToPosition2(delta);
        if( val != pos ) {
            System.out.println("value");
            return false;
        }

        return true;
    }

    /// Validate that the delta color array for 'B' encodes its change into
    /// the red and green channels and the correct value can be recovered when
    /// evaluating that error
    /// @returns true if the test passes; otherwise, returns false
    public static boolean extensionColorPositionTest4() {
        int pos = (int)'B' - (int)'A';

        int[] delta = Steganography.positionToError2( pos );

        if( !(delta[0] == 1 && delta[1] == 1 && delta[2] == 0) ) {
            return false;
        }

        int val = Steganography.errorToPosition2(delta);
        if( val != pos ) {
            return false;
        }

        return true;
    }

    /// Validate that the delta color array for 'C' encodes its change into
    /// the all three channels and the correct value can be recovered when
    /// evaluating that error
    /// @returns true if the test passes; otherwise, returns false
    public static boolean extensionColorPositionTest5() {
        int pos = (int)'C' - (int)'A';

        int[] delta = Steganography.positionToError2( pos );

        if( !(delta[0] == 1 && delta[1] == 1 && delta[2] == 1) ) {
            return false;
        }

        int val = Steganography.errorToPosition2(delta);
        if( val != pos ) {
            return false;
        }

        return true;
    }

    /// Validate that the delta color array for 'X' encodes its change 
    /// correctly and the correct value can be recovered when evaluating that 
    /// error
    /// @returns true if the test passes; otherwise, returns false
    public static boolean extensionColorPositionTest6() {
        int pos = (int)'X' - (int)'A';

        int[] delta = Steganography.positionToError2( pos );

        if( !(delta[0] == 8 && delta[1] == 8 && delta[2] == 8) ) {
            return false;
        }

        int val = Steganography.errorToPosition2(delta);
        if( val != pos ) {
            return false;
        }

        return true;
    }

    /// Validate that the delta color array for 'Y' encodes its change 
    /// correctly and the correct value can be recovered when evaluating that 
    /// error
    /// @returns true if the test passes; otherwise, returns false
    public static boolean extensionColorPositionTest7() {
        int pos = (int)'Y' - (int)'A';

        int[] delta = Steganography.positionToError2( pos );

        if( !(delta[0] == 9 && delta[1] == 8 && delta[2] == 8) ) {
            return false;
        }

        int val = Steganography.errorToPosition2(delta);
        if( val != pos ) {
            return false;
        }

        return true;
    }

    /// Validate that the delta color array for 'Z' encodes its change 
    /// correctly and the correct value can be recovered when evaluating that 
    /// error
    /// @returns true if the test passes; otherwise, returns false
    public static boolean extensionColorPositionTest8() {
        int pos = (int)'Z' - (int)'A';

        int[] delta = Steganography.positionToError2( pos );

        if( !(delta[0] == 9 && delta[1] == 9 && delta[2] == 8) ) {
            return false;
        }

        int val = Steganography.errorToPosition2(delta);
        if( val != pos ) {
            return false;
        }

        return true;
    }

    //-------------------------------------------------------------------------
    //-------------------------------------------------------------------------
    /// Validate the encryption and decryption processes work using the 
    /// extension algorithms using a number of subtests
    /// @returns true if the test passes; otherwise, returns false
    public static boolean extensionTestCypher() {
        if( !extensionCypherTest1() ) {
            System.out.println("failed::error code 1"); 
            return false;
        }

        if( !extensionCypherTest2() ) {
            System.out.println("failed::error code 2"); 
            return false;
        }

        if( !extensionCypherTest3() ) {
            System.out.println("failed::error code 3"); 
            return false;
        }

        if( !extensionCypherTest4() ) {
            System.out.println("failed::error code 4"); 
            return false;
        }

        if( !extensionCypherTest5() ) {
            System.out.println("failed::error code 5"); 
            return false;
        }

        if( !extensionCypherTest6() ) {
            System.out.println("failed::error code 6"); 
            return false;
        }

        System.out.println("succeeded");
        return true;
    }

    /// Validate that 'HELLO' is correctly encoded and decoded into a 
    /// white image
    /// @returns true if the test passes; otherwise, returns false
    public static boolean extensionCypherTest1() {
        int[][][] key;
        int[][][] cypher;
        String msgin, msgout;

        // load the key image
        key = imTool.imageToPixels( imTool.readImageFile( "white.png" ) );
        
        // generate a message
        msgin = "Hello";
        // clean the string up so it meets the specification
        msgin = Utilities.clean( msgin );

        // encrypt the message to create a cypher image
        cypher = Steganography.encrypt2( msgin, key );

        // if the cyphered message is null, the test fails
        if( cypher == null ) {
            return false;
        }

        // decrypt the message back out
        msgout = Steganography.decrypt2( cypher, key );

        //System.out.println(msgout);

        // if the decrypted message is not the same as the encrypted message
        // the test fails
        if(!msgout.equals(msgin)) {
            return false;
        }

        // otherwise, the messages are the same and the test passes
        return true;
    }

    /// Validate that 'HELLO' is correctly encoded and decoded into a 
    /// gradient image
    /// @returns true if the test passes; otherwise, returns false
    public static boolean extensionCypherTest2() {
        int[][][] key;
        int[][][] cypher;
        String msgin, msgout;

        // load the key image
        key = imTool.imageToPixels( imTool.readImageFile( "gradient.png" ) );
        
        // generate a message
        msgin = "Hello";
        // clean the string up so it meets the specification
        msgin = Utilities.clean( msgin );

        // encrypt the message to create a cypher image
        cypher = Steganography.encrypt2( msgin, key );

        // if the cyphered message is null, the test fails
        if( cypher == null ) {
            return false;
        }

        // decrypt the message back out
        msgout = Steganography.decrypt2( cypher, key );

        //System.out.println(msgout);

        // if the decrypted message is not the same as the encrypted message
        // the test fails
        if(!msgout.equals(msgin)) {
            return false;
        }

        // otherwise, the messages are the same and the test passes
        return true;
    }

    /// Validate that a pangram is correctly encoded and decoded into a 
    /// white image
    /// @returns true if the test passes; otherwise, returns false
    public static boolean extensionCypherTest3() {
        int[][][] key;
        int[][][] cypher;
        String msgin, msgout;

        // load the key image
        key = imTool.imageToPixels( imTool.readImageFile( "white.png" ) );
        
        // generate a message
        msgin = Utilities.pangram();
        // clean the string up so it meets the specification
        msgin = Utilities.clean( msgin );

        // encrypt the message to create a cypher image
        cypher = Steganography.encrypt2( msgin, key );

        // if the cyphered message is null, the test fails
        if( cypher == null ) {
            return false;
        }

        // decrypt the message back out
        msgout = Steganography.decrypt2( cypher, key );

        //System.out.println(msgout);

        // if the decrypted message is not the same as the encrypted message
        // the test fails
        if(!msgout.equals(msgin)) {
            return false;
        }

        // otherwise, the messages are the same and the test passes
        return true;
    }

    /// Validate that a pangram is correctly encoded and decoded into a 
    /// gradient image
    /// @returns true if the test passes; otherwise, returns false
    public static boolean extensionCypherTest4() {
        int[][][] key;
        int[][][] cypher;
        String msgin, msgout;

        // load the key image
        key = imTool.imageToPixels( imTool.readImageFile( "gradient.png" ) );
        
        // generate a message
        msgin = Utilities.pangram();
        // clean the string up so it meets the specification
        msgin = Utilities.clean( msgin );

        // encrypt the message to create a cypher image
        cypher = Steganography.encrypt2( msgin, key );

        // if the cyphered message is null, the test fails
        if( cypher == null ) {
            return false;
        }

        // decrypt the message back out
        msgout = Steganography.decrypt2( cypher, key );

        //System.out.println(msgout);

        // if the decrypted message is not the same as the encrypted message
        // the test fails
        if(!msgout.equals(msgin)) {
            return false;
        }

        // otherwise, the messages are the same and the test passes
        return true;
    }

    /// Validate that long text is correctly encoded and decoded into a white
    /// image
    /// @returns true if the test passes; otherwise, returns false
    public static boolean extensionCypherTest5() {
        int[][][] key;
        int[][][] cypher;
        String msgin, msgout;

        // load the key image
        key = imTool.imageToPixels( imTool.readImageFile( "white.png" ) );
        
        // generate a message
        msgin = Utilities.loremipsum();
        // clean the string up so it meets the specification
        msgin = Utilities.clean( msgin );

        // encrypt the message to create a cypher image
        cypher = Steganography.encrypt2( msgin, key );

        // if the cyphered message is null, the test fails
        if( cypher == null ) {
            return false;
        }

        // decrypt the message back out
        msgout = Steganography.decrypt2( cypher, key );

        //System.out.println(msgout);

        // if the decrypted message is not the same as the encrypted message
        // the test fails
        if(!msgout.equals(msgin)) {
            return false;
        }

        // otherwise, the messages are the same and the test passes
        return true;
    }

    /// Validate that long text is correctly encoded and decoded into a 
    /// gradient image
    /// @returns true if the test passes; otherwise, returns false
    public static boolean extensionCypherTest6() {
        int[][][] key;
        int[][][] cypher;
        String msgin, msgout;

        // load the key image
        key = imTool.imageToPixels( imTool.readImageFile( "gradient.png" ) );
        
        // generate a message
        msgin = Utilities.loremipsum();
        // clean the string up so it meets the specification
        msgin = Utilities.clean( msgin );

        // encrypt the message to create a cypher image
        cypher = Steganography.encrypt2( msgin, key );

        // if the cyphered message is null, the test fails
        if( cypher == null ) {
            return false;
        }

        // decrypt the message back out
        msgout = Steganography.decrypt2( cypher, key );

        //System.out.println(msgout);

        // if the decrypted message is not the same as the encrypted message
        // the test fails
        if(!msgout.equals(msgin)) {
            return false;
        }

        // otherwise, the messages are the same and the test passes
        return true;
    }
}
