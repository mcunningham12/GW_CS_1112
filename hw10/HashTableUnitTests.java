/*-------------------------------------------------
Author: Maxwell Cunningham
This class runs a series of unit tests on HashTable
------------------------------------------------*/

public class HashTableUnitTests {

    public static void main(String[] args) {
        System.out.println("insert test 1: " + insertTest1());
        System.out.println("insert test 2: " + insertTest2());
        System.out.println("insert test 3: " + insertTest3());
        System.out.println("search test 1: " + searchTest1());
        System.out.println("search test 2: " + searchTest2());
        System.out.println("search test 3: " + searchTest3());
    }

    public static boolean insertTest1() {
        HashTable h = new HashTable(5);
        h.insert("a",1);
        h.insert("a",2);
        //check a value with search
        if(h.search("a",h.getProfile()) != 2){
            return false;
        }
        //make sure the hash table has no length greater than 1
        if(h.greatestLength() > 1){
            return false;
        }
        return true;
    }

    public static boolean insertTest2(){
        //create hash table and insert values
        HashTable h = new HashTable(5);
        h.insert("a",1);
        h.insert("b",2);
        h.insert("c",3);
        //make sure the correct value is ascribed to c
        if(h.search("c",h.getProfile()) != 3){
            return false;
        }
        //update b and check value ascribed to it
        h.insert("b",3);
        if(h.search("b",h.getProfile()) != 3){
            return false;
        }
        //insert more values than there are buckets
        h.insert("d",4);
        h.insert("e",5);
        h.insert("f",6);
        //make sure there is no length greater than 2 in this array
        if(h.greatestLength()>2){
            return false;
        }
        return true;
    }

    public static boolean insertTest3(){
        //create hash table and insert values
        HashTable h = new HashTable(4);
        h.insert("d",20);
        h.insert("e",30);
        h.insert("f",40);
        h.insert("g",50);
        //this should do nothing but it should compile nonetheless
        h.insert("",5);
        if(h.search("e",h.getProfile()) !=30){
            return false;
        }
        //the number of nodes inserted is equal to numBuckets
        //make sure each bucket has no more than 1 node in it
        if(h.greatestLength()>1){ 
            return false;
        }
        return true;
    }

    public static boolean searchTest1(){
        //create hash table and insert values
        HashTable h = new HashTable(10);
        h.insert("d",20);
        h.insert("e",30);
        h.insert("f",40);
        h.insert("g",50);
        //make sure search returns the correct value, -1
        //since "a" was never inserted into this hash table
        if(h.search("a",h.getProfile()) != -1){
            return false;
        }
        return true;
    }

    public static boolean searchTest2(){
        //create hash table and insert values
        HashTable h = new HashTable(10);
        h.insert("d",20);
        h.insert("e",30);
        h.insert("f",40);
        h.insert("g",50);
        //make sure search returns the correct values
        if(h.search("",h.getProfile()) != -1){
            return false;
        }
        if(h.search(null,h.getProfile()) != -1){
            return false;
        }
        if(h.search("  ",h.getProfile()) != -1){
            return false;
        }
        return true;
    }

    public static boolean searchTest3(){
        //create hash table and insert values
        HashTable h = new HashTable(10);
        h.insert("d",20);
        h.insert("e",30);
        h.insert("f",40);
        h.insert("g",50);
        //check to make sure search returns the correct values
        if(h.search("e",h.getProfile()) != 30){
            return false;
        }
        h.insert("g",75);
        if(h.search("g",h.getProfile()) != 75){
            return false;
        }
        return true;
    }
}
