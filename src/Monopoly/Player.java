/**
 * Monopoly.Player class creates a player for the game
 * @author: Sahil Agrawal
 * @version: October 21 2020
 */
package Monopoly;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Player {
    private String playerName;
    public HashMap<Player, ArrayList<Property>> ownedProperties;
    public int money;
    public int currentPosition;

    /**
     * Constructor for the player
     *
     * @param playerName PLayer name
     */
    public Player(String playerName){
        this.playerName = playerName;
        this.money = 1000;
        this.currentPosition = 0;
        ownedProperties = new HashMap<>();
    }

    /**
     * Returns the name of the player
     * @return Syring of the player name
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Returns the properties owned by a player
     * @return properties owned by a player
     */
    public HashMap<Player, ArrayList<Property>> getOwnedProperties() {
        return this.ownedProperties;

    }

    /**
     * Returns how much money a player has
     * @return int of players money
     */
    public int getMoney() {
        return money;
    }

    /**
     * Adds a property to a player if they decide to buy it
     * @param player the player that wants to buy
     * @param property the property they want to buy
     */
    private void buyProperty(Player player,Property property){
        ArrayList<Property> properties = ownedProperties.get(player);
        if(properties == null){
            properties = new ArrayList<Property>();
            ownedProperties.put(player,properties);
        }else{
            if(!properties.contains(property)) properties.add(property);
        }

    }

    /**
     * Updates the players position
     * @param amount how many spaces the player moves
     */
    private void updateCurrentPosition(int amount){
        currentPosition += amount;
    }

    /**
     * The String representation of Monopoly.Player
     * @return String representation of Monopoly.Player
     */
    @Override
    public String toString(){
        return "Player name: " + playerName + "\nOwned Properties: " + getOwnedProperties().toString() + "\nMoney in the bank: " + money + "\nCurrent Position: " + currentPosition;
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
                Objects.equals(ownedProperties,player.ownedProperties) &&
                Objects.equals(money,player.money) &&
                Objects.equals(currentPosition,player.currentPosition);
    }
}
