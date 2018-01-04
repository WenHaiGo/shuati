package mysort;

public class QuickSort {
	public static void quickSort(int[] arr, int left, int right) {
		if(left>=right)
			return;
		int p = arr[left];
		int i = left,j = right;
		
		while(i<j)
		{
			while(arr[j]>=p&&i<j)
			{
				j--;
			}
			
			while(arr[i]<=p&&i<j)
			{
				i++;
			}
			
			if(i<j)
			{
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		arr[left] = arr[i];
		arr[i] = p; 
		quickSort(arr, left, i-1);
		quickSort(arr, i+1, right);
	}
	
	
	public static void main(String[] args) {
		int[] arr = {1,3,4,2,1,7,8,3,0,1000,3};
		quickSort(arr, 0, arr.length-1);
		for (int i : arr) {
			System.out.println(i);
		}
		
	}
}
