import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class Pro1 extends JFrame implements ActionListener
{
	JTextField text;
	JButton button1, button2;
	Container container;
	public void actionPerformed(ActionEvent event)
	{
		if (event.getSource() == button1)
			text.setText(text.getText().toUpperCase());
		else
			text.setText(text.getText().toLowerCase());
	}
	public Pro1()
	{
		container = getContentPane();
		container.setLayout(new FlowLayout());
		text = new JTextField(30);
		container.add(text);
		button1 = new JButton("uppercase");
		button2 = new JButton("lowercase");
		button1.addActionListener(this);
		button2.addActionListener(this);
		container.add(button1);
		container.add(button2);
	}
	public static void main(String[] args)
	{
		Pro1 p1 = new Pro1();
		p1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p1.setSize(600, 80);
		p1.setVisible(true);
	}
}