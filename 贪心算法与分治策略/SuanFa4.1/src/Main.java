import java.util.Scanner;
public class Main
{
	public static void main(String[] args)
	{
		int field = 0, amount = 0;
		System.out.println("����һ���м����");
		Scanner sc1 = new Scanner(System.in);
		field = sc1.nextInt();
		int [][] activeTime = new int [field][2];
		System.out.println("�����������Ŀ�ʼʱ���Լ�����ʱ��");
		Scanner sc2 = new Scanner(System.in);
		for (int i = 0; i < field; i++)
		{
			activeTime[i][0] = sc2.nextInt();
			activeTime[i][1] = sc2.nextInt();
		}
		Calculate ca = new Calculate();
		amount = ca.calculateField(activeTime, field);
		System.out.println("�᳡����Ϊ��   " + amount);
	}
}