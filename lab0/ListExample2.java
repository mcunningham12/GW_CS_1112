import java.util.*;
import java.awt.*;
import java.awt.image.*;

public class ListExample2 
{
    public static void main (String[] argv) 
    {
        // Create an empty list that can hold objects of type Image:
        LinkedList<Image> imageList = new LinkedList<Image> ();

        // Retrieve images from files using ImageTool, and add one
        // by one into the list.
        ImageTool imTool = new ImageTool ();
        Image image1 = imTool.readImageFile ("alum1.jpg");
        imageList.add (image1);
        Image image2 = imTool.readImageFile ("alum2.jpg");
        imageList.add (image2);
        Image image3 = imTool.readImageFile ("alum3.jpg");
        imageList.add (image3);

        viewImages (imageList);

    }


    // The list as method parameter:

    static void viewImages (java.util.List<Image> imageList)
    {
        ImageTool imTool = new ImageTool ();
        for (Image image : imageList) {        // Note the for-loop
            imTool.showImage (image);
        }
    }

}
