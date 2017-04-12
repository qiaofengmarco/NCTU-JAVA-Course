import javax.swing.JOptionPane;
public class Pro3
{
	public static void main(String args[])
	{
		String a, b;
		a = JOptionPane.showInputDialog("Enter a file name:");
		CharSequence c = a.subSequence(0, a.length());
		for (int i = a.length() - 1; i >= 0; i--)
			if (c.charAt(i) == '.')
			{
				b = a.substring(i + 1, a.length());
				JOptionPane.showMessageDialog(null, "The extension is " + b);
				break;
			}
		System.exit(0);	
	}
}