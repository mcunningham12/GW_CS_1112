import java.awt.*;
import java.awt.image.*;

public class GreyScale {

    static ImageTool imTool = new ImageTool ();

    public static void main (String[] argv)
    {
        // Read in an image and display.
        Image image = imTool.readImageFile ("statue.jpg");
        imTool.showImage (image, "original");

        // Convert to grey scale and display.
        Image greyImage = toGreyScale (image);
        imTool.showImage (greyImage, "grey-scale");
    }
    
    static Image toGreyScale (Image image)
    {
        // Extract pixels and size.
        int[][][] pixels = imTool.imageToPixels (image);
        int numRows = pixels.length;
        int numCols = pixels[0].length;

        // Make array of exactly the same size.
        int[][][] greyPixels = new int [numRows][numCols][4];

        // INSERT YOUR CODE HERE
        for(int i=0;i<numRows;i++){
            for(int j=0;j<numCols;j++){
               //get average of RGB values for each pixel
               int av = (pixels[i][j][1] + pixels[i][j][2] + pixels[i][j][3])/3;
                System.out.println(av);
               //replace each RGB value with the average
               greyPixels[i][j][0] = pixels[i][j][0];
               greyPixels[i][j][1] = av;
               greyPixels[i][j][2] = av;
               greyPixels[i][j][3] = av; 
            }
        }
        
        Image greyImage = imTool.pixelsToImage (greyPixels);
        return greyImage;
    }

}
