/*---------------------------------------------------------------------------
This class is a data structure designed to manipulate data in a shopping cart

author: Max Cunningham
---------------------------------------------------------------------------*/

public class ShoppingCart {

    private int count;        /// amount of elements in cart
    private Product[] data;   /// arraylist of products in cart
    private int[] quant;
  
    public ShoppingCart() {
        count = 0;
        data = new Product[1];
        quant = new int[1];
    }
    
    ///adds the passed in product to the array
    ///if and only if the product is not already in the array
    ///returns true if the product can be added
    ///returns false if the product is already in the array
    boolean add (Product product, int quantity) {
        //check if the product can be added
        if(product == null || product.getName() == null || product.getPrice()<0||quantity<1) {
            return false;
        }
        //check if the data array is empty
        if (count==0) {
            data[0]=product;
            quant[0]=quantity;
            count++;
            return true;
        }
        //check if the element is already in the array
        //if so just update the quantity
        int index=0;
        for (int j=0;j<count;j++){
            if(data[j].compareTo(product) == 0){
                index=j;
                quant[j]=quant[j]+quantity;
                return true;
            }
        }
        //double the length of the new array for good measure
        if(data.length==count){
            int len = data.length;
            Product[] nD = new Product[len*2];
            int[] nQuant = new int[len*2];
            for(int i=0;i<data.length;i++){
                nD[i]=data[i];
                nQuant[i]=quant[i];
            }
            data = nD;
            quant = nQuant;
            data[count]=product;
            quant[count]=quantity;
            count++;
            return true;
        }

        //check if there are enough elements in the array to add
        //if not, a new array will be created
        data[count]=product;
        quant[count]=quantity;
        count++;
        return true;
    } 

    ///checks to see if the product is already in the array
    ///returns false if so
    ///adds the product to the array at the given element otherwise
    ///returns true if so
    public boolean addAt(Product product, int index){
        //check if the index is valid
        if(index > count || index >= data.length || product == null){
            return false;
        }
        //check if the product can be added
        if( product.getName() == null || product.getPrice()<0) {
            return false;
        }
        //check if the product being added is already in the cart
        if(contains(product)){
            return false;
        }
        //if count = length of the array, a new array must be allocated
        if(data.length==count){
            //make new array and add all the elements from data to it
            Product[] nD = new Product[data.length*2];
            for (int i=0;i<data.length;i++){
                nD[i]=data[i];
            }
            //make data reference nD so data is still the array we operate on
            //the original data array will be garbage collected, which is fine
            data = nD;
            //shift each of the elements after index one to the right
            for (int i=count;i>index;i--){
                data[i]=data[i-1];
            }
            //finally, add the product into the array and increment count
            data[index]=product;
            count++;
            return true;
        }       

        //if there are enough spots, add and shift every element
        for (int i=index+1;i<count;i++) {
            data[i]=data[i-1];
        }
        //add the element to the array and incremen countt
        data[index] = product;
        count++;
        return true;
    }
    
    ///if the product is not in the array
    ///    returns false
    ///if the product is in the array
    ///    removes the product from the array and shifts each element
    ///    to the left one index afterwards
    ///    returns true if the product is removed and elements are moved successfully
    public boolean remove(Product product) { 
        //check if the product can be removed
        if(product == null || product.getName() == null || product.getPrice()<0) {
            return false;
        }
        //create index variable to track where the product is in the array
        int index=0;
        //check if the product is not in the array
        //if so, return false      
        if(contains(product)==false){
            return false;
        }
        for(int i=0;i<=count;i++){
            if((get(i) != null) && (get(i).compareTo(product)==0)){
               //now that we've found the product to remove
               //set it equal to null, set index equal to where it was
               data[i]=null;
               index = i;
               break;
            }
         }
         //move every element behind index in the array one index to the left
         for(int j=index;j<count-1;j++){        
            data[j]=data[j+1];
         }
         //decrement count at the end of the process
         count--;
         return true;
    }
    
    
    ///if each element has a valid price, returns the total price
    public double checkout() {
        //check if the cart is empty
        if(count == 0){
            return 0;
        }
        //create total variable and add the price of each product
        double total=0;
        for(int i=0;i<=count;i++){
            if(get(i) != null && get(i).getPrice() > 0|| getQuantity(get(i))>0) {
                total = (total + (get(i).getPrice()* getQuantity(data[i])));
            }
        }
        //cuts the total variable to two decimal places
        total=total*100;
        total=(int)total;
        total=total/100;
        return total;
    }
    
    ///returns the amount of elements in the shopping cart
    public int count() {
        return count;
    }
    
    ///allows for products within the shopping cart to be accessed
    public Product get(int index) {
        if(index<count){
            return data[index];
        }
        return null;
    }
    ///clears the shopping cart and the count variable
    
    public void clear() {
        for(int i=0;i<count;i++){
            data[i]=null;
        }
        count=0;
    }

    ///returns true if the data array is empty
    ///returns false if there exist elements in the shopping cart
    public boolean isEmpty() {
        if(count == 0){
            return true;
        }
        return false;
    }

    ///returns true if the product exists in the shopping cart
    public boolean contains(Product product){
        //null check
        if(product == null || product.getName() == null || product.getName().length()<1 || product.getPrice()<0){
            return false;
        }
        //check to see if the element is in the array
        if(count>0){
            for(int i=0;i<count-1;i++){
                if( (data[i] != null) && ( (data[i].compareTo(product))==0)){
                    return true;
                }
            }
        }
        return false;
    }

    public int getQuantity(Product product){
        if(product == null){
            return -1;
        }
        for(int i=0;i<=count;i++){
            if(data[i] != null && (data[i].compareTo(product)==0)){
                return quant[i];
            }
        }
        return 0;
    }
    public boolean applyDiscount(Product product, double discount){
        if(discount<=0||product == null||discount>100){
            return false;
        }
        //create index variable to track where the product is in the array
        int index=0;
        //make discount a decimal, will be used later
        //now discount is a decimal representing how much of the original
        //price must be paid
        discount = 1-(discount *.01);
        //check if the product is not in the array
        //if so, return false      
        if(contains(product)==false){
            return false;
        }
        for(int i=0;i<=count;i++){
            if((get(i) != null) && (get(i).compareTo(product)==0)){
               //now that we've found the product to remove
               //set it equal to null, set index equal to where it was
               index = i;
               break;
            }
        }
        //multiply original price by discount factor
        discount = product.getPrice()*discount;
        //truncate new price to two decimal places
        discount=discount*100;
        discount=(int)discount;
        discount=discount/100;
        data[index] = new Product(product.getName(), discount);
        return true;
    }
}
