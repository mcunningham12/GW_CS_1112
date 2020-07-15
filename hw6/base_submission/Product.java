/*-------------------------------------------------------------------------
This class is a data structure designed to encapsulating product information

author: Aaron Coplan, Zuri Lawrence, James Taylor
-------------------------------------------------------------------------*/

public class Product {

    private final String name;          /// name of the product.  immutable
    private final double price;         /// price of the product.  immutable

    //add extra variable fields for extension here

    /// Constructor for creating a new product
    /// @param name required name of the product
    /// @param price required price of the product
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /// Accessor for retrieving the name of this product
    /// @returns the name of this product
    public String getName() {
        return name;
    }

    /// Accessor for retrieving the price of this product
    /// @returns the price of this product
    public double getPrice() {
        return price;
    }

    /// Comparison operation to determine ordering of products
    /// @param other another product to compare to this product
    /// @returns 0 if the products are the same, -1 if the other should
    ///          precede this product, and 1 if this product should precede
    ///          the other
    public int compareTo(Product other) {
        if( name.equals(other.name) && price == other.price ) {
            return 0;
        }
        int result = name.compareTo(other.name);
        if( result != 0 ) {
            return result;
        }
        if( other.price < price ) {
            return 1;
        }
        return -1;
    }

    /// Returns a formatted string containing this product's data
    /// @returns a formatted string containing this product's data
    public String toString() {
        String s = new String(name);
        s += "::" + price;
        return s;
    }

    //add extra functions for extension here
}
