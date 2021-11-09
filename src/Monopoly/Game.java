package Monopoly;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class Game {

    ArrayList<Property> propertyList;
    private final InputParser parser;
    private ArrayList<Integer> dice;
    private ArrayList<Player> players;
    private Player currentPlayer;
    private int currentPlayerIndex;
    private ArrayList<Square> squares = new ArrayList<Square>(40);
    private int currentTurn = 1;
	private int totalPlayers;
    private int min_players = 2;
    private int max_players = 6;

    private ArrayList<MonopolyView> views;


    /**
     * Create the game and initialise its internal map.
     */
    public Game()
    {
        Board board = new Board();
        propertyList = board.getBoard();
        parser = new InputParser();
        dice = new ArrayList<>();
        players = new ArrayList<>();
        views = new ArrayList<>();
        currentPlayerIndex = 0;
    }

    /**
     * Creates the Monopoly board
     */
    private void createBoard(){
        
    }

    public void addView(MonopolyView mview){
        views.add(mview);
    }

    private void notifyAllViews(MonopolyEvent e){
        for (MonopolyView v : views){
            v.handleMonopolyUpdate(e);
        }
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

            int maxPlayers = 6;
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

        currentPlayer = players.get(currentPlayerIndex);

        boolean finished = false;
        boolean roll = false;
        System.out.println("\nTurn " + currentTurn + ". It is " + currentPlayer.getPlayerName() + "'s turn.");

        while (!finished) {
            System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
            Command command = InputParser.getCommand();
            System.out.println();
            finished = processCommand(command);
            if (totalPlayers == 1) {
                System.out.println(players.get(0).getPlayerName() + " won!");
                finished = true;
            }

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

    private void getDetails(int currentPos) {
        Property currentProperty = propertyList.get(currentPos);

        System.out.println("Welcome to " + propertyList.get(currentPos).getName() + " (Position " + currentPos + ")");

        if(propertyList.get(currentPos).getColour().equals("none")) {
            System.out.println("Under Construction. Stay tuned for this in a later update!");
        }else if(!(propertyList.get(currentPos).getColour().equals("none")) && currentProperty.checkAvailability()) {
            System.out.println("You can buy this property for: " + propertyList.get(currentPos).getPurchasingCost());
        }
        else{
            System.out.println("This property is owned by " + propertyList.get(currentPos).getOwner().getPlayerName());
            System.out.println("The rent for this property is: " + propertyList.get(currentPos).getRentCost());


            int rent = currentProperty.getRentCost();
            if(getCurrentPlayer().getMoney() < propertyList.get(currentPos).getRentCost()){
                System.out.println("You cannot afford the rent. You have paid what you could and gone bankrupt.");
                currentProperty.getOwner().setMoney(currentProperty.getOwner().getMoney() + currentPlayer.getMoney());
                currentPlayer.setMoney(0);
                for (int i = 0; i < currentPlayer.getProperties().size(); i++) {
                    currentPlayer.getProperties().get(i).setOwner(null);
                }
                System.out.println(currentPlayer.getPlayerName() + " lost. All their properties have been liberated and are now available to buy.");
                players.remove(currentPlayer);
                totalPlayers--;
            }else{
                System.out.println("The rent cost will be taken from your account");
                currentPlayer.setMoney(currentPlayer.getMoney() - rent);
                currentProperty.getOwner().setMoney(currentProperty.getOwner().getMoney() + rent);
            }
        }
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
        Property currentProperty = propertyList.get(currentPlayer.currentPosition);

        switch (commandWord) {
            case BUY_PROPERTY:
                if (currentProperty.getColour().equals("none")) {
                    System.out.println("You cannot buy this property.");
                    break;
                } else if (currentProperty.getPurchasingCost() > currentPlayer.getMoney()) {
                    System.out.println("You do not have enough funds to buy this property.");
                } else if (!currentProperty.checkAvailability()) {
                    System.out.println("You cannot buy this property, it belongs to " + currentProperty.getOwner().getPlayerName() + ".");
                } else {
                    System.out.printf("Are you sure you want to buy %s? Y/N\n", currentProperty.getName());
                    Scanner buyScn = new Scanner(System.in);
                    String buyAns = buyScn.nextLine();

                    if (buyAns.equals("Y")) {
                        currentPlayer.buyProperty(currentProperty);
                        currentProperty.setOwner(currentPlayer);
                        int propertyCost = currentProperty.getPurchasingCost();

                        currentPlayer.setMoney(currentPlayer.getMoney() - propertyCost);
                        System.out.println("You are now the owner of " + currentProperty.getName() + ".");
                        System.out.println("Your balance is now $" + currentPlayer.getMoney());

                        break;
                    } else if (buyAns.equals("N")) {
                        break;
                    } else {
                        System.out.println("Unknown answer, please try the command again.");
                        break;
                    }
                }

            case DEBUG_ROLL:
                System.out.println("Welcome to the secret debug roll! Please enter the position you want Player " + currentPlayer.getPlayerName() + " to move to: \n");
                Scanner posScn = new Scanner(System.in);
                if (!(posScn.hasNextInt())) {
                    System.out.println("Unknown entry. Please try the command again.");
                    break;
                }

                int newPos = posScn.nextInt();
                if (newPos > 39) {
                    System.out.println("Requested position is too high (Maximum is 39). Please try the command again.");
                    break;
                }
                currentPlayer.currentPosition = newPos;
                System.out.println("Your new position is " + currentPlayer.currentPosition + " (" + propertyList.get(currentPlayer.currentPosition).getName() + ")");

                getDetails(currentPlayer.currentPosition);

                break;

            case HELP:
                printHelp();
                break;

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

            case ROLL:
                System.out.println("Now rolling for your turn!");

                int diceRoll = rollDice();
                //Add doubles, which would keep rolled to false so the player can roll again.
                System.out.println("You have moved " + diceRoll + " positions!");

                int startingPos = currentPlayer.currentPosition;
                int endingPos = startingPos + diceRoll;

                if (endingPos > 39) {
                    int placesBefore39 = 39 - startingPos;
                    currentPlayer.currentPosition = (diceRoll - placesBefore39) - 1;
                } else {
                    currentPlayer.currentPosition = startingPos + diceRoll;
                }

                getDetails(currentPlayer.currentPosition);
                break;

            case PLAYER_STATE:

                System.out.println("Which player's state?");
                System.out.println("Options: " + getPlayerList());
                Scanner playerScn = new Scanner(System.in);
                String playerAns = playerScn.nextLine();

                for (int i = 0; i < totalPlayers; i++) {
                    if (playerAns.equals(players.get(i).getPlayerName())) {
                        System.out.println(players.get(i).getPlayerState());
                        break;
                    }
                }
                System.out.println("Unknown Entry. Please try the command again.");
                break;

            case UNKNOWN:
                System.out.println("Unknown command.");
                break;

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

    private String getPlayerList() {
        StringBuilder playerList = new StringBuilder();
        for (int i = 0; i < totalPlayers - 1; i++) {
            playerList.append(players.get(i).getPlayerName()).append(" ");
        }

        playerList.append(players.get(totalPlayers - 1).getPlayerName());

        return playerList.toString();
    }

    private void passTurn() {
        currentPlayerIndex++;
        if (currentPlayerIndex >= totalPlayers){
            currentPlayerIndex = 0;
        }
        currentPlayer = players.get(currentPlayerIndex);
        currentTurn++;
        System.out.println("Turn " + currentTurn + ". It is "+ currentPlayer.getPlayerName() + "'s turn.");
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
     * Returns the total number of players
     */
    int getTotalPlayers(){
        return totalPlayers;
    }

    /**
     * Sets the total number of players
     * @param num Total number of players
     */
    void setTotalPlayers(int num){
        totalPlayers = num;
    }

    /**
     *  Returns the minimum number of players allowed in the game
     */
    int getMinPlayers(){
        return min_players;
    }

    /**
     * Returns the minimum number of players allowed in the game
     */
    int getMaxPlayers(){
        return max_players;
    }

    /**
     * Adds a player to the list of players
     * @param p Player to be added
     */
    void addPlayer(Player p){
        players.add(p);
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