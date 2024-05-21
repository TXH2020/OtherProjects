package programs;

public class Quicksort {
	static void swap(int[] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	static int partition(int[] arr, int low, int high)
	{
		int i = low,j=high+1,pivot = arr[low];
		while(i<j)
		{
			do {i=i+1;}
			while(arr[i]<pivot && i<arr.length-1);
			do {j=j-1;}
			while(arr[j]>pivot);
			swap(arr,i,j);
		}
		swap(arr, i, j);
		swap(arr,low,j);
		return j;
	}
	static void quickSort(int[] arr, int low, int high)
	{
		if (low < high)
		{
			int pi = partition(arr, low, high);
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
	}
	static void printArray(int[] arr, int size)
	{
		for(int i = 0; i < size; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	public static void main(String[] args)
	{
		int[] arr = new int[10];
		int n = arr.length;
		for(int i=0;i<n;i++)
			arr[i]=(int)(Math.random()*10);
		printArray(arr, n);
		quickSort(arr, 0, n - 1);
		System.out.println("Sorted array: ");
		printArray(arr, n);
	}
}
