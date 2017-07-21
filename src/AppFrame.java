import java.awt.BorderLayout;

import javax.swing.JFrame;

public class AppFrame {

	private JFrame frame;
	private RNGPanel panel1;
	private RNGPanel panel2;
	
	public void activate() {
		frame = new JFrame("RNGs and Monte Carlo Test");
		panel1 = new LehmerPanel();
		panel1.activate();
		panel2 = new JavaPanel();
		panel2.activate();

		frame.getContentPane().add(BorderLayout.NORTH, panel1);
		frame.getContentPane().add(BorderLayout.CENTER, panel2);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
}
