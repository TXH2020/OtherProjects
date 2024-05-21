package programs;
import java.util.*;
public class Dynamic {
	static int mem[];
	static int pred[];
	static void set(int n) {
		mem=new int[n+1];
		pred=new int[n+1];
		mem[0]=0;
		pred[0]=pred[1]=0;
	}
	static int find_pred(int arr[][],int u) {
			for(int i=u;i>=1;i--)
			if(arr[u-1][0]>=arr[i-2][1]) {
				return i-1;}
			return 0;
	}
	static void swap(int[][] arr, int i, int j)
	{
		for(int k=0;k<arr[i].length;k++) {
			int temp=arr[i][k];
			arr[i][k]=arr[j][k];
			arr[j][k]=temp;
		}
	}
	static int partition(int[][] arr, int low, int high)
	{
		int i = low,j=high+1,pivot = arr[low][1];
		while(i<j)
		{
			do {i=i+1;}
			while(arr[i][1]<pivot && i<arr.length-1);
			do {j=j-1;}
			while(arr[j][1]>pivot);
			swap(arr,i,j);
		}
		swap(arr, i, j);
		swap(arr,low,j);
		return j;
	}
	static void quickSort(int[][] arr, int low, int high)
	{
		if (low < high)
		{
			int pi = partition(arr, low, high);
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
	}
	static void maxprofit(int[][] arr) {
		 for(int i=2;i<=arr.length;i++) 
			 pred[i]=find_pred(arr,i);
		 for(int i=1;i<=arr.length;i++) 
		 mem[i]=Math.max(mem[i-1], mem[pred[i]]+arr[i-1][2]);
		 System.out.println("Maximum Profit:"+mem[arr.length]);
	}
public static void main(String args[]) {
	Scanner in=new Scanner(System.in);
	System.out.println("Enter no. of requests");
	int n=in.nextInt();
	Dynamic.set(n);
	int arr[][]=new int[n][3];
	for(int i=0;i<n;i++) {
		System.out.println("Enter start time,finish time, value");
		arr[i][0]=in.nextInt();
		arr[i][1]=in.nextInt();
		arr[i][2]=in.nextInt();
	}
	Dynamic.quickSort(arr,0,n-1);
	Dynamic.maxprofit(arr);
	}
}
