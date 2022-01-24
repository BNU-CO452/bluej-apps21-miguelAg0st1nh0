import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Inventory extends ZuulCommand
{
    /**
     * Constructor for objects of class ZuulCommand
     *
     * @param game
     */

    private HashMap<String, Items> inventory;
    private ArrayList<Items> invent;
    private Items items;
    private String name;
    public Inventory(Game game, String name)
    {
        super(game);
        this.name = name;
        inventory = new HashMap<>();
        invent = new ArrayList<>();
    }

    public void execute()
    {

        printInventory();

    }

    public Items findItem(String item)
    {
        for(Items items: invent)
        {
            if(items.getName().equals(item))
            {
                return items;
            }
        }
        return null;
    }

    public void addItemToInvent(Items items)
    {
        invent.add(items);
    }

    public void printInventory()
    {
        for(Items items: invent)
        {

            System.out.println("Inventory: " + items.getName());
        }
    }


    public void addItems(String name, Items items)
    {
        this.name = name;
        this.items = items;
        inventory.put(name, items);
        System.out.println(items.getShortDescription());

    }

    public String printFullInventory()
    {
        Set<String> keys = inventory.keySet();
        String print = "Inventory: ";

        if(inventory != null)
        {
            for(String names : keys)
            {

                print += "" + names;
            }

        }
        else
        {
            System.out.println("Inventory is empty!");
        }
        System.out.println(print);

        return print;
    }

};
