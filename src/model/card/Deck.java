package model.card;

import java.io.*;
import java.util.*;

import engine.GameManager;
import engine.board.BoardManager;
import model.card.standard.Ace;
import model.card.standard.Five;
import model.card.standard.Four;
import model.card.standard.Jack;
import model.card.standard.King;
import model.card.standard.Queen;
import model.card.standard.Seven;
import model.card.standard.Standard;
import model.card.standard.Suit;
import model.card.standard.Ten;
import model.card.wild.Burner;
import model.card.wild.Saver;

public class Deck {
    private static final String CARDS_FILE = "Cards.csv";
    private static ArrayList<Card> cardsPool;

    public static void loadCardPool(BoardManager boardManager, GameManager gameManager) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(CARDS_FILE));
        String line;
        cardsPool = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            String code = data[0];
            int frequency = Integer.parseInt(data[1]);
            String name = data[2];
            String description = data[3];
            Suit suit = null;
            int rank = -1;
            
           if(!code.equals("14")&&!code.equals("15")) {
                rank = Integer.parseInt(data[4]); 
                suit = Suit.valueOf(data[5]);
                }
           
           
           
            Card card = null;
            switch (code) {
        	case "0":card= new Standard(name, description, rank, suit, boardManager, gameManager);break;
            case "1": card= new Ace(name, description, suit, boardManager, gameManager);break;
            case "4": card= new Four(name, description, suit, boardManager, gameManager);break;
            case "5": card=  new Five(name, description, suit, boardManager, gameManager);break;
            case "7": card= new Seven(name, description, suit, boardManager, gameManager);break;
            case "10":card= new Ten(name, description, suit, boardManager, gameManager);break;
            case "11": card= new Jack(name, description, suit, boardManager, gameManager);break;
            case "12": card= new Queen(name, description, suit, boardManager, gameManager);break;
            case "13": card= new King(name, description, suit, boardManager, gameManager);break;
            case "14":card=  new Burner(name, description, boardManager, gameManager);break;
            case "15": card= new Saver(name, description, boardManager, gameManager);break;
          //  default: throw new IllegalArgumentException("Unknown card code: " + code);
            
        }
            for (int i = 0; i < frequency; i++) {
                cardsPool.add(card);
            }
        }

        reader.close();
    }

//    private static Card createCard(String code, String name, String description, BoardManager boardManager, GameManager gameManager,int rank,Suit suit) {
//    switch (code) {
//    	case "0":return new Standard(name, description, rank, suit, boardManager, gameManager);
//        case "1": return new Ace(name, description, suit, boardManager, gameManager);
//        case "4": return new Four(name, description, suit, boardManager, gameManager);
//        case "5": return new Five(name, description, suit, boardManager, gameManager);
//        case "7": return new Seven(name, description, suit, boardManager, gameManager);
//        case "10": return new Ten(name, description, suit, boardManager, gameManager);
//        case "11": return new Jack(name, description, suit, boardManager, gameManager);
//        case "12": return new Queen(name, description, suit, boardManager, gameManager);
//        case "13": return new King(name, description, suit, boardManager, gameManager);
//        case "14": return new Burner(name, description, boardManager, gameManager);
//        case "15": return new Saver(name, description, boardManager, gameManager);
//        default: throw new IllegalArgumentException("Unknown card code: " + code);
//    }
//}

    public static ArrayList<Card> drawCards() {
        Collections.shuffle(cardsPool);
        ArrayList<Card> drawnCards = new ArrayList<>();

        for (int i = 0; i < 4 && !cardsPool.isEmpty(); i++) {
            drawnCards.add(cardsPool.remove(0));
        }

        return drawnCards;
    }

    public static void printDeck() {
        for (Card card : cardsPool) {
            System.out.println(card);
        }
    }
}