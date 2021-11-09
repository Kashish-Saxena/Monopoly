package Monopoly;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MonopolyFrame extends JFrame implements MonopolyView {

    private Game game;

    public MonopolyFrame(Game game) throws IOException {
        super("Monopoly");

        this.game = game;




        JFrame frame = new JFrame("Monopoly");
        JPanel panel = new JPanel();

        frame.setLayout(new BorderLayout());



        panel.setSize(900, 50);
        panel.setBackground(Color.lightGray);


        BufferedImage image = ImageIO.read(MonopolyFrame.class.getResourceAsStream("board.jpg"));
        JLabel label = new JLabel(new ImageIcon(image));
        label.setSize(400, 400);
        label.setBackground(Color.lightGray);


        JPanel inputpanel = new JPanel();
        //panel.add();

        // main window
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add the JPanel to the main window
        frame.add(panel, BorderLayout.PAGE_START);
        frame.add(label, BorderLayout.CENTER);
        frame.setSize(1800, 1000);
        frame.setBackground(Color.lightGray);



        frame.setVisible(true);

        game.addView(this);
    }

    private void handleInitialSetup(MonopolyEvent e){
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
        game.play();
    }

    @Override
    public void handleMonopolyUpdate(MonopolyEvent e) {
        handleInitialSetup(e);
    }

    public static void main(String[] args) throws IOException {
        Game game = new Game();
        MonopolyFrame mainFrame = new MonopolyFrame(game);
    }
}