
/**
 * This contains all the possible command words
 * for the game of Zuul
 *
 * @author Derek Peacock & Nicholas Day
 * @version 25-08-2021
 */
public enum CommandWords
{
    //TODO add new command words
    MAP("map", "Display map!"),
    ITEMS ("item", ""),
    GO   ("go","Exit location in <direction>"),
    TAKE ("take", "Take <it+em> from location"),
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
