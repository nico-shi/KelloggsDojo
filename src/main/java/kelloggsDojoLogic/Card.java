package kelloggsDojoLogic;

public class Card {

	public static final String TIGER = "Tiger";
	public static final String TOUCAN = "Toucan";
	public static final String TRITHREAT = "TripleThreat";
	public static final String RED = "red";
	public static final String YELLOW = "yellow";
	public static final String BLUE = "blue";
	private String mascot;
	private String colour; // Instantiate colour of card
	private int number; // Instantiate number of card

	public Card(String mascot, String colour, int number) {
		super();
		this.mascot = mascot;
		this.colour = colour;
		this.number = number;
	}

	public String getMascot() {
		return mascot;
	}

	public String getColour() {
		return colour;
	}

	public int getNumber() {
		return number;
	}

	public boolean isTiger() {
		return TIGER.equals(mascot);
	}

	public boolean isToucan() {
		return TOUCAN.equals(mascot);
	}

	public boolean isTripleThreat() {
		return TRITHREAT.equals(mascot);
	}

	public boolean isRed() {
		return RED.equals(colour);
	}

	public boolean isYellow() {
		return YELLOW.equals(colour);
	}

	public boolean isBlue() {
		return BLUE.equals(colour);
	}

	@Override
	public String toString() {
		return mascot + " " + colour + " " + number;
	}

	public Card clone() {
		return new Card(mascot, colour, number);
	}

} // Card class
