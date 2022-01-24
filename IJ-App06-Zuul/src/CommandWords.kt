import java.util.Locale
import java.util.HashMap
import kotlin.jvm.JvmStatic

/**
 * This contains all the possible command words
 * for the game of Zuul
 *
 * @author Derek Peacock & Nicholas Day
 * @version 25-08-2021
 */
enum class CommandWords(val word: String, val description: String) {
    GO("go", "Exit location in <direction>"), TAKE("take", "Take <item> from location"), HELP("help", "List all available commands"), QUIT("quit", "End the game");
}