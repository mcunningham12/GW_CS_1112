import java.awt.*;
import java.awt.image.*;

public class ImageEnlarger {

    static ImageTool imTool = new ImageTool ();


    public static void main (String[] argv)
    {
        Image image = imTool.readImageFile ("bugsThumb.jpg");
        imTool.showImage (image, "original");

        Image enlargedImage = enlarge (image, 5);

        imTool.showImage (enlargedImage, "enlarged");
    }


    static Image enlarge (Image image, double factor)
    {
        // Extract the pixels and array dimensions.
        int[][][] pixels = imTool.imageToPixels (image);
        int numRows = pixels.length;
        int numCols = pixels[0].length;

        // The resulting shrunk image will have more rows and columns.
        int numTargetRows = (int) (factor * numRows);
        int numTargetCols = (int) (factor * numCols);

        int multiplier = numTargetRows / numRows;

        // Make the pixel array for the target.
        int[][][] enlargedPixels = new int [numTargetRows][numTargetCols][4];

        for (int i=0; i<numRows; i++) {
            for (int j=0; j<numCols; j++) {

                // Copy a single pixel from the smaller into a region of the larger.
                int startRow = i * multiplier;
                int startCol = j * multiplier;
                for (int m=0; m<multiplier; m++) {
                    for (int n=0; n<multiplier; n++) {
                        // This time, we'll do the copy correctly.
                        for (int k=0; k<3; k++) {
                            enlargedPixels[startRow+m][startCol+n][k] = pixels[i][j][k];
                        }
                    }
                }
                // End-copy-region
            }
        }

        Image enlargedImage = imTool.pixelsToImage (enlargedPixels);
        return enlargedImage;
    }
    
}

