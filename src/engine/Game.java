package engine;

import engine.board.Board;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import model.Colour;
import model.card.Card;
import model.card.Deck;
import model.player.CPU;
import model.player.Player;

public class Game implements GameManager {
    private final Board board;
    private final ArrayList<Player> players;
    public ArrayList<Player> getPlayers() {
		return players;
	}

	private final ArrayList<Card> firePit;
    private int currentPlayerIndex;
    private int turn;

    public Game(String playerName) throws IOException {
        ArrayList<Colour> colourOrder = getShuffledColours();
        this.board = new Board(colourOrder, this);
        this.players = new ArrayList<>();
        this.firePit = new ArrayList<>();
        this.turn=0;

        players.add(new Player(playerName, colourOrder.get(0)));
        
        for (int i = 1; i < 4; i++) {
            players.add(new CPU("CPU " + i, colourOrder.get(i), board));
        }

        Deck.loadCardPool(board, this);

        for (Player player : players) {
            player.setHand(Deck.drawCards());
        }
    }

    private ArrayList<Colour> getShuffledColours() {
        ArrayList<Colour> colourOrder = new ArrayList<>();
        Collections.addAll(colourOrder, Colour.values());
        Collections.shuffle(colourOrder);
        return colourOrder;
    }

	public ArrayList<Card> getFirePit() {
		return firePit;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

public Board getBoard() {
    return board;
}
}