import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;


public class Player {

	//Deck deck;
	//Board board;

	public Player() {
		//this.deck = new Deck();
		//this.board = new Board();
		//board.setCards(deck.dealCards(12));
		//board.showCards();
	}

	public static boolean isSet(Card card1, Card card2, Card card3) {
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

	public static HashMap<Integer, Card> findSet(Board board) {
		ArrayList<Card> cards = board.getCards();
		if (cards == null || cards.size() == 0 ) return null;

		int n = cards.size();
		int count = 0;
		Card card1,card2,card3;

		for (int i=0; i <= n - 3; i++) {
			card1 = cards.get(i);

			for (int j=i+1; j <= n - 2; j++) {
				card2 = cards.get(j);

				for (int k=j+1; k <= n - 1; k++) {
					card3 = cards.get(k);
					count ++;

					if (isSet(card1,card2,card3)) {
						HashMap<Integer, Card> set = new HashMap<Integer,Card>();
						set.put(i, card1);
						set.put(j, card2);
						set.put(k, card3);


						cards.remove(k);
						cards.remove(j);
						cards.remove(i);

						return set;
					}
				}
			}
		}
		System.out.println(count);
		return null;
	}

	public static ArrayList<ArrayList<Card> > completeGame() {
		ArrayList<ArrayList<Card>> sets = new ArrayList<ArrayList<Card>>();
		HashMap<Integer, Card> setMap = new HashMap<Integer, Card>();
		ArrayList<Card> set = new ArrayList<Card>();
		Deck deck = new Deck();
		Board board = new Board();
		board.setCards(deck.dealCards(12)); // deal 12 cards from deck to board
		
		while(true) {
			setMap = findSet(board);
			if (board.isEmpty() || setMap == null) {
				if (deck.isEmpty()) {
					return sets;
				} else {
					board.addCards(deck.deal());
				}
			} else {

			//for (int key: setMap.keySet()) {
				//board.getCards().remove(key);
			//}
			set = toList(setMap);
			Test.showCards(set);
			sets.add(set);
			}

		}

	}





private static ArrayList<Card> toList(HashMap<Integer, Card> cards) {
	if (cards == null) return null;
	ArrayList<Card> cardList = new ArrayList<Card>();
	for (Card card: cards.values()) {
		cardList.add(card);
	}
	return cardList;
}
}
