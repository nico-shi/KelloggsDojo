package kelloggsDojo;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kelloggsDojoLogic.Card;
import kelloggsDojoLogic.CardFactory;

public class CardGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CardGUI frame = new CardGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} // main method

	public CardGUI() {
		super();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 750); // 100, 100, 1280, 720
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	public void createCardGUI(Card card, int x, int y, JLabel theLabel) {
		int cardWidth = 108;
		int cardLength = 140;
		JLabel cardLabel = new JLabel("");
		cardLabel.setBounds(x, y, cardWidth, cardLength);
		JLabel mascotLabel = new JLabel("");

		Image redCard = new ImageIcon(this.getClass().getResource("/RedCard.jpg")).getImage();
		Image redCardScaled = redCard.getScaledInstance(cardWidth, cardLength, Image.SCALE_DEFAULT);
		Image yellowCard = new ImageIcon(this.getClass().getResource("/YellowCard.jpg")).getImage();
		Image yellowCardScaled = yellowCard.getScaledInstance(cardWidth, cardLength, Image.SCALE_DEFAULT);
		Image blueCard = new ImageIcon(this.getClass().getResource("/BlueCard.jpg")).getImage();
		Image blueCardScaled = blueCard.getScaledInstance(cardWidth, cardLength, Image.SCALE_DEFAULT);

		Image tigerImage = new ImageIcon(this.getClass().getResource("/Tiger.png")).getImage();
		Image tigerScaled = tigerImage.getScaledInstance(50, 90, Image.SCALE_DEFAULT);
		Image toucanImage = new ImageIcon(this.getClass().getResource("/Toucan.png")).getImage();
		Image toucanScaled = toucanImage.getScaledInstance(72, 83, Image.SCALE_DEFAULT);
		Image tripleThreatImage = new ImageIcon(this.getClass().getResource("/TripleThreat.png")).getImage();
		Image tripleThreatScaled = tripleThreatImage.getScaledInstance(95, 72, Image.SCALE_DEFAULT);

		if (card.getColour().equals("red")) {
			cardLabel.setIcon(new ImageIcon(redCardScaled));
		} else if (card.getColour().equals("yellow")) {
			cardLabel.setIcon(new ImageIcon(yellowCardScaled));
		} else if (card.getColour().equals("blue")) {
			cardLabel.setIcon(new ImageIcon(blueCardScaled));
		}

		if (card.getMascot().equals("Tiger")) {
			mascotLabel.setIcon(new ImageIcon(tigerScaled));
			mascotLabel.setBounds(25, 28, 50, 90);
		} else if (card.getMascot().equals("Toucan")) {
			mascotLabel.setIcon(new ImageIcon(toucanScaled));
			mascotLabel.setBounds(15, 28, 72, 83);
		} else if (card.getMascot().equals("TripleThreat")) {
			mascotLabel.setIcon(new ImageIcon(tripleThreatScaled));
			mascotLabel.setBounds(7, 36, 95, 72);
		}

		JLabel cardNum1 = new JLabel(Integer.toString(card.getNumber()));
		cardNum1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
		cardNum1.setForeground(Color.WHITE);
		cardNum1.setHorizontalAlignment(JLabel.LEFT);
		cardNum1.setVerticalAlignment(JLabel.TOP);
		cardNum1.setBounds(10, 10, 30, 30);
		JLabel cardNum2 = new JLabel(Integer.toString(card.getNumber()));
		cardNum2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
		cardNum2.setForeground(Color.WHITE);
		cardNum2.setHorizontalAlignment(JLabel.RIGHT);
		cardNum2.setVerticalAlignment(JLabel.BOTTOM);
		cardNum2.setBounds(cardWidth - 45, cardLength - 35, 30, 30);

		cardLabel.add(cardNum1);
		cardLabel.add(cardNum2);
		cardLabel.add(mascotLabel);
		theLabel.add(cardLabel);
	} // createCardGUI method

	public void displayAllCards(JLabel theLabel) {
		Card[] fullDeck = CardFactory.getFullDeck();
		int y = 10;
		int x = 10;
		int counterY = 1;
		int counterX = 1;
		for (int i = 0; i < 45; i++) {
			createCardGUI(fullDeck[i], x, y, theLabel);
			if (i == 9 || i == 19 || i == 29 || i == 39) {
				x = 10;
				y = 10 + (counterY * 140);
				counterX = 1;
				counterY++;
			} else {
				x = 10 + (counterX * 108);
				counterX++;
			}
		}
	}

	public void displayPlayersHand(Card[] playersHand, int x, int y, JLabel theLabel) {
		int ogX = x;
		for (int i = 0; i < playersHand.length; i++) {
			createCardGUI(playersHand[i], x, y, theLabel);
			x = ogX + ((i + 1) * 108) + ((i + 1) * 100);
		}
	}

	public void displayPointCards(List<Card> pointCards, int x, int y, JLabel theLabel) {
		int ogY = y;
		for (int i = 0; i < pointCards.size(); i++) {
			createCardGUI(pointCards.get(i), x, y, theLabel);
			y = ogY + ((i + 1) * 70);
		}
	}

	public void removeCard(int cardX, int cardY, JLabel theLabel) {
		theLabel.remove(theLabel.getComponentAt(cardX, cardY));
	}

	public int getPlayersCardX(int index) {
		return 230 + (index * 108) + (index * 100);
	}

	public int getPlayersCardY(int index) {
		return 510;
	}

} // CardGUI class
