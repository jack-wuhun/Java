public class Way
{
	double [][]weightValueQuality;
	double [][]volumeValueQuality;
	int []weightGoodsAmount;
	int []volumeGoodsAmount;
	int []goodsAmount;
	int weightValueSum = 0;
	int volumeValueSum = 0;
	int valueSum = 0;
	public void Calculate(int [][]goodsDetail, int goodsType, double [][]goodsQuality, 
			int bagWeight, int bagVolume)
	{		
		int weightSum = 0, volumeSum = 0;
		weightGoodsAmount = new int [goodsType];
		volumeGoodsAmount = new int [goodsType];
		for (int i = 0; i < goodsType; i++) 
		{
			weightGoodsAmount[i] = 0;
			volumeGoodsAmount[i] = 0;
		}
		findMaxQuality(goodsQuality, goodsType);
		
		for (int i = 0; i < goodsType; i++)
		{			
			if ((bagWeight >= weightSum) && (bagVolume >= volumeSum)) 
			{
				int lastWeightSum = weightSum;
				int weightKey = (int)weightValueQuality[i][1];
				int volumeKey = (int)volumeValueQuality[i][1];
				if ((weightSum + goodsDetail[weightKey][0] <= bagWeight) &&
						(volumeSum + goodsDetail[weightKey][1] <= bagVolume)) 
				{
					weightSum += goodsDetail[weightKey][0];
					weightValueSum += goodsDetail[weightKey][2];	
					weightGoodsAmount[weightKey] = 1;
				}			
				if ((volumeSum + goodsDetail[volumeKey][1] <= bagVolume) &&
						(lastWeightSum + goodsDetail[volumeKey][0] <= bagWeight)) 
				{
					volumeSum += goodsDetail[volumeKey][1];
					volumeValueSum += goodsDetail[volumeKey][2];
					volumeGoodsAmount[volumeKey] = 1;
				}
			}
		}
		if (weightValueSum >= volumeValueSum)
		{
			goodsAmount = weightGoodsAmount;
			valueSum = weightValueSum;
		}
		else 
		{
			goodsAmount = volumeGoodsAmount;
			valueSum = volumeValueSum;
		}
	}
	
	private void findMaxQuality(double [][]goodsQuality, int goodsType)//性价比
	{
		weightValueQuality = new double [goodsType][2];//0:重量性价比 1:关键值
		volumeValueQuality = new double [goodsType][2];//0:体积性价比 1:关键值
		for (int i = 1; i < goodsType; i++) //初始化数据
		{
			weightValueQuality[i][0] = 0;
			weightValueQuality[i][1] = 0;
			volumeValueQuality[i][0] = 0;
			volumeValueQuality[i][1] = 0;
		}
		weightValueQuality[0][0] = goodsQuality[0][0];
		weightValueQuality[0][1] = 0;
		volumeValueQuality[0][0] = goodsQuality[0][1];
		volumeValueQuality[0][1] = 0;
		
		for (int i = 1; i < goodsType; i++)//goodsQuality的数
		{
			for (int j = 0; j < goodsType; j++)//valueQuality的数
			{
				if (goodsQuality[i][0] > weightValueQuality[j][0])
				{
					for (int k = i; k > j; k--)
					{
						weightValueQuality[k][0] = weightValueQuality[k - 1][0];
						weightValueQuality[k][1] = weightValueQuality[k - 1][1];										
					}
					weightValueQuality[j][0] = goodsQuality[i][0];
					weightValueQuality[j][1] = i;		
					break;
				}				
			}		
		}
		
		for (int i = 1; i < goodsType; i++)//goodsQuality的数
		{
			for (int j = 0; j < goodsType; j++)//valueQuality的数
			{
				if (goodsQuality[i][1] > volumeValueQuality[j][0])
				{
					for (int k = i; k > j; k--)
					{
						volumeValueQuality[k][0] = volumeValueQuality[k - 1][0];
						volumeValueQuality[k][1] = volumeValueQuality[k - 1][1];										
					}
					volumeValueQuality[j][0] = goodsQuality[i][1];
					volumeValueQuality[j][1] = i;		
					break;
				}				
			}		
		}
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