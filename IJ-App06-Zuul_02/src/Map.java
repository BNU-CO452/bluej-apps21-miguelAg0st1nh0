

/**
 * This class is responsible for creating and
 * linking all the Locations in the game to
 * form a 2D or 3D network
 *
 *  [Pub]<---->[Outside]<---->[Theatre]
 *                 |
 *          [Computer Lab]<---->[Office]
 *             
 * @author Derek Peacock and Nicholas Day
 * @version 2021-08-22
 */
public class Map
{
    // Need to add a list of exits

    public Location cave, monolith, mountain, jungle, matingPlace, savannah, huntingArea;

    public Location currentLocation;


    /**
     * Constructor for objects of class Map
     */
    public Map()
    {
        createLocations();

    }

    /**
     * Create all the Locations and link their exits together.
     * Set the current location to the outside.
     * Both locations need to have been created before
     * their exists are linked.
     */
    private void createLocations()
    {
        createCave();
        createJungle();
        createMountain();
        createMonolith();
        createMatingPlace();
        createSavannah();
        createHuntingArea();
        currentLocation = cave;  // start game outside
    }
    
    /**
     * Create the outside and link it to the
     * theatre, lab and pub
     */
    private void createCave()
    {
        cave = new Location("in a cave, this is your safe place, here you can rest and replenish your energy levels! <Rest> to rest!");
        cave.setItem(new Item("map"));

    }

    public void createHuntingArea()
    {
        huntingArea = new Location("among other creatures, seems like a nice place to hunt and to drink some water, as you spot a river nearby!");
        cave.setExit("north", huntingArea);
        huntingArea.setExit("south", cave);
        huntingArea.setItem(new Item("spear"));

    }

    private void createSavannah()
    {
        savannah = new Location(" in the savannah, the weather is dry, you feel hot. This soil seems to grow special herbs!");
        cave.setExit("south", savannah);
        savannah.setExit("north", cave);

        savannah.setItem(new Item("herb"));

    }
    
    /**
     * Create the pub and link it to the outside
     */
    private void createMonolith()
    {
        monolith = new Location("in an open field and you spot this strange monolith. Seems like a place for rituals or to call for the Gods! <pray> to Pray to the Gods!");
        cave.setExit("west", monolith);
        monolith.setExit("east", cave);
        monolith.setExit("south", jungle);
        monolith.setItem(new Item("amulet"));
        jungle.setExit("north", monolith);
    }
    
    /**
     * Create the theatre linked to the outside
     */
    private void createJungle()
    {
        jungle = new Location("in a jungle, here lies some dangerous creatures. Be, careful with your actions! You seem to spot a strange flask stuck on a tree. It's risky but can be worth it!");
        jungle.setExit("north", monolith);
        jungle.setItem(new Item("flask"));
    }
    
    /**
     * Create the office linked to the lab
     */
    private void createMountain()
    {
        mountain = new Location("in the mountains, it is a nice place to get an overview of the world! It is so peaceful here, you rest your energy automatically!");
        mountain.setExit("north", matingPlace);
    }
    
    /**
     * Create the lab and link it to the outside and office
     */
    private void createMatingPlace()
    {
        // create the Locations
        matingPlace = new Location("in mating area, you spot other females with whom you can mate with and increase chances of specie survival!");
        cave.setExit("east", matingPlace);
        matingPlace.setExit("west", cave);
        matingPlace.setExit("south", mountain);
        mountain.setExit("north", matingPlace);
    }



    
    public Location getCurrentLocation()
    {
        return currentLocation;
    }

    
    public void enterLocation(Location nextLocation)
    {
        currentLocation = nextLocation;
    }
}
