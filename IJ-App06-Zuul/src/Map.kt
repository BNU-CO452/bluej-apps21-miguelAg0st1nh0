import java.util.Locale
import java.util.HashMap
import kotlin.jvm.JvmStatic

/**
 * This class is reponsible for creating and
 * linking all the Locations in the game to
 * form a 2D or 3D network
 *
 * [Pub]<---->[Outside]<---->[Theatre]
 * |
 * [Computer Lab]<---->[Office]
 *
 * @author Derek Peacock and Nicholas Day
 * @version 2021-08-22
 */
class Map {
    // Need to add a list of exits
    private var outside: Location? = null
    private var theater: Location? = null
    private var pub: Location? = null
    private var lab: Location? = null
    private var office: Location? = null
    var currentLocation: Location? = null
        private set

    /**
     * Create all the Locations and link their exits together.
     * Set the current location to the outside.
     * Both locations need to have been created before
     * their exists are linked.
     */
    private fun createLocations() {
        createOutside()
        createTheatre()
        createPub()
        createOffice()
        createLab()
        currentLocation = outside // start game outside
    }

    /**
     * Create the outside and link it to the
     * theatre, lab and pub
     */
    private fun createOutside() {
        outside = Location("outside the main entrance of the university")
    }

    /**
     * Create the pub and link it to the outside
     */
    private fun createPub() {
        pub = Location("in the campus pub")
        pub!!.setExit("east", outside)
        outside!!.setExit("west", pub)
    }

    /**
     * Create the theatre linked to the outside
     */
    private fun createTheatre() {
        theater = Location("in a lecture theater")
        theater!!.setExit("west", outside)
        outside!!.setExit("east", theater)
    }

    /**
     * Create the office linked to the lab
     */
    private fun createOffice() {
        office = Location("in the computing admin office")
    }

    /**
     * Create the lab and link it to the outside and office
     */
    private fun createLab() {
        // create the Locations
        lab = Location("in a computing lab")
        lab!!.setExit("east", office)
        office!!.setExit("west", lab)
        lab!!.setExit("north", outside)
        outside!!.setExit("south", lab)
    }

    fun enterLocation(nextLocation: Location?) {
        currentLocation = nextLocation
    }

    /**
     * Constructor for objects of class Map
     */
    init {
        createLocations()
    }
}