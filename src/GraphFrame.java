import javax.swing.*;

import java.awt.*;

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

	/*
	 * This method creates a window for displaying the graph of Lehmer's pseudo RNG,
	 * which is created after the user clicks a button. This method then adds
	 * widgets to the window.
	 */
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
