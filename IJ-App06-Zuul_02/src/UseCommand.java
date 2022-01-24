import java.util.Random;

public class UseCommand extends ZuulCommand
{
    String item;
    public boolean hasUsed;

    public UseCommand(Game zuul, String item)
    {
        super(zuul);
        this.item = item;
        hasUsed = false;
    }

    public void execute()
    {
        Player player = zuul.player;

        if(item == null)
        {
            System.out.println("Use what?");
        }
        else if(item.equals("herb") && player.hasHerbInInventory("herb") && !hasUsed)
        {
            player.setPlayerHuntChance(35);
            System.out.println("Your hunting chance is now 65% instead of 50%");
            hasUsed = true;
        }
        else if(item.equals("herb") && !player.hasHerbInInventory("herb"))
        {
            System.out.println("Your don't have that in your inventory!");

        }
        else if(item.equalsIgnoreCase("amulet") && player.hasAmuletInInventory("amulet"))
        {
            player.setPlayerMatingChance(20);
            System.out.println("Your mating chance is now 80%");
        }

        else if(item.equalsIgnoreCase("flask") && player.hasFlaskInInventory("flask"))
        {
            flaskEffect();
        }


    }

    private void flaskEffect()
    {
        Player player = zuul.player;
        Random rand = new Random();
        int newRand = rand.nextInt(3);
        System.out.println("You drink the strange flask and the randomness of the Gods are with you...");
        try {Thread.sleep(2000);} catch (InterruptedException e){}

        switch (newRand)
        {
            case 0:
                System.out.println("Ewwww... tastes like poison!");
                player.setPlayerHP(player.getPlayerHP() - 35);
                System.out.println("Current HP: " + player.getPlayerHP());
                break;
            case 1:
                System.out.println("Hummm... tastes like wine!");
                player.setPlayerThirst(player.getPlayerThirst() - 25);
                player.setPlayerEnergy(player.getPlayerEnergy() - 25);
                System.out.println("Current Thirst is lowered, is now:" + player.getPlayerThirst());
                System.out.println("Current Energy is lowered, is now:" + player.getPlayerEnergy());
                break;
            case 2:
                System.out.println("Wooooow.... tastes like the true drink of the Gods! Which you feel like one now!");
                player.setPlayerEnergy(100);
                player.setPlayerHunger(0);
                player.setPlayerThirst(0);
                player.setPlayerHP(100);
                System.out.println("You replenish and restore all stats!");

                break;
            default:
                System.out.println("... nothing happened!");
                break;
        }
    }

}
