import java.util.Scanner;
public class Main 
{
	public static void main(String[] args)
	{
		int max = 0, key = 0;
		System.out.println("输入这串序列有多少个数");
		Scanner sc1 = new Scanner(System.in);
		int amount = sc1.nextInt();
		int [][] sumNumbers = new int [amount][amount];
		int []numbers = new int [amount];
		System.out.println("输入" + amount + "个数字");
		Scanner sc2 = new Scanner(System.in);
		for (int i = 0; i < amount; i++) 
		{
			numbers[i] = sc2.nextInt();
		}

		Way w = new Way();
		sumNumbers = w.max(numbers, amount);
		max = w.getMax();
		key = w.getKey(max);
		System.out.println(amount + "个数组成的序列的最长单调递增数子序列长度为 " + max);
		System.out.print("子序列为：   ");
		for (int i = 0; i < amount; i++)
		{
			if (sumNumbers[key][i] != 0)
			{
				System.out.print(sumNumbers[key][i] + " ");				
			}
		}
	}
}