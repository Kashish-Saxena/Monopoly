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
    private boolean inJail = false;
    private int JailTurn = 0;

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

    public int getJailTurn() { return JailTurn; }

    public void setJailTurn(int turn) { JailTurn = turn; }

    public int getCurrentPosition(){
        return currentPosition;
    }

    /**
     * Returns if the player is AI
     * @return false
     */
    public boolean isAI(){
        return false;
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
