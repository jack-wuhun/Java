import java.util.Scanner;
public class Main 
{
	public static void main(String[] args) 
	{	
		int bagLimited = 0, goodsType = 0, valueSum = 0;
		System.out.println("���빲�м�����Ʒ�Լ���������������");
		Scanner sc1 = new Scanner(System.in);
		goodsType = sc1.nextInt();
		bagLimited = sc1.nextInt();
		int []goodsAmount = new int [goodsType];
		double [][]goodsDetail = new double[goodsType][3];//Weight Value valueQuality
		System.out.println("���������Ʒ����������Ʒ��ֵ");
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
		System.out.println("����Ʒ��ֵΪ��   " + valueSum);
		System.out.println("ÿ����Ʒ���裺   ");
		for (int i = 0; i < goodsType; i++) 
		{
			System.out.print(goodsAmount[i] + "  ");			
		}
	}
}