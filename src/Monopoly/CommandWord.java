package Monopoly;

/**
 * This class is taken from the Zuul with enumerations v2 project from the lectures
 * with some modifications to work with the monopoly project.
 *
 * Representations for all the valid command words for the game
 * along with a string in a particular language.
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public enum CommandWord
{
    // A value for each command word along with its
    // corresponding user interface string.
    BUY_PROPERTY("buy"), DEBUG_ROLL("debug"), HELP("help"), PASS_TURN("pass"),
    QUIT("quit"), ROLL("roll"), PLAYER_STATE("state"), UNKNOWN("?");

    // The command string.
    private String commandString;

    /**
     * Initialise with the corresponding command string.
     * @param commandString The command string.
     */
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }

    /**
     * @return The command word as a string.
     */
    public String toString()
    {
        return commandString;
    }
}