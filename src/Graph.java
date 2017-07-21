/* 
 * Class Description:
 *        This class is a subclass of JPanel that overrides method paintCOmponent()
 * in order to draw a specified graph. Points with coordinates (Ak,Ak+1), where Ak is
 * a certain element in a sequence and Ak+1 is the following element, are plotted
 * on the graph. It also contains abscissa and ordinate with appropriate intervals.
 *
 * Algorithm Description:
 *       The algorithm of plotting points for unit-circle test is the following:
 * points with coordinates (Ak,Ak+1), where Ak is a certain element in a sequence
 * and Ak+1 is the following element, are plotted on the graph. Thus the number of
 * points to be plotted is smaller than the total number of elements by 1. 
 */
import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Graph extends JPanel {
	
	// Default serial version UID
	private static final long serialVersionUID = 1L;

	/* Array that stores integral element in the output */
	private int[] sampleInt;

	/* Array that stores decimal element in the output */
	private double[] sampleDou;

	/* Specified radius of a circle */
	private int radius;

	@Override
	public void paintComponent(Graphics g1) {
		super.paintComponent(g1);

		Graphics2D g = (Graphics2D) g1;

		/*
		 * An optimized distance from the left edge of a window to the left edge of the
		 * graph
		 */
		final int WIDTH_HORIZONTAL = 100 + 5 * (Integer.toString(radius).length());

		/* Draw abscissa and ordinate */
		g.setColor(Color.black);
		g.drawLine(WIDTH_HORIZONTAL, 550, WIDTH_HORIZONTAL + 500, 550);
		g.drawLine(WIDTH_HORIZONTAL, 550, WIDTH_HORIZONTAL, 50);

		/* Draw scale bars for abscissa. */
		for (int i = 1; i != 11; i++) {
			g.drawLine(WIDTH_HORIZONTAL + 50 * i, 550, WIDTH_HORIZONTAL + 50 * i, 555);
		}

		/* Draw scale bar for ordinate. */
		for (int i = 1; i != 11; i++) {
			g.drawLine(WIDTH_HORIZONTAL - 5, 550 - 50 * i, WIDTH_HORIZONTAL, 550 - 50 * i);
		}

		/* If the radius is 1, array sampleDou is used. */
		if (radius == 1) {
			/* Label numbers for abscissa. */
			for (int i = 0; i != 11; i++) {
				String n = Double.toString(0.10 * i).substring(0, 3);
				g.drawString(n, WIDTH_HORIZONTAL - 5 + 50 * i, 575);
			}
			/* Label numbers for ordinate. */
			for (int i = 0; i != 11; i++) {
				String n = Double.toString(0.1 * i).substring(0, 3);
				g.drawString(n, WIDTH_HORIZONTAL - 25, 555 - 50 * i);
			}

			/* Plot points */
			for (int i = 0; i != sampleDou.length - 1; i++) {
				g.setColor(Color.blue);
				/* Find x-coordinate. */
				int x = WIDTH_HORIZONTAL + (int) (50 * sampleDou[i] * 10);
				/* Find y-coordinate. */
				int y = 550 - (int) Math.round(sampleDou[i + 1] * 50 * 10);

				/* Plot a point (a circle with radius of 5) on this point. */
				g.fillOval(x - 3, y - 3, 5, 5);
			}
		}
		/* If the radius is not 1, array sampleInt is used. */
		else {
			String n = Integer.toString(radius);
			String zero = "0";
			g.drawString(n, WIDTH_HORIZONTAL + 495, 575);
			g.drawString(n, WIDTH_HORIZONTAL - 45, 55);

			g.drawString(zero, WIDTH_HORIZONTAL - 5, 575);
			g.drawString(zero, WIDTH_HORIZONTAL - 45, 555);

			/* Plot points */
			for (int i = 0; i != sampleInt.length - 1; i++) {
				g.setColor(Color.blue);
				/* Find x-coordinate. */
				int x = WIDTH_HORIZONTAL + (int) (500.0 * sampleInt[i] / radius);
				/* Find y-coordinate. */
				int y = 550 - (int) Math.round(sampleInt[i + 1] * 500.0 / radius);

				/* Plot a point (a circle with radius of 5) on this point. */
				g.fillOval(x - 3, y - 3, 5, 5);
			}
		}

		g.setColor(Color.black);
		/* Set a font for axis labels. */
		g.setFont(new Font("Serif", Font.ITALIC, 13));
		/* Label abscissa titles. */
		g.drawString("Predecessor", 225 + WIDTH_HORIZONTAL, 600);
		/* Label ordinate titles. */
		g.drawString("Follower", 10, 300);

	}

	public void setSampleInt(int[] n) {
		sampleInt = n;
	}

	public void setSampleDou(double[] n) {
		sampleDou = n;
	}

	public void setRadius(int r) {
		radius = r;
	}

}
