package kelloggsDojo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OutputMessages {

	int counter = 0;

	public JPanel matchMessage(int result, int matchCounter) {

		JPanel messagePanel = new JPanel();
		messagePanel.setBackground(new Color(255, 255, 255));
		messagePanel.setBounds(228, 55, 730, 69);

		if (result == 0) // Player loses//
		{
			JLabel output = new JLabel("Point - King Kelloggs!");
			messagePanel.add(output);
			output.setFont(new Font("Arial", Font.PLAIN, 40));
		}

		else if (result == 1) // Player wins//
		{

			JLabel output = new JLabel("Point - Player!");
			messagePanel.add(output);
			output.setFont(new Font("Arial", Font.PLAIN, 50));

		}

		else if (result == 3) {
			if (matchCounter == 3 && counter == 0) {
				JLabel output = new JLabel("You Have Earned the Golden Spoon!");
				messagePanel.add(output);
				output.setFont(new Font("Arial", Font.PLAIN, 40));
				counter++;
			}

			else if (matchCounter == 6 && counter == 1) {
				JLabel output = new JLabel("You Have Earned the DIAMOND Spoon!");
				messagePanel.add(output);
				output.setFont(new Font("Arial", Font.PLAIN, 40));
				counter++;
			}

			else {
				JLabel output = new JLabel("Player has won a Match!");
				messagePanel.add(output);
				output.setFont(new Font("Arial", Font.PLAIN, 50));
			}
		}

		else // Assume tie//
		{
			JLabel output = new JLabel("Tie!");
			messagePanel.add(output);
			output.setFont(new Font("Arial", Font.PLAIN, 50));
		}

		return messagePanel;

	}

	public int count() {

		return counter;
	}

}