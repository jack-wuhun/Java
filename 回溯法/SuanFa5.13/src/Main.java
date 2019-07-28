import java.util.Scanner;
public class Main 
{
	public static void main(String[] args) 
	{		
		int minFeeSum;
		System.out.println("请输入共有n件工作以及共有n个工人");
		Scanner sc1 = new Scanner(System.in);
		int amount = sc1.nextInt();
		int [][] workerDetail = new int[amount][amount];
		System.out.println("请输入各工作分配给个工人所需的费用");
		Scanner sc2 = new Scanner(System.in);
		for (int i = 0; i < amount; i++)
		{
			for (int j = 0; j < amount; j++) 
			{
				workerDetail[i][j] = sc2.nextInt();				
			}
		}
		Calculate ca = new Calculate();
		minFeeSum = ca.calculateFee(workerDetail, amount);
		System.out.println("由此可见，最低所需费用为： " + minFeeSum);
	}
}