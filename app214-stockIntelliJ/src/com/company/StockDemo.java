package com.company;
/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 */
public class StockDemo
{
    // The stock manager.
    private StockList stock;

    /**
     * Create a StockManager and populate it with at least
     * 10 sample products.
     */
    public StockDemo(StockList stock)
    {
        this.stock = stock;
        
        // Add at least 10 products, they must be unique to you
        // Make sure the ids are sequential numbers
        
        stock.add(new Product(101, "GTA V"));
        stock.add(new Product(102, "GTA IV"));
        stock.add(new Product(103, "Far Cry 6"));
        stock.add(new Product(104, "Fallout 4"));
        stock.add(new Product(105, "Sims 4"));
        stock.add(new Product(106, "Life is Strange"));
        stock.add(new Product(107, "Life is Strange 2"));
        stock.add(new Product(108, "Call of Duty World at War"));
        stock.add(new Product(109, "Age of Empires III"));
        stock.add(new Product(110, "Age of Empires IV"));
    }
    
    /**
     * Provide a demonstration of how the ProductList meets all
     * the user requirements by making a delivery of each product 
     * buying it in various amounts and then selling each
     * product by various amounts. Make sure all the requirements
     * have been demonstrated.
     */
    public void runDemo()
    {
        // Show details of all of the products before delivery.
        buyProducts();
        stock.print();
        sellProducts();
        stock.print();
        stock.autoRestock(100);
    }
    //Automation process to start the demo with some stock.



    private void buyProducts()
    {
        stock.buyProduct(101, 500);
        stock.buyProduct(102, 450);
        stock.buyProduct(103, 300);
        stock.buyProduct(104, 450);
        stock.buyProduct(105, 300);
        stock.buyProduct(106, 500);
        stock.buyProduct(107, 800);
        stock.buyProduct(108, 350);
        stock.buyProduct(109, 450);
        stock.buyProduct(110, 600);
        
    }

    private void sellProducts()
    {
        stock.buyProduct(101, 120);
        stock.buyProduct(102, 100);
        stock.buyProduct(103, 160);
        stock.buyProduct(104, 150);
        stock.buyProduct(105, 130);
        stock.buyProduct(106, 100);
        stock.buyProduct(107, 180);
        stock.buyProduct(108, 150);
        stock.buyProduct(109, 150);
        stock.buyProduct(110, 190);
    }    
}