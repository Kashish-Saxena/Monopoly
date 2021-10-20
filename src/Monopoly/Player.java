package Monopoly;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Player {
    private String playerName;
    public HashMap<Player, ArrayList<Property>> ownedProperties;
    public int money;
    public int currentPosition;

    public Player(String playerName, int money, int currentPosition){
        this.playerName = playerName;
        this.money = money;
        this.currentPosition = currentPosition;
        ownedProperties = new HashMap<>();
    }

    public String getPlayerName() {
        return playerName;
    }

    public HashMap<Player, ArrayList<Property>> getOwnedProperties() {
        return this.ownedProperties;

    }

    public int getMoney() {
        return money;
    }

    private void buyProperty(Player player,Property property){
        ArrayList<Property> properties = ownedProperties.get(player);
        if(properties == null){
            properties = new ArrayList<Property>();
            ownedProperties.put(player,properties);
        }else{
            if(!properties.contains(property)) properties.add(property);
        }

    }
    private void updateCurrentPosition(int amount){
        currentPosition += amount;
    }


    @Override
    public String toString(){
        return "Player name: " + playerName + "\nOwned Properties: " + ownedProperties + "\nMoney in the bank: " + money + "\nCurrent Position: " + currentPosition;
    }

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
