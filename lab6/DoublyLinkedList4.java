class ListItem {

    String data;
    ListItem next;    // To point to next node in list.
    ListItem prev;    // To point to the previous node in the list.

}


public class DoublyLinkedList4 {

    // Instance variables.
    ListItem front = null;
    ListItem rear = null;

    int numItems = 0;

    public void add (String s)
    {
	if (front == null) {
            // Similar to singly-linked list, except for setting rear.prev
	    front = new ListItem ();
	    front.data = s;
	    rear = front;
	    rear.next = null;
	    rear.prev = null;           // Must set this correctly.
            System.out.println("Address: " + front);
	}
	else {
            // Make new ListItem and set its fields correctly.
            ListItem nextOne = new ListItem ();
	    nextOne.data = s;
	    nextOne.next = null;
	    nextOne.prev = rear;

            // Adjust the next pointer of the current last one, and adjust rear itself.
	    rear.next = nextOne;
	    rear = nextOne;
            System.out.println("Address: " + nextOne);
	}    
	numItems ++;
    }


    public int size ()
    {
	return numItems;
    }

    
    public String get (int i)
    {
	if (i >= numItems) {
	    return null;
	}
	int count = 0;

	ListItem listPtr = front;
	while (count < i) {
	    listPtr = listPtr.next;
	    count ++;
	}
	return listPtr.data;
    }


    public boolean contains (String s)
    {
	if (front == null) {
	    return false;
	}

    // Forward traversal.
	ListItem listPtr = front;
	while (listPtr != null) {
	    if ( listPtr.data.equals(s) ) {
		    return true;
	    }
	    listPtr = listPtr.next;
	}
	return false;
    }


    public String toString ()
    {
	if (front == null) {
	    return "empty";
	}
	String s = "";
	ListItem listPtr = front;
	while (listPtr != null) {
	    s += " \"" + listPtr.data + "\"";
	    listPtr = listPtr.next;
	}
	return s;
    }



    // Find String s and delete it if it occurs in the list.

    public void delete (String s)
    {
	ListItem listPtr = front;
	while ( (listPtr != null) && (! listPtr.data.equals(s)) ) {
	    listPtr = listPtr.next;
	}

    // If it's not there, return.
	if (listPtr == null) {
	    return;
	}

	// Otherwise delete: four cases.
    if (front == rear) {
        // Case 1: only one element.
        System.out.println("Only node: " + listPtr);
        front = rear = null;
    }
    else if (listPtr == front) {
        // Case 2: we're deleting from the front.
	System.out.println("First node: " + listPtr);
        System.out.println("Next node: " + listPtr.next);
        front = listPtr.next;
        front.prev = null;
    }
    else if (listPtr == rear) {
        // Case 3: delete the last element.
	System.out.println("Node before last: " + listPtr.prev);
        System.out.println("Last node: " + listPtr);
        rear = listPtr.prev;
        rear.next = null;
	}
    else {
	// Case 4: In the middle: stitch the prev and next nodes together.
	System.out.println("Node before: " + listPtr.prev);
        System.out.println("Node to be deleted: " + listPtr);
        System.out.println("Next node: " + listPtr.next);
	listPtr.prev.next = listPtr.next;
        listPtr.next.prev = listPtr.prev;
	}
	numItems --;
    }



    public void delete (int i)
    {
    // Check for bad input.
	if ( (i < 0) || (i >= numItems) ) {
	    return;
	}

    // Find the i-th element.
	int count = 0;
	ListItem listPtr = front;
	while ( (listPtr != null) && (count != i) ) {
	    listPtr = listPtr.next;
	    count ++;
	}

	// Otherwise delete: four cases.
    if (front == rear) {
        // Case 1: only one element.
        System.out.println("Only node: " + listPtr);
        front = rear = null;
        }
    else if (listPtr == front) {
        // Case 2: we're deleting from the front.
	System.out.println("First node: " + listPtr);
        System.out.println("Next node: " + listPtr.next);
        front = listPtr.next;
        front.prev = null;
	}
    else if (listPtr == rear) {
        // Case 3: delete the last element.
        System.out.println("Last node: " + listPtr);
        System.out.println("Next to last node: " + listPtr.prev);
        rear = listPtr.prev;
        rear.next = null;
	}
    else {
	// Case 4: In the middle: stitch the prev and next nodes together.
	System.out.println("Node before deleted: " + listPtr.prev);
        System.out.println("Deleted node: " + listPtr);
        System.out.println("Next node: " + listPtr.next);
        listPtr.prev.next = listPtr.next;
	listPtr.next.prev = listPtr.prev;
	}
	numItems --;
    }
}
