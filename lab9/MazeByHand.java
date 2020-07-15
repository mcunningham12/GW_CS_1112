
import java.util.*;

public class MazeByHand {

    public static void main (String[] argv)
    {
        //create maze, start point, and end point
        Maze maze = new Maze (5, 5);
        Coord c1 = new Coord(3,4);
        Coord c2 = new Coord(1,1);
        //break walls between (3,4) and (1,1)
        maze.breakWall(c1,new Coord(3,3));
        maze.breakWall(new Coord(3,3),new Coord(3,2));
        maze.breakWall(new Coord(3,2),new Coord(2,2));
        maze.breakWall(new Coord(2,2),new Coord(2,1));
        maze.breakWall(new Coord(2,1),new Coord(1,1));
        //make list and add coordinates to it
        LinkedList<Coord> solutionPath = new LinkedList<Coord>();
        solutionPath.add(new Coord(3,4));
        solutionPath.add(new Coord(3,3));
        solutionPath.add(new Coord(3,2));
        solutionPath.add(new Coord(2,2));
        solutionPath.add(new Coord(2,1));
        solutionPath.add(new Coord(1,1));
        maze.setSolutionPath(solutionPath);
        maze.display ();        
    }
}
