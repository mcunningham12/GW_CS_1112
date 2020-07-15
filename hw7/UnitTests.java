/*-------------------------------------------------------------------------
These unit tests check the validity of the methods in the Catalog class

author: Maxwell Cunningham
-------------------------------------------------------------------------*/
public class UnitTests {
    private static String[] shows;
    public static void main(String[] args) {
        //this is an array of strings that I can use to make shows
        shows = ShowFactory.getShows();
        System.out.println("addToBack: " + addToBackTest());
        System.out.println("addToFront: " + addToFrontTest());
        System.out.println("remove: " + removeTest());
        System.out.println("getCurrentShow: " + getCurrentShowTest());
        System.out.println("stepForward: " + stepForwardTest());
        System.out.println("stepBackward: " + stepBackwardTest());
        System.out.println("isEmpty: " + isEmptyTest());
        System.out.println("clear: " + clearTest());
    }

    public static boolean addToBackTest(){
        //make a catalog and add some shows
        Catalog cat = new Catalog();
        cat.addToBack(shows[1]);
        cat.addToBack(shows[3]);
        cat.addToBack(shows[9]);
        cat.addToBack(shows[7]);
        //should fail
        cat.addToBack(shows[1]);
        cat.addToBack(shows[7]);
        //null check
        cat.addToBack(null);
        //Integrity check 
        if (cat.checkIntegrity() != true){
            return false;
        } 
        //start moving forward through the array and make sure that it circles back
        cat.stepForward();
        if(!(cat.getCurrentShow().equals("That 70's Show"))){
            return false;
        }
        cat.stepForward();
        if(!(cat.getCurrentShow().equals("LetterKenny"))){
            return false;
        }
        cat.stepForward();
        if(!(cat.getCurrentShow().equals("Seinfeld"))){
            return false;
        }
        cat.stepForward();
        if(!(cat.getCurrentShow().equals("Rick and Morty"))){
            return false;
        }
        //start moving backward through the array and make sure that it circles back
        cat.stepBackward();
        if(!(cat.getCurrentShow().equals("Seinfeld"))){
            return false;
        }
        cat.stepBackward();
        if(!(cat.getCurrentShow().equals("LetterKenny"))){
            return false;
        }       
        cat.stepBackward();
        if(!(cat.getCurrentShow().equals("That 70's Show"))){
            return false;
        } 
        cat.stepBackward();
        if(!(cat.getCurrentShow().equals("Rick and Morty"))){
            return false;
        } 
        return true; 
    }

    public static boolean addToFrontTest(){
        //make a catalog and add some shows
        Catalog cat = new Catalog();
        cat.addToFront(shows[1]);
        cat.addToFront(shows[3]);
        cat.addToFront(shows[9]);
        cat.addToFront(shows[7]);
        //should add nothing
        cat.addToFront(shows[7]);
        cat.addToFront(shows[9]);
        //shows[7] should be at the front, then shows[9], shows[3], then shows[1]
        //check if addToFront handles null effectively
        cat.addToFront(null);
        //Integrity check 
        if (cat.checkIntegrity() != true){
            return false;
        }        
        //start moving forward through the array and make sure that it circles back
        cat.stepForward();
        //check if each step forward in the array goes to the correct show
        if(!(cat.getCurrentShow().equals("Seinfeld"))){
            return false;
        }
        cat.stepForward();
        if(!(cat.getCurrentShow().equals("LetterKenny"))){
            return false;
        }
        cat.stepForward();
        if(!(cat.getCurrentShow().equals("That 70's Show"))){
            return false;
        }
        cat.stepForward();
        if(!(cat.getCurrentShow().equals("Rick and Morty"))){
            return false;
        }
        //start moving backward through the array and make sure that it circles back
        cat.stepBackward();
        //check if each step backward in the array goes to the correct show
        if(!(cat.getCurrentShow().equals("That 70's Show"))){
            return false;
        }
        cat.stepBackward();
        if(!(cat.getCurrentShow().equals("LetterKenny"))){
            return false;
        }       
        cat.stepBackward();
        if(!(cat.getCurrentShow().equals("Seinfeld"))){
            return false;
        } 
        cat.stepBackward();
        if(!(cat.getCurrentShow().equals("Rick and Morty"))){
            return false;
        } 
        return true;
    }

