import java.util.Locale
import java.util.HashMap
import kotlin.jvm.JvmStatic

object Main {
    /**
     * Create a new game and start to play it.
     * @author Derek
     */
    @JvmStatic
    fun main(args: Array<String>) {
        val zuul = Game()
        zuul.play()
    }
}