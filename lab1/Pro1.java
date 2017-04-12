import java.awt.*;
import javax.swing.*;
import java.net.URL;
import javax.imageio.ImageIO;
import java.io.*;
public class Pro1 extends JApplet
{
	Integer x, y;
	public void init()
	{
		String X,Y;
		X = JOptionPane.showInputDialog("Enter the first number:");
		Y = JOptionPane.showInputDialog("Enter the second number:");
		x = Integer.parseInt(X);
		y = Integer.parseInt(Y);
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		if (x >= y)
			g.drawString("The JVM loads the class specified by ClassNmae and uses the class name to invoke method 'main'.", 25, 25);
		else
			g.drawString("The browser first creates an object of the Class, and then called init, start, paint, stop, destroy method in order.", 25, 25);
		try
		{
			URL pic = new URL(getDocumentBase(), "conan.jpg");
			Image image = ImageIO.read(pic);
			g.drawImage(image, 100, 100, this);		
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}	
	}
}