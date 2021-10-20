package Monopoly;
import java.util.ArrayList;
import java.util.HashMap;

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

    private void buyProperty(Property property){
        money -= getPurchasingCost();

    }
}
