public class Way
{
	int []goodsAmount;
	int valueSum = 0;
	public void calculate(double [][]goodsDetail, int bagLimited, int goodsType)
	{
		int weightSum = 0, key = 0;
		double [][]valueQuality = new double [goodsType][2];//0:性价比 1:关键值
		valueQuality = findMaxQuality(goodsDetail, goodsType);
		goodsAmount = new int [goodsType]; 
		for (int i = 0; i < goodsType; i++) 
		{
			goodsAmount[i] = 0;
		}
		
		for (int j = 0; j < goodsType; j++) 
		{			
			if (bagLimited > weightSum) 
			{
				int amountTemp = 0;
				key = (int)valueQuality[j][1];
				amountTemp = ((bagLimited - weightSum) / (int)goodsDetail[key][0]);
				goodsAmount[key] = amountTemp;
				weightSum += amountTemp * goodsDetail[key][0];
				valueSum += amountTemp * goodsDetail[key][1];								
			}
		}					
	}
	
	private double[][] findMaxQuality(double [][]goodsDetail, int goodsType)//性价比
	{
		double [][]valueQuality = new double [goodsType][2];//0:性价比 1:关键值
		for (int i = 1; i < goodsType; i++) //初始化数据
		{
			valueQuality[i][0] = 0;
			valueQuality[i][1] = 0;
		}
		valueQuality[0][0] = goodsDetail[0][2];
		valueQuality[0][1] = 0;
		for (int i = 1; i < goodsType; i++)//goodsDetail的数
		{
			for (int j = 0; j < goodsType; j++)//valueQuality的数
			{
				if (goodsDetail[i][2] > valueQuality[j][0])
				{
					for (int k = i; k > j; k--)
					{
						valueQuality[k][0] = valueQuality[k - 1][0];
						valueQuality[k][1] = valueQuality[k - 1][1];										
					}
					valueQuality[j][0] = goodsDetail[i][2];
					valueQuality[j][1] = i;		
					break;
				}				
			}		
		}
		return valueQuality;
	}
	
	public int[] getAmountData()
	{
		return goodsAmount;
	}
	
	public int getValueSumData()
	{
		return valueSum;
	}
}