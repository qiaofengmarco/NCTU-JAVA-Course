import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.* ;
import javax.swing.event.*;

public class DemoFrame extends JFrame
{
	private JFrame frame1,frame2;
	private DemoPanel panel1,panel2,myPanel;
	public boolean f,s;
	public DemoFrame()
	{
		myPanel = new DemoPanel(1, this);
		add(myPanel);
	}
	public void closeFirst()
	{
		frame1.setVisible(false);
		f = false;
		frame1.dispose();
	}
	public void closeSecond()
	{
		frame2.setVisible(false);
		s = false;
		frame2.dispose();
	}
	public void addFirst()
	{
		frame1 = new JFrame();
		panel1 = new DemoPanel(myPanel.t1 % 10, this);
		f = true;
		frame1.add(panel1);
		frame1.setSize(600,500);
		frame1.setVisible(true);
	}
	public void addSecond()
	{
		frame2 = new JFrame();
		panel2 = new DemoPanel(myPanel.t2 % 10, this);
		s = true;
		frame2.add(panel2);
		frame2.setSize(600,500);
		frame2.setVisible(true);
	}
//==================================================================================
}

