
/**
 * This class implements an Instruction Queue that has the same functionality as your base instruction Queue.
 * However, This time you will be implementing that functionality by using the 2 stacks the we have provided.
 * The ExtensionStack class is fully implemented for you and you should not change it.
 *      It is a data structure that holds a stack of instructions. Much like your base version had nodes that contained the instructions.
 *      Use the functions in this class to help you implement your new Queue.
 */
public class ExtensionQueue {

    private ExtensionStack leftStack;
    private ExtensionStack rightStack;

    public ExtensionQueue(){
        leftStack = new ExtensionStack();
        rightStack = new ExtensionStack();
    }

    /* add a new element to your Queue, adjust the nodes accordingly
     */
    public void enqueue(int duration, MyOperation operation){
        //TODO

    }

    /* return and remove the appropriate element from the queue
    if empty, return null
     */
    public Instruction dequeue(){
        //TODO
        return null;
    }

    /* return true if there is nothing in the stack, false otherwise
     */
    public boolean isEmpty(){
        //TODO
        return false;
    }

    @Override
    /**
     * return the contents as a string
     */
    public String toString() {
        //TODO

        return "";
    }
}
