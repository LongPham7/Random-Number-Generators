import javax.swing.*;

import java.awt.*;

public class Frame2 extends JFrame {
	private int[] inputInt;
	private double[] inputDou;
	private int radius;

	public Frame2(int[] n, int r) {
		super("Graph of Lehmer's RNG");
		inputInt = n;
		radius = r;
	}

	public Frame2(double[] n) {
		super("Graph of Lehmer's RNG");
		inputDou = n;
		radius = 1;
	}

	/*
	 * This method creates a window for displaying the graph of Lehmer's pseudo RNG,
	 * which is created after the user clicks a button. This method then adds
	 * widgets to the window.
	 */
	public void go2() {
		Graph graph = new Graph();
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
