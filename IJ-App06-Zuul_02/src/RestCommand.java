public class RestCommand extends ZuulCommand
{


    public RestCommand(Game game)
    {
        super(game);
    }


    public void execute()
    {
        Player player = zuul.player;
        Map map = zuul.MAP;

        if(map.currentLocation == map.cave)
        {
            System.out.println("Resting...");
            try {Thread.sleep(3000);} catch (InterruptedException e){}
            player.setPlayerEnergy(100);
            System.out.println("You feel energetic! Your current energy: " + player.getPlayerEnergy());
        }
        else
        {
            System.out.println("You are not in the right place to rest!");
        }

    }
}
