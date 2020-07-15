import java.util.*;
//This is exercise 8
public class QueueExample {

    public static void main (String[] argv)
    {
        // We'll use Java's LinkedList as our queue.
        LinkedList<String> taskQueue = new LinkedList<String>();

        // Add some strings.
        taskQueue.add ("Pay bills");
        taskQueue.add ("Clean room");
        taskQueue.add ("Do homework");
        taskQueue.add ("See movie");
        taskQueue.add ("Hang out");
        
        // Now extract in "queue" order using the removeFirst() method in LinkedList.
        
        taskQueue.removeFirst();
        System.out.println(taskQueue);
        System.out.println ("=> Tasks remaining: " + taskQueue.size());

        taskQueue.removeFirst();
        System.out.println(taskQueue);
        System.out.println ("=> Tasks remaining: " + taskQueue.size());

        taskQueue.removeFirst();
        System.out.println(taskQueue);
        System.out.println ("=> Tasks remaining: " + taskQueue.size());

        taskQueue.removeFirst();
        System.out.println(taskQueue);
        System.out.println ("=> Tasks remaining: " + taskQueue.size());

        taskQueue.removeFirst();
        System.out.println(taskQueue);
        System.out.println ("=> Tasks remaining: " + taskQueue.size());
    }
}
