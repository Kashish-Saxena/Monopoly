package Monopoly;

import javax.swing.*;
import java.io.IOException;

public class MonopolyFrame extends JFrame {

    private Game game;

    public MonopolyFrame(Game game) throws IOException {
        super("Monopoly");

        this.game = game;

        JFrame frame = new JFrame("Monopoly");
        JPanel panel = new JPanel();
        JLabel gametitle = new JLabel("Welcome to Monopoly");
        panel.add(gametitle);
        //BufferedImage image = ImageIO.read(new File("./java.jpg"));
        //JLabel label = new JLabel(new ImageIcon(image));
        //panel.add(label);

        JPanel inputpanel = new JPanel();
        //panel.add();

        // main window
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add the JPanel to the main window
        frame.add(panel);

        frame.pack();
        frame.setVisible(true);
    }

    private void handleGameEvent(MonopolyEvent e){
        String str = "";
        String name = "";
        while (!(game.getTotalPlayers() >= game.getMinPlayers() && game.getTotalPlayers() <= game.getMaxPlayers())) {
            try {
                str = JOptionPane.showInputDialog("Enter Number of Players (2-6):");
                if (str != null) {
                    game.setTotalPlayers(Integer.parseInt(str));
                }
            } catch (NumberFormatException excp) {
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

    public static void main(String[] args) throws IOException {
        Game game = new Game();
        MonopolyFrame mframe = new MonopolyFrame(game);
    }
}