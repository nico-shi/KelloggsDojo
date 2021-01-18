package kelloggsDojo;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SpoonBowlMethod {

	public JLabel setBowl(int matchCounter) {

		JLabel bowl = new JLabel("");

		if (matchCounter == 0 || matchCounter == 3 || matchCounter == 6) {
			Image Img40 = new ImageIcon(this.getClass().getResource("/Bowl3.png")).getImage();
			Image Img41 = Img40.getScaledInstance(600, 300, Image.SCALE_DEFAULT);
			bowl.setIcon((new ImageIcon(Img41)));
			bowl.setBounds(17, 0, 221, 200);

		}

		else if (matchCounter == 1 || matchCounter == 4 || matchCounter == 7) {
			Image Img40 = new ImageIcon(this.getClass().getResource("/Bowl2.png")).getImage();
			Image Img41 = Img40.getScaledInstance(600, 300, Image.SCALE_DEFAULT);
			bowl.setIcon((new ImageIcon(Img41)));
			bowl.setBounds(-178, -25, 398, 240);

		}

		else if (matchCounter == 2 || matchCounter == 5 || matchCounter == 8) {
			Image Img40 = new ImageIcon(this.getClass().getResource("/Bowl1.png")).getImage();
			Image Img41 = Img40.getScaledInstance(650, 300, Image.SCALE_DEFAULT);
			bowl.setIcon((new ImageIcon(Img41)));
			bowl.setBounds(-398, 6, 664, 240);

		}

		return bowl;

	}

	public JLabel setSpoon(int matchCounter) {

		JLabel spoon = new JLabel("");

		if (matchCounter < 3) {
			Image Img20 = new ImageIcon(this.getClass().getResource("/Spoon1.png")).getImage();
			Image Img21 = Img20.getScaledInstance(262, 193, Image.SCALE_DEFAULT);
			spoon.setIcon((new ImageIcon(Img21)));
			spoon.setBounds(-30, 479, 216, 199);
		}

		else if (matchCounter < 6) {
			Image Img20 = new ImageIcon(this.getClass().getResource("/Spoon2.png")).getImage();
			Image Img21 = Img20.getScaledInstance(327, 241, Image.SCALE_DEFAULT);
			spoon.setIcon((new ImageIcon(Img21)));
			spoon.setBounds(-48, 475, 225, 217);
		}

		else if (matchCounter < 9) {
			Image Img20 = new ImageIcon(this.getClass().getResource("/Spoon3.png")).getImage();
			Image Img21 = Img20.getScaledInstance(85, 195, Image.SCALE_DEFAULT);
			spoon.setIcon((new ImageIcon(Img21)));
			spoon.setBounds(50, 477, 128, 199);
		}

		return spoon;

	}

}
