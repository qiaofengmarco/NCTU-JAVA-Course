import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
class Turtle
{
	public int x = 0, y = 0;
	char direction;
}
public class Pro1 extends JFrame implements ActionListener
{
	JTextField text;
	JButton pen_up, pen_down, turn_right, turn_left, forward, display_map;
	Turtle t = new Turtle();
	Container container;
	int[][] map;
	public void actionPerformed(ActionEvent event)
	{
		if ((event.getSource() == pen_up) || (event.getSource() == pen_down))
		{
			t.x = 0;
			t.y = 0;
			t.direction = 'E';
			map[0][0] = 1;
			text.setEditable(false);
		}
		else if (event.getSource() == turn_left)
		{
			if (t.direction == 'E')
				t.direction = 'N';
			else if (t.direction == 'N')
				t.direction = 'W';
			else if (t.direction == 'W')
				t.direction = 'S';
			else 
				t.direction = 'E';
			text.setEditable(false);
		}
		else if (event.getSource() == turn_right)
		{
			if (t.direction == 'E')
				t.direction = 'S';
			else if (t.direction == 'S')
				t.direction = 'W';
			else if (t.direction == 'W')
				t.direction = 'N';
			else 
				t.direction = 'E';
			text.setEditable(false);			
		}
		else if (event.getSource() == forward)
		{
			text.setEditable(true);
		}
		else if (event.getSource() == text)
		{
			int walking = Integer.parseInt(text.getText()), newx = t.x, newy = t.y;
			text.setEditable(false);
			text.setText("");
			if (t.direction == 'E')
				newx += walking;
			else if (t.direction == 'W')
				newx -= walking;
			else if (t.direction == 'S')
				newy += walking;
			else
				newy -= walking;
			if ((newx >= 0) && (newx < 20) && (newy >= 0) && (newx < 20))
			{
				int minx = Math.min(newx, t.x), maxx = Math.max(newx, t.x), miny = Math.min(newy, t.y), maxy = Math.max(newy, t.y);
				for (int i = minx; i <= maxx; i++)
					for (int j = miny; j <= miny; j++)
						map[i][j] = 1;
				t.x = newx;
				t.y = newy;
			}
		}
		else 
		{
			for (int[] row : map)
			{
				for (int item : row)
					if (item == 1)
						System.out.printf("#");
					else
						System.out.printf(" ");
				System.out.println();
			}
		}
	}
	public Pro1()
	{
		container = getContentPane();
		container.setLayout(new FlowLayout());
		map = new int[20][];
		for (int i = 0; i < 20; i++)
			map[i] = new int[20];
		pen_up = new JButton("Pen up");
		pen_down = new JButton("Pen down");
		turn_right = new JButton("Turn right");
		turn_left = new JButton("Turn left");
		forward = new JButton("Forward");
		display_map = new JButton("Display");
		text = new JTextField(20);
		text.setEditable(false);
		pen_up.addActionListener(this);
		pen_down.addActionListener(this);
		turn_left.addActionListener(this);
		turn_right.addActionListener(this);
		forward.addActionListener(this);
		display_map.addActionListener(this);
		text.addActionListener(this);
		add(pen_up);
		add(pen_down);
		add(turn_left);
		add(turn_right);
		add(forward);
		add(turn_left);
		add(turn_right);
		add(forward);
		add(display_map);
		add(text, BorderLayout.SOUTH);
	}
	public static void main(String[] args)
	{
		Pro1 p1 = new Pro1();
		p1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p1.setSize(600, 130);
		p1.setVisible(true);
	}
}