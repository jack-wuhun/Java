import java.util.Scanner;
public class Main 
{
	public static void main(String[] args) 
	{		
		int minFeeSum;
		System.out.println("�����빲��n�������Լ�����n������");
		Scanner sc1 = new Scanner(System.in);
		int amount = sc1.nextInt();
		int [][] workerDetail = new int[amount][amount];
		System.out.println("��������������������������ķ���");
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
		System.out.println("�ɴ˿ɼ�������������Ϊ�� " + minFeeSum);
	}
}