package Monopoly;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class Game implements Serializable {

    MonopolyFrame mf = new MonopolyFrame(this);
    ArrayList<Property> propertyList;
    private ArrayList<Player> players;
    private Player currentPlayer;
    private int currentPlayerIndex;
    private int currentTurn = 1;
	private int totalPlayers = 0;
    private int min_players = 2;
    private int max_players = 6;
    private int doubleCount;

    private ArrayList<MonopolyView> views;


    /**
     * Create the game and initialise its internal map.
     */
    public Game() throws IOException {
        Board board = new Board();
        propertyList = board.getBoard();
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

    public void processRoll() {
        Player currentPlayer = this.getCurrentPlayer();
        int[] dices = this.rollDice();
        int diceRoll = dices[0] + dices[1];
        //if player in jail
        if (currentPlayer.getJail()) {
            currentPlayer.setJailTurn(currentPlayer.getJailTurn() + 1);

            Object[] options = {"Pay $50", "Roll"};

            int input = JOptionPane.showOptionDialog(new JFrame(), "You may pay $50 to get out. " +
                            "Also, you may roll once per turn until you find doubles," +
                            " however after three turns you must pay the $50 fine. \n You are at turn " + currentPlayer.getJailTurn() + ".", "You are in jail!",
                    JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);

            //if player agrees to pay the 50$ fine
            if (input == JOptionPane.YES_OPTION) {
                if (currentPlayer.getMoney() < 50) {
                    JOptionPane.showMessageDialog(new JFrame(), "You do not have enough money to pay the fine.");
                    input = JOptionPane.NO_OPTION;
                } else {
                    currentPlayer.setMoney(currentPlayer.getMoney() - 50);
                    JOptionPane.showMessageDialog(new JFrame(), "You are out of jail!");
                    currentPlayer.setJailTurn(0);
                    currentPlayer.setJail(false);
                }
            }

            //if player does not pay the fine or does not have enough money to pay for it
            if (input == JOptionPane.NO_OPTION) {


                //if doubles
                if (dices[0] == dices[1]) {
                    JOptionPane.showMessageDialog(new JFrame(), "You have rolled " + dices[0] + " and " + dices[1] + ". You are out of jail!");
                    currentPlayer.setJail(false);
                    this.move(diceRoll);

                //if not doubles
                } else {

                    //if player does not have enough money to pay for it, and it has been three turns
                    if (currentPlayer.getMoney() < 50 && currentPlayer.getJailTurn() == 3) {
                        JOptionPane.showMessageDialog(new JFrame(), "You have rolled " + dices[0] + " and " + dices[1] + ".\nYou do not have sufficient funds to pay for the fine.\nYou have gone bankrupt and lost the game!");
                        this.goBankrupt(currentPlayer);
                        this.passTurn();
                    }
                    else if (currentPlayer.getMoney() >= 50 && currentPlayer.getJailTurn() == 3) {
                        JOptionPane.showMessageDialog(new JFrame(), "You have rolled " + dices[0] + " and " + dices[1] + ".\nYou have automatically paid the $50 fine.\nYou are out of jail!");
                        currentPlayer.setJail(false);
                        this.move(diceRoll);
                    }

                    //if player has enough money to pay for it, and it has been three turns
                    else {
                        JOptionPane.showMessageDialog(new JFrame(), "You have rolled " + dices[0] + " and " + dices[1] + ".\nYou are not out of jail. Passing your turn.");
                        this.passTurn();
                        /*
                        JLabel info = new JLabel("Current Player: "+ this.getCurrentPlayer().getPlayerName());
                        JLabel money = new JLabel("This player has "+ this.getCurrentPlayer().getMoney()+" dollars!");
                        JLabel more = new JLabel("This player owns: "+ this.getCurrentPlayer().getProperties());
                        startingInfo.removeAll();
                        startingInfo.add(info);
                        startingInfo.add(money);
                        startingInfo.add(more, BorderLayout.EAST);
                        startingInfo.revalidate();
                        startingInfo.repaint();
                        SwingUtilities.updateComponentTreeUI(frame);*/
                    }
                }
            }

        //if player not in jail
        } else if (!currentPlayer.getJail()) {
            boolean doubles = false;


            //if not doubles
            if (!(dices[0] == dices[1])) {
                mf.rollButton.setEnabled(false);
            //if doubles
            } else {
                doubles = true;
                mf.rollButton.setEnabled(true);
            }

            //if rolled two doubles before this double
            if (doubleCount == 2 && doubles) {
                doubleCount = 0;
                JOptionPane.showMessageDialog(new JFrame(), "You have rolled three doubles in a row. You are going to jail for speeding.");
                currentPlayer.currentPosition = 10;
                currentPlayer.setJail(true);

            //if not double OR if player didn't roll 2 doubles before this double
            } else {

                //if double
                if (doubles) {
                    JOptionPane.showMessageDialog(mf.frame, "You have rolled " + dices[0] + " and " + dices[1] + " (" + diceRoll + "). They are doubles! You may roll again.");
                    doubleCount++;

                //if not double
                } else {
                    JOptionPane.showMessageDialog(mf.frame, "You have rolled " + dices[0] + " and " + dices[1] + " (" + diceRoll + ").");
                    doubleCount = 0;
                }

                this.move(diceRoll);
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

    public void move(int diceRoll) {
        //move player to new position
        int startingPos = currentPlayer.currentPosition;
        int endingPos = startingPos + diceRoll;

        //if player reaches the last tile (before looping back)
        if (endingPos > 39) {
            int placesBefore39 = 39 - startingPos;
            currentPlayer.currentPosition = (diceRoll - placesBefore39) - 1;
            JOptionPane.showMessageDialog(new JFrame(), "You passed on GO! You have received $200");
            currentPlayer.setMoney(currentPlayer.getMoney() + 200);

            //if player doesn't reach last tile
        } else {
            currentPlayer.currentPosition = startingPos + diceRoll;
        }

        //if player lands on go to jail tile
        if (currentPlayer.currentPosition == 30) {
            JOptionPane.showMessageDialog(new JFrame(), "You landed on the go to jail square! You are going to jail.");
            currentPlayer.currentPosition = 10;
            currentPlayer.setJail(true);

            //if player lands on anything else
        } else {
            try {
                mf.propertyPopUp();

            } catch (IOException ex) {
                ex.printStackTrace();
            }

            //Property currentProperty = game.getPropertyList().get(currentPlayer.currentPosition);
        }
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

    private void goBankrupt(Player player) {
        for (int i = 0; i < player.getProperties().size(); i++) {
            player.getProperties().get(i).removeOwner();
            players.remove(player);
            totalPlayers--;
        }
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

    public void buyHouse(Player player, Property property){
        //String
    }

    /**
     * saves/serializes this Game object.
     */
    public void serializeGame (String filename){
        try {
            FileOutputStream fileOut = new FileOutputStream("src/Monopoly/saves/" + filename + ".ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * loads/deserializes Game object.
     */
    public static Game deserializeGame(String filepath) {
        try {
            FileInputStream fileIn = new FileInputStream("src/Monopoly/saves/" +filepath+ ".ser");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Game game = (Game) objectIn.readObject();
            objectIn.close();
            return game;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;

        }
    }

}