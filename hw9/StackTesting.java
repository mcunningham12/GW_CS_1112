/*--------------------------------------------------------------
Author: Maxwell Cunningham
This class provides a series of unit tests for MyStack:
--------------------------------------------------------------*/
public class StackTesting {

    public static void main(String[] args){
        //call the unit tests and return their value
        System.out.println("push test 1: " + pushTest1());
        System.out.println("push test 2: " + pushTest2());
        System.out.println("pop test 1: " + popTest1());
        System.out.println("pop test 2: " + popTest2());
        System.out.println("peek test 1: " +peekTest1());
        System.out.println("peek test 2: " +peekTest2());
        System.out.println("peek test 3: " + peekTest3());
        System.out.println("isEmpty test 1: " +isEmptyTest1());
        System.out.println("isEmpty test 2: " +isEmptyTest2());
        System.out.println("isEmpty test 3: " +isEmptyTest3());
        System.out.println("toString test 1: " + toStringTest1());
        System.out.println("toString test 2: " + toStringTest2());
    }

///Unit Tests----------------------------------------------------
    
    public static boolean pushTest1(){
        //create stack and add elements
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(-1);
        stack.push(2);
        //check the orientation of the stack with toString
        if(!stack.toString().equals("[2,-1,1]")) {
            return false;
        }
        return true;
    }
    //this test makes sure the stack works after it has to expand
    //past the initial 3 elements
    public static boolean pushTest2(){
        //create stack and add elements
        MyStack stack = new MyStack();
        stack.push(3);
        stack.push(7);
        stack.push(-5);
        stack.push(10);
        stack.push(25);
        //check the orientation of the stack with toString
        if(!stack.toString().equals("[25,10,-5,7,3]")){
            return false;
        }
        return true;
    } 

    public static boolean popTest1() {
        //create stack and add elements
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(-1);
        stack.push(2);
        //use pop to get the integer we just added
        if(stack.pop() != 2){
            return false;
        }
        return true;
    }

    public static boolean popTest2() {
        //create stack and add elements
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        //use pop to get integer just added
        int x = stack.pop();
        if(x != 5){
            return false;
        }
        //pop the stack again and get the next element
        x=stack.pop();
        if(x!= 4){
            return false;
        }
        return true;
    }

    public static boolean peekTest1() { 
        //create stack and add elements
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(-1);
        stack.push(2);
        //check if peek returns correct value
        if(stack.peek() !=2){
            return false;
        }
        //check if the value was not removed
        if(stack.pop() !=2){
            return false;
        }
        return true;
    }

    public static boolean peekTest2() {
        //create stack and add elements
        MyStack stack = new MyStack();
        stack.push(35);
        stack.push(72);
        //manipulate the stack
        stack.pop();
        stack.pop();
        stack.push(60);
        stack.pop();
        //make sure an empty stack returns the right value
        if(stack.peek() != Integer.MIN_VALUE){
            return false;
        }
        return true;
    }

    public static boolean peekTest3() {
        //create stack and add elements
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(5);
        stack.push(7);
        stack.push(9);
        //make sure stack peeks at correct element
        if(stack.peek() != 9){
            return false;
        }
        return true;
    }

    public static boolean isEmptyTest1() {
        //create a stack
        MyStack stack = new MyStack();
        //make sure isEmpty returns correctly
        if(stack.isEmpty() != true){
            return false;
        }
        return true;
    }
    public static boolean isEmptyTest2() {
        //create a stack and add elements
        MyStack stack = new MyStack();
        stack.push(3);
        stack.push(5);
        //make sure isEmpty returns correctly
        if(stack.isEmpty() != false){
            return false;
        }
        return true;
    }
    public static boolean isEmptyTest3() {
        //create stack and add elements
        MyStack stack = new MyStack();
        stack.push(7);
        stack.push(11);
        //remove elements
        stack.pop();
        stack.pop();
        //make sure isEmpty is still true
        if(stack.isEmpty() != true){
            return false;
        }     
        return true;
    }

    public static boolean toStringTest1() {
        //create stack and add elements
        MyStack stack = new MyStack();
        stack.push(7);
        stack.push(3);
        stack.push(9);
        //make sure string is good
        if(!stack.toString().equals("[9,3,7]")){
            return false;
        }
        //make sure string is good without top element
        stack.pop();
        if(!stack.toString().equals("[3,7]")){
            return false;
        }
        stack.pop();
        stack.pop();
        //make sure string returns properly when stack is empty
        if(!stack.toString().equals("[]")){
            return false;
        } 
        return true;
    }
    public static boolean toStringTest2() {
        //create stack and add elements
        MyStack stack = new MyStack();
        //make sure an empty stack returns the proper string
        if(!stack.toString().equals("[]")){
            return false;
        }
        //add and then remove some elements
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.pop();
        stack.pop();
        if(!stack.toString().equals("[2,1]")){
            return false;
        }
        return true;
    }
}
