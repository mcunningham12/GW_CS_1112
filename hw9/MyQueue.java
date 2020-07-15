/*-------------------------------------------------
Author: Maxwell Cunningham

This class creates a queue based on a Linked List
and has various methods to manipulate it
--------------------------------------------------*/
public class MyQueue {

    //each node has an instruction and a next node
    //this is a single linked list
    private class Node{
        Instruction inst;
        Node next;
    }

    //global variables
    private Node head;
    private Node tail;

    public MyQueue(){
        head = null;
        tail = null;
    }

    //this method adds an operation and duration for said operation
    //to the top of the queue
    public void enqueue(int duration, MyOperation operation){
        //do not enqueue an invalid operation
        if(operation == null){
            return;
        }
        //if the operation is valid, then run the method
        else {
            //if the queue is empty
            if (head == null){
                //make new node
                Node create = new Node();
                //set head and tail equal to node
                head=create;
                tail=create;
                //make new instruction and add it to the new node
                Instruction i = new Instruction(duration, operation);
                create.inst = i;
            } else {
            //if the queue already has a head
            //make new node
            Node create = new Node();
            //put the new node at the end of the list
            tail.next=create;
            tail=create;
            //create new instruction with the given parameters
            //insert instruction into the created node
            Instruction i = new Instruction(duration, operation);
            create.inst=i;
            }
        } //end else
    }

    //this method removes the instruction that was first inserted
    //returns first instruction if it exists
    //if empty, returns null
    public Instruction dequeue(){
        //if the queue is empty, return null
        if(head == null){
            return null;
        }
        //if there are elements in the queue
        //  return the element at the top of the queue
        Instruction ret = head.inst;
        head = head.next;
        return ret;
    }

    //returns true if the queue has no elements
    //returns false if there exist elements in the queue
    public boolean isEmpty(){
        //check if there is a head
        if(head == null){
            return true;
        }
        //if not
        return false;
    }
    
    //this method converts the queue into an appropriate string
    public String toString() {
        //create a node to traverse the string
        //starting at the front
        Node trav = new Node();
        trav = head;
        //create string
        String s = "[";
        //traverse the linked list
        while(trav != null){
            //if the node is not the last one
            if(trav.next != null){
                s+="Duration: " + trav.inst.getDuration() + ", " + trav.inst.getOp()+", ";
            //if it is the last one, do not add a comma at the end
            } else if(trav.next == null) {
              s+="Duration: " + trav.inst.getDuration() + ", " + trav.inst.getOp();
            }
            //increment the node traversing the queue
            trav=trav.next;
        }
        //finish the string and return it
        s+="]";
        return s;
    }
}
