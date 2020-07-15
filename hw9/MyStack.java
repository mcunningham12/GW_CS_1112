/*-------------------------------------------------
Author: Maxwell Cunningham
This program documents methods related to
manipulating a stack based on an array of integers
------------------------------------------------*/
public class MyStack {

    //global variables
    private int top;
    private int[] data;

    public MyStack(){
        top = 0;
        data = new int[3];
    }


    ///This method allows an integer to be added
    ///to the top of the stack
    public void push(int insert){
        //check if the array is full
        if(top >=data.length) {
            //if so, create a new array with double the length
            int[] nD = new int[data.length*2];
            //add previous elements to the new array
            for(int i=0;i<data.length;i++){
                nD[i]=data[i];
            }
            //add the new element to the new array
            nD[top]=insert;
            //have data reference the new array so data
            //can still be used as a global variable
            data = nD;
            //increment top
            top++;
        } else {
            //if there is enough space, just add and incremenet top
            data[top]=insert;
            top++;
        }
    }

    ///This method returns the integer at the top of the stack
    ///    and removes it from the stack.
    ///If the stack is empty, returns Integer.MIN_VALUE
    public int pop(){
        //check if the array is empty
        if(isEmpty()){
            return Integer.MIN_VALUE;
        }
        //if the array is not empty, decrement top and return
        top--;
        return data[top];
    }

    ///Returns the element on the top of the stack without removing it
    public int peek(){
        //check if the array is empty
        if(isEmpty()){
            return Integer.MIN_VALUE;
        }
        //return element at the top without removing
        return data[top-1];
    }

    ///Returns true if the stack is empty
    ///Return false if the stack is not empty
    public boolean isEmpty(){
        //check where top is
        //if 0, the stack is empty
        if(top>0){
            return false;
        }
        return true;
    }

    ///Converts the stack into a string, from top to bottom
    ///If empty, returns []
    public String toString() {
        String s = "[";
        //traverse the whole stack
        for(int i = top-1;i>=0;i--){
            //for last element, do not add a comma
            if(i==0){
                s+=data[0];
            } else {
            //add to the string
            s+= data[i] + ",";
            }
        }
        //finalize the string
        s+="]";
        return s;
    }
}
