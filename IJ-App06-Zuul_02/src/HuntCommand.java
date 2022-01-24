import java.util.Random;

public class HuntCommand extends ZuulCommand
{
    String object;
    Boolean canHuntForFood;
    Player player = zuul.player;
    Map map = zuul.MAP;

    public HuntCommand(Game zuul, String object)
    {
        super(zuul);
        this.object = object;
        canHuntForFood = false;
    }

    public void execute()
    {
        canHuntForFood = player.hasSpearInInventory("spear");

        if(object == null)
        {
            System.out.println("Hunter for food or water?");

        }
        else if(object.equalsIgnoreCase("food") && !canHuntForFood)
        {
            System.out.println("You don't have nothing to hunt with!");
        }
        else if(object.equalsIgnoreCase("food") && canHuntForFood)
        {
            huntForFood();
        }
        else if(object.equalsIgnoreCase("water") && map.currentLocation != map.huntingArea)
        {
            System.out.println("You are not near a water source!");
        }
        else if(object.equalsIgnoreCase("water") && map.currentLocation == map.huntingArea)
        {
            huntForWater();
        }

    }


    private void huntForFood()
    {
        System.out.println("Hunting...");
        Random rand = new Random();
        int newRandom = rand.nextInt(100);
        try {Thread.sleep(1500);} catch (InterruptedException e){}
        System.out.println("Random " + newRandom);
        if(newRandom >= player.getPlayerHuntChance())
        {
            player.decreasePlayerHunger(40);
            player.setPlayerHP(player.getPlayerHP() + 10);
            System.out.println("You successfully captured the creature! Your hunger decreases and you heal some points!");
            if(player.getPlayerHunger() < 0)
            {
                player.setPlayerHunger(0);

            }
        }
        else
        {
            //Damages player by 30HP;
            player.increasePlayerHunger(40);
            System.out.println("You fail to capture the creature! Your hunger increases!");
            if(player.getPlayerHunger() > 100)
            {
                player.decreasePlayerHP(50);
                player.setPlayerHunger(100);
                System.out.println("You're Hungry! You lose HP! Current HP: " + player.getPlayerHP());
                if(player.getPlayerHP() == 0)
                {
                    System.out.println("You died from starvation!");
                }
            }
        }


        System.out.println("Your current Hunger level is: " + player.getPlayerHunger());
    }

    private void huntForWater()
    {
        System.out.println("Drinking...");
        Random rand = new Random();
        int newRandom = rand.nextInt(100);
        System.out.println(newRandom);
        try {Thread.sleep(1500);} catch (InterruptedException e){}
        if(newRandom >= player.getPlayerHuntChance())
        {
            //Hydrates player by 30;
            player.decreasePlayerThirst(30);
            System.out.println("You successfully drink water! Your thirst decreases!");
            if(player.getPlayerThirst() < 0)
            {
                player.setPlayerHP(player.getPlayerHP() + 5);
                player.setPlayerThirst(0);
            }
        }
        else
        {
            //Damages player by 30HP;
            player.increasePlayerThirst(40);
            System.out.println("You fail to drink water! Your thirst increases!");
            if(player.getPlayerThirst() > 100)
            {
                player.decreasePlayerHP(50);
                player.setPlayerThirst(100);
                System.out.println("You're Thirsty! Current HP: " + player.getPlayerHP());

                if(player.getPlayerHP() == 0)
                {
                    System.out.println("You died from dehydration!");
                }
            }
        }


        System.out.println("Your current Thirst level is: " + player.getPlayerThirst());
    }



}

