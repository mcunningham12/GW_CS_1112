/*-----------------------------------------------------------
These are the unit tests for the ShoppingCart class

There are multiple tests for each method inside the boolean
methods below.

Author: Max Cunningham
-----------------------------------------------------------*/



public class UnitTests {

    private static Product[] products;
    
    public static void main(String[] args) {
        //create a new array and add products to it
        products = InventoryHelper.getProducts();
        
        System.out.println("add: " + addTest());
        System.out.println("addAt: " + addAtTest());
        System.out.println("remove: " + removeTest());
        System.out.println("checkout: " + checkoutTest());    
        System.out.println("count: " + countTest());
        System.out.println("get: " + getTest());
        System.out.println("clear: " + clearTest());
        System.out.println("isEmpty: " + isEmptyTest());
        System.out.println("contains: " + containsTest());
    }

    ///This method tests if the add method works correctly
    ///Will return true if it does and false if it does not
    public static boolean addTest(){
        //create a new array and add products to it
        Product[] products = InventoryHelper.getProducts();
        ShoppingCart s = new ShoppingCart();
        //add elements to a full array
        Product p1 = new Product("Waflles", 3.99);
        Product p2 = new Product("Bacon", 6.95);
        s.add(p1);
        s.add(p2);
        //make sure an element cannot be added in twice
        s.add(p1);
        //make sure a null parameter does nothing
        s.add(null);
        if (s.count() != 2){
            return false;
        }
        return true;
    }
    ///This method tests if the addAt method works
    ///Returns true if it works for each unit test and false if it does not
    public static boolean addAtTest(){
        Product p1 = new Product("Waffles", 3.99);
        Product p2 = new Product("Beans", 2.99);
        ShoppingCart s = new ShoppingCart();
        //each of these should work
        s.add(products[1]);
        s.add(products[2]);
        s.addAt(p1,1);
        s.addAt(p2,2);
        //this one should fail and do nothing
        s.addAt(p1,3);
        //these should all do nothing
        s.addAt(products[9],7);
        s.addAt(null,-1);
        s.addAt(null, 5);
        if(s.count() !=4){
            return false;
        }
        return true;
    }

    public static boolean removeTest(){
        ShoppingCart s = new ShoppingCart();
        Product test = new Product("Milk", 2.49); 
        s.add(test);
        s.add(products[0]);
        s.add(products[9]);
        s.remove(test);
        if(s.count() !=2){
            return false;
        }
        s.remove(products[0]);
        if(s.count() !=1){
            return false;
        }
        s.remove(test);
        if(s.count() !=1){
            return false;
        }
        return true;
    }
    
    public static boolean checkoutTest(){
        ShoppingCart s = new ShoppingCart();
        Product p1 = new Product("Waffles", 3.99);
        Product p2 = new Product("Beans", 2.99);
        s.add(p1);
        s.add(p2);
        //make sure checkout adds properly
        if(s.checkout() != 6.98){
            return false;
        }
        return true;
    }

    public static boolean countTest(){
        ShoppingCart s = new ShoppingCart(); 
        //make sure the count variable works for each of these methods
        s.add(products[1]);
        s.addAt(products[0],0);
        s.add(products[9]);
        s.add(products[7]);
        s.remove(products[1]);
        if (s.count() != 3){
            return false;
        }
        return true;
    }

    public static boolean getTest(){
        ShoppingCart s = new ShoppingCart();
        s.add(products[7]);
        s.add(products[4]);
        Product p = s.get(1);
        //make sure the get method gets the right element
        if(p == products[4]){
            return true;
        }
        return false;
    }

    public static boolean clearTest(){
        ShoppingCart s = new ShoppingCart();
        s.add(products[1]);
        s.add(products[2]);
        s.add(products[3]);
        s.clear();
        //check to see if clear empties the cart
        if(s.count() !=0 || s.isEmpty() == false){
            return false;
        }
        return true;
    }

    public static boolean isEmptyTest(){
        ShoppingCart s = new ShoppingCart();
        s.add(products[1]);
        s.add(products[2]);
        if (s.isEmpty() == true){
            return false;
        }
        s.clear();
        //make sure clear and empty work together
        if (s.isEmpty() == false){
            return false;
        }
        return true;
    }

    public static boolean containsTest(){
        ShoppingCart s = new ShoppingCart();
        Product p1 = new Product("Milk", 2.49);
        s.add(p1);
        s.add(products[8]);
        s.add(products[2]);
        //should return true because p1 is in the cart
        if (s.contains(p1) != true){
            System.out.println("failed case 1");
            return false;
        }
        //should return false because p2 has not been added to the cart
        Product p2 = new Product("Waffles", 5.99);
        if (s.contains(p2) != false){
            System.out.println("failed case 2");
            return false;
        }
        //should return false because p3 has not been added
        Product p3 = new Product(null, 3.99);
        if (s.contains(p3) != false){
            System.out.println("failed case 3");
            return false;
        }
        return true;
    } 
}
