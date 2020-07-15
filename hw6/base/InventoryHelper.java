/*-------------------------------------------------------------------------
This class generates a set of products that can be added to a shopping cart

author: Aaron Coplan, Zuri Lawrence, James Taylor
-------------------------------------------------------------------------*/

public class InventoryHelper {

    public static Product[] getProducts() {
        Product[] products = new Product[10];
        products[0] = new Product("Eggs", 1.99);
        products[1] = new Product("Milk", 2.49);
        products[2] = new Product("Bread", 2.99);
        products[3] = new Product("Froot Loops", 5.99);
        products[4] = new Product("Pizza", 8.99);
        products[5] = new Product("Hummus", 3.99);
        products[6] = new Product("Soup", 2.99);
        products[7] = new Product("Bell Pepper", 0.99);
        products[8] = new Product("Mushrooms", 2.99);
        products[9] = new Product("Chicken", 4.99);
        return products;
    }
}
