import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Sierp extends JFrame implements ActionListener 
{  
	private JTextField text = new JTextField("0");
	private JButton button1, button2;
	private SierpPanel sp = new SierpPanel();
	private int order = 0;
	public Sierp() 
	{
		//sp.setPreferredSize(new Dimension(200, 200));
		JPanel p1 = new JPanel();
		text.setHorizontalAlignment(SwingConstants.RIGHT);
		text.setEditable(false);
		button1 = new JButton("+");
		button2 = new JButton("-");
		button1.addActionListener(this);
		button2.addActionListener(this);
		add(sp);
		p1.add(button2);
		p1.add(text);
		p1.add(button1);
		add(p1, BorderLayout.SOUTH);
	}
	public void actionPerformed(ActionEvent event)
	{
		if (event.getSource() == button1)
		{
			order++;
			text.setText(Integer.toString(order));
			sp.setOrder(order);
		}
		else
		{
			if (Integer.parseInt(text.getText()) > 1)
			{
				order--;
				text.setText(Integer.toString(order));
				sp.setOrder(order);				
			}
		}		
	}
	public static void main(String[] args)
	{
		
		Sierp p = new Sierp();
		p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p.setSize(600, 500);
		p.setVisible(true);
	}
}
class SierpPanel extends JPanel 
{
	private int order = 0;
	public void setOrder(int order)
	{ 
		this.order = order;
		repaint();  
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Point p1 = new Point(getWidth()/2, 10);
		Point p2 = new Point(10, getHeight()-10);
		Point p3 = new Point(getWidth()-10, getHeight()-10);
		display(g, order, p1, p2, p3);  
	}
	private void display(Graphics g, int order, Point p1, Point p2, Point p3)
	{
		if (order == 0)
		{
			g.drawLine(p1.x, p1.y, p2.x, p2.y);
			g.drawLine(p1.x, p1.y, p3.x, p3.y);
			g.drawLine(p2.x, p2.y, p3.x, p3.y); 
		}
		else 
		{
			Point p12 = midPoint(p1, p2);
			Point p23 = midPoint(p2, p3);
			Point p31 = midPoint(p3, p1);
			System.out.println("order="+order);
			display(g, order-1, p1, p12, p31);
			display(g, order-1, p12, p2, p23);
			display(g, order-1, p31, p23, p3); 
		}   
	}  
	private Point midPoint(Point p1, Point p2)
	{
		return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2); 
	}
}