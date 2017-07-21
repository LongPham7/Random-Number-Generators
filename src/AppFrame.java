import java.awt.BorderLayout;

import javax.swing.JFrame;

public class AppFrame {

	private JFrame frame;
	private RNGPanel panelLehmer;
	private RNGPanel panelJava;
	
	public void activate() {
		frame = new JFrame("RNGs and Monte Carlo Test");
		panelLehmer = new LehmerPanel();
		panelLehmer.activate();
		panelJava = new JavaPanel();
		panelJava.activate();

		frame.getContentPane().add(BorderLayout.NORTH, panelLehmer);
		frame.getContentPane().add(BorderLayout.CENTER, panelJava);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
}
