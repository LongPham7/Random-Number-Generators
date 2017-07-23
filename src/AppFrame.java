import java.awt.BorderLayout;
import javax.swing.JFrame;

/** 
 * This class creates the main frame that interacts with users. 
 * */
public class AppFrame {

	private JFrame frame;
	private RNGPanel panelLehmer;
	private RNGPanel panelJava;
	
	public void activate() {
		frame = new JFrame("RNGs and Monte Carlo Test");
		panelLehmer = new LinearCongruentialPanel();
		panelLehmer.activate();
		panelJava = new JavaPanel();
		panelJava.activate();

		frame.getContentPane().add(BorderLayout.NORTH, panelLehmer);
		frame.getContentPane().add(BorderLayout.CENTER, panelJava);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(430, 500);
		frame.setVisible(true);
	}
}
