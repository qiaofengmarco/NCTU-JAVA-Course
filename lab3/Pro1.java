import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Pro1 extends JPanel implements MouseListener, MouseMotionListener
{
	int x1, y1, count, x2, y2, x3, y3;
	float thickness;
	Color c;
	public Pro1()
	{
		thickness = 4;
		addMouseListener(this);
		addMouseMotionListener(this);
		c = Color.BLACK;
		count = 0;
	}
	
	//MouseListener
	public void mousePressed(MouseEvent event)
	{
		x1 = event.getX();
		y1 = event.getY();
	}
	public void mouseReleased(MouseEvent event)
	{
	}
    public void mouseClicked(MouseEvent event)
	{
		int x = event.getX(), y = event.getY();
		Graphics g = getGraphics();
		Graphics2D g2 = (Graphics2D) g;
		if ((x >= 10) && (x <= 30) && (y >= 10) && (y <= 30)) 
		{
			thickness = 4;
			c = Color.BLACK;
		}
		else if ((x >= 40) && (x <= 60) && (y >= 10) && (y <= 30)) 
		{
			if ((thickness <= 24.0) && (c == Color.BLACK))
				thickness += 4;
		}
		else if ((x >= 70) && (x <= 90) && (y >= 10) && (y <= 30))
		{
			if ((thickness <= 24.0) && (c == g2.getBackground()))
				thickness += 4;
		}
		else if ((x >= 100) && (x <= 120) && (y >= 10) && (y <= 30))
		{
			thickness = 4;
			c = g2.getBackground();
		}
		else
		{
			if (event.getButton() == MouseEvent.BUTTON1)
			{
				g2.setColor(c);
				g2.setStroke(new BasicStroke(thickness, BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));	
				g2.drawLine(x,y,x,y);
			}
			else if (event.getButton() == MouseEvent.BUTTON3)
			{	
				count++;
				if (count == 1)
				{
					x2 = x;
					y2 = y;
					System.out.printf("first, (%d, %d)\n", x2, y2);
				}
				else if (count == 2)
				{
					x3 = x;
					y3 = y;	
					System.out.printf("Second, (%d, %d)\n", x3, y3);
				}
				else if (count == 3)
				{
					count = 0;
					int x_temp, y_temp;
					x_temp = Math.min(x2, x3);
					y_temp = Math.min(y2, y3);
					System.out.printf("Third, (%d, %d)\n", x_temp, y_temp);					
					g2.copyArea(x_temp, y_temp, Math.abs(x2 - x3), Math.abs(y2 - y3), x - x_temp, y - y_temp);
					x2 = 0;
					y2 = 0;
					x3 = 0;
					y3 = 0;
				}
			}
		}
	}
    public void mouseEntered(MouseEvent event){}
	public void mouseExited(MouseEvent event){}
	
	//MouseMotionListener
	public void mouseDragged( MouseEvent event )
	{
		int x = event.getX(), y = event.getY();
		Graphics g = getGraphics();
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(c);
		g2.setStroke(new BasicStroke(thickness, BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));		
		g2.drawLine(x1, y1, x, y);
		x1 = x;
		y1 = y;
	}
    public void mouseMoved( MouseEvent event ){}

    public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(10, 10, 20, 20);
		g.drawRect(40, 10, 20, 20);
		g.fillArc(40, 10, 20, 20, 0, 360);
		g.drawRect(70, 10, 20, 20);
		g.drawArc(70, 10, 20, 20, 0, 360);
		g.drawRect(100, 10, 20, 20);	
    }
	public static void main(String[] args)
	{
		JFrame jf = new JFrame();
		Pro1 p1 = new Pro1();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(p1);
		jf.setSize(600, 600);
		jf.setVisible(true);
	}
}