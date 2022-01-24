
/**
 * This contains all the possible command words
 * for the game of Zuul
 *
 * @author Derek Peacock & Nicholas Day
 * @version 25-08-2021
 */
public enum CommandWords
{
    GO   ("go","Exit location in <direction>"),
    INVENTORY("inventory", "Prints full inventory!"),
    DROP("drop", "Drops <item> from inventory"),
    HUNT("hunt", "Hunt for food or water"),
    USE("use","Use certain items!"),
    REST("rest", "Rest in your safe place to replenish player energy!"),
    STATS("stats", "Prints all player Stats!"),
    MAP("map", "This prints the world map"),
    PRAY("pray", "Pray to the monolith and wait for divine help!"),
    MATE("mate", "This command allows player to ensure specie survival!"),
    TAKE ("take", "Take <item> from location"),
    HELP ("help", "List all available commands"),
    QUIT ("quit", "End the game");
    
    public final String word;
    public final String description;
    
    CommandWords(String word, String description)
    {
        this.word = word;
        this.description = description;
    }
}
