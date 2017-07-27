import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class LinearCongruentialPanel extends RNGPanel {

	// Default serial version UID
	private static final long serialVersionUID = 1L;

	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;

	private JButton button;

	private JTextField field1;
	private JTextField field2;
	private JTextField field3;
	private JTextField field4;

	private JComboBox<int[]> combo;

	private LinearCongruentialRNG lehmer;

	// Array of parameters {m, a, c} in Lehmer's pseudo RNG
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
		label6 = new JLabel("Pseudo random numbers: ");
		label7 = new JLabel("Estimated quadrant area: ");

		button = new JButton("<html>" + "Generate numbers and \ndraw a graph".replaceAll("\\n", "<br>") + "</html>");

		field1 = new JTextField(15);
		field2 = new JTextField(15);
		field3 = new JTextField(15);
		field4 = new JTextField(15);

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
		panelAddComponent(button, 0, 5, 1);
		panelAddComponent(label6, 0, 6, 1);
		panelAddComponent(field3, 1, 6, 1);
		panelAddComponent(label7, 0, 7, 1);
		panelAddComponent(field4, 1, 7, 1);

		button.addActionListener(new buttonListener());
	}

	// Action listener for a button to display results and a graph
	class buttonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				displayResultsandGraph();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Error", "Error Message", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	protected void displayResultsandGraph() {
		int k = Integer.parseInt(field2.getText());
		int seed = Integer.parseInt(field1.getText());
		int[] coefficients = (int[]) combo.getSelectedItem();
		int m = coefficients[0];
		int a = coefficients[1];
		int c = coefficients[2];

		lehmer = new LinearCongruentialRNG(k, seed, m, a, c);
		int[] list = lehmer.output();
		double ratio = lehmer.ratio(list);
		field3.setText(Arrays.toString(list));
		field4.setText(Double.toString(4 * ratio));

		GraphFrame graph = new GraphFrame(list, m);
		graph.activate();
		graph.setVisible(true);
	}
}