    public static boolean removeTest(){
        Catalog cat = new Catalog();
        //add a bunch of shows
        cat.addToFront(shows[1]);
        cat.addToFront(shows[3]);
        cat.addToFront(shows[9]);
        cat.addToBack(shows[7]);
        //Integrity check 
        if(cat.checkIntegrity() != true){
            return false;
        }
        //remove two shows in the list and one that is not
        cat.removeShow(shows[1]);
        cat.removeShow(shows[4]);
        cat.removeShow(shows[9]);
        //now the list should only have two elements, so I am going to check
        //if I can traverse this list correctly
        if(cat.getCurrentShow() != shows[7]){
            return false;
        }
        cat.stepForward();
        if(cat.getCurrentShow() != shows[3]){
            return false;
        }
        cat.stepForward();
        if(cat.getCurrentShow() != shows[7]){
            return false;
        }
        return true;
    }

    public static boolean getCurrentShowTest(){
        //make a catalog and add some shows
        Catalog cat = new Catalog();
        cat.addToFront(shows[1]);
        cat.addToFront(shows[3]);
        cat.addToFront(shows[9]);
        cat.addToBack(shows[7]);
        //make sure current show starts at the one most recently added
        if (!cat.getCurrentShow().equals(shows[7])){
            return false;
        }
        //manipulate the catalog and garbage collect the original list
        cat.clear();
        cat.addToBack(null);
        cat.addToFront(shows[7]);
        //check to see if the current show is still the most recently added one
        if (!cat.getCurrentShow().equals(shows[7])){
            return false;
        }       
        return true;
    }

    public static boolean stepForwardTest(){
        //make a catalog and add some shows
        Catalog cat = new Catalog();
        cat.addToFront(shows[1]);
        cat.addToFront(shows[3]);
        cat.addToFront(shows[9]);
        cat.addToBack(shows[7]);
        //list currently is in the order: 9, 3, 1, 7
        //  current show is 7
        //step forward three times and make sure the current show is 1
        cat.stepForward();
        cat.stepForward();
        cat.stepForward();
        if(cat.getCurrentShow() != shows[1]){
            return false;
        }
        return true;
    }

    public static boolean stepBackwardTest(){
        Catalog cat = new Catalog();
        cat.addToFront(shows[1]);
        cat.addToFront(shows[3]);
        cat.addToFront(shows[9]);
        cat.addToBack(shows[7]);
        //same order as before, but this time 
        //we are going to move in the opposite direction
        cat.stepBackward();
        cat.stepBackward();
        cat.stepBackward();
        //make sure the current show after these operations is correct
        //9, 3, 1, 7 was order with current at 7. 3 steps back is 9
        if(!cat.getCurrentShow().equals(shows[9])){
            return false;
        }
        return true;
    }

    public static boolean isEmptyTest(){
        //add some shows and see if the catalog is empty
        Catalog cat = new Catalog();
        cat.addToFront(shows[1]);
        cat.addToFront(shows[2]);
        cat.addToFront(shows[3]);
        cat.addToBack(shows[4]);
        if (cat.isEmpty() != false){
            return false;
        }
        //clear the catalog and check if it is empty again
        cat.clear();
        if (cat.isEmpty() != true){
            return false;
        }
        return true;
    }

    public static boolean clearTest(){
        //make catalog and add some shows
        Catalog cat = new Catalog();
        cat.addToFront(shows[1]);
        cat.addToFront(shows[3]);
        cat.addToFront(shows[9]);
        cat.addToBack(shows[7]);
        cat.clear();
        //check to make sure it is empty now
        if(cat.isEmpty() != true){
            return false;
        }
        return true; 
    }
}
