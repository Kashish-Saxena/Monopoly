package Monopoly;

import java.util.*;

public class MonopolyEvent extends EventObject {

    //Game.Status status;

    public MonopolyEvent(Game game) {
        super(game);

        //this.status = status;
    }
}
