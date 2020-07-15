wimport java.util.Arrays;

public class ExtensionStack {

    private Instruction[] stack;
    private int count;

    public ExtensionStack() {
        stack = new Instruction[12];
        count = 0;
    }

    /**
     * This adds an instruction to the top of your stack
     *
     * @param instruction the instruction object you want to add
     */
    public void push(Instruction instruction){

        if (count==stack.length){
            Instruction[] biggerStack = new Instruction[stack.length*2];
            for (int i = 0; i< stack.length; i++){
                biggerStack[i] = stack[i];
            }

            stack = biggerStack;
        }

        stack[count] = instruction;
        count++;
    }

    /* return the top of stack and remove it
     if there is nothing in the stack, returns null
     */
    public Instruction pop(){
        //TODO
        if (isEmpty()){
            return null;
        }

        count --;

        return stack[count];
    }

    /* return the top of stack without removing it
     if there is nothing in the stack, returns null
     */
    public Instruction peek(){
        //TODO
        if (isEmpty()){
            return null;
        }

        return stack[count-1];
    }

    /* return true if there is nothing in the stack, false otherwise

     */
    public boolean isEmpty(){

        return (count == 0);
    }

    @Override
    public String toString() {
        String ret = "[";

        for (int i = 0;i<count;i++){
            ret += stack[i].toString();
            if (i+1!=count) ret+=", ";
        }

        return ret+"]";
    }
}
