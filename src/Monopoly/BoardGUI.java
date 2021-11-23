package Monopoly;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Box;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
/*
 * a class to represent the board gui for the Monopoly game
 */

public class BoardGUI extends JPanel {
    private int[][] boardPosition;
	JLabel[] players; 
	JTextArea[] properties;
	int numPlayers;
    int numProperties;
    int numSpaces;
    int numRailroads;
    int numUtilities;
    JLabel[] spaces = new JLabel[40];

    private String[] playerIcon = {"src\\Monopoly\\Players_Icons\\playerOne.jpg", "src\\Monopoly\\Players_Icons\\playerTwo.jpg", "src\\Monopoly\\Players_Icons\\playerThree.jpg", "src\\Monopoly\\Players_Icons\\playerFour.jpg", "src\\Monopoly\\Players_Icons\\playerFive.jpg", "src\\Monopoly\\Players_Icons\\playerSix.jpg"} ;

    public BoardGUI(int numPlayers, int numProperties, int numSpaces){
        this.numPlayers = numPlayers;
        this.numProperties = numProperties;
        this.numSpaces = 40;

        this.setSize(1000, 1000);
        this.setLayout(null);
        
        for(int i = 0; i < numPlayers; i++){
            players[i] = new JLabel();
            players[i].setIcon(new ImageIcon(playerIcon[i]));
            players[i].setBounds(0, 0, 50, 50);
            this.add(players[i]);
        }

        for(int i = 0; i < numProperties; i++){
            properties[i] = new JTextArea();
            properties[i].setBounds(0, 0, 50, 50);
            this.add(properties[i]);
        }

        for(int i = 0; i < numSpaces; i++){
            boardPosition[i][0] = 0;
            boardPosition[i][1] = 0;
        }

        Box horizontalBox = Box.createHorizontalBox();
        horizontalBox.setBounds(0, 0, 1000, 1000);
        this.add(horizontalBox);

        Box verticalBox = Box.createVerticalBox();
        verticalBox.setBounds(0, 0, 1000, 1000);
        this.add(verticalBox);

        
        for(int i = 0; i < 40; i++){
            spaces[i] = new JLabel();
            spaces[i].setBounds(0, 0, 50, 50);
            spaces[i].setBorder(new LineBorder(Color.BLACK));
            spaces[i].setBackground(Color.WHITE);
            spaces[i].setOpaque(true);
            spaces[i].setText(Integer.toString(i));
            verticalBox.add(spaces[i]);
        }

        //method to add colors to the different squares based on the properties
        public void addColors(){
            for(int i = 0; i < 40; i++){
                if(boardPosition[i][0] == 1){
                    spaces[i].setBackground(Color.RED);
                }
                else if(boardPosition[i][0] == 2){
                    spaces[i].setBackground(Color.GREEN);
                }
                else if(boardPosition[i][0] == 3){
                    spaces[i].setBackground(Color.BLUE);
                }
                else if(boardPosition[i][0] == 4){
                    spaces[i].setBackground(Color.YELLOW);
                }
                else if(boardPosition[i][0] == 5){
                    spaces[i].setBackground(Color.ORANGE);
                }
                else if(boardPosition[i][0] == 6){
                    spaces[i].setBackground(Color.PINK);
                }
                else if(boardPosition[i][0] == 7){
                    spaces[i].setBackground(Color.CYAN);
                }
                else if(boardPosition[i][0] == 8){
                    spaces[i].setBackground(Color.MAGENTA);
                }
                else if(boardPosition[i][0] == 9){
                    spaces[i].setBackground(Color.GRAY);
                }
                else if(boardPosition[i][0] == 10){
                    spaces[i].setBackground(Color.WHITE);
                }
            } 
    }

        //method to add the names and icons of squares
        public void addNames(){
            for(int i = 0; i < 40; i++){
                if(boardPosition[i][1] == 1){
                    spaces[i].setText("Go");
                    spaces[i].setIcon(new ImageIcon("src\\Monopoly\\propertypictures\\0.png"));
                }
                else if(boardPosition[i][1] == 2){
                    spaces[i].setText("Mediterranean Avenue");
                }
                else if(boardPosition[i][1] == 3){
                    spaces[i].setText("Community Chest");
                }
                else if(boardPosition[i][1] == 4){
                    spaces[i].setText("Baltic Avenue");
                }
                else if(boardPosition[i][1] == 5){
                    spaces[i].setText("Income Tax");
                }
                else if(boardPosition[i][1] == 6){
                    spaces[i].setText("Reading Railroad");
                }
                else if(boardPosition[i][1] == 7){
                    spaces[i].setText("Oriental Avenue");
                }
                else if(boardPosition[i][1] == 8){
                    spaces[i].setText("Chance");
                }
                else if(boardPosition[i][1] == 9){
                    spaces[i].setText("Vermont Avenue");
                }
                else if(boardPosition[i][1] == 10){
                    spaces[i].setText("Connecticut Avenue");
                }
                else if(boardPosition[i][1] == 11){
                    spaces[i].setText("Jail");
                }
                else if(boardPosition[i][1] == 12){
                    spaces[i].setText("St. Charles Place");
                }
                else if(boardPosition[i][1] == 13){
                    spaces[i].setText("Electric Company");
                }
                else if(boardPosition[i][1] == 14){
                    spaces[i].setText("States Avenue");
                }
                else if(boardPosition[i][1] == 15){
                    spaces[i].setText("Virginia Avenue");
                }
                else if(boardPosition[i][1] == 16){
                    spaces[i].setText("Pennsylvania Railroad");
                }
                else if(boardPosition[i][1] == 17){
                    spaces[i].setText("St. James Place");
                }
                else if(boardPosition[i][1] == 18){
                    spaces[i].setText("Community Chest");
                }
                else if(boardPosition[i][1] == 19){
                    spaces[i].setText("Tennessee Avenue");
                }
                else if(boardPosition[i][1] == 20){
                    spaces[i].setText("New York Avenue");
                }
                else if(boardPosition[i][1] == 21){
                    spaces[i].setText("Free Parking");
                else if(boardPosition[i][1] == 22){
                    spaces[i].setText("Kentucky Avenue");
                }
                else if(boardPosition[i][1] == 23){
                    spaces[i].setText("Chance");
                }
                else if(boardPosition[i][1] == 24){
                    spaces[i].setText("Indiana Avenue");
                }
                else if(boardPosition[i][1] == 25){
                    spaces[i].setText("Illinois Avenue");
                }
                else if(boardPosition[i][1] == 26){
                    spaces[i].setText("B & O Railroad");
                }
                else if(boardPosition[i][1] == 27){
                    spaces[i].setText("Atlantic Avenue");
                }
                else if(boardPosition[i][1] == 28){
                    spaces[i].setText("Ventnor Avenue");
                }
                else if(boardPosition[i][1] == 29){
                    spaces[i].setText("Water Works");
                }
                else if(boardPosition[i][1] == 30){
                    spaces[i].setText("Marvin Gardens");
                }
                else if(boardPosition[i][1] == 31){
                    spaces[i].setText("Go To Jail");
                }
                else if(boardPosition[i][1] == 32){
                    spaces[i].setText("Pacific Avenue");
                }
                else if(boardPosition[i][1] == 33){
                    spaces[i].setText("North Carolina Avenue");
                }
                else if(boardPosition[i][1] == 34){
                    spaces[i].setText("Community Chest");
                }
                else if(boardPosition[i][1] == 35){
                    spaces[i].setText("Pennsylvania Avenue");
                }
                else if(boardPosition[i][1] == 36){
                    spaces[i].setText("Short Line");
                }
                else if(boardPosition[i][1] == 37){
                    spaces[i].setText("Chance");
                }
                else if(boardPosition[i][1] == 38){
                    spaces[i].setText("Park Place");
                }
                else if(boardPosition[i][1] == 39){
                    spaces[i].setText("Luxury Tax");
                }
                else if(boardPosition[i][1] == 40){
                    spaces[i].setText("Boardwalk");
                }
            }
        }

            //method to show all the different player icons' current position on the board gui when they move
            public void showPlayerIconPosition(int playerPosition){
                for(int i = 0; i < 40; i++){
                    if(boardPosition[i][0] == playerPosition){
                        spaces[i].setIcon(playerIcon);
                    }
                }
            }
            //method for the player to move to the next square
            public void movePlayer(int playerPosition, int diceRoll){
                for(int i = 0; i < 40; i++){
                    if(boardPosition[i][0] == playerPosition){
                        spaces[i].setIcon(null);
                    }
                }
                playerPosition += diceRoll;
                if(playerPosition > 40){
                    playerPosition -= 40;
                }
                for(int i = 0; i < 40; i++){
                    if(boardPosition[i][0] == playerPosition){
                        spaces[i].setIcon(playerIcon);
                    }
                }
            }
        }





