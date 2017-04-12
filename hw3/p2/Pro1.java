import java.util.Scanner;
public class Pro1
{
	public static void main(String[] args)
	{
		int n;
		double mindis, minx1 = 0, miny1 = 0, minx2 = 0, miny2 = 0;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of the point:");
		n = input.nextInt();
		double[] x = new double[n];
		double[] y = new double[n];
		for (int i = 0; i < n; i++)
		{
			x[i] = input.nextDouble();
			y[i] = input.nextDouble();
		}
		mindis = 1000000;
		double temp, tempx, tempy;
		for (int i = 0; i < n - 1; i++)
			for (int j = i + 1; j < n; j++)
			{
				tempx = Math.abs(x[i] - x[j]);
				tempy = Math.abs(y[i] - y[j]);
				temp = tempx * tempx + tempy * tempy;
				if (temp < mindis)
				{
					mindis = temp;
					minx1 = x[i];
					miny1 = y[i];
					minx2 = x[j];
					miny2 = y[j];
				}
			}
		System.out.printf("The closest points are (%.2f,%.2f) and (%.2f,%.2f).", minx1, miny1, minx2, miny2);		
	}
}