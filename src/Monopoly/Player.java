/**
 * Monopoly.Player class creates a player for the game
 * @author: Sahil Agrawal
 * @version: October 24 2020
 */
package Monopoly;
import java.util.ArrayList;
import java.util.Objects;

public class Player {
    private String playerName;
    private ArrayList<Property> properties = new ArrayList<Property>();
    public int money;
    public int currentPosition;
    private int diceResult;

    /**
     * Constructor for the player
     *
     * @param playerName PLayer name
     */
    public Player(String playerName){
        this.playerName = playerName;
        this.money = 1000;
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
        /*
        if(properties == null){
            properties = new ArrayList<Property>();
            ownedProperties.put(player,properties);
        }else{
            if(!properties.contains(property)) properties.add(property);
        }
         */
        if (!properties.contains(property)) { properties.add(property); }

        else { System.out.println("You already own this property."); }
    }

    /**
     * Returns the dice result of the player
     */
    public int getDiceResults(){
        return diceResult;
    }

    /**
     * Returns the dice result of the player
     */
    public void setDiceResults(int result){
        diceResult = result;
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
    @Override
    public String toString(){
        return "Player name: " + playerName + "\nOwned Properties: " + getProperties().toString() + "\nMoney in the bank: " + money + "\nCurrent Position: " + currentPosition;
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
