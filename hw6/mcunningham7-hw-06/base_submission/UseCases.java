/*-------------------------------------------------------------------------
This file contains a number of use cases that would typically occur when
using a shopping cart.  This file is not intended as a substitute for
comprehensive unit testing, but it will show how the cart might be used
once the implementation is finished.

author: James Taylor 
-------------------------------------------------------------------------*/

public class UseCases {
    private static Product[] products;

    public static void main(String[] args) {

        products = InventoryHelper.getProducts();

        usecase1();
        usecase2();
        usecase3();
        usecase4();
        usecase5();
    }

    // A person puts one item into the cart and checksout
    public static void usecase1() {
        System.out.println("*Use Case 1");
        ShoppingCart cart = new ShoppingCart();

        cart.add(products[4]);

        String msg = "count:" + cart.count() + "; isEmpty:" + cart.isEmpty();
        System.out.println(msg);
        for(int i = 0; i < cart.count(); i++) {
            System.out.println(cart.get(i));
        }

        System.out.println("checkout:" + cart.checkout());
        System.out.println();
    }

    // A person puts multiple items into the cart and checksout
    public static void usecase2() {
        System.out.println("*Use Case 2");
        ShoppingCart cart = new ShoppingCart();

        cart.add(products[1]);
        cart.add(products[3]);

        String msg = "count:" + cart.count() + "; isEmpty:" + cart.isEmpty();
        System.out.println(msg);
        for(int i = 0; i < cart.count(); i++) {
            System.out.println(cart.get(i));
        }

        System.out.println("checkout:" + cart.checkout());
        System.out.println();
    }

    // A person puts an item into the cart and removes that item
    public static void usecase3() {
        System.out.println("*Use Case 3");
        ShoppingCart cart = new ShoppingCart();

        cart.add(products[6]);

        cart.remove(products[6]);

        String msg = "count:" + cart.count() + "; isEmpty:" + cart.isEmpty();
        System.out.println(msg);
        for(int i = 0; i < cart.count(); i++) {
            System.out.println(cart.get(i));
        }

        System.out.println("checkout:" + cart.checkout());
        System.out.println();
    }

    // A person rearranges items in the cart
    public static void usecase4() {
        System.out.println("*Use Case 4");
        ShoppingCart cart = new ShoppingCart();

        cart.add(products[5]);
        cart.addAt(products[9],0);


        String msg = "count:" + cart.count() + "; isEmpty:" + cart.isEmpty();
        System.out.println(msg);
        for(int i = 0; i < cart.count(); i++) {
            System.out.println(cart.get(i));
        }

        System.out.println("checkout:" + cart.checkout());
        System.out.println();
    }

    // A person searches through the cart for a specific item
    public static void usecase5() {
        System.out.println("*Use Case 5");
        ShoppingCart cart = new ShoppingCart();

        cart.add(products[7]);
        cart.add(products[8]);
        cart.add(products[9]);

        if(cart.contains(products[8])) {
            System.out.println("Found " + products[8] + " in the cart");
        }

        if(!cart.contains(products[0])) {
            System.out.println("Forgot to put " + products[0] + " in the cart");
        }

        System.out.println();
    }
}
