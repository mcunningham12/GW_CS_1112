/*---------------------------------------------------
Author: Maxwell Cunningham
This class runs a series of unit tests on BinaryTree
and its associated methods
--------------------------------------------------*/

public class BinaryTreeUnitTests {
 
    public static void main(String[] args) {
        //call insert tests
        System.out.println("insert test 1: " + insertTest1());
        System.out.println("insert test 2: " + insertTest2());
        System.out.println("insert test 3: " + insertTest2());
        System.out.println("search test 1: " + searchTest1());
        System.out.println("search test 2: " + searchTest2());
        System.out.println("search test 3: " + searchTest3());
    }

    public static boolean insertTest1() {
        BinaryTree b = new BinaryTree();
        b.insert(KVP.keys[0],KVP.values[0]);
        TreeNode right = new TreeNode(KVP.keys[1],KVP.values[1]);
        b.insert(KVP.keys[1],KVP.values[1]);
        TreeNode root = b.getRoot();
        if(root.getRightChild().getValue() != right.getValue()){
            return false;
        }
        if(!root.getRightChild().getKey().equals(right.getKey())){
            return false;
        }
        return true;
    }

    public static boolean insertTest2(){
        //make a tree and insert some values
        BinaryTree b = new BinaryTree();
        b.insert(KVP.keys[0],KVP.values[0]);
        b.insert(KVP.keys[1],KVP.values[1]);
        b.insert(KVP.keys[2],KVP.values[2]);
        //This tree will have to be balanced since the
        //second and third nodes will be inserted on the same side
        TreeNode right = new TreeNode(KVP.keys[2],KVP.values[2]);
        TreeNode left = new TreeNode(KVP.keys[0],KVP.values[0]);
        TreeNode root = b.getRoot();
        if(!root.getRightChild().getKey().equals(right.getKey())){
            return false;
        }
        if(root.getRightChild().getValue() != right.getValue()){
            return false;
        }
        if(!root.getLeftChild().getKey().equals(left.getKey())){
            return false;
        }
        if(root.getLeftChild().getValue() != left.getValue()){
            return false;
        }       
        return true;
    }
    public static boolean insertTest3(){
        //make a tree and insert some values
        BinaryTree b = new BinaryTree();
        b.insert(KVP.keys[0],KVP.values[0]);
        b.insert(KVP.keys[1],KVP.values[1]);
        b.insert(KVP.keys[2],KVP.values[2]); 
        b.insert(KVP.keys[3],KVP.values[3]);
        b.insert(KVP.keys[4],KVP.values[4]);
        //in this tree, the node with keys[2] and values[2] will be the root
        TreeNode root = b.getRoot();
        //make sure that is true
        if(!root.getKey().equals(KVP.keys[2])){
            return false; 
        }
        if(root.getValue() != KVP.values[2]){
            return false;
        }
        return true;
    }
    public static boolean searchTest1(){
        //make sure search returns the correct value
        BinaryTree b = new BinaryTree();
        b.insert(KVP.keys[0],KVP.values[0]);
        b.insert(KVP.keys[1],KVP.values[1]);
        b.insert(KVP.keys[2],KVP.values[2]);
        if(b.search(KVP.keys[2], b.getProfile()) != KVP.values[2]){
            return false;
        }
        return true;
    }

    public static boolean searchTest2(){
        //make sure search returns -1 for a string not in the tree
        BinaryTree b = new BinaryTree();
        b.insert(KVP.keys[0],KVP.values[0]);
        b.insert(KVP.keys[1],KVP.values[1]);
        b.insert(KVP.keys[2],KVP.values[2]);
        if(b.search(KVP.keys[3], b.getProfile()) != -1){
            return false;
        }
        return true;
    }
    public static boolean searchTest3(){
        //this is the null check unit test
        BinaryTree b = new BinaryTree();
        if(b.search(null,b.getProfile()) != -1){
            return false;
        }
        return true;
    }
}
