    package Monopoly;

    /**
         * creating an artificial intelligence player for the game of monopoly
         * that is able to play against the human player and the user is able to create as many ai players as they want
         * @author Pareena Sumbli November 2021
         */
    public class AIPlayer extends Player {

        private boolean bought = false;

        public AIPlayer(String playerName) {
              super(playerName);
         }

         public void buyProperty(Game game, Property property, int currentPlayerIndex) {
             if (property.checkAvailability() == true && this.getMoney() >= property.getPurchasingCost() && !property.getColour().equals("none")){
                 property.setOwner(this);
                 this.getProperties().add(property);
                 this.setMoney(this.getMoney() - property.getPurchasingCost());
                 bought = true;
             }
             else{
                 bought = false;
             }
         }

        /**
         * return if player bought the property it landed on
         * @return status of bought
         */
        public boolean bought(){
             return bought;
         }

        /**
         * Returns if the player is AI
         * @return true
         */
        public boolean isAI(){
             return true;
         }

    }