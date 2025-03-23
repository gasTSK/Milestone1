package engine.board;

import java.util.ArrayList;
import java.util.Random;

import engine.GameManager;
import model.Colour;

public class Board implements BoardManager {
    private final GameManager gameManager;
    private final ArrayList<Cell> track;
    private final ArrayList<SafeZone> safeZones;
    private int splitDistance ;
    private final int TRACK_SIZE = 100;
    
    public Board(ArrayList<Colour> colourOrder, GameManager gameManager) {
        this.gameManager = gameManager;
        this.track = new ArrayList<>();
        this.safeZones = new ArrayList<>();
        this.splitDistance = 3;
        initializeTrack(colourOrder);
        assignTrapCell();
        createSafeZones(colourOrder);
        
    }

    private void initializeTrack(ArrayList<Colour> colourOrder) {
        for (int i = 0; i < TRACK_SIZE; i++) { 
            if (i == 25 || i == 50 || i == 75 || i == 0) {
                track.add(new Cell(CellType.BASE));
            } else if (i == 98 || i == 23 || i == 48 || i == 73) {
                track.add(new Cell(CellType.ENTRY));
            } else {
                track.add(new Cell(CellType.NORMAL));
            }
        }
    }



    private void assignTrapCell() {
        Random rand = new Random();
        int trapsAssigned = 0;
        while (trapsAssigned < 8) {
            int index = rand.nextInt(track.size());
            if (track.get(index).getCellType() == CellType.NORMAL && !track.get(index).isTrap()) {
                track.get(index).setTrap(true);
                trapsAssigned++;
            }
        }
    }

    private void createSafeZones(ArrayList<Colour> colourOrder) {
        for (Colour colour : colourOrder) {
            safeZones.add(new SafeZone(colour));
        }
    }

    public ArrayList<Cell> getTrack() {
        return track;
    }

    public ArrayList<SafeZone> getSafeZones() {
        return safeZones;
    }

    public int getSplitDistance() {
        return splitDistance;
    }

    public void setSplitDistance(int splitDistance) {
        this.splitDistance = splitDistance;
    }

	public GameManager getGameManager() {
		return gameManager;
	}
}
