public class Way
{
	int max = 0;
	int []key = new int [2000];
	public int[][] max(int[] numbers, int amount)
	{
		int [][]sonNumbers = new int [amount][amount];
		sonNumbers[0][0] = numbers[0];
		int []longest = new int [amount];
		longest[0] = 1;
		int max = 1;
		for (int i = 1; i < amount; i++)
		{
			int temp = 0;
			for (int j = 0; j < i; j++)
			{
				if (numbers[i] > numbers[j] && temp < longest[j]) 
				{
					temp = longest[j];
					sonNumbers[i][j] = numbers[j];
				}
			}
			sonNumbers[i][i] = numbers[i];
			longest[i] = temp + 1;
		}	
		for (int i = 1; i < amount; i++)
		{
			if (max < longest[i])
			{
				max = longest[i];
				longest[i] = max;
			}
		}	
		this.key = longest;
		this.max = max;
		return sonNumbers;
	}
	
	public int getMax()//获得最长子序列的长度
	{
		return max;
	}
	
	public int getKey(int max)//获得输出子序列的关键码
	{
		int temp = 0;
		for (int i = 0; i < key.length; i++) 
		{
			if (max == key[i])
			{
				temp = i;				
			}
		}
		return temp;
	}
}