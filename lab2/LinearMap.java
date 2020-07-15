import java.awt.*;
import java.awt.image.*;

public class LinearMap {

    static ImageTool imTool = new ImageTool ();

    public static void main (String[] argv)
    {
        // Read in an image and display.
        Image image = imTool.readImageFile ("prof.jpg");
        imTool.showImage (image, "original");

        // Convert to grey scale and display.
        Image mappedImage = linearMap (image, -1.0, 255.0);
        imTool.showImage (mappedImage, "mapped image");
    }

    static Image linearMap (Image image, double a, double b)
    {
        // Extract pixels and size.
        int[][][] pixels = imTool.imageToPixels (image);
        int numRows = pixels.length;
        int numCols = pixels[0].length;
        
        // Make the new pixels.
        int[][][] mappedPixels = new int [numRows][numCols][4];

        // Almost like a copy.
        for (int i=0; i<numRows; i++) {
            for (int j=0; j<numCols; j++) {
                mappedPixels[i][j][0] = pixels[i][j][0];
                mappedPixels[i][j][1] = enforcePixelBounds (a * pixels[i][j][1] + b);
                mappedPixels[i][j][2] = enforcePixelBounds (a * pixels[i][j][2] + b);
                mappedPixels[i][j][3] = enforcePixelBounds (a * pixels[i][j][3] + b);
            }
        }

        // Returned transformed image.
        Image mappedImage = imTool.pixelsToImage (mappedPixels);
        return mappedImage;
    }
    

    // Each pixel value needs to be between 0 and 255.

    static int enforcePixelBounds (double pixelValue)
    {
        int value = (int) pixelValue;
        if (value < 0) {
            return 0;
        }
        if (value > 255) {
            return 255;
        }
        return value;
    }

}

