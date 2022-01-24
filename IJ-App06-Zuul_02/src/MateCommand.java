import java.util.Random;

public class MateCommand extends ZuulCommand
{


    public MateCommand(Game zuul)
    {
        super(zuul);
    }

    public void execute()
    {
        Map map = zuul.MAP;


        if(map.currentLocation == map.matingPlace)
        {
            matingChances();
        }
    }

    public void matingChances()
    {
        Player player = zuul.player;

        Random rand = new Random();
        int totalFemales = rand.nextInt(10);

        if(totalFemales > 0)
        {
            System.out.println("You found " + totalFemales + " females in the area, for the sake of specie survival you try to mate with all of them!");
            System.out.println("Mating...");
            try {Thread.sleep(3000);} catch (InterruptedException e){}
            for(int i = 0; i < totalFemales; i++)
            {

                Random random = new Random();
                int newRandom = random.nextInt(100);
                if(newRandom >= player.getPlayerMatingChance())
                {
                    System.out.println("Successful created a cub! Your specie survival hope increases!");
                    player.setTotalCubs(player.getTotalCubs() + 1);
                    System.out.println("Your current specie population: " + player.getTotalCubs());
                }
                else
                {
                    System.out.println("You failed to create a cub! You lose energy and other vitals!");
                    player.setPlayerEnergy(player.getPlayerEnergy() - 10);
                    player.setPlayerHunger(player.getPlayerHunger() + 10);
                    player.setPlayerThirst(player.getPlayerThirst() + 10);
                    System.out.println("Current Energy: " + player.getPlayerEnergy());
                    System.out.println("Current Hunger: " + player.getPlayerHunger());
                    System.out.println("Current Thirst: " + player.getPlayerThirst());
                    if(player.getPlayerThirst() >= 60 || player.getPlayerHunger() >= 60)
                    {
                        System.out.println("You should head for the hunting area to restore some of your vitals");
                    }
                    if(player.getPlayerEnergy() <= 20)
                    {
                        System.out.println("You're, tired, you should go back to the cave to rest!");
                        System.out.println("Current Energy: " + player.getPlayerEnergy());
                    }
                    if(player.getPlayerEnergy() <= 0)
                    {
                        System.out.println("You're exhausted, you lose HP!");
                        player.setPlayerHP(player.getPlayerHP() - 20);
                        System.out.println("Current HP: " + player.getPlayerHP());
                    }
                }

            }

        }
        else
        {
            System.out.println("There are no females in the area, try again!");

        }

    }


}
