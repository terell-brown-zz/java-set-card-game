import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;


public class Player {
	
	

	public static boolean isSet(Card card1, Card card2, Card card3) {
		// returns true if the three cards make a set and false otherwise
		return (isAllSame(card1,card2,card3) || isAllDifferent(card1,card2,card3));
	}

	private static boolean isAllSame(Card card1, Card card2, Card card3) {
		// returns true if all 4 attributes of each card are the same and false otherwise
		int[] attr1 = card1.getAttributes();
		int[] attr2 = card2.getAttributes();
		int[] attr3 = card3.getAttributes();
		return Arrays.equals(attr1, attr2) && Arrays.equals(attr1, attr3) && Arrays.equals(attr2, attr3);
	}

	private static boolean isAllDifferent(Card card1, Card card2, Card card3) {
		// returns true if no attributes of all 3 cards match
		int[] attr1 = card1.getAttributes();
		int[] attr2 = card2.getAttributes();
		int[] attr3 = card3.getAttributes();

		for (int i =0; i < 4; i++) {
			if (attr1[i] == attr2[i] || attr1[i] == attr3[i] || attr2[i] == attr3[i]) {
				return false;
			}
		}

		return true;
	}

	public static ArrayList<Card> findSet(Board board) {
		// returns 3 cards that make up a set given a board of cards
		// returns null if no sets found on the board
		
		ArrayList<Card> cards = board.getCards();
		int n = cards.size();
		if (cards == null || n == 0 ) return null;
	
		Card card1,card2,card3;

		// loops through every combination of 3 cards
		for (int i=0; i <= n - 3; i++) {
			card1 = cards.get(i);

			for (int j=i+1; j <= n - 2; j++) {
				card2 = cards.get(j);

				for (int k=j+1; k <= n - 1; k++) {
					card3 = cards.get(k);

					if (isSet(card1,card2,card3)) {
						ArrayList<Card> set = new ArrayList<Card>();
						set.add(card1);
						set.add(card2);
						set.add(card3);
						
						// remove set of cards from board
						cards.remove(k);
						cards.remove(j);
						cards.remove(i);

						return set;
					}
				}
			}
		}
		return null;
	}
	
	public static ArrayList<ArrayList<Card>> completeGame() {
		// creates a board and deck of cards, completes a game of Set
		// and returns list of sets
		
		ArrayList<ArrayList<Card>> sets = new ArrayList<ArrayList<Card>>();
		
		// initiate the game
		Deck deck = new Deck();
		Util.showCards(Util.DECK, deck.getCards());
		Board board = new Board();
		board.setCards(deck.dealCards(12)); // deal 12 cards from deck to board
		Util.showCards(Util.BOARD,board.getCards());

		ArrayList<Card> set = new ArrayList<Card>();
		
		// find all the sets!
		while(true) {
			set = findSet(board);
			if (board.isEmpty() || set == null) {
				if (deck.isEmpty()) {
					return sets;
				} else {
					board.addCards(deck.deal());
				}
			} else {
				sets.add(set);
			}
		}
	}

}
