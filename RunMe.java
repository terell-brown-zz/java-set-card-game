import java.util.ArrayList;

public class RunMe {
	
	public static void main(String[] args ) {
		
		// Testing isSet() Method
		////////////////////////////////////////////////////////////////
		System.out.println("Testing isSet Method: \n");
		Card card1 = new Card(1,2,3,1);
		Card card2 = new Card(2,3,1,3);
		Card card3 = new Card(3,1,2,2);
		Card card4 = new Card(1,1,2,2);
		Card card5 = new Card(1,3,2,3);
		
		
		// Test when all cards are the same ==> true
		System.out.println("Test when all cards are the same");
		System.out.println(Player.isSet(card1,card1,card1)+ "\n");
		
		// Test when all cards are different ==> true
		System.out.println("Test when all cards are different ==> true");
		System.out.println(Player.isSet(card1,card2,card3) + "\n");
		
		// 2 Cards the same ==> false
		System.out.println("Test when 2 cards are the same ==> false");
		System.out.println(Player.isSet(card1,card1,card3));
		System.out.println(Player.isSet(card1,card3,card3));
		System.out.println(Player.isSet(card2,card1,card2));
		System.out.println(Player.isSet(card2,card1,card2)+ "\n");
		
		// random tests
		System.out.println("Random testing");
		System.out.println(Player.isSet(card5,card4,card3));
		System.out.println(Player.isSet(card2,card4,card1));
		System.out.println(Player.isSet(card5,card2,card1)+ "\n");
		
		

		// Testing findSet() Method
		////////////////////////////////////////////////////////////////
		System.out.println("Testing findSet Method: \n");
		
		Deck deck = new Deck();
		Util.showCards(Util.DECK,deck.getCards());
		
		Board board = new Board();
		board.setCards(deck.dealCards(24));
		Util.showCards(Util.BOARD,board.getCards());
		
		ArrayList<Card> set1 = Player.findSet(board);
		Util.showCards(Util.SET, set1);

		
		// Testing completeGame() Method
		////////////////////////////////////////////////////////////////
		System.out.println("Testing completeGame Method: \n");
		ArrayList<ArrayList<Card>> sets = Player.completeGame();
		Util.showSets(sets);
	}
}

