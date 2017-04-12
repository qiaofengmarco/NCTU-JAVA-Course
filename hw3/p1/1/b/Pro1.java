import java.awt.*;
import javax.swing.*;
class DrawPanel extends JPanel
{
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		int width = getWidth(), height = getHeight();
		for (int i = 0; i <= 15; i++)
		{
			g.drawLine(0, 0, width - width / 16 * i, height / 16 * i);
			g.drawLine(width, height, width - width / 16 * (16 - i), height / 16 * (16 - i));  
			g.drawLine(width, 0, width * i / 16, height * i / 16);
			g.drawLine(0, height, width * (16 - i) / 16, height * (16 - i) / 16);
		}
	}
}
public class Pro1
{
	public static void main(String[] args)
	{
		JFrame jf = new JFrame();
		DrawPanel dp = new DrawPanel();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(dp);
		jf.setSize(500, 500);
		jf.setVisible(true);
	}
}