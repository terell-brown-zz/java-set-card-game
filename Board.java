import java.util.LinkedList;
import java.util.List;


public class Board {
	
	private LinkedList<Card> cards;
	private int numCards;
	
	public Board() {
		
	}

	public LinkedList<Card> getCards() {
		return cards;
	}

	public void setCards(LinkedList<Card> cards) {
		this.cards = cards;
	}

	public int getNumCards() {
		return numCards;
	}

	public void setNumCards(int numCards) {
		this.numCards = numCards;
	}
	
	public void addCards(List<Card> cards) {
		if (cards.isEmpty()) { 
			return;
		} else {
		this.cards.addAll(cards);
		}
	}
	
	public void showCards() {
		if (cards == null) {
			System.out.println("There are no cards on the board");
			return;
		} 
		
		System.out.println("Cards on the board include: ");
		for (Card card: cards) {
			System.out.println("[" + card.getColor() + "," + card.getShape() + "," + card.getShading() + "," + card.getNumber() + "]"  );
		}
	}
	


}