import java.util.ArrayList;

public class InventoryCommand extends ZuulCommand
{


    /**
     * Constructor for objects of class ZuulCommand
     *
     *
     */
    public InventoryCommand(Game zuul)
    {
        super(zuul);

    }


    public void execute()
    {
        Player player = zuul.player;
        player.printInventory();

    }

}
