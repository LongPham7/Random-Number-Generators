import javax.swing.*;

import java.awt.*;

public abstract class RNGPanel extends JPanel {
	
	// Default serial version UID
	private static final long serialVersionUID = 1L;

	protected GridBagConstraints c = new GridBagConstraints();

	public abstract void activate();

	protected abstract void displayResult();

	protected abstract void displayGraph();

	// Adds a specified component to this JPanel at a specified coordinate. 
	protected void panelAddComponent(Component component, int x, int y, int width) {
		c.fill = GridBagConstraints.BOTH;
		c.gridx = x;
		c.gridy = y;
		c.gridwidth = width;
		this.add(component, c);
	}
}
