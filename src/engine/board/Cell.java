package engine.board;

import model.player.Marble;
public class Cell {
private Marble marble;
private CellType cellType;
private boolean trap;

public Cell(CellType cellType) {
    this.cellType = cellType;
    this.marble = null;
    this.trap = false;
}

public void setCellType(CellType cellType) {
	this.cellType = cellType;
}

public Marble getMarble() {
    return marble;
}

public CellType getCellType() {
    return cellType;
}

public boolean isTrap() {
    return trap;
}

public void setMarble(Marble marble) {
    this.marble = marble;
}

public void setTrap(boolean trap) {
    this.trap = trap;
}
}

