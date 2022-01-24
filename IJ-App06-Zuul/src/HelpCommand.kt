import java.util.Locale
import java.util.HashMap
import kotlin.jvm.JvmStatic

/**
 * Write a description of class HelpCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class HelpCommand(zuul: Game?) : ZuulCommand(zuul) {
    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and
     * a list of the command words.
     */
    override fun execute() {
        println(" You are lost. You are alone. You wander")
        println(" around at the university.")
        println()
        println(" Your command words are:")
        println()
        for (command in CommandWords.values()) {
            println(" " + command.word +
                    "\t  : " + command.description)
        }
        println()
        println(" e.g. go west, take gold")
        println()
        println(zuul!!.MAP.currentLocation.longDescription)
    }
}