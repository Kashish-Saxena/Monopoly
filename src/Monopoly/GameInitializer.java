package Monopoly;

import javax.swing.*;
import java.io.Serializable;
import java.util.EventObject;

public class GameInitializer {
    private Game game;

    public GameInitializer(Game game) {
        this.game = game;
    }

    public void handleSetup() {
        String str = "";
        while (!(game.getTotalPlayers() >= game.getMinPlayers() && game.getTotalPlayers() <= game.getMaxPlayers())) {
            try {
                str = JOptionPane.showInputDialog("Enter Number of Players (2-6):");
                if (str != null) { //cannot cancel a player number choice
                    game.setTotalPlayers(Integer.parseInt(str));
                }
            } catch (NumberFormatException excp) {
                game.setTotalPlayers(0);
            }
        }

        String name = "";
        int isAI = 0;
        for (int i = 0; i < game.getTotalPlayers(); i++) {
            name = "";
            while (name == null || name.equals("")) {
                name = JOptionPane.showInputDialog("Enter Player " + (i + 1) + "'s name:");
            }

            isAI = JOptionPane.showConfirmDialog(null, "Is " + name + " an AI?");
            //0 corresponds to yes button, 1 corresponds to no button
            if (isAI == 0) {
                Player player = new AIPlayer(name + " (AI)");
                game.addPlayer(player);
            } else {
                Player player = new Player(name);
                game.addPlayer(player);
            }
        }
    }

}
