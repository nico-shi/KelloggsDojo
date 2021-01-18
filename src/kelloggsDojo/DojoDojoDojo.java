package kelloggsDojo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import java.awt.Panel;
import javax.swing.Box;
import java.awt.Color;

public class DojoDojoDojo extends JFrame {

	private JPanel contentPane;
	private JPanel panel_AiCards;
	private JPanel panel_Bowl;
	private JPanel panel_Spoon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DojoDojoDojo frame = new DojoDojoDojo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DojoDojoDojo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		

		/*	panel_Bowl = new JPanel();
		panel_Bowl.setBackground(Color.WHITE);
		panel_Bowl.setBounds(458, 234, 369, 207);
		contentPane.add(panel_Bowl);
		
		JLabel Bowl = new JLabel("");
		Image Img2 = new ImageIcon(this.getClass().getResource("CerealBowl1.PNG")).getImage();
		Bowl.setIcon((new ImageIcon(Img2)));
		Bowl.setBounds(458, 234, 369, 207);
		panel_Bowl.add(Bowl); */
		
		/*	JPanel panel_Spoon = new JPanel();
		panel_Spoon.setBackground(Color.WHITE);
		panel_Spoon.setBounds(1004, 441, 260, 229);
		contentPane.add(panel_Spoon);
		
		JLabel Spoon = new JLabel("");
		Image Img1 = new ImageIcon(this.getClass().getResource("Spoon1.PNG")).getImage();
		Spoon.setIcon((new ImageIcon(Img1)));
		panel_Spoon.setBounds(1004, 441, 260, 229);
		panel_Spoon.add(Spoon); */
		
		
		JLabel background = new JLabel("");
		background.setVerticalAlignment(SwingConstants.TOP);
		Image Img = new ImageIcon(this.getClass().getResource("MainDojo.png")).getImage();
		contentPane.setLayout(null);
		background.setIcon((new ImageIcon(Img)));
		background.setBounds(5, 5, 1264, 671);
		contentPane.add(background);
		

		

		JPanel panel_Logo = new JPanel();
		panel_Logo.setBounds(5, 5, 260, 229);
		contentPane.add(panel_Logo);
		
		JPanel panel_UserCards = new JPanel();
		panel_UserCards.setBounds(5, 441, 1000, 229);
		contentPane.add(panel_UserCards);
		
		panel_AiCards = new JPanel();
		panel_AiCards.setBounds(1259, 5, -994, 229);
		contentPane.add(panel_AiCards);
		

		
		
		JPanel panel_PlayerCard = new JPanel();
		panel_PlayerCard.setBounds(89, 234, 369, 207);
		contentPane.add(panel_PlayerCard);
		
		JPanel panel_AiCard = new JPanel();
		panel_AiCard.setBounds(827, 234, 369, 207);
		contentPane.add(panel_AiCard);
		
		JPanel panel_PlayerPoints = new JPanel();
		panel_PlayerPoints.setBounds(5, 234, 84, 207);
		contentPane.add(panel_PlayerPoints);
		
		JPanel panel_AiPoints = new JPanel();
		panel_AiPoints.setBounds(1195, 234, 69, 207);
		contentPane.add(panel_AiPoints);
		
		
		
	}
}
