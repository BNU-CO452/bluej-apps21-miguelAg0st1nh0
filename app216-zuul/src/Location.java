import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Class Location - a location on the map of an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Location" represents one place in the scenery of the game.  It is 
 * connected to other locations via exits.  For each existing exit, the 
 * location stores a reference to the neighboring locations.
 * 
 * @author  Michael Kölling and David J. Barnes
 * Modified by Miguel Agostinho
 * @version 07/12/2021
 */

public class Location 
{

    private Items itemInRoom;
    private String description;
    // This stores exits of this room.
    private HashMap<String, Location> exits;
    private HashMap<String, Items> items;

    /**
     * Create a location described by "description".
     * Initially, a location has no exits.
     * "description" is something like "a kitchen" or
     * "an open court yard".
     */
    public Location(String description) 
    {

        this.description = description;
        exits = new HashMap<>();
        items = new HashMap<>();
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Location neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north-west
     * @return A long description of this room
     */
    //TODO print here the items that exist in the planet;
    public String getLongDescription()
    {
        return " You are at " + description + ".\n" + getExitString();
    }


    /**
     * Return a string listing all the exits locations,
     * for example "Exits: north-west".
     */
    private String getExitString()
    {
        String exitNames = " Exits: ";
        Set<String> keys = exits.keySet();
        
        for(String exit : keys) 
        {
            if(exitNames.length() > 8)
                exitNames += ", " + exit;
            else
                exitNames += exit;
        }
        return exitNames;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Location getExit(String direction) 
    {
        return exits.get(direction);
    }
}

