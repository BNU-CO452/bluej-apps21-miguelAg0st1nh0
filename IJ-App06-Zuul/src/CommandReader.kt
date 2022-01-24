import java.util.*
import kotlin.jvm.JvmStatic

/**
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 *
 * This parser reads user input and tries to interpret it as an "Adventure"
 * command. Every time it is called it reads a line from the terminal and
 * tries to interpret the line as a two-word command. It returns the command
 * as an object of class Command.
 *
 * The reader has a set of known command words. It checks user input against
 * the known commands, and if the input is not one of the known commands, it
 * returns a command object that is marked as an unknown command.
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
class CommandReader(private val game: Game) {
    private val reader // source of command input
            : Scanner
    private var commandWord: String? = null
    private var word2: String? = null// get second word
    // note: we just ignore the rest of the input line.
// get first word// Find up to two words on the line.
    /**
     * @return The next command from the user.
     */
    val command: Boolean
        get() {
            val inputLine: String
            print(" > ")
            inputLine = reader.nextLine().lowercase(Locale.getDefault())

            // Find up to two words on the line.
            val tokenizer = Scanner(inputLine)
            if (tokenizer.hasNext()) {
                commandWord = tokenizer.next() // get first word
                word2 = if (tokenizer.hasNext()) {
                    tokenizer.next() // get second word
                    // note: we just ignore the rest of the input line.
                } else null
            }
            return executeCommand()
        }

    private fun executeCommand(): Boolean {
        if (commandWord == CommandWords.GO.word) {
            val go = GoCommand(game, word2)
            go.execute()
        } else if (commandWord == CommandWords.TAKE.word) {
            val take = TakeCommand(game, word2)
            take.execute()
        } else if (commandWord == CommandWords.HELP.word) {
            val help = HelpCommand(game)
            help.execute()
        } else if (commandWord == CommandWords.QUIT.word) {
            return true // game over
        }

        // Return false means the game is not over
        return false
    }

    /**
     * Create a parser to read from the terminal window.
     */
    init {
        reader = Scanner(System.`in`)
    }
}