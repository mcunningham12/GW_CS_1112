/*-------------------------------------------------------------------------
This class is a series of methods that operates on a catalog of shows

author: Maxwell Cunningham
-------------------------------------------------------------------------*/
public class Catalog {

    private Node head;
    private Node current;  //the show you are currently looking at

    //A newly created linked list is completely and all members are null
    public Catalog() {
        head = null;
        current = null;
    }

    //adds a new node to the back of the array with String show as the name
    //  returns true if the string is valid
    //  return false if the string is null
    //  returns false if the show has already been added
    public boolean addToBack(String show) {
        if(show == null){
            return false;
        }
        //check if the show is already in the linked list
        //make current the head and have listPtr traverse the list
        Node listPtr = head;
        current = head;
        while (listPtr != null) {
            //if you've gone through the whole list without finding show
            //then exit the while loop
            if (listPtr.next == current){
                break;
            }
            //check if the show exists where listPtr is in the list
            if (listPtr.data.show.equals(show)) {
                return false;
            }
            //increment listPtr
            listPtr = listPtr.next;
        }

        //if the linked list is empty
        if (head == null) {
            //create new node
            Node first = new Node(show);
            //since it is the first node in the list, it is the head
            head = first;
            current = first;
            //since there exist no other nodes, it must point to itself
            //in both directions
            head.next = first;
            head.prev = first;
            return true;
        }
        //if the list is not empty
        //make a new node and set it to be the current one
        Node nextOne = new Node(show);
        current = nextOne;
        //redo pointers
        //since this is the back of the list, the new node should point to the head
        //in the forward direction, and point to what used to be the tail
        //in the other direction
        nextOne.prev = head.prev;
        nextOne.next = head;
        nextOne.prev.next = nextOne;
        nextOne.next.prev = nextOne;
        return true;
    }
    
    //add a show by name to the linked list
    //  return true if the name does not already exist in the list
    //      adds the name to the list
    //  return false if the name already exists 
    //      does not add
    //  return false if the name is null
    public boolean addToFront(String show) {
        //null check
        if(show == null){
            return false;
        }
        //check if the show is already in the linked list
        //make current the head and have listPtr traverse the list
        Node listPtr = head;
        current = head;
        while (listPtr != null) {
            //if you've gone through the whole list without finding show
            //then exit the while loop
            if (listPtr.next == current){
                break;
            }
            //check if the show exists where listPtr is in the list
            if (listPtr.data.show.equals(show)) {
                return false;
            }
            //increment listPtr
            listPtr = listPtr.next;
        }

        //if the linked list is empty
        if (head == null) {
            //make a new node, make it the head, and have it point to
            //itself in both directions
            Node first = new Node(show);
            head = first;
            current = first;
            head.next = first;
            head.prev = first;
            return true;
        }
        //if the list is not empty, make a new node and set it to current
        Node nextOne = new Node(show);
        current = nextOne;
        //redo pointers
        //it should point to the tail in the prev direction and point to the
        //former head in the next direction
        nextOne.prev = head.prev;
        nextOne.next = head;
        head.prev = nextOne;
        head.prev.prev.next = nextOne; 
        //since added at front, head now points to this node
        head = nextOne;
        return true;
    }
    
    //remove a show by name from the linked list
    //  return true if the name exists in the list
    //      removes the show from the list while maintaining its integrity
    //  returns false if the name does not exist in the list
    //      removes nothing
    //  returns false if the name is null
    public boolean removeShow(String show) {
        //null check
        if (head == null) {
            return false;
        }
        Node listPtr = head;
        current = head;
        while (listPtr != null) {
            //if list has been traversed without finding the name
            //  break the while loop and return false
            if (listPtr.next == current){
                break;
            }
            if (listPtr.data.show.equals(show)) {
                current=listPtr.prev;
                listPtr.prev.next = listPtr.next;
                listPtr.next.prev = listPtr.prev;
                //after these two are executed, listPtr will be garbage collected
                return true;
            }
            listPtr = listPtr.next;
        }
        return false;
    }

    //empties the linked list entirely
    public void clear() {
        head = null;
	current = null;
    }

    //checks if the list is completely empty or not
    //  returns false if there exists at least one element in the list
    //  returns true if there are no elements in the list
    public boolean isEmpty() {
        if (head != null){
            return false;
        }
        return true;
    }

    //returns the name of the current show
    public String getCurrentShow() {
        return current.data.show;
    }

    //advances current to the next show and returns its name
    public String stepForward() {
        //null check
        if (current.next != null){
            //advance current and return the name of the show
            current = current.next;
            return current.data.show;
        }
        return null;
    }

    //moves current to the previous show in the list and returns its name
    public String stepBackward() {
        //null check
        if (current.prev != null) {
            //move current back one and return the name of the show
            current = current.prev;
            return current.data.show;
        }
        return null;
    }


    /* ---------------------------- HELPERS -------------------------------
    This section contians helper functions that support the class.  Some
    may only be internally used while others may be publicly exposed for
    general usage like toString and checkIntegrity.
    For example, you might add a search function here. 
    ---------------------------------------------------------------------*/
    /// This method is inherited from the Object base class and allows
    /// a user of this class to serialize the state which might be used for
    /// printing.  If the list is not internally consistent, then this
    /// method might generate an exception.  
    public String toString() {
        if(head == null) {
            return null;
        }

        String s = new String("[");

        Node it = head;
        s += it.data.show + "<=>";
        it = it.next;

        while(it != head) {
            s += it.data.show + "<=>";
            it = it.next;
        }

        s += "], current:";
        if(current != null) {
            s += current.data.show;
        } else {
            s += "null";
        }
        
        return s; 
    }

    /// This method performs a number of tests to validate the integrity
    /// of the linked list 
    /// @returns true if the list is internally consistent; otherwise, 
    ///          returns false.
    public boolean checkIntegrity() {
        // sanity check
        if(head == null) {
            // if list empty, but current is set, integrity compromised
            if(current != null) {
                return false;
            }   
            // otherwise, empty list has full integrity
            return true;
        }

        // if the head has any illegal pointers, integrity compromised
        if(head.next == null || head.prev == null) {
            return false;
        }
       
        // check that the rest of the list has the correct references.
        // already checked head, move to second element
        Node it = head.next;
        while(it != head) {          // when we circle back to head, done
            if(it.next.prev != it) {
                return false;
            }
            if(it.prev.next != it) {
                return false;
            }
            it = it.next;
        }

        // at this point, current should be set.  If it is not, the 
        // integrity is compromised
        if(current == null) {
            return false;
        }

        return true;
    }


    /*---------------------------- EXTENSION ------------------------------
    This section contains functions that are part of the extension 
    implementation.  Functions primarily consist of sort interfaces (public)
    and any internal functions (private) needed to support a specific sort
    ---------------------------------------------------------------------*/
    public enum SortType {
        SELECTION,
        BUBBLE,
        INSERTION,
        QUICK,
        MERGE
    }

    public void sort(SortType type) {
        switch(type) {
            case SELECTION:
                sortSelection();
                break;
            case BUBBLE:
                sortBubble();
                break;
            case INSERTION:
                sortInsertion();
                break;
            case QUICK:
                sortQuick();
                break;
            case MERGE:
                sortMerge();
                break;
        }
    }

    public void sortSelection() {

    }

    public void sortBubble() {

    }

    public void sortInsertion() {

    }

    public void sortQuick() {

    }

    public void sortMerge() {

    }
}
