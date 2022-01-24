import java.util.Locale
import java.util.HashMap
import kotlin.jvm.JvmStatic

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
 * Modified by Derek Peacock & Nicholas Day
 * @version 2016.02.29
 */
class Location(
        /**
         * @return The short description of the room
         * (the one that was defined in the constructor).
         */
        val shortDescription: String) {

    // stores exits of this room.
    private val exits: HashMap<String, Location?>

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    fun setExit(direction: String, neighbor: Location?) {
        exits[direction] = neighbor
    }

    /**
     * Return a description of the room in the form:
     * You are in the kitchen.
     * Exits: north west
     * @return A long description of this room
     */
    val longDescription: String
        get() = """ You are ${shortDescription}.
$exitString"""

    /**
     * Return a string listing the locations's exits,
     * for example "Exits: north west".
     */
    private val exitString: String
        private get() {
            var exitNames = " Exits: "
            val keys: Set<String> = exits.keys
            for (exit in keys) {
                exitNames += if (exitNames.length > 8) ", $exit" else exit
            }
            return exitNames
        }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    fun getExit(direction: String): Location? {
        return exits[direction]
    }

    /**
     * Create a location described by "description".
     * Initially, a location has no exits.
     * "description" is something like "a kitchen" or
     * "an open court yard".
     */
    init {
        exits = HashMap()
    }
}