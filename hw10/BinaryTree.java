/*----------------------------------------------------------
Author: Maxwell Cunningham
This class describes a binary tree and has methods to 
manipulate it
----------------------------------------------------------*/

import java.util.List;
import java.util.ArrayList;

public class BinaryTree {

    //global variables:
    //root, profile array, number of times search has been called, and
    //amount of comparisons
    private TreeNode root;
    private int[] profile = new int[10];
    private int searchCalls=0;
    private int compareCount=0;

    //this method inserts the key and value into the correct location
    //in the binary tree
    public void insert(String key, int value) {
        //if root is null, create root and return
        if(root == null) {
            root = new TreeNode(key,value);
            return;
        }
        //if root is not null, we call the recursive helper function
        recursiveInsertHelper(root, key, value);
        //balance the tree every time a node is inserted
        //not efficient, but works via brute force
        balanceTree();
    }

    //this is a helper function to insert
    //operates recursively
    public void recursiveInsertHelper(TreeNode node, String key, int value){
        //check if key is less than key of node
        if(key.compareTo(node.getKey()) < 0){
            //if there is a left child, call the function again
            //for left child
            if(node.getLeftChild() != null){
                recursiveInsertHelper(node.getLeftChild(), key, value);
            }
            //if there is not a left child, we are in the correct location
            //to insert key and value into the tree
            else {
                TreeNode insert = new TreeNode(key, value);
                node.setLeftChild(insert);
            }
        }
        //if key is greater than the node
        else {
            //check if a right child exists
            //if so, call the function again for right child
            if(node.getRightChild() != null){
                recursiveInsertHelper(node.getRightChild(),key,value);
            }
            //if there is not a right child, create new node and set it to right child
            else {
                TreeNode insert = new TreeNode(key,value);
                node.setRightChild(insert);
            }
        }
    }

    public int search(String key, int[] profile) {
        //null checks, don't run method
        if(getRoot() == null||key.equals(null) || key=="" || key==" ") return -1;
        //set integer equal to recursive helper function
        int value = recursiveSearch(getRoot(),key);
        
        //make sure profile is long enough, if not double its length
        if(searchCalls>=profile.length){
            profile= doubleProfileSize(profile);
        }
        //insert compareCount into respective element of profile
        //as determined by searchCalls
        profile[searchCalls]=compareCount;
        //increment search calls
        searchCalls++;
        //reset compareCount back to 0
        compareCount=0;

        //return the value corresponding to the given key
        return value;
    }

    //This is a helper function to search that does most of the heavy lifting
    public int recursiveSearch(TreeNode node, String key){
        //increment compare count
        compareCount++;
        //check if the key is equal to the key of the node
        if(key.compareTo(node.getKey()) == 0){
           return node.getValue();
        }
        //increment compareCount
        compareCount++;
        //if key is less than key of the node
        if(key.compareTo(node.getKey()) < 0){
            //check if there is a left child, if not return -1
            //key does not exist in the tree
            if(node.getLeftChild() == null){
                return -1;
            }
            //if there is a left child, call recursive search with left child
            else {
                return recursiveSearch(node.getLeftChild(),key);
            }
        }
        //going to the right side
        else {
            //check if there exists a right child
            //if not, return -1 as the key does not exist in the tree
            if(node.getRightChild() == null){
                return -1;
            }
            //if right child does exist, then call the recursive method for right child
            else {
                return recursiveSearch(node.getRightChild(),key);
            }
        }
    }


  /*This algorithm focuses on correctness
    and is not the most efficient algorithm
    available. Please look up different
    algorithms that solve the balancing problem.
  */
    private void balanceTree() {
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        //Sorts tree from given root
        populateList(root, nodes);
        //Return null if root has no children
        if(nodes.size() == 0) return;

        this.root = balanceTreeHelper(nodes, 0, nodes.size() - 1);
    }

    private TreeNode balanceTreeHelper(List<TreeNode> nodes, int start, int end) {
        int mid = (start + end) / 2;
        TreeNode node = nodes.get(mid);
        if(start == end){
            node.setLeftChild(null);
            node.setRightChild(null);
            return node;
        }
        //Recursively balance tree on left and right children using
        //middle node as root
        if(!(mid - 1 < start)) {
            node.setLeftChild(balanceTreeHelper(nodes, start, mid - 1));
        } else {
            node.setLeftChild(null);
        }

        if(!(mid + 1 > end)) {
            node.setRightChild(balanceTreeHelper(nodes, mid + 1, end));
        } else {
            node.setRightChild(null);
        }

        return node;
    }

    private void populateList(TreeNode node, List<TreeNode> list) {
        if(node == null) return;
        populateList(node.getLeftChild(), list);
        list.add(node);
        populateList(node.getRightChild(), list);
    }
    
/*-------------------------------------------------------------
Helper Functions:
-------------------------------------------------------------*/
    //this function doubles the size of the profiile array
    private int[] doubleProfileSize(int[] profile){
        //create new array of double length
        int[] nD = new int[profile.length*2];
        //insert existing elements of profile into array
        for(int i=0;i<profile.length;i++){
            nD[i]=profile[i];
        }
        //set reference of profile to new array and return
        profile=nD;
        return profile;
    }
    //this function returns the profile array so it can be used in unit tests
    public int[] getProfile(){
        return profile;
    }

    //this function returns the root so it can be used in unit tests
    public TreeNode getRoot(){
        return root;
    }
    public int getProfileValue(int x){
        return profile[x];
    }
}
