import javax.swing.*;

import java.awt.*;

public class RandomNumberGeneraotrs {
	
	private JFrame frame;

	private Panel panel1;
	private Panel panel2;

	public static void main(String[] args) {
		RandomNumberGeneraotrs gui = new RandomNumberGeneraotrs();
		gui.activate();
	}

	public void activate() {
		frame = new JFrame("RNGs and Monte Carlo Test");
		panel1 = new Panel1();
		panel1.activate();
		panel2 = new Panel2();
		panel2.activate();

		frame.getContentPane().add(BorderLayout.NORTH, panel1);
		frame.getContentPane().add(BorderLayout.CENTER, panel2);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
}
