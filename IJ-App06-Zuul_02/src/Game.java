/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  locations, creates the CommandReader and starts the game.  
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 * 
 * Modified and extended by Student Name
 */

public class Game 
{
    public final Map MAP;
    public Player player;
    public Location location;
    private CommandReader reader;
    private boolean gameOver;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        player = new Player();
        MAP = new Map();
        reader = new CommandReader(this);
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();
        gameOver = false;

        // Enter the main command loop.  Here we repeatedly 
        // read commands and execute them until the game is over.
                
        while (! gameOver) 
        {
            gameOver = reader.getCommand();

            if(player.getPlayerHP() <= 0)
            {
                gameOver = true;
                System.out.println("Good Luck next time!");
            }
            if(player.getTotalCubs() >= 30)
            {
                System.out.println("You survived the primal era and managed to ensure a fair amount of your specie!");
                System.out.println("Congratulations, you win the game!!!");
                gameOver = true;
            }
        }
        
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println(" Welcome to the World of Zuul!");
        System.out.println(" World of Zuul is a survival adventure game, your main goal is to ensure your own survival and create a fair number of your own specie population to win the game.");
        System.out.println(" Good Luck and remember to keep an eye on your stats at all times. The universe is written in random numbers, which can change when you least expect!");
        System.out.println(" Type 'help' if you need help.");
        System.out.println();
        System.out.println(MAP.getCurrentLocation().getLongDescription());
    }
}
