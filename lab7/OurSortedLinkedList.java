class ListItem {
    int data;
    ListItem next;
}

public class OurSortedLinkedList {
    int numItems = 0;
    ListItem front = null;
    ListItem rear = null;
    
    public void add (int K)
    {
        if (front == null) {
            // This is the same as before:
            front = new ListItem();
            front.data = K;
            rear = front;
            rear.next = null;
        }
        else {
            // This part is a little more complicated now since
            // we have to first find the right place and then
            // possibly insert between existing elements.
            // Find the right place for it.
            ListItem listPtr = front;
            ListItem followPtr = null;
            while ( (listPtr != null) && (listPtr.data < K) ) {
                followPtr = listPtr;
                listPtr = listPtr.next;
            }
            // Make the node.
            ListItem nextOne = new ListItem ();
            nextOne.data = K;
            // There are three cases to handle.
            if (listPtr == front) {
                // CASE 1: Insert in front.
                nextOne.next = front;
                front = nextOne;
            }
            else if (listPtr == null) {
                // CASE 2: Insert at rear.
                rear.next = nextOne;
                rear = nextOne;
            }
            else {
                // CASE 3: Insert in the middle.
                followPtr.next = nextOne;
                nextOne.next = listPtr;
            }
        }
        numItems ++;
    }

 public boolean contains (int K)
 {
    if (front == null) {
        return false;
    }
    
    // Start from the front and walk down the list. We don't
    // have to go further once we've hit something larger than K.
    
    ListItem listPtr = front;
    while ( (listPtr != null) && (listPtr.data <= K) ) {
        if ( listPtr.data == K ) {
            return true;
        }
    listPtr = listPtr.next;
    }
    return false;
 }
 public void printWithAddresses ()
 {
    if (front == null) {
        return;
    }
    ListItem listPtr = front;
    while (listPtr != null) {
        // listPtr's default toString() prints out the memory address.
        System.out.println (" \"" + listPtr.data + "\" at address " + listPtr);
        listPtr = listPtr.next;
        }
  }
   
}
