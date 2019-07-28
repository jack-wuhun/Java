public class Way 
{
	private int[] data;
	void inPutData (int dataAmount, int[] wData)
	{
		int low = 0, high = dataAmount - 1;	
		int []data = new int [dataAmount];

		for (int i = 0; i < data.length; i++)
		{
			data[i] = wData[i];
		}
		manageData(data, low, high);
	}
	
	private void manageData(int[] data, int low, int high)
	{
		int h = high;
		int l = low;
		int bn = data[l];
		while(l < h)
		{
			while(l < h && data[h] >= bn)
			{
				h--;
			}
			int temp = data[h];
			data[h] = data[l];
			data[l] = temp;
			
			while(l < h && data[l] <= bn)
			{
				l++;
			}
			temp = data[l];
			data[l] = data[h];
			data[h] = temp;
			
			if(l > low)
			{		
				manageData(data, low, l- 1);
			}
			
			if (h < high) 
			{	
				manageData(data, l+1, high);
			}
		}
		setData(data);
	}
	
	private void setData(int[] data)//实时更新数据，并且私有化加密
	{
		this.data = data;
	}

	private int[] getData()//私有化提取数据，保证数据不外流
	{
		return data;
	}
	
	void getGoal(int goal)
	{		
		getData();
		System.out.print(data[goal - 1]);
	}
}