/*-----------------------------------------------------------------
Author: Maxwell Cunningham
This class provides unit tests for MyQueue
-----------------------------------------------------------------*/
public class QueueTesting {

    public static void main(String[] args){
        //call the unit tests and print the results
        System.out.println("enqueue test 1: " + enqueueTest1());
        System.out.println("enqueue test 2: " + enqueueTest2());
        System.out.println("dequeue test 1: " + dequeueTest1());
        System.out.println("dequeue test 2: " + dequeueTest2());
        System.out.println("isEmpty test 1: " + isEmptyTest1());
        System.out.println("isEmpty test 2: " + isEmptyTest2());
        System.out.println("isEmpty test 3: " + isEmptyTest3());
        System.out.println("toString test 1: " + toStringTest1());
        System.out.println("toString test 2: " + toStringTest2());
    }
    public static boolean enqueueTest1(){
        //create queue and add elements
        MyQueue q = new MyQueue();
        q.enqueue(5, new MyOperation(OpType.LOAD,0));
        //null check in between enqueues
        q.enqueue(5, null);
        q.enqueue(3, new MyOperation(OpType.ADD,0));
        //if the string has correct orientation, the enqueue method worked correctly
        if(!q.toString().equals("[Duration: 5, Operation with type=LOAD and value=0, Duration: 3, Operation with type=ADD and value=0]")) {
            return false;
        }        
        return true;
    }
    public static boolean enqueueTest2(){
        //create queue and add elements
        MyQueue q = new MyQueue();
        //this should do nothing
        q.enqueue(3, null);
        //these should be enqueued
        q.enqueue(4, new MyOperation(OpType.STORE,1));
        q.enqueue(2, new MyOperation(OpType.ADD,1));
        q.enqueue(7, new MyOperation(OpType.SUB,3));
        //if the string is correct, enqueue worked correctly
        if(!q.toString().equals("[Duration: 4, Operation with type=STORE and value=1, Duration: 2, Operation with type=ADD and value=1, Duration: 7, Operation with type=SUB and value=3]")){
            return false;
        }
        return true;
    }

    public static boolean dequeueTest1(){
        //create queue
        MyQueue q = new MyQueue();
        //make sure an empty queue returns nothing on dequeue
        if(q.dequeue() != null){
            return false;
        }
        return true;
    }

    public static boolean dequeueTest2(){
        //create queue and add elements
        MyQueue q = new MyQueue();
        q.enqueue(3, new MyOperation(OpType.LOAD,-1));
        q.enqueue(5, new MyOperation(OpType.STORE, -1));
        q.enqueue(1, new MyOperation(OpType.ADD,-1));
        //set instruction i equal to dequeued instruction
        Instruction i = q.dequeue();
        //make sure it is equal to the instruction from
        //the first element added
        if(i.getDuration() !=3){
            return false;
        }
        //create new operatoin and make sure it is equal to
        //the first operation added
        MyOperation m = new MyOperation(OpType.LOAD, -1);
        if(!i.getOp().toString().equals(m.toString())){
            return false;
        }
        //now check the second element added
        i=q.dequeue();
        //make sure the duration is right
        if(i.getDuration() != 5){
            return false;
        }
        m = new MyOperation(OpType.STORE, -1);
        //make sure the instruction is right
        if(!i.getOp().toString().equals(m.toString())){
            return false;
        }
        return true;
    }

    public static boolean isEmptyTest1(){
        //create queue and add elements
        MyQueue q = new MyQueue();
        q.enqueue(3, new MyOperation(OpType.LOAD, -1));
        q.dequeue();
        //make sure it is empty
        if(q.isEmpty() != true){
            return false;
        }
        return true;
    }
    public static boolean isEmptyTest2(){
        //create queue and add element 
        MyQueue q = new MyQueue();
        q.enqueue(3, new MyOperation(OpType.SUB, -2));
        //make sure it is not empty
        if(q.isEmpty() != false){
            return false;
        }
        return true;
    }
    public static boolean isEmptyTest3(){
        //create queue and add elements
        MyQueue q = new MyQueue();
        q.enqueue(7, new MyOperation(OpType.ADD, -3));
        q.enqueue(3, new MyOperation(OpType.LOAD, -5)); 
        q.enqueue(3, new MyOperation(OpType.LOAD,-1));
        q.enqueue(5, new MyOperation(OpType.STORE, -1));
        q.enqueue(1, new MyOperation(OpType.ADD,-1));
        q.dequeue();
        q.dequeue();
        //make sure it is not empty
        if(q.isEmpty() != false){
            return false;
        }
        return true;
    }
    public static boolean toStringTest1(){ 
        //create queue and add elements
        MyQueue q = new MyQueue();
        q.enqueue(7, new MyOperation(OpType.ADD, -3));
        q.enqueue(3, new MyOperation(OpType.LOAD, -5)); 
        q.enqueue(3, new MyOperation(OpType.LOAD,-1));
        q.enqueue(5, new MyOperation(OpType.STORE, -1));
        q.enqueue(1, new MyOperation(OpType.ADD,-1));
        q.dequeue();
	q.dequeue();
        //make sure string is right
        if(!q.toString().equals("[Duration: 3, Operation with type=LOAD and value=-1, Duration: 5, Operation with type=STORE and value=-1, Duration: 1, Operation with type=ADD and value=-1]")){
        return false;
	}
	return true;
    }

    public static boolean toStringTest2(){
        //create queue and add elements
        MyQueue q = new MyQueue();
        q.enqueue(5, new MyOperation(OpType.LOAD,0));
        q.enqueue(3, new MyOperation(OpType.ADD,0));
    	q.enqueue(7, new MyOperation(OpType.SUB, -5));
    	q.dequeue();
    	q.dequeue();
        //make sure string is right
    	if(!q.toString().equals("[Duration: 7, Operation with type=SUB and value=-5]")){
		return false;
	}
	return true;
    }

}
