import java.util.Scanner;
public class Main 
{
	public static void main(String[] args) 
	{		
		int goodsType, bagWeight, bagVolume, valueSum;
		System.out.println("��������Ʒ��������");
		Scanner sc1 = new Scanner(System.in);
		goodsType = sc1.nextInt();
		int [][]goodsDetail = new int [goodsType][3];//��Ҫ���������ֵ
		double [][]goodsQuality = new double[goodsType][2];//�����Լ۱�   ����Լ۱�
		int []goodsAmount = new int [goodsType];
		System.out.println("�����뱳�����������ݻ�");
		Scanner sc2 = new Scanner(System.in); 
		bagWeight = sc2.nextInt();
		bagVolume = sc2.nextInt();
		System.out.println("��ֱ�������  " +goodsType + " ����Ʒ���������������ֵ");
		Scanner sc3 = new Scanner(System.in);
		for (int i = 0; i < goodsType; i++) 
		{
			goodsDetail[i][0] = sc3.nextInt();
			goodsDetail[i][1] = sc3.nextInt();
			goodsDetail[i][2] = sc3.nextInt();
			goodsQuality[i][0] = (double)goodsDetail[i][2] / (double)goodsDetail[i][0];//�����Լ۱� 
			goodsQuality[i][1] = goodsDetail[i][2] / goodsDetail[i][1];//����Լ۱�
		}
		Way w = new Way();
		w.Calculate(goodsDetail, goodsType,  goodsQuality, bagWeight, bagVolume);
		goodsAmount = w.getAmountData();
		valueSum = w.getValueSumData();	
		System.out.println("����Ʒ��ֵΪ:" + valueSum);
		System.out.println("ÿ����Ʒ���裺   ");
		for (int i = 0; i < goodsType; i++) 
		{
			System.out.print(goodsAmount[i] + "  ");			
		}
	}
}