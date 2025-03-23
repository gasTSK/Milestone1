package model.player;

import java.util.ArrayList;
import model.card.Card;
import model.Colour;

public class Player {
    private final String name;
    private final Colour colour;
    private ArrayList<Card> hand;
    private final ArrayList<Marble> marbles;
    private Card selectedCard;
    private final ArrayList<Marble> selectedMarbles;

    public Player(String name, Colour colour) {
        this.name = name;
        this.colour = colour;
        this.hand = new ArrayList<>();
        this.marbles = new ArrayList<>();
        this.selectedMarbles = new ArrayList<>();
        this.selectedCard = null;

        for (int i = 0; i < 4; i++) {
            this.marbles.add(new Marble(colour));
        }
    }
    public void drawCards(ArrayList<Card> newCards) {
        hand.addAll(newCards);
    }

    public String getName() {
        return name;
    }

    public Colour getColour() {
        return colour;
    }

    public Card getSelectedCard() {
        return selectedCard;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public ArrayList<Marble> getMarbles() {
        return marbles;
	}
	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}
	
}