/**
 * Monopoly.Player class creates a player for the game
 * @author: Sahil Agrawal
 * @version: October 24 2020
 */
package Monopoly;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Player implements Serializable {
    private String playerName;
    private ArrayList<Property> properties = new ArrayList<Property>();
    public int money;
    public int currentPosition;
    private int diceResult;
    private boolean inJail = false;

    /**
     * Constructor for the player
     *
     * @param playerName Player name
     */
    public Player(String playerName){
        this.playerName = playerName;
        this.money = 1500;
        this.currentPosition = 0;

    }

    /**
     * Returns the name of the player
     * @return String of the player name
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Returns the properties owned by a player
     * @return properties owned by a player
     */
    public ArrayList<Property> getProperties() {
        return this.properties;

    }

    public String getPropertyNames(){
        String test = "";
        for(Property p:properties){
            test+=p.getName()+", \n";
        }

        return test;
    }

    /**
     * Returns how much money a player has
     * @return int of players money
     */
    public int getMoney() {
        return money;
    }

    public void setMoney(int money){
        this.money = money;
    }

    /**
     * Adds a property to a player if they decide to buy it
     * @param property the property they want to buy
     */
    public void buyProperty(Property property) {
            properties.add(property);
    }

    /**
     * Returns the dice result of the player
     */
    public int getDiceResults(){
        return diceResult;
    }


    /**
     * returns the jail time state of the player
     * @return boolean value of if player is in jail or not.
     */
    public boolean getJail() {
        return inJail;
    }

    /**
     * Sets jail state of player (in jail if true, not in jail if false)
     * @param bool value of jail state
     */
    public void setJail(boolean bool) {
        inJail = bool;
    }
    /**
     * Updates the players position
     * @param amount how many spaces the player moves
     */
    void updateCurrentPosition(int amount){
        currentPosition += amount;
    }

    /**
     * The String representation of Monopoly.Player
     * @return String representation of Monopoly.Player
     */
    public String getPlayerState(){
        return "Player name: " + playerName + "\nOwned Properties: \n" + getProperties().toString().replace("[", "").replace("]", "") + "\nMoney in the bank: " + money + "\nCurrent Position: " + currentPosition;
    }
    public int getCurrentPosition(){
        return currentPosition;
    }




    /**
     * Compares all the values of the players
     * @param o the object that is being compared with
     * @return boolean that will return the result of the comparison
     */
    @Override
    public boolean equals(Object o){
        if(this == o)return true;
        Player player = (Player) o;
        return Objects.equals(playerName,player.playerName) &&
                Objects.equals(properties,player.properties) &&
                Objects.equals(money,player.money) &&
                Objects.equals(currentPosition,player.currentPosition);
    }


}
