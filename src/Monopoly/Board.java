package Monopoly;
import java.util.*;
public class Board {
    ArrayList<Square> squares = new ArrayList<Square>(40);
    int currentTurn = 0;
	int totalPlayer = 0;
	Player[] players;

    public Board(int totalPlayer) {
		players = new Player[totalPlayer];
		this.totalPlayer = totalPlayer;
		for(int i = 0;i < players.length;i++){
			//players[i] = new Player(i, "Player " + (i + 1));
		}
    }
}
