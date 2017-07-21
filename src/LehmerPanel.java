import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class LehmerPanel extends RNGPanel {

	// Default serial version UID
	private static final long serialVersionUID = 1L;

	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel result;

	private JButton button1;
	private JButton button2;

	private JTextField field1;
	private JTextField field2;
	private JTextField field3;

	private JComboBox<int[]> combo;

	private LehmerRNG lehmer;

	/*
	 * Array that stores a choice set of three constants in Lehmer's pseudo RNG in
	 * the order of {m,a,c}
	 */
	private final int[][] parameters = { { 6075, 106, 1283 }, { 7875, 211, 1663 }, { 7875, 421, 1663 },
			{ 11979, 430, 2513 }, { 6655, 936, 1399 }, { 6075, 1366, 1283 }, { 53125, 171, 11213 },
			{ 11979, 859, 2531 }, { 29282, 419, 6173 }, { 14406, 967, 3041 }, { 134456, 141, 28411 },
			{ 31104, 625, 6571 }, { 14000, 1541, 2957 }, { 12960, 1741, 2731 }, { 21870, 1291, 4621 },
			{ 139968, 205, 29573 }, { 81000, 421, 17117 }, { 29282, 1255, 6173 }, { 134456, 281, 28411 },
			{ 86436, 1093, 18257 }, { 259200, 421, 54773 } };

	public void activate() {
		label1 = new JLabel("Various Random Number Generators");
		label2 = new JLabel("Lehmer's RNG");
		label3 = new JLabel("{m, a, c}: ");
		label4 = new JLabel("Seed: ");
		label5 = new JLabel("Number of terms: ");
		label6 = new JLabel("Output: ");
		result = new JLabel("Result: ");

		button1 = new JButton("Test with unit square");
		button2 = new JButton("Draw a graph");

		field1 = new JTextField(15);
		field2 = new JTextField(15);
		field3 = new JTextField(15);

		combo = new JComboBox<int[]>(parameters);

		combo.setRenderer(new ListCellRenderer<int[]>() {

			private final JLabel label = new JLabel();

			@Override
			public Component getListCellRendererComponent(JList<? extends int[]> list, int[] value, int index,
					boolean isSelected, boolean cellHasFocus) {
				String[] convertedToString = new String[value.length];
				for (int i = 0; i != value.length; i++) {
					convertedToString[i] = Integer.toString(value[i]);
				}
				String result = String.join(", ", convertedToString);
				label.setText("{" + result + "}");
				return label;
			}
		});

		this.setLayout(new GridBagLayout());
		panelAddComponent(label1, 0, 0, 2);
		panelAddComponent(label2, 0, 1, 1);
		panelAddComponent(label3, 0, 2, 1);
		panelAddComponent(combo, 1, 2, 1);
		panelAddComponent(label4, 0, 3, 1);
		panelAddComponent(field1, 1, 3, 1);
		panelAddComponent(label5, 0, 4, 1);
		panelAddComponent(field2, 1, 4, 1);
		panelAddComponent(label6, 0, 5, 1);
		panelAddComponent(field3, 1, 5, 1);
		panelAddComponent(button1, 0, 6, 1);
		panelAddComponent(result, 1, 6, 1);
		panelAddComponent(button2, 0, 7, 1);

		button1.addActionListener(new button1Listener());
		button2.addActionListener(new button2Listener());
	}

	/*
	 * This inner class implements an ActionListener of a button which displays the
	 * result of unit-circle test on Lehmer's pseudo RNG.
	 */
	class button1Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				displayResult();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "There is an error.", "Error Message", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	protected void displayResult() {
		int k = Integer.parseInt(field2.getText());
		int seed = Integer.parseInt(field1.getText());
		int[] coefficients = (int[]) combo.getSelectedItem();
		int m = coefficients[0];
		int a = coefficients[1];
		int c = coefficients[2];

		lehmer = new LehmerRNG(k, seed, m, a, c);
		int[] list1 = lehmer.output();
		double Ratio = lehmer.ratio(list1);
		result.setText("Result: " + 4 * Ratio);
		field3.setText(Arrays.toString(list1));
	}

	/*
	 * This inner class implements an ActionListener of a button that creates a new
	 * window and that displays a graph of Lehmer's pseudo RNG on the window.
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
		int k = Integer.parseInt(field2.getText());
		int seed = Integer.parseInt(field1.getText());
		int[] coefficients = (int[])combo.getSelectedItem();
		int m = coefficients[0];
		int a = coefficients[1];
		int c = coefficients[2];

		lehmer = new LehmerRNG(k, seed, m, a, c);
		int[] list1 = lehmer.output();

		GraphFrame graph = new GraphFrame(list1, m);
		graph.activate();
		graph.setVisible(true);
	}
}
