import java.util.Scanner;
public class Main 
{
	public static void main(String[] args)
	{
		int parts = 0, supplier = 0, sumWeight = 0, limitedPrice = 0;
		System.out.println("����һ���м��������Լ��м�����ͬ�Ĺ�Ӧ�̣������ܼ۸񲻳�������");
		Scanner sc1 = new Scanner(System.in);
		parts = sc1.nextInt();
		supplier = sc1.nextInt();
		limitedPrice = sc1.nextInt();
		int []smallestPartsDetail = new int [parts];//���շ���Ҫ��Ĳ�������
		int []partsSupplier = new int [parts];//�����Ĺ�Ӧ��
		int [][]partDetail = new int[parts][supplier * 2];//0-suppier:�۸� suppier-2suppier:����
		System.out.println("�������Ӧ�̶Ը����������ļ۸��Լ�����");
		Scanner sc2 = new Scanner(System.in);
		for (int i = 0; i < supplier; i++)//����۸�
		{
			for (int j = 0; j < supplier; j++) 
			{
				partDetail[i][j] = sc2.nextInt();
			}
		}
		for (int i = 0; i < supplier; i++)//��������
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
		System.out.println("���յ�������Ϊ�� " + sumWeight);
		System.out.print("ѡ��ĸ����������ֱ�Ϊ�� ");
		for (int i = 0; i < parts; i++) 
		{
			System.out.print(smallestPartsDetail[i] + " ");	
		}
		System.out.println();
		System.out.print("ѡ�񲿼��Ĺ�Ӧ�̷ֱ�Ϊ�� ");
		for (int i = 0; i < parts; i++) 
		{
			System.out.print(partsSupplier[i] + 1 + " ");
		}
	}
}