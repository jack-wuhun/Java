public class Calculate
{
	public double calculateField(int[] time, int customer, int service)
	{	
		int timeSum = 0;
		double averageWaitTime = 0;
		int []customerTime = selectTime(time, customer);	
		int []temp = new int [service - 1];
		int loopTemp = 0;
		temp[0] = customerTime[0];
		for (int i = 1; i < temp.length; i++)
		{
			temp[i] = 0;
		}
		for (int i = 0; i < customer; i++) 
		{
			int lastTemp = 0;
			timeSum += (customer - i) * temp[loopTemp];
			lastTemp = temp[loopTemp];
			loopTemp++;
			if (loopTemp == (service - 1)) 
			{
				loopTemp = 0;
			}
			if (i == 0) 
			{
				temp[0] = customerTime[1] - customerTime[0];
				loopTemp = 0;
			}
			else if(i == (customer - 1))
			{
				temp[loopTemp] = customerTime[i] - lastTemp;
			}
			else
			{
				temp[loopTemp] = customerTime[i + 1] - lastTemp;
			}
		}		
		averageWaitTime = timeSum / customer;
		return averageWaitTime;
	}

	private int[] selectTime(int []customerTime, int customer)
	{
		for (int i = 0; i < customer; i++)
		{
			for (int j = i + 1; j < customer; j++)
			{
				int temp = 0;
				if (customerTime[j] < customerTime[i])
				{
					temp = customerTime[i];
					customerTime[i] = customerTime[j];
					customerTime[j] = temp;
				}		
			}
		}
		return customerTime;
	}
}