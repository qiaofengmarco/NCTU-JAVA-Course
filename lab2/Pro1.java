import java.awt.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.Color;
public class Pro1 extends JPanel
{
	public int radius, shape;
	JFrame jf;
	public Pro1()
	{
		radius = (int)(Math.random()*130) + 20;
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		int wid = super.getWidth() / 2, h = jf.getHeight() / 2;
		Point pt = SwingUtilities.convertPoint(jf, wid, h, this);
		if (shape == 1)
		{
			g.setColor(new Color((int)(Math.random()*255), (int)(Math.random()*250) + 5, (int)(Math.random()*245) + 10));
			g.fillOval(pt.x - radius, pt.y - radius, 2 * radius, 2 * radius);
		}
		else
		{
			g.setColor(new Color((int)(Math.random()*255), (int)(Math.random()*250) + 5, (int)(Math.random()*245) + 10));
			g.fillRect(pt.x - radius, pt.y - radius, 2 * radius, 2 * radius); 
		}
	}
	public static void main(String[] args)
	{
		Pro1 p = new Pro1();
		JFrame w = new JFrame();
		int shape;
		Scanner input = new Scanner(System.in);
		System.out.print("Select the shape(1 for circle):");
		shape = input.nextInt();
		p.shape = shape;
		p.jf = w;
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.add(p);
		w.setSize(600,600);
		w.setVisible(true);		
	}
}