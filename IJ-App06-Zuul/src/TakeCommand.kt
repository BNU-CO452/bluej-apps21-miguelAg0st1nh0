import java.util.Locale
import java.util.HashMap
import kotlin.jvm.JvmStatic

/**
 * This command allows the player to
 * take or pickup an item from a room
 * and carry it around to use somewhere
 * else
 *
 * @author Derek Peacock & Nicholas Day
 * @version 2021-08-23
 */
class TakeCommand
/**
 * Take an item from a location and add it
 * to the player's inventory.
 */(zuul: Game?, var item: String?) : ZuulCommand(zuul) {
    override fun execute() {
        if (item == null) {
            // if there is no second word, we don't know what to take...
            println("Take what?")
            return
        }
        val map = zuul!!.MAP
        // remove the item from the current room
        // and add it to the player's inventory
        // Print out a suitable message.
    }
}