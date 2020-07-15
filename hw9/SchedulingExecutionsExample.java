
import java.util.Scanner;

public class SchedulingExecutionsExample {

    private static MyStack valueStack = new MyStack();
    private static MyQueue instructionQ = new MyQueue();

    /**
     * This class is a main menu that you can execute.
     * It will be the hub of your program and will prompt the user for inputs which correlate to the functions you implement below
     * DO NOT MODIFY THE CODE FOR MAIN. It is already implemented for you.
     * @param args
     */
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //this allows the user to enter in values when prompted

        int menuChoice = -1;
        while(menuChoice!=0){ //while loop that keeps going until user prompts it to stop
            System.out.println("Insert an integer based on what functionality you want then press enter to continue");
            System.out.println("1. create an instruction");
            System.out.println("2. execute your instructions");
            System.out.println("3. reset your current state");
            System.out.println("0. exit the program");
            menuChoice = sc.nextInt();

            if (menuChoice == 1){  //this will ask for inputs and lead to the fill function below
                sc.nextLine();
                System.out.println("insert the type of operation you wish to create: (LOAD, STORE, ADD, MUL, SUB, DIV, MOD;)");
                String oType = sc.nextLine();
                oType = oType.toUpperCase();

                MyOperation op = null;
                if (oType.equals("LOAD")){
                    System.out.println("insert a value (int) to put into the system:");
                    int val = sc.nextInt();
                    op = new MyOperation(OpType.LOAD,val);
                }else if (oType.equals("STORE")){
                    op = new MyOperation(OpType.STORE);
                }else if (oType.equals("ADD")){
                    op = new MyOperation(OpType.ADD);
                }else if (oType.equals("MUL")){
                    op = new MyOperation(OpType.MUL);
                }else if (oType.equals("SUB")){
                    op = new MyOperation(OpType.SUB);
                }else if (oType.equals("DIV")){
                    op = new MyOperation(OpType.DIV);
                }else if (oType.equals("MOD")){
                    op = new MyOperation(OpType.MOD);
                }else{
                    System.out.println("this was not a valid operation");
                }

                if (op!=null){
                    System.out.println("insert a duration (int) to be associated with this operation:");
                    int dur = sc.nextInt();
                    fill(op,dur);
                }

            }else if (menuChoice == 2){ //this will ask for inputs and lead to the execute function below

                System.out.println("insert a duration (int) for how long you wish to run your instructions:");
                int len = sc.nextInt();
                execute(len);

            }else if (menuChoice == 3){ //this wil lead to the flush function below
                flush();
            }else if (menuChoice!=0){
                System.out.println("this was not a valid menu option");
            }

        }

        sc.close();
    }


    /**
     * insert elements into your instruction Queue to be executed at a later time
     *
     * @param o the type and value associated with the operation. This should be based off of user input in the main method.
     * @param dur how long the instruction takes to execute
     */
    public static void fill(MyOperation o, int dur){
        //enqueue the operation and its duration
        instructionQ.enqueue(dur,o);
    }

    /**
     * should execute the instructions inside of your Queue for as long as you still have time to execute them by doing the required work and
     *      removing them from the Queue.
     * for each type of operation:
     *      Load places a value on your stack
     *      Store prints a value to the screen and removes it from the stack
     *      Opertations such as ADD, MUL, SUB, DIV, MOD should use the stockOperations function to perform arithmatic
     * The end of the execute function should print how many instructions you were executed and the total execution time for those instructions.
     *
     * @param time the amount of time you have to execute instructions
     */
    public static void execute(int time){
        //create a while loop that runs if there is still time
        //and the queue is not empty
        int instructions=0;
        int timeSpanned=0;
        while(instructionQ.isEmpty() == false && time > 0){
            //get the instruction at the top of the queue and its duration
            Instruction i = instructionQ.dequeue();
            int duration = i.getDuration();
            //get the type from the instruction
            OpType o = i.getOp().getType();
            //if the type is load, add that value to the stack
            if(o.toString().equals("LOAD")){
               valueStack.push(i.getOp().getValue());
            }
            //if the type is store, remove from stack and print it
            else if(o.toString().equals("STORE")){
                int x = valueStack.pop();
                System.out.println(x);                
            }
            //if the type is not load or store, 
            else {
                stackOperations(i.getOp().getType());                
            }
            //increment timeSpanned by duration
            //subtract given time by duration
            //increment instructions
            timeSpanned+=duration; 
            time=time-duration;
            instructions++;
        }
        //print time spanned and instructions
        System.out.println("Instructions executed: " + instructions);
        System.out.println("Total execution time: " + timeSpanned); 
    }

    /**
     * clear everything out of your instruction Queue and value Stack
     */
    public static void flush(){
        //set the queue and stack equal to new objects that are empty
        instructionQ = new MyQueue();
        valueStack = new MyStack();
    }

    /**
     * This function uses the stack to perform arithmetic operations.
     * Opertations such as ADD, MUL, SUB, DIV, MOD do the corresponding arithmetic computation by popping the top 2 elements
     *           from the stack then pushing the result onto the stack.
     *           For example in substraction, it would be the bottom element - the top element of the 2 that you pulled out.
     *              if the stack has Bottom--> 3 --> 1 --> top, SUB would perform 3-1.
     * If there is a reason the execution may not work or is invalid, print the error to the screen
     *
     * @param type The type of arithmetic operation that you want to execute.
     */
    public static void stackOperations(OpType type){
        //I am writing this method under the assumption it is not called for
        //LOAD or STORE since I wrote execute with this parameter
        //if the stack is empty, do nothing
        if (valueStack.isEmpty()==true){
            System.out.println("The stack is empty. No operation will occur");
            return;
        //if the stack is not empty, run the method
        } else {
            //pop the top two elements from the stack
            int x = valueStack.pop();
            int y = valueStack.pop();
            
            //do the operation corresponding to given type
            if(type.toString().equals("ADD")){
                int z = y+x;
                System.out.println(y + "+" + x+"="+z);
            }
            //make sure the order is correct, element closer to bottom - top
            else if(type.toString().equals("SUB")){
                int z = y-x;
                System.out.println(y + "-" + x+"="+z);
            }
            else if(type.toString().equals("MUL")){
                int z = y*x;
                System.out.println(y + "*" + x+"="+z);
            }
            //make sure order is correct, element closer to bottom/top 
            else if(type.toString().equals("DIV")){
                double z = (double) y/x;
                System.out.println(y + "/" + x+"="+z);
            } 
            //again, make sure the order is correct, y mod x
            else if(type.toString().equals("MOD")){
                int z = y%x;
                System.out.println(y + "MOD" + x+"="+z);
            }
        }
    }
}
