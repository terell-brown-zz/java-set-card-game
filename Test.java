
public class Test {
	
	public static void main(String[] args ) {
		Card card1 = new Card(1,2,3,1);
		Card card2 = new Card(2,3,1,3);
		Card card3 = new Card(3,1,2,2);
		
		Player player = new Player();
		
		// Test when all cards the same
		System.out.println(player.isSet(card1,card1,card1));
		// Test when all cards are different
		System.out.println(player.isSet(card1,card2,card3));
		// 2 Cards the same
		System.out.println(player.isSet(card1,card1,card3));
		System.out.println(player.isSet(card1,card3,card3));
		System.out.println(player.isSet(card2,card1,card2));
	}
}

