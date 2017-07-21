import javax.swing.*;

import java.awt.*;

/** 
 * This class corresponds to a view in the MVC architecture. 
 * */
public class GraphFrame extends JFrame {

	// Default serial version UID
	private static final long serialVersionUID = 1L;

	private int[] inputInt;
	private double[] inputDou;
	private int radius;

	public GraphFrame(int[] n, int r) {
		super("Graph of Lehmer's RNG");
		inputInt = n;
		radius = r;
	}

	public GraphFrame(double[] n) {
		super("Graph of Lehmer's RNG");
		inputDou = n;
		radius = 1;
	}

	// Creates GUI components for a frame where a graph is displayed. 
	public void activate() {
		GraphPanel graph = new GraphPanel();
		if (radius == 1) {
			graph.setSampleDou(inputDou);
		} else {
			graph.setSampleInt(inputInt);
		}
		graph.setRadius(radius);
		this.getContentPane().add(BorderLayout.CENTER, graph);
		graph.repaint();

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(700, 700);
	}
}
