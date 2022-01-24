import java.util.Locale
import java.util.HashMap
import kotlin.jvm.JvmStatic

/**
 * This class is the main class of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.  Users
 * can walk around some scenery. That's all. It should really be extended
 * to make it more interesting!
 *
 * To play this game, create an instance of this class and call the "play"
 * method.
 *
 * This main class creates and initialises all the others: it creates all
 * locations, creates the CommandReader and starts the game.
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 *
 * Modified and extended by Student Name
 */
class Game {
    val MAP: Map
    private val reader: CommandReader
    private var gameOver = false

    /**
     * Main play routine.  Loops until end of play.
     */
    fun play() {
        printWelcome()
        gameOver = false

        // Enter the main command loop.  Here we repeatedly 
        // read commands and execute them until the game is over.
        while (!gameOver) {
            gameOver = reader.command
        }
        println("Thank you for playing.  Good bye.")
    }

    /**
     * Print out the opening message for the player.
     */
    private fun printWelcome() {
        println()
        println(" Welcome to the World of Zuul!")
        println(" World of Zuul is a new, incredibly boring adventure game.")
        println(" Type 'help' if you need help.")
        println()
        println(MAP.currentLocation?.longDescription)
    }

    /**
     * Create the game and initialise its internal map.
     */
    init {
        MAP = Map()
        reader = CommandReader(this)
    }
}