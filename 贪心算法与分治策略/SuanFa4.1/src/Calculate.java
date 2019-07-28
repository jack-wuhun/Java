public class Calculate
{
	public int calculateField(int [][]time, int field)
	{
		int []end = new int [field];
		for (int i = 1; i < field; i++) 
		{
			end[i] = 0;
		}
		int amount = 0;
		int[][] activeTime = selectTime(time, field);
		end[0] = activeTime[0][1];		
		int lastKey = 0;
		for (int i = 1; i < field; i++)
		{
			int key = 0;
			for (int j = 0; j < field; j++) 
			{
				if (end[j] == 0)
				{
					continue;
				}
				if (activeTime[i][0] >= end[j])
				{
					end[j] = activeTime[i][1];
					break;
				}
				else
				{
					key = j + 1;
					if (j == lastKey)
					{
						break;
					}
				}
			}
			if (key != 0)
			{
				lastKey = key;		
			}
			end[key] = activeTime[i][1];
		}
		for (int i = 0; i < field; i++) 
		{
			if (end[i] != 0) 
			{
				amount++;
			}
		}	
		return amount;		
	}
	
	private int[][] selectTime(int [][]activeTime, int field)
	{
		for (int i = 0; i < field; i++)
		{
			for (int j = i + 1; j < field; j++)
			{
				int temp = 0, temp1 = 0;
				if (activeTime[j][0] < activeTime[i][0])
				{
					temp = activeTime[i][0];
					temp1 = activeTime[i][1];
					activeTime[i][0] = activeTime[j][0];
					activeTime[i][1] = activeTime[j][1];
					activeTime[j][0] = temp;
					activeTime[j][1] = temp1;
				}		
			}
		}
		return activeTime;
	}
}