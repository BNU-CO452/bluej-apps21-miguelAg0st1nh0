public class MapCommand extends ZuulCommand
{

    public MapCommand(Game zuul)
    {
        super(zuul);
    }

    public void execute()
    {
        Player player = zuul.player;
        Map map = zuul.MAP;
        if(player.hasMapInInventory("map"))
        {
            System.out.println("<------------------MAP--------------------->");
            System.out.println("              [Hunting Area]                ");
            System.out.println("                    |                       ");
            System.out.println("[Monolith]<----->[Cave]<----->[Mating Place]");
            System.out.println("    |               |               |       ");
            System.out.println("[Jungle]<------>[Savannah]<----->[Mountain] ");
            System.out.println("<------------------------------------------>");
            System.out.println("Current Location: " + map.currentLocation.getShortDescription());
            System.out.println("<------------------------------------------>");

        }
        else
        {
            System.out.println("You are not carrying the map with you! Find it first to use this command!");
        }
    }
}
