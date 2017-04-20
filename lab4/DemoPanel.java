import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.* ;
import javax.swing.event.*;

public class DemoPanel extends JPanel implements ActionListener
{
	private Image image;
	private JButton first,second;
	private JTextField text1, text2;
	private JPanel	myPanel;
	private DemoFrame frame;
	private String	path;
	private int i;
	public int t1 = 1, t2 = 2;
	public DemoPanel(int index, DemoFrame f)
	{
		text1 = new JTextField("1",10);
		text2 = new JTextField("2",10);
		first = new JButton("first");
		add(text1);
		first.addActionListener(this);
		add(first);
		second = new JButton("second");
		second.addActionListener(this);
		add(second);
		add(text2);
		frame = f;
		i = index;
	}
	public void paintComponent(Graphics g)
	{	
		//Random random = new Random();
		super.paintComponent(g);
		//int fileNum = random.nextInt(10);
		//Image image = new ImageIcon("images\\" + Integer.toString(fileNum) + ".jpg").getImage();
		Image image = new ImageIcon("images\\" + i + ".jpg").getImage();
		g.drawImage(image,0,0,getWidth(),getHeight(),null);
		//i = fileNum;
	}


//Handlers
//==================================================================================
//button
		public void actionPerformed(ActionEvent event)
		{
			if (event.getSource() == first)
			{
				if (frame.f)
					frame.closeFirst();
				else
				{
					t1 = 1;
					if (s1.equals(""))
						t1 = 1;
					else
						t1 = Integer.parseInt(s1);
					frame.addFirst();
				}
			}
			else if (event.getSource() == second)
			{
				if (frame.s)
					frame.closeSecond();
				else
				{
					t2 = 2;
					String s1 = text2.getText();
					if (s1.equals(""))
						t2 = 2;
					else
						t2 = Integer.parseInt(s1);
					frame.addSecond();
				}
			}
			else if (event.getSource() == text1)
			{
				t1 = 1;
				if (text1.getText().equals(""))
					t1 = 1;
				else
					t1 = Integer.parseInt(text1.getText());
			}
			else
			{
				t2 = 2;
				if (text2.getText().equals(""))
					t2 = 2;
				else
					t2 = Integer.parseInt(text2.getText());
			}
		}	
//==================================================================================		
}