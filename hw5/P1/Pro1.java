import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
public class Pro1 extends JFrame implements ActionListener
{
	private JTextField text;
	private JLabel label;
	Container container;
	public void actionPerformed(ActionEvent event)
	{
		int size = Integer.parseInt(text.getText());
		int[][] pascal;
		if (size > 0)
		{
			pascal = new int[size][];
			//只能用enhanced for的方法來取值，但是不能用來new！否則會報error
			for (int i = 0; i < size; i++)
			{
				pascal[i] = new int[i + 1];
				for (int j = 0; j <= i; j++)
				{
					if ((j == 0) || (j == i))
						pascal[i][j] = 1;
					else
						pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
				}
			}
			for (int[] row : pascal)
			{
				for (int item : row)
					System.out.printf("%d ", item);
				System.out.println();
			}
		}
	}
	public Pro1()
	{
		container = getContentPane();
		container.setLayout(new FlowLayout());
		text = new JTextField(10);
		text.addActionListener(this);
		label = new JLabel("Enter the size of the Pascal Triangle:");
		add(label);
		add(text);
	}
	public static void main(String args[])
	{ 
		Pro1 p1 = new Pro1();
		p1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p1.setSize(600, 80);
		p1.setVisible(true);
	}
}