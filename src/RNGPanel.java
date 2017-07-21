import javax.swing.*;

import java.awt.*;

/**
 * Abstract class for panels where users can specify parameters to be used by
 * an RNG to generate pseudo random numbers
 */
public abstract class RNGPanel extends JPanel {

	// Default serial version UID
	private static final long serialVersionUID = 1L;

	protected GridBagConstraints c = new GridBagConstraints();

	// Creates GUI components
	public abstract void activate();

	// Displays the pseudo random number generated and their graph. 
	protected abstract void displayResultsandGraph();

	// Adds a given component to this JPanel at a specified coordinate.
	protected void panelAddComponent(Component component, int x, int y, int width) {
		c.fill = GridBagConstraints.BOTH;
		c.gridx = x;
		c.gridy = y;
		c.gridwidth = width;
		this.add(component, c);
	}
}
