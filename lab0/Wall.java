import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

class WallPanel extends JPanel {

    // Store the image locally so that the panel class can access it for drawing.
    Image image;


    // This method is where drawing is done.

    public void paintComponent (Graphics g)
    {
        // Render the image.
	g.drawImage (image, 0,0, this);

        // INSERT YOUR CODE HERE:
	// Do your graffitti here. For example,
	// This draws the M
	g.drawLine (150,200, 150,100);
	g.drawLine (150,100,200,200);
	g.drawLine (200,200,300,100);
	g.drawLine (300,100,300,200);

	//This draws the C
	g.drawLine (200,250,150,250);
	g.drawLine (150,250,100,300);
	g.drawLine (100,300,100,350);
	g.drawLine (100,350,150,400);
	g.drawLine (150,400,200,400);
    }

}


class WallFrame extends JFrame {

    public WallFrame ()
    {
        // Set frame parameters.
	this.setSize (400, 400);
	this.setTitle ("Wall");

        // Image tool to handle image loading.
	ImageTool imTool = new ImageTool ();
	Image image = imTool.readImageFile ("wall.jpg");

        // Create the panel and place inside frame.
	WallPanel panel = new WallPanel ();
	panel.image = image;
	Container cPane = this.getContentPane();
	cPane.add (panel);

        // Show the frame.
	this.setVisible (true);
    }
}


public class Wall {
    public static void main (String[] argv)
    {
        // Bring up the frame, which does everything else.
	WallFrame w = new WallFrame ();
    }

}

