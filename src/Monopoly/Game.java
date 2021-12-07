package Monopoly;


import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Game implements Serializable {

    ArrayList<Property> propertyList;
    private ArrayList<Integer> dice;
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
     * Returns the current player from the players list
     */
    public Player getCurrentPlayer(){
        return players.get(currentPlayerIndex);
    }

    public void setCurrentPlayer(int playerIndex) {
        currentPlayer = players.get(playerIndex);
        currentPlayerIndex = playerIndex;
    }

    int[] rollDice() {
        int[] dices = new int[2];
        int dice1 = ThreadLocalRandom.current().nextInt(1, 7);
        int dice2 = ThreadLocalRandom.current().nextInt(1, 7);
        dices[0] = dice1;
        dices[1] = dice2;
        return dices;

    }

    public ArrayList<Property> getPropertyList() {
        return propertyList;
    }


    public void passTurn() {
        currentPlayerIndex++;
        if (currentPlayerIndex >= totalPlayers) {
            currentPlayerIndex = 0;
        }
        this.setCurrentPlayer(currentPlayerIndex);
        currentTurn++;
        System.out.println("Turn " + currentTurn + ". It is "+ currentPlayer.getPlayerName() + "'s turn.");
    }

    public void goBankrupt(Player player) {
        for (int i = 0; i < player.getProperties().size(); i++) {
            player.getProperties().get(i).removeOwner();
            players.remove(player);
            totalPlayers--;
        }
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

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public int getDoubleCount() {
        return doubleCount;
    }

    public void setDoubleCount(int count) {
        doubleCount = count;
    }
}