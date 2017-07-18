import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Panel2 extends Panel
{
	private JLabel label7;
	private JLabel label8;
	private JLabel label9;
	private JLabel result2;
	
	private JTextField field4;
	private JTextField field5;
	
	private JButton button2;
	private JButton button4;
	
	public Panel2()
	{
		super();
	}
	
	public void go()
	{
		label7 = new JLabel("Java's pseudo RNG");
		label8 = new JLabel("Number of terms: ");
		label9 = new JLabel("Output: ");
		result2 = new JLabel("Result: ");
		
		field4 = new JTextField(15);
		field5 = new JTextField(15);
		
		button2 = new JButton("Test with unit square");
		button4 = new JButton("Draw a graph");
		
	    this.setLayout(new GridBagLayout());
	    panelAddComponent(label7,0,0,1);
	    panelAddComponent(label8,0,1,1);
	    panelAddComponent(field4,1,1,1);
	    panelAddComponent(label9,0,2,1);
	    panelAddComponent(field5,1,2,1);
	    panelAddComponent(button2,0,3,1);
	    panelAddComponent(result2,1,3,1);
	    panelAddComponent(button4,0,4,1);
	    
	    button2.addActionListener(new button2Listener());
	    button4.addActionListener(new button4Listener());
	}
	

    
    /*
     * This inner class implements an ActionListener of a button which displays
     * the result of unit-circle test on Java's pseudo RNG.
     */
    class button2Listener implements ActionListener
    {
    	public void actionPerformed(ActionEvent event)
    	{
    		try
    		{
    			displayResult();
    		}
    		catch(Exception e)
    		{
    			JOptionPane.showMessageDialog(null,"There is an error.","Error Message", JOptionPane.ERROR_MESSAGE);
    		}
    	}
    }
    
    protected void displayResult()
    {
    	int k = Integer.parseInt(field4.getText());
    	JavaRNG rng = new JavaRNG(k);
		double [] list2 = rng.output();
		double ratio = rng.ratio(list2);
		result2.setText("Result: "+4*ratio);
		field5.setText(Arrays.toString(list2));
    }
    
    /*
     * This inner class implements an ActionListener of a button that creates a
     * new window and that displays a graph of Java's pseudo RNG on the window.
     */
    class button4Listener implements ActionListener
    {
    	public void actionPerformed(ActionEvent event)
    	{
    		try
    		{
    			displayGraph();
    		}
    		catch(Exception ex)
    		{
    			JOptionPane.showMessageDialog(null,"There is an error.","Error Message", JOptionPane.ERROR_MESSAGE);
    		}
    	}
    }
    
    protected void displayGraph()
    {
        int k = Integer.parseInt(field4.getText());
        JavaRNG rng = new JavaRNG(k);
        double [] list2 = rng.output();
		
    	Frame2 frame2 = new Frame2(list2);
    	frame2.go2();
		frame2.setVisible(true);
    }
}
