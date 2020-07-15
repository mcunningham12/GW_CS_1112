import java.util.*;
//This is exercise 9
public class QueueExample2 {

    public static void main (String[] argv)
    {
        // We'll use Java's LinkedList as our queue.
        ArrayList<String> taskQueue = new ArrayList<String>();
        int top=0;
        // Add some strings.
        taskQueue.add ("Pay bills");
        top++;
        taskQueue.add ("Clean room");
        top++;
        taskQueue.add ("Do homework");
        top++;
        taskQueue.add ("See movie");
        top++;
        taskQueue.add ("Hang out");
        top++;        

        // Now extract in "queue" order using the method below.
        removeQueue(taskQueue, top);
    }
    public static void removeQueue(ArrayList<String> taskQueue, int top) {
        while (top > 0) {
            taskQueue.remove(top-1);
            System.out.println(taskQueue);
            System.out.println ("=> Tasks remaining: " + taskQueue.size());
            top--;
        }
    }
}
