import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class JavaPanel extends RNGPanel {
	
	// Default serial version UID
	private static final long serialVersionUID = 1L;
	
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel result;

	private JTextField field1;
	private JTextField field2;

	private JButton button1;
	private JButton button2;

	public void activate() {
		label1 = new JLabel("Java's pseudo RNG");
		label2 = new JLabel("Number of terms: ");
		label3 = new JLabel("Output: ");
		result = new JLabel("Result: ");

		field1 = new JTextField(15);
		field2 = new JTextField(15);

		button1 = new JButton("Test with unit square");
		button2 = new JButton("Draw a graph");

		this.setLayout(new GridBagLayout());
		panelAddComponent(label1, 0, 0, 1);
		panelAddComponent(label2, 0, 1, 1);
		panelAddComponent(field1, 1, 1, 1);
		panelAddComponent(label3, 0, 2, 1);
		panelAddComponent(field2, 1, 2, 1);
		panelAddComponent(button1, 0, 3, 1);
		panelAddComponent(result, 1, 3, 1);
		panelAddComponent(button2, 0, 4, 1);

		button1.addActionListener(new button1Listener());
		button2.addActionListener(new button2Listener());
	}

	/*
	 * This inner class implements an ActionListener of a button which displays the
	 * result of unit-circle test on Java's pseudo RNG.
	 */
	class button1Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				displayResult();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "There is an error.", "Error Message", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	protected void displayResult() {
		int k = Integer.parseInt(field1.getText());
		JavaRNG rng = new JavaRNG(k);
		double[] list2 = rng.output();
		double ratio = rng.ratio(list2);
		result.setText("Result: " + 4 * ratio);
		field2.setText(Arrays.toString(list2));
	}

	/*
	 * This inner class implements an ActionListener of a button that creates a new
	 * window and that displays a graph of Java's pseudo RNG on the window.
	 */
	class button2Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				displayGraph();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "There is an error.", "Error Message", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	protected void displayGraph() {
		int k = Integer.parseInt(field1.getText());
		JavaRNG rng = new JavaRNG(k);
		double[] list2 = rng.output();

		Frame2 frame2 = new Frame2(list2);
		frame2.go2();
		frame2.setVisible(true);
	}
}
