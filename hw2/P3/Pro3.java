import java.util.Scanner;
public class Pro3
{
	/*public Pro3()
	{
		a = new int[10010];
		b = new int[10010];
		c  = new int[10010];
	}*/
	public static double F(double x, int n, int[] a, int[] b, int[] c)
	{
		double ans = a[0] * x * x + b[0] * x + c[0], temp;
		for (int i = 1; i < n; i++)
		{
			temp = a[i] * x * x + b[i] * x + c[i];
			if (ans < temp)
				ans = temp; 
		}
		return ans;
	}
	public static void main(String[] args)
	{
		int T;
		int n;
		int [] a = new int[10010];
		int [] b = new int[10010];
		int [] c = new int[10010];
		Scanner input = new Scanner(System.in);
		T = input.nextInt();
		while (T > 0)
		{
			T--;
			n = input.nextInt();
			for (int i = 0; i < n; i++)
			{
				a[i] = input.nextInt();
				b[i] = input.nextInt();
				c[i] = input.nextInt();
			}
			double L = 0.0, R = 1000.0, m1, m2;
			for (int i = 0; i < 100; i++)
			{
				m1 = L + (R - L) / 3;
				m2 = R - (R - L) / 3;
				if (Pro3.F(m1, n, a, b, c) < Pro3.F(m2, n, a, b, c)) 
					R = m2;
				else L = m1;					
			}
			System.out.printf("The max is %.4f.", Pro3.F(L, n, a, b, c));
			System.out.println();
		}
	}
}