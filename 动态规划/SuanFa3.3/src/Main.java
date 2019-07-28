import java.util.Scanner;
public class Main 
{
	public static void main(String[] args) 
	{	
		int bagLimited = 0, goodsType = 0, valueSum = 0;
		System.out.println("输入共有几种物品以及背包的容量限制");
		Scanner sc1 = new Scanner(System.in);
		goodsType = sc1.nextInt();
		bagLimited = sc1.nextInt();
		int []goodsAmount = new int [goodsType];
		double [][]goodsDetail = new double[goodsType][3];//Weight Value valueQuality
		System.out.println("请输入各物品的重量和物品价值");
		sc1 =new Scanner(System.in);
		for (int i = 0; i < goodsType; i++) 
		{
			for (int j = 0; j < 2; j++)
			{
				goodsDetail[i][j] = sc1.nextInt();
			}
			goodsDetail[i][2] = (goodsDetail[i][1] / goodsDetail[i][0]);
		}	
		Way w = new Way();
		w.calculate(goodsDetail, bagLimited, goodsType);
		goodsAmount = w.getAmountData();
		valueSum = w.getValueSumData();	
		System.out.println("总物品价值为：   " + valueSum);
		System.out.println("每种物品所需：   ");
		for (int i = 0; i < goodsType; i++) 
		{
			System.out.print(goodsAmount[i] + "  ");			
		}
	}
}