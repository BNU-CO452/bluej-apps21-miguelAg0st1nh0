public class StatsCommand  extends ZuulCommand
{

    public StatsCommand(Game zuul)
    {
        super(zuul);
    }

    public void execute()
    {
        Player player = zuul.player;

        System.out.println("Player current Stats:");
        System.out.println("Player HP:" + player.getPlayerHP());
        System.out.println("Player Hunger:" + player.getPlayerHunger());
        System.out.println("Player Thirst:" + player.getPlayerThirst());
        System.out.println("Player Energy:" + player.getPlayerEnergy());
        System.out.println("Total Population:" + player.getTotalCubs());
        System.out.println("------------------------");
    }
}
