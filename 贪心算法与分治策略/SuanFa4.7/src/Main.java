import java.util.Scanner;
public class Main 
{
	public static void main(String[] args) 
	{
		int customer = 0, service = 0;
		double waitTime = 0;
		System.out.println("����һ���м����˿ͺ��м��������");
		Scanner sc1 = new Scanner(System.in);
		customer = sc1.nextInt();
		service = sc1.nextInt();
		int [] customerTime = new int [customer];
		System.out.println("����������˿�����ķ���ʱ��");
		Scanner sc2 = new Scanner(System.in);
		for (int i = 0; i < customer; i++)
		{
			customerTime[i] = sc2.nextInt();
		}
		Calculate ca = new Calculate();
		waitTime = ca.calculateField(customerTime, customer, service);
		System.out.println("ƽ���ȴ�ʱ������Ϊ�� " + waitTime);
	}
}