//This is exercise 14. see pdf for pseudo-code

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;


class AntEaterPanel extends JPanel {

    // We'll put all the ant-clicks into a queue, from which the anteater 
    // will pull out the next target.
    ArrayList<Point> antQueue = new ArrayList<Point>();
    
    Point antEater;    // The current position of the anteater.
    Point nextAnt;     // The position of the current ant being chased.

    int antsEaten = 0;
    double totalDist = 0;
    // Constructor.

    public AntEaterPanel () 
    {
        // Listen to mouseclicks.
        this.addMouseListener (
            new MouseAdapter () {
                public void mouseClicked (MouseEvent e) 
                {
                    handleClick (e.getX(), e.getY());
                }
            }
                                    
        );
        
        // The anteater will run in a separate thread.
        Thread t = new Thread () {
                public void run () 
                {
                    move ();
                }
            };
        t.start ();
    }



    public void paintComponent (Graphics g)
    {
        super.paintComponent (g);

        // Clear drawing area.
        g.setColor (Color.white);
        Dimension D = this.getSize();
        g.fillRect (0,0, D.width, D.height);

        // Draw the ants.
        g.setColor (Color.gray);
        if (nextAnt != null) {
            g.fillOval (nextAnt.x-2,nextAnt.y-2, 4, 4);
        }
        for (Iterator<Point> iter=antQueue.iterator(); iter.hasNext(); ) {
            Point p = iter.next();
            g.fillOval (p.x-2,p.y-2, 4, 4);
        }

        // AntEater.
        g.setColor (Color.red);
        g.fillOval (antEater.x-10,antEater.y-10, 20, 20);
    }
    
    
    void draw ()
    {
        // Place a call to paintComponent(). 
        this.repaint ();
    }


    void handleClick (int x, int y)
    {
        // Add a new ant to the queue.
        antQueue.add (new Point(x,y));
        draw ();
    }
    

    void move ()
    {
        // This is where we'll start the anteater.
        antEater = new Point (0,0);
        
        while (true) {

            // Anteater sleeps 100 milliseconds.
            try {
                Thread.sleep (100);
            }
            catch (InterruptedException e) {
            }

            if (nextAnt == null) {
                if (! antQueue.isEmpty() ) {
                    // Find the closest ant
		    // Iterative search the arrayList for the shortest distance
                    double closest = distance(antQueue.get(0), antEater);
		    int element=0;
	            for(int i=1;i<antQueue.size();i++){
			if(distance(antQueue.get(i),antEater) < closest){
		            // Closer distance found, change closest and element
			    closest=distance(antQueue.get(i),antEater);
			    element = i;
		        }
		    }
                    // Set nextAnt equal to closest ant and remove it from
		    // the array list.
                    // also increment the total distance
	            nextAnt = antQueue.get(element);
		    antQueue.remove(element);
                    totalDist += distance(nextAnt, antEater);
                }
            }
            else {
                if ( distance(nextAnt, antEater) < 10 ) {
                    // Eat the ant.
                    totalDist += distance(nextAnt, antEater);
                    nextAnt = null;
                    antsEaten++;
                }
                else {
                    // Otherwise, step towards ant.
                    double theta = Math.atan2 ((nextAnt.y - antEater.y), (nextAnt.x - antEater.x));
                    double stepsize = 10.0;
                    antEater.x = (int) (antEater.x + stepsize*Math.cos(theta));
                    antEater.y = (int) (antEater.y + stepsize*Math.sin(theta));
                    totalDist += stepsize*Math.cos(theta);
                    totalDist += stepsize*Math.sin(theta);
                    draw ();
                }
            }
            System.out.println("Distance: " + totalDist);
            System.out.println("AntsEaten: " + antsEaten);
        }
    }


    double distance (Point p, Point q)
    {
        double distSq = (p.x-q.x)*(p.x-q.x) + (p.y-q.y)*(p.y-q.y);
        return Math.sqrt (distSq);
    }

} //end-panel



class AntEaterFrame extends JFrame {
    
    public AntEaterFrame ()
    {
        this.setTitle ("AntEater");
        this.setSize (300, 300);

        // The frame only consists of the panel.
        AntEaterPanel panel = new AntEaterPanel ();
        this.getContentPane().add (panel);

        this.setVisible (true);
    }

} //end-frame



public class AntEater2 {

    public static void main (String[] argv)
    {
        AntEaterFrame f = new AntEaterFrame ();
    }

}
