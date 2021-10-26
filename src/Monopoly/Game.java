package Monopoly;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class Game {

    private Board board;
    ArrayList<Property> propertyList;
    private InputParser parser;
    private CommandWord commandWord;
    private ArrayList<Integer> dice;
    private ArrayList<Player> players;
    private Player currentPlayer;
    private int currentPlayerIndex;
    private ArrayList<Square> squares = new ArrayList<Square>(40);
    private int currentTurn = 1;
	private int totalPlayers;
    private int maxPlayers = 6;

    /**
     * Create the game and initialise its internal map.
     */
    public Game()
    {
        board = new Board();
        propertyList = board.getBoard();
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
        System.out.println("How many people are playing today? Minimum 2, Maximum 6.");

        boolean confirmedPlayers = false;
        while (!confirmedPlayers) {
            Scanner sc = new Scanner(System.in);
            if (!(sc.hasNextInt())) {
                System.out.println("Unknown entry. Please enter the number again.");
                continue;
            }

            totalPlayers = sc.nextInt();

            if (totalPlayers > maxPlayers) {
                System.out.println("Too many players. Please enter the number again.");
                continue;

            } else if (totalPlayers < 2) {
                System.out.println("Not enough players. Please enter the number again.");
                continue;
            }
            confirmedPlayers = true;
        }

        int i;
        //int j;

        for (i = 1; i <= totalPlayers; i++){
            System.out.printf("\nPlease write Player %d's name:\n", i);
            Scanner username = new Scanner(System.in);
            String playerName = username.nextLine();
            Player p = new Player(playerName);
			players.add(p);
            //p.setDiceResults(rollDice());
        }

        /*
        for (j = 0; j < players.size(); j++) {
            while (players.get(j).getDiceResults() == players.get(j + 1).getDiceResults()) {
                players.get(j).setDiceResults(rollDice()); //roll until all players have different results
            }
            setPlayerOrder();
        }
        */

        boolean finished = false;

        while (!finished) {
            System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
            Command command = InputParser.getCommand();
            System.out.println();
            finished = processCommand(command);

        }
        System.out.println("Thank you for playing Monopoly!");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to Monopoly!");
        System.out.println();
        //System.out.println(currentRoom.getLongDescription());
    }

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
                System.out.printf("Are you sure you want to buy %s? Y/N", propertyList.get(currentPlayer.currentPosition).getName());
                Scanner buyScn = new Scanner(System.in);
                String buyAns = buyScn.nextLine();
                if (buyAns.equals("Y")) {
                    currentPlayer.buyProperty(propertyList.get(currentPlayer.currentPosition));
                    propertyList.get(currentPlayer.currentPosition).setOwner(currentPlayer);
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
    /*
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
    */
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