import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Board {
	
	private ArrayList<Card> cards;
	
	public Board() {
		
	}
	
	public int getNumCards() {
		return cards.size();
	}
	public boolean isEmpty() {
		return cards.size() == 0;
	}
	public ArrayList<Card> getCards() {
		return cards;
	}
	

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}

	public void addCard(Card card) {
		if (card == null) return;
		cards.add(card);
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