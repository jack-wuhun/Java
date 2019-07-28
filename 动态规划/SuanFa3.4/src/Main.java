import java.util.Scanner;
public class Main 
{
	public static void main(String[] args) 
	{		
		int goodsType, bagWeight, bagVolume, valueSum;
		System.out.println("请输入物品的种类数");
		Scanner sc1 = new Scanner(System.in);
		goodsType = sc1.nextInt();
		int [][]goodsDetail = new int [goodsType][3];//重要、体积、价值
		double [][]goodsQuality = new double[goodsType][2];//重量性价比   体积性价比
		int []goodsAmount = new int [goodsType];
		System.out.println("请输入背包的容量、容积");
		Scanner sc2 = new Scanner(System.in); 
		bagWeight = sc2.nextInt();
		bagVolume = sc2.nextInt();
		System.out.println("请分别输入这  " +goodsType + " 样物品的重量、体积、价值");
		Scanner sc3 = new Scanner(System.in);
		for (int i = 0; i < goodsType; i++) 
		{
			goodsDetail[i][0] = sc3.nextInt();
			goodsDetail[i][1] = sc3.nextInt();
			goodsDetail[i][2] = sc3.nextInt();
			goodsQuality[i][0] = (double)goodsDetail[i][2] / (double)goodsDetail[i][0];//重量性价比 
			goodsQuality[i][1] = goodsDetail[i][2] / goodsDetail[i][1];//体积性价比
		}
		Way w = new Way();
		w.Calculate(goodsDetail, goodsType,  goodsQuality, bagWeight, bagVolume);
		goodsAmount = w.getAmountData();
		valueSum = w.getValueSumData();	
		System.out.println("总物品价值为:" + valueSum);
		System.out.println("每种物品所需：   ");
		for (int i = 0; i < goodsType; i++) 
		{
			System.out.print(goodsAmount[i] + "  ");			
		}
	}
}