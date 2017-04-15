import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class Pro1 extends JFrame implements ActionListener
{
	JTextField text1, text2;
	JLabel label1, label2;
	JButton tossButton;
	FlowLayout fl;
	Container container;
	int head = 0, tail = 0;
	public boolean flip()
	{
		Random ran = new Random();
		return (ran.nextInt(2) == 1);
	}
	public void actionPerformed(ActionEvent event)
	{
		boolean tossing = flip();
		if (tossing)
			head++;
		else
			tail++;
		text1.setText(Integer.toString(head));
		text2.setText(Integer.toString(tail));
	}
	public Pro1()
	{
		container = getContentPane();
		fl = new FlowLayout();
		container.setLayout(fl);
		label1 = new JLabel("Head:");
		container.add(label1);
		text1 = new JTextField(10);
		text1.setEditable(false);
		container.add(text1);
		label2 = new JLabel("Tail:");
		container.add(label2);
		text2 = new JTextField(10);
		text2.setEditable(false);
		container.add(text2);
		tossButton = new JButton("Toss");
		tossButton.addActionListener(this);
		container.add(tossButton);
	}
	public static void main(String[] args)
	{
		Pro1 p1 = new Pro1();
		p1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p1.setSize(600, 80);
		p1.setVisible(true);
	}
}