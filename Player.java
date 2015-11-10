import java.util.Arrays;


public class Player {
	
	Deck deck;
	Board board;
	
	public Player() {
		this.deck = new Deck();
		this.board = new Board();
		board.setCards(deck.dealCards(12));
		board.showCards();
	}
	
	public boolean isSet(Card card1, Card card2, Card card3) {
		return (isAllSame(card1,card2,card3) || isAllDifferent(card1,card2,card3));
	}

	private boolean isAllSame(Card card1, Card card2, Card card3) {
		// returns true if all 4 attributes of each card are the same and false otherwise
		
		int[] attr1 = card1.getAttributes();
		int[] attr2 = card2.getAttributes();
		int[] attr3 = card3.getAttributes();
		return Arrays.equals(attr1, attr2) && Arrays.equals(attr1, attr3) && Arrays.equals(attr2, attr3);
	}

	private boolean isAllDifferent(Card card1, Card card2, Card card3) {
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
		
	
}
