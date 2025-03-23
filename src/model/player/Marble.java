package model.player;

import model.Colour;

//A class representing the Marbles available in the game.
public class Marble {
private final Colour colour;
public Marble(Colour colour) {
	this.colour=colour;
}
public Colour getColour() {
    return colour;
}
}
