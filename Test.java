import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class Test {
	
	public static void main(String[] args ) {
		Card card1 = new Card(1,2,3,1);
		Card card2 = new Card(2,3,1,3);
		Card card3 = new Card(3,1,2,2);
		

		
		// Test when all cards the same
		System.out.println(Player.isSet(card1,card1,card1));
		// Test when all cards are different
		System.out.println(Player.isSet(card1,card2,card3));
		// 2 Cards the same
		System.out.println(Player.isSet(card1,card1,card3));
		System.out.println(Player.isSet(card1,card3,card3));
		System.out.println(Player.isSet(card2,card1,card2));
		
		Deck deck = new Deck();
		Board board = new Board();
		board.setCards(deck.dealCards(12));
		//board.addCard(card1);
		//board.addCard(card1);
		//board.addCard(card1);
		//board.showCards();
		
		HashMap<Integer,Card> set1 = Player.findSet(board);
		
		//showCards(toList(set1));

		
		ArrayList<ArrayList<Card>> sets = Player.completeGame();
		showSets(sets);
	}
	
	public static void showSets(ArrayList<ArrayList<Card>> sets) {
		
		System.out.println(sets.size() + " sets were found and they are as follows:");
		for (int i = 0; i < sets.size(); i++) {
			showCards(sets.get(i));
		}
	}
	public static void showCards(List<Card> cards) {
		if (cards == null) {
			System.out.println("There are no cards");
			return;
		} 
		
		System.out.println("This set of cards includes: ");
		for (Card card: cards) {
			System.out.println("[" + card.getColor() + "," + card.getShape() + "," + card.getShading() + "," + card.getNumber() + "]"  );
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

