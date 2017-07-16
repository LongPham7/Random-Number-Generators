package RNGs2;

import javax.swing.*;

import java.awt.*;

public abstract class Panel extends JPanel
{
	protected GridBagConstraints c;
	
	public Panel()
	{
		c = new GridBagConstraints();
	}
	
	public abstract void go();
	protected abstract void displayResult();
	protected abstract void displayGraph();
	
	/*
	 * This method adds a specified component to a specified JPanel in a
	 * specified position. The layout is GridBagLayout. 
	 * @param component:   component to be added
	 *        panel:       specified JPanel
	 *        x:           abscissa-coordinate of the component
	 *        y:           ordinate-coordinate of the component
	 *        width:       width of the component
	 */
    protected void panelAddComponent(Component component,int x, int y, int width)
    {
    	  c.fill = GridBagConstraints.BOTH;
      	  c.gridx = x;
      	  c.gridy = y;
      	  c.gridwidth = width;
      	  this.add(component,c);
    }
	
}
