import javax.swing.JOptionPane;
public class Case2
{
	public static int largest(int x, int y, int z)
	{
		int max = x;
		if (max < y)
			max = y;
		if (max < z);
			max = z;
		return max;
	}
	public static int smallest(int x, int y, int z)
	{
		int min = x;
		if (min > y)
			min = y;
		if (min > z)
			min = z;
		return min;
	}
	public static void main(String args[])
	{
		int x, y, z, max, min;
		String X, Y, Z;
		X = JOptionPane.showInputDialog("Enter the first number:");
		Y = JOptionPane.showInputDialog("Enter the second number:");
		Z = JOptionPane.showInputDialog("Enter the third number:");
		x = Integer.parseInt(X); y = Integer.parseInt(Y); z = Integer.parseInt(Z);
		max = Case2.largest(x, y, z);
		min = Case2.smallest(x, y, z);
		JOptionPane.showMessageDialog(null, "The largest number is " + max);
		JOptionPane.showMessageDialog(null, "The smallest number is " + min);
		System.exit(0);
	}
}