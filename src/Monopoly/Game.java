package Monopoly;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class Game {

    ArrayList<Property> propertyList;
    private ArrayList<Integer> dice;
    private ArrayList<Player> players;
    private Player currentPlayer;
    private int currentPlayerIndex;
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
        dice = new ArrayList<>();
        players = new ArrayList<>();
        views = new ArrayList<>();
        currentPlayerIndex = 0;
    }



    public void addView(MonopolyView mview){
        views.add(mview);
    }

    private void notifyAllViews(MonopolyEvent e){
        for (MonopolyView v : views){
            v.handleMonopolyUpdate(e);
        }
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
     * Returns the current player from the players list
     */
    public Player getCurrentPlayer(){
        return players.get(currentPlayerIndex);
    }

    int[] rollDice() {
        int[] dices = new int[2];
        int dice1 = ThreadLocalRandom.current().nextInt(1, 7);
        int dice2 = ThreadLocalRandom.current().nextInt(1, 7);
        dices[0] = dice1;
        dices[1] = dice2;
        return dices;

    }

    private String getPlayerList() {
        StringBuilder playerList = new StringBuilder();
        for (int i = 0; i < totalPlayers - 1; i++) {
            playerList.append(players.get(i).getPlayerName()).append(" ");
        }

        playerList.append(players.get(totalPlayers - 1).getPlayerName());

        return playerList.toString();
    }

    public ArrayList<Property> getPropertyList() {
        return propertyList;
    }

    public void passTurn() {
        currentPlayerIndex++;
        if (currentPlayerIndex >= totalPlayers){
            currentPlayerIndex = 0;
        }
        currentPlayer = players.get(currentPlayerIndex);
        currentTurn++;
        System.out.println("Turn " + currentTurn + ". It is "+ currentPlayer.getPlayerName() + "'s turn.");
    }

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

    public void buyHouse(Player player, Property property){
        //String
    }

    public ArrayList<Player> getPlayers(){
        return players;
    }
}