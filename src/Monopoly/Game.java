package Monopoly;

import java.util.ArrayList;

public class Game {

    private InputParser parser;
    private CommandWord commandWord;
    private ArrayList<Integer> dice;
    private ArrayList<Player> players;
    private Player currentPlayer;

    /**
     * Create the game and initialise its internal map.
     */
    public Game()
    {
        parser = new InputParser();
        dice = new ArrayList<>();
        players = new ArrayList<>();
    }

    private void createBoard(){

    }

    public void play(){
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to Monopoly!");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        //System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    /*private boolean processCommand(CommandWord command)
    {
        boolean wantToQuit = false;

        CommandWord commandWord = Command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
        }
        return wantToQuit;
    }*/

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the
     * command words.
     */
    private void printHelp()
    {
        System.out.println("You are lost");
        System.out.println();
        System.out.println("Your command words are:");
        //parser.showCommands();
    }

    private int rollDice(){
        return (int) ((Math.random() * 11) + 1);
    }

    private void passTurn(){

    }


}
