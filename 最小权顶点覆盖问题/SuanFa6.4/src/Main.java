import java.util.Scanner;
public class Main 
{
	public static void main(String[] args)
	{
		int parts = 0, supplier = 0, sumWeight = 0, limitedPrice = 0;
		System.out.println("输入一共有几个部件以及有几个不同的供应商，并且总价格不超过多少");
		Scanner sc1 = new Scanner(System.in);
		parts = sc1.nextInt();
		supplier = sc1.nextInt();
		limitedPrice = sc1.nextInt();
		int []smallestPartsDetail = new int [parts];//最终符合要求的部件重量
		int []partsSupplier = new int [parts];//部件的供应商
		int [][]partDetail = new int[parts][supplier * 2];//0-suppier:价格 suppier-2suppier:重量
		System.out.println("输入各供应商对各部件给出的价格以及重量");
		Scanner sc2 = new Scanner(System.in);
		for (int i = 0; i < supplier; i++)//输入价格
		{
			for (int j = 0; j < supplier; j++) 
			{
				partDetail[i][j] = sc2.nextInt();
			}
		}
		for (int i = 0; i < supplier; i++)//输入重量
		{
			for (int j = supplier; j < supplier * 2; j++) 
			{
				partDetail[i][j] = sc2.nextInt();
			}
		}
		Calculate ca = new Calculate();
		sumWeight = ca.calculateParts(partDetail, parts, limitedPrice);
		smallestPartsDetail = ca.getSmallestWeight();
		partsSupplier = ca.getPartsSupplier();
		System.out.println("最终的总重量为： " + sumWeight);
		System.out.print("选择的各部件重量分别为： ");
		for (int i = 0; i < parts; i++) 
		{
			System.out.print(smallestPartsDetail[i] + " ");	
		}
		System.out.println();
		System.out.print("选择部件的供应商分别为： ");
		for (int i = 0; i < parts; i++) 
		{
			System.out.print(partsSupplier[i] + 1 + " ");
		}
	}
}