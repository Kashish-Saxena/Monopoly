package Monopoly;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MonopolyController implements ActionListener {


    private Game game;

    public MonopolyController(Game game) { this.game = game; }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("pass")){
            game.passTurn();
        }

        else if (e.getActionCommand().equals("buyproperty")){

            //game.buyProperty();
        }

        else if (e.getActionCommand().equals("roll")){
            //game.rollDice();
        }
    }
}
