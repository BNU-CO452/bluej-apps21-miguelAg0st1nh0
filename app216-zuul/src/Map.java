
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
    
    private Location sun, mercury, venus, earth, mars, jupiter, saturn, uranus, neptune;

    private Location currentLocation;

    /**
     * Constructor for objects of class Map
     */
    public Map()
    {
        createLocations();
        currentLocation = sun;
    }

    /**
     * Create all the Locations and link their exits together.
     * Set the current location to the outside.
     * Both locations need to have been created before
     * their exists are linked.
     */
    private void createLocations()
    {
        createSun();
        createMercury();
        createVenus();
        createEarth();
        createMars();
        createJupiter();
        createSaturn();
        createUranus();
        createNeptune();

        //Start the game at the source, AKA the sun;

    }
    
    /**
     * Create the Planets and Sun: Mercury, Venus, Earth, Mars, Jupiter, Saturn, Uranus, Neptune
     *
     */

    private void createSun()
    {
        // create the Locations
        sun = new Location("Sun, AKA the source!");



    }

    /**
     * Create Mercury and link it to the sun
     */
    private void createMercury()
    {
        mercury = new Location("Mercury, AKA the brown planet!");

        mercury.setExit("east", sun);
        sun.setExit("west", mercury);
    }
    
    /**
     * Create Venus and link it to the sun
     */
    private void createVenus()
    {
        venus = new Location("Venus, AKA the light red planet!");
        
        venus.setExit("south", sun);
        sun.setExit("north", venus);
    }

    /**
     * Create Earth and link it to the sun
     */
    private void createEarth()
    {
        earth = new Location("Earth, AKA the blue planet!");
        
        earth.setExit("west", sun);
        sun.setExit("east", earth);

    }

    /**
     * Create Mars and link it to the sun and Jupiter
     */
    private void createMars()
    {
        mars = new Location("Mars, AKA the dark red planet!");

        mars.setExit("north", sun);
        sun.setExit("south", mars);
        mars.setExit("south", jupiter);
    }

    /**
     * Create Jupiter and link it to the Saturn, Mars, Uranus and Neptune
     */
    private void createJupiter()
    {
        // create the Locations
        jupiter = new Location("Jupiter, AKA the light green planet!");

        mars.setExit("south", jupiter);
        jupiter.setExit("north", mars);
    }

    private void createSaturn()
    {
        // create the Locations
        saturn = new Location("Saturn, AKA the dark green planet!");

        saturn.setExit("east", jupiter);
        jupiter.setExit("west", saturn);
    }
    private void createUranus()
    {
        // create the Locations
        uranus = new Location("Uranus, AKA the grey planet!");

        uranus.setExit("west", jupiter);
        jupiter.setExit("east", uranus);
    }

    private void createNeptune()
    {
        // create the Locations
        neptune = new Location("Neptune, AKA the purple planet!");

        neptune.setExit("north", jupiter);
        jupiter.setExit("south", neptune);
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
