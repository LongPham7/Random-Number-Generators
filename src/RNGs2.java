import javax.swing.*;

import java.awt.*;

public class RNGs2 
{
	private JFrame frame;
	
	private Panel1 panel1;
	private Panel2 panel2;
	
	/*
	 * This method is executed in the beginning of the programming, creating an object
	 * of this class.
	 */
	public static void main(String[] args)
	{
		RNGs2 gui = new RNGs2();
		gui.go();
	}
	
	/*
	 * This method creates the main window and adds widgets to it.
	 */
	public void go()
	{
		frame = new JFrame("RNGs and Monte Carlo Test");
		panel1 = new Panel1();
		((Panel1)panel1).go();
		panel2 = new Panel2();
		((Panel2)panel2).go();
		
		frame.getContentPane().add(BorderLayout.NORTH, panel1);
		frame.getContentPane().add(BorderLayout.CENTER, panel2);
	    
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(500,500);
	    frame.setVisible(true);
	}
    
}
