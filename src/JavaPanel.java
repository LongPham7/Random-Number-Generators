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
	private JLabel label4;

	private JTextField field1;
	private JTextField field2;
	private JTextField field3;

	private JButton button;

	public void activate() {
		label1 = new JLabel("Java's pseudo RNG");
		label2 = new JLabel("Number of terms: ");
		label3 = new JLabel("Pseudo random numbers: ");
		label4 = new JLabel("Estimated quadrant area: ");

		field1 = new JTextField(15);
		field2 = new JTextField(15);
		field3 = new JTextField(15);

		button = new JButton("<html>" + "Generate numbers and \ndraw a graph".replaceAll("\\n", "<br>") + "</html>");

		this.setLayout(new GridBagLayout());
		panelAddComponent(label1, 0, 0, 1);
		panelAddComponent(label2, 0, 1, 1);
		panelAddComponent(field1, 1, 1, 1);
		panelAddComponent(button, 0, 2, 1);
		panelAddComponent(label3, 0, 3, 1);
		panelAddComponent(field2, 1, 3, 1);
		panelAddComponent(label4, 0, 4, 1);
		panelAddComponent(field3, 1, 4, 1);

		button.addActionListener(new buttonListener());
	}

	// Action listener for the button to calculate results and to display a graph
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
		int k = Integer.parseInt(field1.getText());
		JavaRNG rng = new JavaRNG(k);
		double[] list = rng.output();
		double ratio = rng.ratio(list);
		field3.setText(Double.toString(4 * ratio));
		field2.setText(Arrays.toString(list));

		GraphFrame graph = new GraphFrame(list);
		graph.activate();
		graph.setVisible(true);
	}
}
