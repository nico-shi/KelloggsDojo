package kelloggsDojo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kelloggsDojoLogic.Card;
import kelloggsDojoLogic.CardFactory;
import kelloggsDojoLogic.KingKelloggsAI;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MainGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel_AiCards;
	private JPanel panel_Bowl;
	private JPanel panel_Spoon;
	private CardGUI cardGUI = new CardGUI();
	private KingKelloggsAI AI = new KingKelloggsAI();
	private OutputMessages om = new OutputMessages(); // Take this for merge//
	private SpoonBowlMethod sb = new SpoonBowlMethod();
	private int matchCounter = 0;
	private Card[] playersHand;
	private JLabel background1;
	private List<Card> playersPointCards = new ArrayList<Card>();
	private List<Card> kingKelloggsPointCards = new ArrayList<Card>();
	private JLabel bowl;
	private JLabel spoon;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 20, 60));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Main Menu GUI//

		JButton startGameBt = new JButton("Start");
		startGameBt.setFont(new Font("Wawati TC", Font.PLAIN, 20));
		startGameBt.setIcon(null);
		startGameBt.setForeground(Color.RED);
		startGameBt.setBackground(Color.WHITE);
		startGameBt.setBounds(1072, 269, 139, 38);
		contentPane.add(startGameBt);

		JButton instructionsBt = new JButton("Instructions");
		instructionsBt.setFont(new Font("Wawati TC", Font.PLAIN, 20));
		instructionsBt.setIcon(null);
		instructionsBt.setForeground(Color.RED);
		instructionsBt.setBackground(Color.WHITE);
		instructionsBt.setBounds(1072, 371, 147, 38);
		contentPane.add(instructionsBt);

		JButton quitGameBt = new JButton("Quit");
		quitGameBt.setFont(new Font("Wawati TC", Font.PLAIN, 20));
		quitGameBt.setForeground(Color.RED);
		quitGameBt.setBackground(Color.WHITE);
		quitGameBt.setIcon(null);
		quitGameBt.setBounds(1085, 642, 115, 38);
		contentPane.add(quitGameBt);

		JLabel background = new JLabel("");
		Image Img = new ImageIcon(this.getClass().getResource("/DojoBackground.png")).getImage();
		background.setIcon((new ImageIcon(Img)));
		background.setBounds(0, 0, 1280, 720);
		contentPane.add(background);

		// Win Screen GUI//

		JButton endButton = new JButton("End Game");
		endButton.setForeground(new Color(128, 0, 0));
		endButton.setFont(new Font("Arial", Font.BOLD, 35));
		endButton.setBounds(179, 566, 199, 67);

		JButton btnPlayAgain = new JButton("Play Again");
		btnPlayAgain.setForeground(new Color(128, 0, 0));
		btnPlayAgain.setFont(new Font("Arial", Font.BOLD, 35));
		btnPlayAgain.setBounds(921, 566, 199, 67);

		JLabel kingpng = new JLabel("");
		Image Img103 = new ImageIcon(this.getClass().getResource("/King.png")).getImage();
		Image Img104 = Img103.getScaledInstance(748, 550, Image.SCALE_DEFAULT);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		kingpng.setIcon((new ImageIcon(Img104)));
		kingpng.setBounds(283, 167, 654, 361);

		JLabel lblYouHaveDefeated = new JLabel("You Have Defeated King Kelloggs!");
		lblYouHaveDefeated.setForeground(new Color(128, 0, 0));
		lblYouHaveDefeated.setFont(new Font("Arial", Font.BOLD, 60));
		lblYouHaveDefeated.setHorizontalAlignment(SwingConstants.CENTER);
		lblYouHaveDefeated.setBounds(6, 32, 1268, 123);

		// Instructions GUI//

		JLabel label = new JLabel("");
		Image newImg = new ImageIcon(this.getClass().getResource("/Unknown.png")).getImage();
		Image img = newImg.getScaledInstance(680, 480, Image.SCALE_DEFAULT);
		label.setIcon(new ImageIcon(img));
		label.setBounds(-41, 379, 471, 399);

		JPanel panel = new JPanel();
		panel.setBounds(324, 25, 631, 114);

		JLabel lblNewLabel = new JLabel("Instructions");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 70));
		lblNewLabel.setBackground(Color.WHITE);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(85, 203, 709, 150);

		JLabel lblNewLabel_1_1 = new JLabel("Welcome to the Kellogg’s Dojo. I am King Kellogg’s, and I bestow");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 20));

		JLabel lblNewLabel_1_2 = new JLabel("upon you a silver spoon. Soon, you will earn a golden spoon, and ");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 20));

		JLabel lblNewLabel_1_3 = new JLabel("then the coveted diamond spoon. But first, you must try to beat me ");
		lblNewLabel_1_3.setFont(new Font("Arial", Font.PLAIN, 20));

		JLabel lblNewLabel_1 = new JLabel("in a game of cards - but not just any game of cards.");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));

		JButton btnBackToMenu = new JButton("Back to Menu");
		btnBackToMenu.setFont(new Font("Arial", Font.PLAIN, 25));
		btnBackToMenu.setBounds(70, 42, 175, 80);

		JButton btnNextPage = new JButton("Next Page");
		btnNextPage.setFont(new Font("Arial", Font.PLAIN, 25));
		btnNextPage.setBounds(1040, 42, 175, 80);

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBounds(483, 454, 709, 150);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("You will receive a hand of 5 cards: each card will contain a number");
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 20));

		JLabel lblNewLabel_1_2_1_1 = new JLabel(" (1-5), a Kellogg’s mascot, and will each be either red, yellow\n");
		lblNewLabel_1_2_1_1.setFont(new Font("Arial", Font.PLAIN, 20));

		JLabel lblNewLabel_1_3_1_1 = new JLabel(" or blue. Tony the Tiger beats Toucan Sam; Toucan Sam beats\n");
		lblNewLabel_1_3_1_1.setFont(new Font("Arial", Font.PLAIN, 20));

		JLabel lblNewLabel_1_4_1 = new JLabel(" Snap, Crackle & Pop; Snap, Crackle & Pop beats Tony the Tiger.\n");
		lblNewLabel_1_4_1.setFont(new Font("Arial", Font.PLAIN, 20));

		// Instructions GUI for page 2//

		JLabel lblNewLabel1 = new JLabel("We will both play a card and whoever wins that round will get to keep their");
		lblNewLabel1.setFont(new Font("Arial", Font.PLAIN, 18));

		JLabel lblNewLabel2 = new JLabel("card as a point. If we play the same Kellogg’s mascot, whoever has the");
		lblNewLabel2.setFont(new Font("Arial", Font.PLAIN, 18));

		JLabel lblNewLabel3 = new JLabel(
				"larger number on their card wins. If we both play the same mascot and number,");
		lblNewLabel3.setFont(new Font("Arial", Font.PLAIN, 18));

		JLabel lblNewLabel4 = new JLabel("then no one receives a point and the game moves on to the next round.");
		lblNewLabel4.setFont(new Font("Arial", Font.PLAIN, 18));

		JLabel lblNewLabel5 = new JLabel("To win a match, you must have 3 points cards with all different mascots,");
		lblNewLabel5.setFont(new Font("Arial", Font.PLAIN, 20));

		JLabel lblNewLabel6 = new JLabel(
				"regardless of colour. Or, you must have 3 points cards with the same mascot,");
		lblNewLabel6.setFont(new Font("Arial", Font.PLAIN, 20));

		JLabel lblNewLabel7 = new JLabel("but each card must be a different colour. Once you have won a match, your");
		lblNewLabel7.setFont(new Font("Arial", Font.PLAIN, 20));

		JLabel lblNewLabel8 = new JLabel("cereal bowl will fill up. 3 matches won will level up your spoon.");
		lblNewLabel8.setFont(new Font("Arial", Font.PLAIN, 20));

		JButton btnPreviousPage = new JButton("Previous Page");
		btnPreviousPage.setFont(new Font("Arial", Font.PLAIN, 25));
		btnPreviousPage.setBounds(1040, 42, 175, 80);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(525, 616, 631, 53);

		JLabel lblAreYouReady = new JLabel("Are you ready to play?");
		lblAreYouReady.setForeground(Color.WHITE);
		lblAreYouReady.setHorizontalAlignment(SwingConstants.CENTER);
		lblAreYouReady.setFont(new Font("Arial", Font.PLAIN, 30));
		lblAreYouReady.setBackground(Color.WHITE);

		JLabel card1 = new JLabel("");
		Image newImg1 = new ImageIcon(this.getClass().getResource("/BSCP.JPG")).getImage();
		Image img1 = newImg1.getScaledInstance(102, 132, Image.SCALE_DEFAULT);
		card1.setIcon(new ImageIcon(img1));
		card1.setBounds(960, 221, 102, 132);

		JLabel card2 = new JLabel("");
		Image newImg2 = new ImageIcon(this.getClass().getResource("/RSCP.JPG")).getImage();
		Image img2 = newImg2.getScaledInstance(102, 132, Image.SCALE_DEFAULT);
		card2.setIcon(new ImageIcon(img2));
		card2.setBounds(924, 213, 102, 132);

		JLabel card3 = new JLabel("");
		Image newImg3 = new ImageIcon(this.getClass().getResource("/YSCP.JPG")).getImage();
		Image img3 = newImg3.getScaledInstance(102, 132, Image.SCALE_DEFAULT);
		card3.setIcon(new ImageIcon(img3));
		card3.setBounds(883, 203, 102, 132);

		JLabel win = new JLabel("");
		Image newWin1 = new ImageIcon(this.getClass().getResource("/Win.png")).getImage();
		Image win1 = newWin1.getScaledInstance(69, 99, Image.SCALE_DEFAULT);
		win.setIcon(new ImageIcon(win1));
		win.setBounds(151, 403, 76, 114);

		JLabel winn = new JLabel("");
		Image newWin2 = new ImageIcon(this.getClass().getResource("/Win.png")).getImage();
		Image win2 = newWin2.getScaledInstance(69, 99, Image.SCALE_DEFAULT);
		winn.setIcon(new ImageIcon(win2));
		winn.setBounds(374, 403, 76, 116);

		JLabel winN = new JLabel("");
		Image newWin3 = new ImageIcon(this.getClass().getResource("/Win.png")).getImage();
		Image win3 = newWin3.getScaledInstance(69, 99, Image.SCALE_DEFAULT);
		winN.setIcon(new ImageIcon(win3));
		winN.setBounds(1062, 239, 76, 114);

		JLabel winn1 = new JLabel("");
		Image newWin4 = new ImageIcon(this.getClass().getResource("/Win.png")).getImage();
		Image win4 = newWin4.getScaledInstance(69, 99, Image.SCALE_DEFAULT);
		winn1.setIcon(new ImageIcon(win4));
		winn1.setBounds(1006, 107, 76, 116);

		JLabel card4 = new JLabel("");
		Image newImg4 = new ImageIcon(this.getClass().getResource("/BTT.JPG")).getImage();
		Image img4 = newImg4.getScaledInstance(102, 132, Image.SCALE_DEFAULT);
		card4.setIcon(new ImageIcon(img4));
		card4.setBounds(950, 151, 102, 132);

		JLabel card5 = new JLabel("");
		Image newImg5 = new ImageIcon(this.getClass().getResource("/YST.JPG")).getImage();
		Image img5 = newImg5.getScaledInstance(102, 132, Image.SCALE_DEFAULT);
		card5.setIcon(new ImageIcon(img5));
		card5.setBounds(836, 151, 102, 132);

		JLabel card6 = new JLabel("");
		Image newImg6 = new ImageIcon(this.getClass().getResource("/RST.JPG")).getImage();
		Image img6 = newImg6.getScaledInstance(102, 132, Image.SCALE_DEFAULT);
		card6.setIcon(new ImageIcon(img6));
		card6.setBounds(1120, 295, 102, 132);

		JLabel card7 = new JLabel("");
		Image newImg7 = new ImageIcon(this.getClass().getResource("/BST.JPG")).getImage();
		Image img7 = newImg7.getScaledInstance(102, 132, Image.SCALE_DEFAULT);
		card7.setIcon(new ImageIcon(img7));
		card7.setBounds(1006, 295, 102, 132);

		JLabel card8 = new JLabel("");
		Image newImg8 = new ImageIcon(this.getClass().getResource("/YTT.JPG")).getImage();
		Image img8 = newImg8.getScaledInstance(102, 132, Image.SCALE_DEFAULT);
		card8.setIcon(new ImageIcon(img8));
		card8.setBounds(143, 531, 102, 132);

		JLabel card9 = new JLabel("");
		Image newImg9 = new ImageIcon(this.getClass().getResource("/RTT.JPG")).getImage();
		Image img9 = newImg9.getScaledInstance(102, 132, Image.SCALE_DEFAULT);
		card9.setIcon(new ImageIcon(img9));
		card9.setBounds(85, 459, 102, 132);

		JLabel card10 = new JLabel("");
		Image newImg10 = new ImageIcon(this.getClass().getResource("/YTT.JPG")).getImage();
		Image img10 = newImg10.getScaledInstance(102, 132, Image.SCALE_DEFAULT);
		card10.setIcon(new ImageIcon(img10));
		card10.setBounds(37, 387, 102, 132);

		JLabel card11 = new JLabel("");
		Image newImg11 = new ImageIcon(this.getClass().getResource("/YTT.JPG")).getImage();
		Image img11 = newImg11.getScaledInstance(102, 132, Image.SCALE_DEFAULT);
		card11.setIcon(new ImageIcon(img11));
		card11.setBounds(357, 531, 102, 132);

		JLabel card12 = new JLabel("");
		Image newImg12 = new ImageIcon(this.getClass().getResource("/RST.JPG")).getImage();
		Image img12 = newImg12.getScaledInstance(102, 132, Image.SCALE_DEFAULT);
		card12.setIcon(new ImageIcon(img12));
		card12.setBounds(304, 459, 102, 132);

		JLabel card13 = new JLabel("");
		Image newImg13 = new ImageIcon(this.getClass().getResource("/BSCP.JPG")).getImage();
		Image img13 = newImg13.getScaledInstance(102, 132, Image.SCALE_DEFAULT);
		card13.setIcon(new ImageIcon(img13));
		card13.setBounds(260, 387, 102, 132);

		// Main Game GUI//

		JLabel king = new JLabel("");
		Image Img13 = new ImageIcon(this.getClass().getResource("/King.png")).getImage();
		Image Img14 = Img13.getScaledInstance(374, 275, Image.SCALE_DEFAULT);
		contentPane.setLayout(null);
		king.setIcon((new ImageIcon(Img14)));
		king.setBounds(906, 0, 374, 210);

		JLabel l = new JLabel("");
		Image newly = new ImageIcon(this.getClass().getResource("/Unknown.png")).getImage();
		Image imag = newly.getScaledInstance(574, 405, Image.SCALE_DEFAULT);
		contentPane.setLayout(null);
		l.setIcon(new ImageIcon(imag));
		l.setBounds(400, 20, 680, 688);

		JLabel deck = new JLabel("");
		Image Img30 = new ImageIcon(this.getClass().getResource("/Deck.png")).getImage();
		Image Img31 = Img30.getScaledInstance(500, 200, Image.SCALE_DEFAULT);
		deck.setIcon((new ImageIcon(Img31)));
		deck.setBounds(217, 495, 845, 172);

		// Bowl Method Initiated//
		// JLabel bowl;

		// Spoon Method Initiated//
		// JLabel spoon;

		JLabel deck_1 = new JLabel("");
		deck_1.setIcon((new ImageIcon(Img31)));
		deck_1.setBounds(717, 495, 845, 172);

		JPanel panel_Logo = new JPanel();
		panel_Logo.setBounds(5, 5, 260, 229);

		JButton CardButton = new JButton("");
		CardButton.setBounds(234, 507, 108, 140);
		CardButton.setOpaque(false); // makes button transparent so the card underneath is visible
		CardButton.setContentAreaFilled(false);
		CardButton.setBorderPainted(false);

		JButton CardButton_1 = new JButton("");
		CardButton_1.setBounds(433, 507, 108, 140);
		CardButton_1.setOpaque(false);
		CardButton_1.setContentAreaFilled(false);
		CardButton_1.setBorderPainted(false);

		JButton CardButton_2 = new JButton("");
		CardButton_2.setBounds(641, 507, 108, 140);
		CardButton_2.setOpaque(false);
		CardButton_2.setContentAreaFilled(false);
		CardButton_2.setBorderPainted(false);

		JButton CardButton_3 = new JButton("");
		CardButton_3.setBounds(840, 507, 108, 140);
		CardButton_3.setOpaque(false);
		CardButton_3.setContentAreaFilled(false);
		CardButton_3.setBorderPainted(false);

		JButton CardButton_4 = new JButton("");
		CardButton_4.setBounds(1055, 507, 108, 140);
		CardButton_4.setOpaque(false);
		CardButton_4.setContentAreaFilled(false);
		CardButton_4.setBorderPainted(false);

		JButton nextButton = new JButton("Next");
		nextButton.setFont(new Font("Arial", Font.BOLD, 20));
		nextButton.setBounds(580, 450, 120, 40);

		background1 = new JLabel("");
		background1.setVerticalAlignment(SwingConstants.TOP);
		Image Img1 = new ImageIcon(this.getClass().getResource("/MainDojo.png")).getImage();
		Image Img12 = Img1.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
		background1.setIcon((new ImageIcon(Img12)));
		background1.setBounds(0, 0, 1280, 720);

		JPanel panel_UserCards = new JPanel();
		panel_UserCards.setBounds(5, 441, 1000, 229);

		panel_AiCards = new JPanel();
		panel_AiCards.setBounds(1259, 5, -994, 229);

		JPanel panel_PlayerCard = new JPanel();
		panel_PlayerCard.setBounds(89, 234, 369, 207);

		JPanel panel_AiCard = new JPanel();
		panel_AiCard.setBounds(827, 234, 369, 207);

		JPanel panel_PlayerPoints = new JPanel();

		JPanel panel_AiPoints = new JPanel();
		panel_AiPoints.setBounds(1195, 234, 69, 207);

		// Action Listeners for Instructions Pages//

		endButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				contentPane.add(startGameBt);
				contentPane.add(instructionsBt);
				contentPane.add(quitGameBt);
				contentPane.add(background);

				matchCounter = 0;
				kingKelloggsPointCards.clear();
				playersPointCards.clear();

				contentPane.validate();
				contentPane.repaint();

				// Add same as main menu GUI//
			}
		});

		btnNextPage.addActionListener(new ActionListener() // adding action listener to the button component and
															// creating a specific action performed method (override)
															// for the button
		{
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(label);
				contentPane.remove(btnNextPage);
				contentPane.add(btnPreviousPage);
				contentPane.add(panel_2);
				contentPane.remove(card1);
				contentPane.remove(card2);
				contentPane.remove(card3);
				contentPane.add(win);
				contentPane.add(winn);
				contentPane.add(winN);
				contentPane.add(winn1);
				contentPane.add(card4);
				contentPane.add(card5);
				contentPane.add(card6);
				contentPane.add(card7);
				contentPane.add(card8);
				contentPane.add(card9);
				contentPane.add(card10);
				contentPane.add(card11);
				contentPane.add(card12);
				contentPane.add(card13);
				contentPane.validate();
				contentPane.repaint();

				panel_1.remove(lblNewLabel_1_1);
				panel_1.remove(lblNewLabel_1_2);
				panel_1.remove(lblNewLabel_1_3);
				panel_1.remove(lblNewLabel_1);
				panel_1.add(lblNewLabel1);
				panel_1.add(lblNewLabel2);
				panel_1.add(lblNewLabel3);
				panel_1.add(lblNewLabel4);

				panel_1.validate();
				panel_1.repaint();

				panel_1_2.remove(lblNewLabel_1_1_1_1);
				panel_1_2.remove(lblNewLabel_1_2_1_1);
				panel_1_2.remove(lblNewLabel_1_3_1_1);
				panel_1_2.remove(lblNewLabel_1_4_1);
				panel_1_2.add(lblNewLabel5);
				panel_1_2.add(lblNewLabel6);
				panel_1_2.add(lblNewLabel7);
				panel_1_2.add(lblNewLabel8);

				panel_1_2.validate();
				panel_1_2.repaint();

				panel_2.add(lblAreYouReady);

				panel_2.validate();
				panel_2.repaint();
			}
		});

		btnPreviousPage.addActionListener(new ActionListener() // adding action listener to the button component and
																// creating a specific action performed method
																// (override) for the button
		{
			public void actionPerformed(ActionEvent e) {
				contentPane.add(label);
				contentPane.add(btnNextPage);
				contentPane.remove(btnPreviousPage);
				contentPane.remove(panel_2);
				contentPane.add(card1);
				contentPane.add(card2);
				contentPane.add(card3);
				contentPane.remove(win);
				contentPane.remove(winn);
				contentPane.remove(winN);
				contentPane.remove(winn1);
				contentPane.remove(card4);
				contentPane.remove(card5);
				contentPane.remove(card6);
				contentPane.remove(card7);
				contentPane.remove(card8);
				contentPane.remove(card9);
				contentPane.remove(card10);
				contentPane.remove(card11);
				contentPane.remove(card12);
				contentPane.remove(card13);
				contentPane.validate();
				contentPane.repaint();

				panel_1.add(lblNewLabel_1_1);
				panel_1.add(lblNewLabel_1_2);
				panel_1.add(lblNewLabel_1_3);
				panel_1.add(lblNewLabel_1);
				panel_1.remove(lblNewLabel1);
				panel_1.remove(lblNewLabel2);
				panel_1.remove(lblNewLabel3);
				panel_1.remove(lblNewLabel4);

				panel_1.validate();
				panel_1.repaint();

				panel_1_2.add(lblNewLabel_1_1_1_1);
				panel_1_2.add(lblNewLabel_1_2_1_1);
				panel_1_2.add(lblNewLabel_1_3_1_1);
				panel_1_2.add(lblNewLabel_1_4_1);
				panel_1_2.remove(lblNewLabel5);
				panel_1_2.remove(lblNewLabel6);
				panel_1_2.remove(lblNewLabel7);
				panel_1_2.remove(lblNewLabel8);

				panel_1_2.validate();
				panel_1_2.repaint();

				panel_2.remove(lblAreYouReady);

				panel_2.validate();
				panel_2.repaint();
			}
		});

		btnBackToMenu.addActionListener(new ActionListener() // adding action listener to the button component and
																// creating a specific action performed method
																// (override) for the button
		{
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				contentPane.validate();
				contentPane.repaint();

				contentPane.add(startGameBt);
				contentPane.add(instructionsBt);
				contentPane.add(quitGameBt);
				contentPane.add(background);
			}
		});

		// Action Listeners for Main Menu//

		instructionsBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();

				contentPane.add(label);
				contentPane.add(panel);
				panel.add(lblNewLabel);
				contentPane.add(panel_1);
				panel_1.add(lblNewLabel_1_1);
				panel_1.add(lblNewLabel_1_2);
				panel_1.add(lblNewLabel_1_3);
				panel_1.add(lblNewLabel_1);
				contentPane.add(btnBackToMenu);
				contentPane.add(btnNextPage);
				contentPane.add(panel_1_2);
				panel_1_2.add(lblNewLabel_1_1_1_1);
				panel_1_2.add(lblNewLabel_1_2_1_1);
				panel_1_2.add(lblNewLabel_1_3_1_1);
				panel_1_2.add(lblNewLabel_1_4_1);
				contentPane.add(card1);
				contentPane.add(card2);
				contentPane.add(card3);

				contentPane.validate();
				contentPane.repaint();
			}
		});

		startGameBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				contentPane.validate();
				contentPane.repaint();

				contentPane.add(CardButton);
				contentPane.add(CardButton_1);
				contentPane.add(CardButton_2);
				contentPane.add(CardButton_3);
				contentPane.add(CardButton_4);
				contentPane.add(nextButton);
				contentPane.add(l);

				bowl = sb.setBowl(matchCounter);
				spoon = sb.setSpoon(matchCounter);
				contentPane.add(bowl);
				contentPane.add(king);
				contentPane.add(spoon);
				// contentPane.add(deck);
				// contentPane.add(deck_1);
				contentPane.add(background1);
				contentPane.add(panel_Logo);
				contentPane.add(panel_UserCards);
				contentPane.add(panel_AiCards);
				contentPane.add(panel_PlayerCard);
				contentPane.add(panel_AiCard);
				contentPane.add(panel_PlayerPoints);
				contentPane.add(panel_AiPoints);

				playersHand = CardFactory.getPlayersHand();
				cardGUI.displayPlayersHand(playersHand, 230, 510, background1);

				contentPane.validate();
				contentPane.repaint();
			}
		});

		quitGameBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		CardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afterPlayerChooses(0);
			}
		});

		CardButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afterPlayerChooses(1);
			}
		});

		CardButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afterPlayerChooses(2);
			}
		});

		CardButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afterPlayerChooses(3);
			}
		});

		CardButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afterPlayerChooses(4);
			}
		});

		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				background1.removeAll();
				contentPane.removeAll();

				contentPane.add(CardButton);
				contentPane.add(CardButton_1);
				contentPane.add(CardButton_2);
				contentPane.add(CardButton_3);
				contentPane.add(CardButton_4);
				contentPane.add(nextButton);
				contentPane.add(l);

				bowl = sb.setBowl(matchCounter);
				spoon = sb.setSpoon(matchCounter);
				contentPane.add(bowl);
				contentPane.add(spoon);
				contentPane.add(king);
				contentPane.add(background1);
				if (kingKelloggsPointCards.size() >= 4) {
					Card card = kingKelloggsPointCards.get(3);
					kingKelloggsPointCards.clear();
					kingKelloggsPointCards.add(card);
				}

				cardGUI.displayPointCards(playersPointCards, 20, 195, background1);
				cardGUI.displayPointCards(kingKelloggsPointCards, 1130, 195, background1); // end of new
				cardGUI.displayPlayersHand(playersHand, 230, 510, background1);

				if (matchCounter == 9) {
					contentPane.removeAll();
					contentPane.setBackground(Color.RED);
					contentPane.add(kingpng);
					contentPane.add(lblYouHaveDefeated);
					contentPane.add(endButton);
					contentPane.add(btnPlayAgain);
				}

				contentPane.validate();
				contentPane.repaint();
			}
		});

	}

	public void afterPlayerChooses(int choice) {
		Card playersCard = playersHand[choice];
		Card kingKelloggsCard = AI.getKingsCard(playersCard, matchCounter);
		cardGUI.createCardGUI(playersCard, 320, 290, background1);
		cardGUI.createCardGUI(kingKelloggsCard, 850, 290, background1);
		cardGUI.removeCard(cardGUI.getPlayersCardX(choice), cardGUI.getPlayersCardY(choice), background1);
		playersHand[choice] = CardFactory.getNewCard();

		int result = AI.getRoundResult(playersCard, kingKelloggsCard);
		if (result == 0) { // player loses
			kingKelloggsPointCards.add(kingKelloggsCard.clone());
		} else if (result == 1) {
			playersPointCards.add(playersCard.clone()); // player wins
		} else {
			// tie or error
		}

		// NEW!
		boolean playerMatch = AI.getMatchResult(playersPointCards);
		boolean kingMatch = AI.getMatchResult(kingKelloggsPointCards);
		if (playerMatch) {
			playersPointCards.clear();
			result = 3;
			matchCounter++;
		}

		JPanel output = om.matchMessage(result, matchCounter); // Gets output message//
		background1.add(output);

		contentPane.validate();
		contentPane.repaint();

		int count = om.count();
	}
}