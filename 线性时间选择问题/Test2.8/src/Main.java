import java.util.Scanner;
public class Main
{
	public static void main(String[] args)
	{
		System.out.println("�������鳤��");
		Scanner scan = new Scanner(System.in);
		int amount = scan.nextInt();
		
		System.out.println("������Ҫ���ҵڼ�С����");
		Scanner sca = new Scanner(System.in);
		int goal = sca.nextInt();
		
		int []data = new int [amount];
		System.out.println("����" + amount + "������Ԫ��");
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < amount; i++) 
		{
			int temp = sc.nextInt();
			data[i] = temp;
		}
		Way w = new Way();
		w.inPutData(amount, data);
		w.getGoal(goal);
	}
}