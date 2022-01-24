import java.util.Locale
import java.util.HashMap
import kotlin.jvm.JvmStatic

/**
 * This command transfers the player from
 * one location to another location provided the
 * two locations are linked by a valid exit
 *
 * @author Derek Peacock & Nicholas Day
 * @version 2021-08-23
 */
class GoCommand(zuul: Game?, var direction: String?) : ZuulCommand(zuul) {
    override fun execute() {
        if (direction == null) {
            // if there is no second word, we don't know where to go...
            println("Go where?")
            return
        }
        val map = zuul!!.MAP

        // Try to leave current room.
        val currentLocation = map.currentLocation
        val nextLocation = currentLocation!!.getExit(direction!!)
        if (nextLocation == null) {
            println("There is no exit in this direction!")
        } else {
            map!!.enterLocation(nextLocation)
            println(map.currentLocation.longDescription)
        }
    }
}