import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class Pro1 extends JApplet implements ActionListener
{
	JTextField text;
	JLabel label;
	int target;
	Random ran = new Random();
	public void init()
	{
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		label = new JLabel("Guess a number between 1 and 1000:");
		container.add(label);
		text = new JTextField(10);
		text.addActionListener(this);
		container.add(text);
		target = ran.nextInt(1000) + 1;
	}
	public void actionPerformed(ActionEvent event)
	{
		int number = Integer.parseInt(text.getText());
		if (number < target)
		{
			showStatus("Too low. Try again.");
			text.setText("");
		}
		else if (number > target)
		{
			showStatus("Too high. Try again.");
			text.setText("");
		}
		else
		{
			showStatus("Congratulations. You guessed the number!!");
			text.setText("");
			target = ran.nextInt(1000) + 1;
		}
	}		
}