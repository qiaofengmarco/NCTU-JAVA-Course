import java.util.Scanner;
import java.math.*;
public class Pro1
{
	public static void main(String[] args)
	{
		Scanner input =  new Scanner(System.in);
		String s1, r1;
		System.out.print("n = ");
		s1 = input.nextLine();
		BigInteger a = new BigInteger("1");
		BigInteger b = new BigInteger(s1);
		if (b.compareTo(BigInteger.ZERO) == 0)
			System.out.println("The factorial of n is 1");
		else
		{
			for (; b.compareTo(BigInteger.ONE) >= 0; b = b.subtract(BigInteger.ONE))
				a = a.multiply(b);
			r1 = a.toString();
			System.out.println("The factorial of n is " + r1);
		}
	}
}
		
		