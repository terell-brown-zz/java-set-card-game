import java.util.ArrayList;
import java.util.List;


public class Util {

	final static int DECK = 0;
	final static int BOARD = 1;
	final static int SET = 2;
	final static int ANY = 3;

	public static void showCards(int context, List<Card> cards) {
		if (cards == null) {
			System.out.println("There are no cards");
			return;
		} 

		// print a statement according to context of the call
		switch (context) {
		case DECK:
			System.out.println("The cards in the deck include: ");
			break;
		case BOARD:
			System.out.println("The cards on the board include: ");
			break;
		case SET:
			System.out.println("This set of cards includes: ");
			break;
		default:
			System.out.println("This group of cards includes: ");
			break;

		}

		for (Card card: cards) {
			System.out.println("[" + card.getColor() + "," + card.getShape() + "," + card.getShading() + "," + card.getNumber() + "]"  );
		}
		System.out.println();
	}


	public static void showSets(ArrayList<ArrayList<Card>> sets) {
		// prints all sets in a list
		System.out.println(sets.size() + " sets were found in this game and they are as follows:");
		for (int i = 0; i < sets.size(); i++) {
			Util.showCards(SET,sets.get(i));
		}
	}


}
