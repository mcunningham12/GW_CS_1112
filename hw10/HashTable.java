/*---------------------------------------------------
Author: Maxwell Cunningham
This class creates a hash table and ascribes various
methods that can be used
----------------------------------------------------*/
public class HashTable {

    private final ListNode[] buckets;
    private final int numBuckets;
    private int[] profile;

    public HashTable(int numBuckets) {
        this.numBuckets = numBuckets;
        this.buckets = new ListNode[numBuckets];
    }

    public void insert(String key, int value) {

        if(key==null||key==""||key==" "||key.length()==0) return;
        //check if the key doesn't already exist
        if (search(key,profile) == -1){
            //figure out which linked list to traverse
            int hash = hash(key);
            ListNode traverse = buckets[hash];
            //check if the linked list at the specific spot in buckets is empty
            //if so, insert and you are done
            if(buckets[hash]==null){
                buckets[hash]=new ListNode(key,value);
                return;
            }
            //otherwise, traverse the linked list until the end
            while(traverse != null){
                traverse = traverse.getNext();
            }
            //set end of linked list equal to new node
            traverse = new ListNode(key,value);
        } else {
            //figure out which linked list to traverse
            int hash = hash(key);
            //create new node to traverse it
            ListNode traverse = buckets[hash];
            //traverse the linked list until key is found
            while(!traverse.getKey().equals(key)){
                traverse = traverse.getNext();
            }
            //update the value
            traverse.setValue(value);
        }
    }

    //if key exists, return its value
    //if not, return -1
    public int search(String key, int[] profile) {
        if(key==null||key==""||key==" "||key.length()==0) return -1;
        //make sure you traverse the right list
        int hash = hash(key);
        //create a pointer to the start of the list
        ListNode trav = buckets[hash];
        //traverse the list until the string is found
        //if found, return value
        while(trav != null){
            if(trav.getKey().compareTo(key)==0){
                return trav.getValue();
            }
            trav=trav.getNext();
        }
        //string does not exist in correct list, return -1
        return -1;
    }

    private int hash(String key) {
        return key.hashCode() % numBuckets;
    }

/*----------------------------------------------------
Helper Functions: These were created to help me run
effective unit tests
----------------------------------------------------*/
    //this is a helper function for the unit tests
    public int[] getProfile(){
        return profile;
    }

    //I am going to use this function to test the insert function
    public int size(ListNode node){
        int count=0;
        ListNode trav = node;
        while(trav != null){
            count++;
            trav=trav.getNext();
        }
        return count;
    }
    
    //iterates through the hash table and finds the array of greatest length
    //use in unit tests to make sure the insertion was done correctly
    //could be used in future assignments to check if re-hashing is necessary
    public int greatestLength(){
        int greatest=size(buckets[0]);
        for(int i=1;i<buckets.length;i++){
            if(size(buckets[i])>greatest){
                greatest=size(buckets[i]);
            }
        }
        return greatest;
    }
}
