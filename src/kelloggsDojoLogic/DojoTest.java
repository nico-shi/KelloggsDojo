package kelloggsDojoLogic;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class DojoTest {

	private static Card player = new Card("Tiger", "red", 1);
	private static KingKelloggsAI AI = new KingKelloggsAI();

	public static void main(String[] args) {
		int wins = 0;
		int losses = 0;
		int ties = 0;
		int errors = 0;
		int elses = 0;
		int winStreak = 5;
		for (int i = 0; i < 1000; i++) {
			int result = AI.getRoundResult(player, AI.getKingsCard(player, winStreak));
			if (result == 0) {
				losses++;
			} else if (result == 1) {
				wins++;
			} else if (result == 2) {
				ties++;
			} else if (result == -1) {
				errors++;
			} else {
				elses++;
			}
		}
		System.out.println("wins = " + wins);
		System.out.println("losses = " + losses);
		System.out.println("ties = " + ties);
		System.out.println("errors = " + errors);
		System.out.println("elses = " + elses);
	}
	
	@Test
	public void testGetMatchResult() {
		List<Card> pointCards = new ArrayList<>();
		pointCards.add(new Card(Card.TRITHREAT, Card.RED, 1));
		pointCards.add(new Card(Card.TRITHREAT, Card.YELLOW, 1));
		pointCards.add(new Card(Card.TRITHREAT, Card.BLUE, 1));
		assertTrue(AI.getMatchResult(pointCards));
	}

}
