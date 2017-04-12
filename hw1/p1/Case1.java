import javax.swing.JOptionPane;
public class Case1
{
	public static void main(String args[])
	{
		int x, y, z, max, min;
		String X, Y, Z;
		X = JOptionPane.showInputDialog("Enter the first number:");
		Y = JOptionPane.showInputDialog("Enter the second number:");
		Z = JOptionPane.showInputDialog("Enter the third number:");
		x = Integer.parseInt(X); y = Integer.parseInt(Y); z = Integer.parseInt(Z);
		if (x < y)
		{
			max = y;
			min = x;
		}
		else
		{
			max = x;
			min = y;
		}
		if (max < z)
			max = z;
		if (min > z)
			min = z;
		JOptionPane.showMessageDialog(null, "The largest number is " + max);
		JOptionPane.showMessageDialog(null, "The smallest number is " + min);
		System.exit(0);
	}
}