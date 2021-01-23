package kelloggsDojoLogic;

import java.util.Random;

public class CardFactory {

	private static String[] types = { Card.TIGER, Card.TOUCAN, Card.TRITHREAT }; // Instantiate array of card types
	private static String[] colours = { Card.RED, Card.YELLOW, Card.BLUE }; // Instantiate array of card colours
	private static Random rand = new Random();

	public static Card[] getFullDeck() {
		Card[] fullDeck = new Card[45];
		int counter = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 1; k < 6; k++) {
					Card card = new Card(types[i], colours[j], k);
					fullDeck[counter++] = card;
				}
			}
		}
		return fullDeck;
	} // getFullDeck

	public static Card getNewCard() {
		int randInt = rand.nextInt(45);
		return getFullDeck()[randInt];
	}

	public static Card[] getPlayersHand() {
		Card[] playersHand = new Card[5];
		for (int i = 0; i < 5; i++) {
			int randInt = rand.nextInt(45);
			playersHand[i] = getFullDeck()[randInt];
		}
		return playersHand;
	}

} // CardFactory class
