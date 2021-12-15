import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockList
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockList()
    {
        stock = new ArrayList<Product>();
    }
    
    

    /**
     * Add a product to the list.
     * @param item The product item to be added.
     * 
     */
    public void add(Product item)
    {
        stock.add(item);
    }
    
    /**
     * Remove item from the list stock
     */
    
    public void remove(int productID)
    {
        Product product = findProduct(productID);
        if(product != null)
        {
            stock.remove(product);
            System.out.println("The product: " + product.getID() + "-" + product.getName() + " was sucessfully removed from the list!");
            print();
        }
        else
        {
            System.out.println("Product not found, check ID number and try again!");
        }
    }
    
    /**
     * Auto Restock if below 5 game copies
     */
    public void autoRestock(int autoStockDefaultValue)
    {
        for(Product products : stock)
        {
            if(products.getQuantity() <= 5)
            {
                
                products.setQuantity(autoStockDefaultValue);
                System.out.println("The Stock levels were found on a low level!");
                System.out.println("Therefore the Auto-Restock was called in on the product: " + products.getID() + "-" + products.getName());
                System.out.println(autoStockDefaultValue + " copies were automatically added to your stock!");
                print();
            }
        }
    }
    
    
    
    /**
     * A method to buy a single quantity of the product
     */
    public void buyProduct(int productID)
    {
        buyProduct(productID, 1);
    }
    
    public void checkStockUnderAmount(int underAmount)
    {
        System.out.println("All the products found on low stock are the following: ");
        
        for(Product product : stock)
        {
            if(product.getQuantity() <= underAmount)
            {
                
                System.out.println(product.toString());
            }
            
        }
    }
    
    /**
     * Buy a quantity of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void buyProduct(int productID, int amount)
    {
        Product product = findProduct(productID);
        if(product != null)
        {
            product.increaseQuantity(amount);
            
            if(amount == 1)
                {
                    System.out.println(amount + " game copy of " + product.getName() + " was bought sucessfully!");
                    System.out.println("Current Level stock is: " + product.getName() + ": " + product.getQuantity());
                    
                }
                //prints for plural 
                else
                {
                    System.out.println(amount + " game copies of " + product.getName() + " were bought sucessfully!");
                    System.out.println("Current Level of stock for: " + product.getName() + " is: " + product.getQuantity() + " copies!");
                    
                }
        }
        else
        {
            System.out.println("Product not found! Check ID number and try again!");
        }
        
        
    }
    
    /**
     * Find a product to match the product id,
     * if not found return null
     */
    public Product findProduct(int productID)
    {
        for(Product product : stock)
        {
            if(product.getID() == productID)
            {
                return product;
            }
            
        }
        
        return null;
    }
    
   
    
    
    /**
     * Sell one of the given product.
     * Show the before and after status of the product.
     * @param id The ID of the product being sold.
     */
    public void sellProduct(int productID, int amount)
    {
        Product product = findProduct(productID);
        
        if(product != null) 
        {
            if(product.getQuantity() > 0 && product.getQuantity() >= amount)
            {
                product.decreaseQuantity(amount);
                
                // print sell confirmation based on input amount by user.
                //prints for singular
                if(amount == 1)
                {
                    System.out.println(amount + " game copy of " + product.getName() + " was sold sucessfully!");
                    System.out.println("Current Level stock is: " + product.getQuantity());
                    
                }
                //prints for plural 
                else
                {
                    System.out.println(amount + " game copies of " + product.getName() + " were sold sucessfully!");
                    System.out.println("Current Level stock is: " + product.getQuantity());
                    
                }
                
                if(product.getQuantity() == 0)
                {
                    System.out.println("Your current stock for game:" + product.getName() + " is 0 copies!");
                    System.out.println("Consider buy more to keep customers happy!");
                }
                
                
            }
            
            if(product.getQuantity() <= 5)
            {
                autoRestock(100);
            }
            else
            {
                // printout message
                System.out.println("There is not enough stock of this item to currently sell " + amount + " copies");
                System.out.println(productID + ", " + product.getName() + " current stock level is: " + product.getQuantity());
            }
        }
        else
        {
            // printout message
            System.out.println("Product ID not found, check ID number and try again!");
        }
    }    

    
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int productID)
    {
        Product product = findProduct(productID);
        
        return product.getQuantity();
    }

    /**
     * Print details of the given product. If found,
     * its name and stock quantity will be shown.
     * @param id The ID of the product to look for.
     */
    public void printProduct(int productID)
    {
        Product product = findProduct(productID);
        
        if(product != null) 
        {
            System.out.println(product.toString());
        }
    }
    
    /**
     * Print out each product in the stock
     * in the order they are in the stock list
     */
    public void print()
    {
        printHeading();
        
        for(Product product : stock)
        {
            System.out.println(product);
        }

        System.out.println();
    }
    
    public void printHeading()
    {
        System.out.println();
        System.out.println(" Miguel's GameStop Stock List");
        System.out.println(" ====================");
        System.out.println("");
    }
}