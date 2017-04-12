import java.awt.*;
import javax.swing.*;
class DrawPanel extends JPanel
{
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		int width = getWidth(), height = getHeight();
		for (int i = 0; i <= 15; i++)
			g.drawLine(0, height * i / 16, width / 16 * i, height);
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