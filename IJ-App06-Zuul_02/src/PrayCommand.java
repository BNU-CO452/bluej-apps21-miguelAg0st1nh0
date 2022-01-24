import java.util.Random;

public class PrayCommand extends ZuulCommand
{
    String name;

    public PrayCommand(Game zuul, String name)
    {
        super(zuul);
        this.name = name;

    }

    public void execute()
    {
        Player player = zuul.player;
        Map map = zuul.MAP;

        if(name == null)
        {
            System.out.println("Pray to what?");
        }
        else if(map.currentLocation == map.monolith && name.equalsIgnoreCase("monolith"))
        {

            System.out.println("Praying...");
            try {Thread.sleep(2000);} catch (InterruptedException e){}
            Random rand = new Random();
            int newRandom = rand.nextInt(4);
            switch (newRandom)
            {
                case 1:
                    player.setPlayerHuntChance(player.getPlayerHuntWaterChance() - 20);
                    System.out.println("Your prayers were answered, the Gods gave you a better change while hunting for food!");
                    System.out.println("Chance is now: " + (100 - player.getPlayerHuntChance()) + "%");
                    break;
                case 2:
                    System.out.println("Your prayers were answered, the Gods gave you vitality, your HP is doubled!");
                    player.setPlayerHP(player.getPlayerHP()*2);
                    System.out.println("Current HP: " + player.getPlayerHP());
                    break;
                case 3:
                    System.out.println("You feel the wrath of the Gods! You lose HP!");
                    player.setPlayerHP(player.getPlayerHP() - 40);
                    System.out.println("Current HP: " + player.getPlayerHP());
                    break;
                case 4:
                    System.out.println("Your prayers were answered, the Gods inspire your feet and you feel them lighter, your Energy is doubled!");
                    player.setPlayerEnergy(player.getPlayerEnergy()*2);
                    System.out.println("Current Energy: " + player.getPlayerEnergy());
                    break;
                default:
                    break;
            }
            player.setPlayerEnergy(player.getPlayerEnergy() - 40);
            System.out.println("Praying draws energy from you! ");
            System.out.println("Current Energy: " + player.getPlayerEnergy());
        }

    }
}
