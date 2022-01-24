
public class DropCommand extends ZuulCommand
{
    String item;

    /**
     * Constructor for objects of class ZuulCommand
     *
     *
     */
    public DropCommand(Game zuul, String item)
    {
        super(zuul);
        this.item = item;

    }

    public void execute()
    {
        if(item == null)
        {
            // if there is no second word, we don't know what to take...
            System.out.println("Drop what?");
            return;
        }
        Player player = zuul.player;

        if(!player.inventory.isEmpty())
        {
            String output = "";

            for(int i = 0; i < player.inventory.size(); i++)
            {
                output += player.inventory.get(i).getItem() + "\n";
                player.removeItemFromInventory(player.inventory.get(i));
                System.out.println("You dropped " + output);

            }
        }
        else
        {
            System.out.println("You have no items to drop!");
        }



    }
}
