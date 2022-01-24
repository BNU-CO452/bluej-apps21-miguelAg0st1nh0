
/**
 * This command transfers the player from
 * one location to another location provided the
 * two locations are linked by a valid exit
 *
 * @author Derek Peacock & Nicholas Day
 * @version 2021-08-23
 */
public class GoCommand extends ZuulCommand
{
    String direction;
    
    public GoCommand(Game zuul, String direction)
    {
        super(zuul);
        this.direction = direction;
    }    

    public void execute()
    {
        if(direction == null) 
        {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        Map map = zuul.MAP;
        Player player = zuul.player;

        // Try to leave current room.
        Location currentLocation = map.getCurrentLocation();
        Location nextLocation = currentLocation.getExit(direction);

        if (nextLocation == null) 
        {
            System.out.println("There is no exit in this direction!");
        }
        else 
        {
            //Everytime player move drains energy;
            player.setPlayerEnergy(player.getPlayerEnergy() - 10);

            if(player.getPlayerEnergy() < 40)
            {
                System.out.println("You are tired, you should go back to the cave to have some rest!");
                System.out.println("Current Energy: " + player.getPlayerEnergy());
            }
            if(player.getPlayerEnergy() <= 0)
            {
                System.out.println("You are loosing HP due to low energy! Have some rest, you look like a zombie right now!");
                player.setPlayerHP(player.getPlayerHP() - 15);
                System.out.println("Current HP: " + player.getPlayerHP() + " Current Energy: " + player.getPlayerEnergy());
            }

            map.enterLocation(nextLocation);
            System.out.println(map.getCurrentLocation().getLongDescription());

            if(map.currentLocation == map.savannah)
            {
                System.out.println("The dry weather makes you naturally sweat! ");
                player.setPlayerThirst(player.getPlayerThirst() + 15);
                System.out.println("Your current hydration level is: " + player.getPlayerThirst());
            }
            if(map.currentLocation == map.mountain)
            {
                System.out.println("Staring at the horizon...");
                try {Thread.sleep(2000);} catch (InterruptedException e){}
                player.setPlayerEnergy(player.getPlayerEnergy() + 50);
                System.out.println("That was relaxing... Your current energy is: " + player.getPlayerEnergy());
            }

        }
    }

    private void recoverHPOverTime()
    {
        Player player = zuul.player;


    }


}
