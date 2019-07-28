public class Calculate 
{
	public int calculateFee(int [][] feeDetail, int amount)
	{		
		int lastSumIndex = 0, minFeeSum = 0;
		int sumIndex = 0;
		int sumTotal = factorial(amount);
		int []feeSum = new int [sumTotal];	
		for (int i = 0; i < amount; i++)
		{
			feeSum[sumIndex] += feeDetail[0][i];
			lastSumIndex = sumIndex;
			sumIndex++;
			feeSum[sumIndex] += feeDetail[0][i];
			sumIndex = lastSumIndex;
			for (int j = 0; j < amount; j++) 
			{
				if (j == i)
				{
					continue;
				}
				else
				{
					feeSum[sumIndex] += feeDetail[1][j]; 
				}
				for (int k = 0; k < amount; k++) 
				{
					if (k == i || k == j)
					{
						continue;
					}
					else 
					{
						feeSum[sumIndex] += feeDetail[2][k];
						sumIndex++;
					}					
				}
			}	
		}	
		minFeeSum = feeSum[0];
		for (int i = 1; i < sumTotal; i++) 
		{
			if (feeSum[i] < minFeeSum)
			{
				minFeeSum = feeSum[i];
			}
		}
		System.out.print("所需费用共有" + sumTotal + "种可能性: ");
		for (int i = 0; i < sumTotal; i++)
		{

			System.out.print(feeSum[i] + " ");
		}			
		System.out.println();
		return minFeeSum;
	}
	
	private int factorial(int amount)
	{
		int sum = 1;
		for (int i = 1; i <= amount; i++) 
		{
			sum = sum * i; 
		}
		return sum;
	}
}