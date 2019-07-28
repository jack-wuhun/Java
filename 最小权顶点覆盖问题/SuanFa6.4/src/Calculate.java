public class Calculate 
{
	int []smallestPartsDetail;
	int []partsSupplier;
	int key = 0;
	public int calculateParts(int [][]partDetail, int parts, int limitedPrice)
	{
		int [][]weightSumDetail = new int[factorial(parts)][parts + 1];
		int [][]priceSumDetail = new int[factorial(parts)][parts + 1];
		int [][]supplierDetail = new int[factorial(parts)][parts];
		int index = 0, minWeightSum = 0;
		smallestPartsDetail = new int [parts];	
		partsSupplier = new int [parts];
		for (int i = 0; i < parts; i++)
		{
			for (int j = 0; j < parts * parts; j++)
			{
				weightSumDetail[index][0] = partDetail[0][i + 3];
				priceSumDetail[index][0] = partDetail[0][i];
				supplierDetail[index][0] = i;
				index++;
			}	
		}
		index = 0;
		
		for (int i = 0; i < parts; i++)
		{
			for (int j = 0; j < parts; j++) 
			{
				for (int k = 0; k < parts; k++) 
				{					
					weightSumDetail[index][1] = partDetail[1][j + 3];
					priceSumDetail[index][1] = partDetail[1][j];
					supplierDetail[index][1] = j;
					index++;
				}
			}
		}
		index = 0;

		for (int i = 0; i < parts * parts; i++) 
		{
			for (int j = 0; j < parts; j++)
			{
				weightSumDetail[index][2] = partDetail[2][j + 3];
				priceSumDetail[index][2] = partDetail[2][j];
				supplierDetail[index][2] =j;
				index++;
			}
		}

		for (int i = 0; i < factorial(parts); i++) //删除总价格超界的数据
		{
			for (int j = 0; j < parts; j++)
			{
				priceSumDetail[i][parts] += priceSumDetail[i][j];
				weightSumDetail[i][parts] += weightSumDetail[i][j];
			}
			if (priceSumDetail[i][parts] > limitedPrice) 
			{
				weightSumDetail[i][parts] = 0;
			}
		}
			
		for (int i = 0; i < factorial(parts); i++) //找出最小总重量的数据
		{
			if (minWeightSum == 0) 
			{
				minWeightSum = weightSumDetail[i][parts];
				key = i;
			}
			else if(weightSumDetail[i][parts] < minWeightSum && weightSumDetail[i][parts] != 0)
			{
				minWeightSum = weightSumDetail[i][parts];
				key = i;
			}	
		}	
		
		for (int i = 0; i < parts; i++)
		{
			smallestPartsDetail[i] = weightSumDetail[key][i];
			partsSupplier[i] = supplierDetail[key][i];
		}
		return minWeightSum;
	}

	public int[] getSmallestWeight()
	{
		return smallestPartsDetail;
	}
	
	private int factorial(int amount)
	{
		int sum = 1;
		for (int i = 0; i < amount; i++) 
		{
			sum = sum * amount; 
		}
		return sum;
	}

	public int[] getPartsSupplier()
	{
		
		return partsSupplier;
	}
}