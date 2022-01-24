import java.util.HashMap;

/**
 * This command allows the player to
 * take or pickup an item from a room
 * and carry it around to use somewhere
 * else
 *
 * @author Derek Peacock & Nicholas Day
 * @version 2021-08-23
 */
public class TakeCommand extends ZuulCommand
{
    String item;
    Inventory invent;
    Items items;
    /**
     * Take an item from a location and add it
     * to the player's inventory.
     */
    public TakeCommand(Game zuul, String item)
    {
        super(zuul);
        this.item = item;
        invent = new Inventory(zuul, item);
    }    

    public void execute()
    {
        if(item == null) 
        {
            // if there is no second word, we don't know what to take...
            System.out.println("Take what?");
            return;
        }
        else if(item.equalsIgnoreCase("BlueShard"))
        {

            this.invent.addItemToInvent(items);
            System.out.println(items + " taken!");

        }

        else if(item.equalsIgnoreCase("RedShard"))
        {
            this.invent.addItemToInvent(items);
            System.out.println(items + " taken!");
        }

        else if(item.equalsIgnoreCase("greenShard"))
        {
            this.invent.addItemToInvent(items);
            System.out.println(items + " taken!");
        }

        else if(item.equalsIgnoreCase("blackShard"))
        {
            this.invent.addItemToInvent(items);
            System.out.println(items + " taken!");
        }

        Map map = zuul.MAP;


        // remove the item from the current room
        // and add it to the player's inventory
        // Print out a suitable message.
    }
}
