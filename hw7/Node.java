/*-------------------------------------------------------------------------
This class encapsulates all data required for a node/element in a doubly 
linked list

author: James Levy, James Taylor
-------------------------------------------------------------------------*/
public class Node {

    // the data reference is final because it is not allowed to change 
    // after construction.  To change it, must create a new node. 
    public final Data data; // reference to list data
    public Node next;       // next Node in the list
    public Node prev;       // previous Node in the list

    // Parameterized constructor requires the show be assigned at the time
    // of creation
    // @param show the show to add to the list 
    public Node(String show) {
        data = new Data(show);
        next = null;
        prev = null;
    }
}
