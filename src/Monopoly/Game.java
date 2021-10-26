package Monopoly;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Game {

    private InputParser parser;
    private ArrayList<Integer> dice;
    private ArrayList<Player> players;
    private Player currentPlayer;
    private int currentPlayerIndex;
    private ArrayList<Square> squares = new ArrayList<Square>(40);
    private int currentTurn = 1;
	private int totalPlayers;
    private HashMap<Player, ArrayList<Property>> ownedProperties = new HashMap<>();


    /**
     * Create the game and initialise its internal map.
     */
    public Game()
    {
        parser = new InputParser();
        dice = new ArrayList<>();
        players = new ArrayList<>();
        currentPlayerIndex = 0;
    }

    /**
     * Creates the Monopoly board
     */
    private void createBoard(){
        
    }

    public void play(){
        printWelcome();
        System.out.println("How many people are playing today?");
        Scanner sc = new Scanner(System.in);
        totalPlayers = sc.nextInt();
        for(int i = 1; i <= totalPlayers; i++){
            Scanner username = new Scanner(System.in);
            String playername= username.nextLine();
            Player p = new Player(playername);
			players.add(p);
            p.setDiceResults(rollDice());
        }
        for (int i = 0; i < players.size(); i++) {
            while (players.get(i).getDiceResults() == players.get(i + 1).getDiceResults()) {
                players.get(i).setDiceResults(rollDice()); //roll until all players have different results
            }
            setPlayerOrder();
        }
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
    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command)
    {
        boolean wantToQuit = false;

        CommandWord commandWord = Command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("Unknown command.");
                break;

            case HELP:
                printHelp();
                break;

            case PLAYER_STATE:
                System.out.println(currentPlayer.toString());
                break;

            case BUY_PROPERTY:
                System.out.printf("Are you sure you want to buy %s? Y/N", getProperty(currentPlayer.currentPosition).getName());
                Scanner buyScn = new Scanner(System.in);
                String buyAns = buyScn.nextLine();
                if (buyAns.equals("Y")) {
                    currentPlayer.buyProperty(getProperty(currentPlayer.currentPosition));
                    break;
                } else if (buyAns.equals("N")) {
                    break;
                } else {
                    System.out.println("Unknown answer, please try the command again.");
                    break;
                }

            case PASS_TURN:
                passTurn();
                break;

            case QUIT:
                System.out.println("Are you sure you want to quit? The game will end and your progress will be lost. Y/N");
                Scanner quitScn = new Scanner(System.in);
                String quitAns = quitScn.nextLine();
                if (quitAns.equals("Y")) {
                    wantToQuit = true;
                    break;
                } else if (quitAns.equals("N")) {
                    break;
                } else {
                    System.out.println("Unknown answer, please try the command again.");
                    break;
                }
        }
        return wantToQuit;
    }


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
        parser.showCommands();
    }

    /**
     * Returns the current player from the players list
     */
    private Player getCurrentPlayer(){
        return players.get(currentPlayerIndex);
    }

    private int rollDice() {
        int dice1 = ThreadLocalRandom.current().nextInt(1, 7);
        int dice2 = ThreadLocalRandom.current().nextInt(1, 7);
        return dice1 + dice2;

    }

    private void passTurn(){
        currentPlayerIndex++;
        if (currentPlayerIndex >= totalPlayers){
            currentPlayerIndex = 0;
        }
        currentPlayer = players.get(currentPlayerIndex);
        System.out.println("It is Player "+ currentPlayer.getPlayerName() + "'s turn.");

        //next player rolls dice
        rollDice();
    }

    /**
     * Sets the player starting the game based on their roll results
     * value 0 if x == y; a value less than 0 if x < y; and a value greater than 0 if x > y
     */
    private void setPlayerOrder(){
        for (int i=0; i<players.size();i++){
            // i < i+1
            if (compareDiceRolls(players.get(i), players.get(i+1)) < 0) {
                Collections.swap(players, i, i + 1);
                currentPlayer = players.get(i);
                break;
            }
            else
                // i > i+1
                currentPlayer = players.get(i);
        }
    }

    /**
     * Compares two players dice results
     * @param a Player one
     * @param b Player two
     * @return comparison result
     */
    private int compareDiceRolls(Player a, Player b){
        return Integer.compare(a.getDiceResults(), b.getDiceResults());
    }

    private void movePlayer(Player p){
        p.updateCurrentPosition (p.getDiceResults());
    }

    public static void main(String[] args) {
        new Game().play();
    }
}