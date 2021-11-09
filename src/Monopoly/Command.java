package Monopoly;

/**
 * This class is taken from the Zuul with enumerations v2 project from the lectures.
 *
 * This class holds information about a command that was issued by the user.
 * A command currently consists of two parts: a CommandWord and a string
 * (for example, if the command was "take map", then the two parts
 * are TAKE and "map").
 *
 * The way this is used is: Commands are already checked for being valid
 * command words. If the user entered an invalid command (a word that is not
 * known) then the CommandWord is UNKNOWN.
 *
 * If the command had only one word, then the second word is <null>.
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Command
{
    private static CommandWord commandWord;
    //private String secondWord;

    /**
     * Create a command object. First and second words must be supplied, but
     * the second may be null.
     * @param commandWord The CommandWord. UNKNOWN if the command word
     * was not recognised.
     */
    public Command(CommandWord commandWord)
    {
        Command.commandWord = commandWord;
    }

    /**
     * Return the command word (the first word) of this command.
     * @return The command word.
     */
    public static CommandWord getCommandWord()
    {
        return commandWord;
    }

    /**
     * @return true if this command was not understood.
     */
    public boolean isUnknown()
    {
        return (commandWord == CommandWord.UNKNOWN);
    }

}
