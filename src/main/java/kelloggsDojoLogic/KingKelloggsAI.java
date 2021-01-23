package kelloggsDojoLogic;

import java.util.List;
import java.util.Random;

public class KingKelloggsAI {
	private Card[] fullDeck;
	private static Random rand = new Random();

	public KingKelloggsAI() {
		super();
		fullDeck = CardFactory.getFullDeck();
	}

	public Card getKingsCard(Card playersCard, int winStreak) {
		int randInt = rand.nextInt(40);
		return getCardListAI(playersCard, winStreak)[randInt];
	}

	public int getRoundResult(Card player, Card kingKelloggs) { // 0 lose, 1 win, 2 tie, -1 error; player's POV
		int result = -1;
		if (player.getMascot().equals(kingKelloggs.getMascot())) {
			if (player.getNumber() > kingKelloggs.getNumber()) {
				result = 1;
			} else if (player.getNumber() < kingKelloggs.getNumber()) {
				result = 0;
			} else { // mascot and number equal
				result = 2;
			}
		} else if (player.getMascot().equals("Tiger")) {
			if (kingKelloggs.getMascot().equals("Toucan")) {
				result = 1;
			} else if (kingKelloggs.getMascot().equals("TripleThreat")) {
				result = 0;
			}
		} else if (player.getMascot().equals("Toucan")) {
			if (kingKelloggs.getMascot().equals("TripleThreat")) {
				result = 1;
			} else if (kingKelloggs.getMascot().equals("Tiger")) {
				result = 0;
			}
		} else if (player.getMascot().equals("TripleThreat")) {
			if (kingKelloggs.getMascot().equals("Tiger")) {
				result = 1;
			} else if (kingKelloggs.getMascot().equals("Toucan")) {
				result = 0;
			}
		}
		return result;
	}

	/**
	 * NEW METHOD: determines match result based on point cards
	 * 
	 * @param pointCards
	 * @return false is lose, true is win
	 */
	public boolean getMatchResult(List<Card> pointCards) {
		boolean result = false;
		int tigerCount = 0;
		int toucanCount = 0;
		int tripleCount = 0;
		int redCount = 0;
		int yellowCount = 0;
		int blueCount = 0;
		if (pointCards.size() >= 3) {
			for (int i = 0; i < pointCards.size(); i++) {
				Card card = pointCards.get(i);
				if (card.isTiger()) {
					tigerCount++;
				} else if (card.isToucan()) {
					toucanCount++;
				} else if (card.isTripleThreat()) {
					tripleCount++;
				}
			}
			if (tigerCount > 0 && toucanCount > 0 && tripleCount > 0) {
				result = true;
			} else {
				if (tigerCount >= 3) {
					for (int i = 0; i < pointCards.size(); i++) {
						Card card = pointCards.get(i);
						if (card.isTiger() && card.isRed()) {
							redCount++;
						} else if (card.isTiger() && card.isYellow()) {
							yellowCount++;
						} else if (card.isTiger() && card.isBlue()) {
							blueCount++;
						}
					}
					if (redCount > 0 && yellowCount > 0 && blueCount > 0) {
						result = true;
					} else {
						redCount = 0;
						yellowCount = 0;
						blueCount = 0;
					}
				}
				if (toucanCount >= 3 && !result) {
					for (int i = 0; i < pointCards.size(); i++) {
						Card card = pointCards.get(i);
						if (card.isToucan() && card.isRed()) {
							redCount++;
						} else if (card.isToucan() && card.isYellow()) {
							yellowCount++;
						} else if (card.isToucan() && card.isBlue()) {
							blueCount++;
						}
					}
					if (redCount > 0 && yellowCount > 0 && blueCount > 0) {
						result = true;
					} else {
						redCount = 0;
						yellowCount = 0;
						blueCount = 0;
					}
				}
				if (tripleCount >= 3 && !result) {
					for (int i = 0; i < pointCards.size(); i++) {
						Card card = pointCards.get(i);
						if (card.isTripleThreat() && card.isRed()) {
							redCount++;
						} else if (card.isTripleThreat() && card.isYellow()) {
							yellowCount++;
						} else if (card.isTripleThreat() && card.isBlue()) {
							blueCount++;
						}
					}
					if (redCount > 0 && yellowCount > 0 && blueCount > 0) {
						result = true;
					}
				}
			}
		}
		return result;
	} // end of getMatchResult method

	public Card[] getCardListAI(Card playerCard, int winStreak) {
		int losingCards;
		int winningCards;
		if (winStreak <= 2) {
			losingCards = 12;
			winningCards = 28;
		} else if (winStreak <= 4) {
			losingCards = 20;
			winningCards = 20;
		} else {
			losingCards = 30;
			winningCards = 10;
		}
		return fillCardListAI(playerCard, losingCards, winningCards);
	}

	private Card[] fillCardListAI(Card playerCard, int losingCards, int winningCards) {
		Card[] cardListAI = new Card[40];
		int i = 0;
		int j = 0;
		while (j < losingCards) {
			int result = getRoundResult(playerCard, fullDeck[i]);
			if (result == 0) {
				cardListAI[j++] = fullDeck[i];
			}
			if (++i == 45) {
				i = 0;
			}
		}
		i = 0;
		j = 0;
		while (j < winningCards) {
			int result = getRoundResult(playerCard, fullDeck[i]);
			if (result == 1) {
				cardListAI[losingCards + j] = fullDeck[i];
				j++;
			}
			if (++i == 45) {
				i = 0;
			}
		}
		return cardListAI;
	}

}
