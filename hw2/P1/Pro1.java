import java.util.Scanner;
public class Pro1
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int r, d;
		double c, a;
		System.out.printf("Enter the radius of the circle:");
		r = input.nextInt();
		d = 2 * r;
		c = 2 * Math.PI * r;
		a = Math.PI * r * r;
		System.out.printf("The diameter of the circle is %d.", d);
		System.out.println();
		System.out.printf("The circumference of the circle is %f.", c);
		System.out.println();
		System.out.printf("The area of the circle is %f.", a);
		System.out.println();
	}
}