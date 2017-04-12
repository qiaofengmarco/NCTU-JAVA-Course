import java.util.Scanner;
import java.math.*;
public class Pro1
{
	public static void main(String[] args)
	{
		String s1, s2, s3, s4, r1, r2, r3, r4, r5, r6, r7, r8;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter two BigIntegers:");
		System.out.print("a = ");
		s1 = input.nextLine();
		System.out.print("b = ");
		s2 = input.nextLine();
		BigInteger a = new BigInteger(s1);
		BigInteger b = new BigInteger(s2);
		BigInteger c, d, e, f;
		c = a.add(b);
		d = a.subtract(b);
		e = a.multiply(b);
		f = a.divide(b);
		r1 = c.toString();
		r2 = d.toString();
		r3 = e.toString();
		r4 = f.toString();
		System.out.println("a + b = " + r1);
		System.out.println("a - b = " + r2);
		System.out.println("a * b = " + r3);
		System.out.println("a / b = " + r4);
		System.out.println("Enter two BigDecimals:");
		System.out.print("a = ");
		s3 = input.nextLine();
		System.out.print("b = ");
		s4 = input.nextLine();
		BigDecimal g = new BigDecimal(s3);
		BigDecimal h = new BigDecimal(s4);
		BigDecimal i, j, k, l;
		i = g.add(h);
		j = g.subtract(h);
		k = g.multiply(h);
		l = g.divide(h);
		r5 = i.toString();
		r6 = j.toString();
		r7 = k.toString();
		r8 = l.toString();
		System.out.println("a + b = " + r5);
		System.out.println("a - b = " + r6);
		System.out.println("a * b = " + r7);
		System.out.println("a / b = " + r8);
	}
}
		