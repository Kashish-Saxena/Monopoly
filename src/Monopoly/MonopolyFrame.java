package Monopoly;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MonopolyFrame extends JFrame implements MonopolyView {

    private Game game;
    private static ArrayList<JLabel> propertyPictures;
    private BoardGUI boardGUI;

    public MonopolyFrame(Game game) throws IOException {
        super("Monopoly");

        this.game = game;
        propertyPictures = new ArrayList<JLabel>();


        handleInitialSetup();

        boardGUI = new BoardGUI(game.getTotalPlayers());
        JFrame frame = new JFrame("Monopoly");

        frame.setLayout(new BorderLayout());

        //JPanel inputPanel = new JPanel();

        // main window
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        boardGUI = new BoardGUI(game.getTotalPlayers());

        //right panel

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setSize(200, 400);

        //add buttons
        JButton rollButton = new JButton("roll");
        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int diceRoll = game.rollDice();
                //TODO: Add doubles, which would keep rolled to false so the player can roll again.
                Player currentPlayer = game.getCurrentPlayer();

                int startingPos = currentPlayer.currentPosition;
                int endingPos = startingPos + diceRoll;

                if (endingPos > 39) {
                    int placesBefore39 = 39 - startingPos;
                    currentPlayer.currentPosition = (diceRoll - placesBefore39) - 1;
                } else {
                    currentPlayer.currentPosition = startingPos + diceRoll;
                }

                Property currentProperty = game.getPropertyList().get(currentPlayer.currentPosition);
                JOptionPane.showMessageDialog(frame, "You have rolled a " + diceRoll + ".");
                try {
                    propertyPopUp();

                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });

        JButton quitButton = new JButton("quit");


        JPanel frameButtonPanel = new JPanel();
        frameButtonPanel.setSize(200, 100);
        frameButtonPanel.add(rollButton);
        frameButtonPanel.add(quitButton);

        rightPanel.add(frameButtonPanel, BorderLayout.PAGE_END);

        frame.add(boardGUI, BorderLayout.CENTER);
        frame.add(rightPanel, BorderLayout.EAST);

        frame.setSize(1800, 1000);
        frame.setBackground(Color.lightGray);

        frame.setVisible(true);

        game.addView(this);
        game.play();
    }

    private void handleInitialSetup(){
        String str = "";
        String name = "";
        while (!(game.getTotalPlayers() >= game.getMinPlayers() && game.getTotalPlayers() <= game.getMaxPlayers())) {
            try {
                str = JOptionPane.showInputDialog("Enter Number of Players (2-6):");
                if (str != null) {
                    game.setTotalPlayers(Integer.parseInt(str));
                }
            } catch (NumberFormatException exception) {
                game.setTotalPlayers(0);
            }
        }

        for (int i = 0; i < game.getTotalPlayers(); i++) {
            name = "";
            while (name == null || name.equals("")) {
                name = JOptionPane.showInputDialog("Enter Player " + (i + 1) + "'s name:");
            }
            Player player = new Player(name);
            game.addPlayer(player);
        }
    }

    @Override
    public void handleMonopolyUpdate(MonopolyEvent e) {
        handleInitialSetup();
    }



    public void propertyPopUp() throws IOException{
        JFrame frame = new JFrame("Property");
        frame.setSize(500, 500);
        JPanel panel = new JPanel();
        JButton buy = new JButton();
        JButton pass = new JButton();
        buy.setText("BUY");
        pass.setText("Pass Turn");
        panel.setLayout(new BorderLayout());
        propertyPictures = new ArrayList<JLabel>();
        for(int i = 0; i < 40; i++) {
            BufferedImage property1 = ImageIO.read(new File("property pictures/"+i+".png"));
            JLabel label1 = new JLabel(new ImageIcon(property1));
            propertyPictures.add(label1);
        }

        ArrayList<Property> propertyList = game.getPropertyList();
        Player currentPlayer = game.getCurrentPlayer();
        Property currentProperty = propertyList.get(currentPlayer.currentPosition);

        JLabel label = new JLabel("Welcome to " + currentProperty.getName());

        panel.add(label,BorderLayout.PAGE_START);
        panel.add(buy,BorderLayout.LINE_START);


        buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!currentProperty.checkAvailability()) {
                    JPanel warningPanel = new JPanel();
                    JOptionPane.showMessageDialog(warningPanel, "The property is already owned.");
                    buy.setEnabled(false);
                } else {
                    int code = JOptionPane.showConfirmDialog(frame, "Are you sure you would like to buy this property?");
                    if (code == JOptionPane.OK_OPTION) {
                        currentPlayer.buyProperty(currentProperty);
                        currentProperty.setOwner(currentPlayer);
                        int propertyCost = currentProperty.getPurchasingCost();

                        currentPlayer.setMoney(currentPlayer.getMoney() - propertyCost);
                    }
                }
            }
            /*
            if (currentProperty.getColour().equals("none")) {
                    System.out.println("You cannot buy this property.");
                    break;
                } else if (currentProperty.getPurchasingCost() > currentPlayer.getMoney()) {
                    System.out.println("You do not have enough funds to buy this property.");
                } else if (!currentProperty.checkAvailability()) {
                    System.out.println("You cannot buy this property, it belongs to " + currentProperty.getOwner().getPlayerName() + ".");
                } else {
                    System.out.printf("Are you sure you want to buy %s? Y/N\n", currentProperty.getName());
                    Scanner buyScn = new Scanner(System.in);
                    String buyAns = buyScn.nextLine();

                    if (buyAns.equals("Y")) {


                        break;
                    } else if (buyAns.equals("N")) {
                        break;
                    } else {
                        System.out.println("Unknown answer, please try the command again.");
                        break;
                    }
                }
             */
        });
        panel.add(pass,BorderLayout.AFTER_LAST_LINE);
        pass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
        frame.add(panel);
        frame.add(propertyPictures.get(currentPlayer.currentPosition),BorderLayout.PAGE_END);


        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        Game game = new Game();
        MonopolyFrame mainFrame = new MonopolyFrame(game);
    }
}