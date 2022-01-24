import java.util.ArrayList;
import java.util.Random;

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

    /**
     * Take an item from a location and add it
     * to the player's inventory.
     */
    public TakeCommand(Game zuul, String item)
    {
        super(zuul);
        this.item = item;

    }    

    public void execute()
    {
        if(item == null) 
        {
            // if there is no second word, we don't know what to take...
            System.out.println("Take what?");
            return;
        }
        else
        {
            Map map = zuul.MAP;

            Item newItem = map.getCurrentLocation().getItem(item);

            if(newItem == null)
            {
                System.out.println("That item is not here!");
            }
            else
            {
                if(newItem.getItem().equalsIgnoreCase("herb"))
                {
                    System.out.println("You picked a special herb that has properties that help you hunting more effectively!");
                    System.out.println("This item can be used!");

                }

                if(newItem.getItem().equalsIgnoreCase("amulet"))
                {
                    System.out.println("You picked a special amulet, it gives you more sex appeal :D!");
                    System.out.println("This item can be used!");

                }
                if(newItem.getItem().equalsIgnoreCase("flask"))
                {
                    System.out.println("You picked the strange flask. Should you drink it?");
                    System.out.println("This item is usable, but effects are unknown!");
                }

                System.out.println(newItem.getItem() + " was added to inventory!");
                Player player = zuul.player;
                player.addItemToInventory(newItem);

            }

        }


        // remove the item from the current room
        // and add it to the player's inventory
        // Print out a suitable message.
    }

}
