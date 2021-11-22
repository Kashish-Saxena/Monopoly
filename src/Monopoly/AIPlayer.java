package Monopoly;
import java.util.ArrayList;
import java.util.Objects;
/**
     * creating an artificial intelligence player for the game of monopoly
     * that is able to play against the human player and the user is able to create as many ai players as they want
     * @author Pareena Sumbli November 2021
     */
public class AIPlayer extends Player {

     public AIPlayer(String playerName) {
          super(playerName);
     }

     /**
	 * Function that mimics the movement of the player
	 */
     public void playTurn(Game game, ArrayList<Player> players, int currentPlayerIndex) {
          int diceRoll = game.rollDice();
          int currentPlayerPosition = players.get(currentPlayerIndex).currentPosition;
          int newPosition = currentPlayerPosition + diceRoll;
          players.get(currentPlayerIndex).updateCurrentPosition(newPosition);
     }

     /**
      * Function that determines if the ai player buys the property based on if there is a current owner and if they have enough money.
     */
    public void buyProperty(Game game, ArrayList<Player> players, int currentPlayerIndex) {
          int currentPlayerPosition = players.get(currentPlayerIndex).currentPosition;
          int propertyIndex = game.getPropertyIndex(currentPlayerPosition);
          Property property = game.getProperty(propertyIndex);
          if (property.getOwner() == null && players.get(currentPlayerIndex).getMoney() >= property.getPrice()) {
               property.setOwner(players.get(currentPlayerIndex));
               players.get(currentPlayerIndex).updateMoney(property.getPrice());
          }
     }

     /**
      * Function that determines if the ai player pays rent to the owner of the property
     */
     public void payRent(Property property, ArrayList<Player> players, int currentPlayerIndex) {
          int currentPlayerPosition = players.get(currentPlayerIndex).currentPosition;
          int propertyIndex = property.position;
          if (property.getOwner() != null && property.getOwner() != players.get(currentPlayerIndex)) {
               int rent = property.getRentCost();
               players.get(currentPlayerIndex).setMoney(money - rent);
               property.getOwner().setMoney(property.getOwner().getMoney()+ rent); 
          }
     }

}