package programs;
import java.util.*;
public class Knapsack {
	static int W;
	static int mem[][];
	static void set(int n,int w) {
		mem=new int[n+1][w+1];
		W=w;
	}
	static void knapsack(int arr[][],int W) {
		for(int i=1;i<=arr.length;i++)
			for(int j=1;j<=W;j++) {
				if(arr[i-1][0]>j)
					mem[i][j]=mem[i-1][j];
				else
					mem[i][j]=Math.max(mem[i-1][j], arr[i-1][1]+mem[i-1][j-arr[i-1][0]]);
			}
		System.out.println("Maximum profit is:"+mem[arr.length][W]);
		int k=W,i=arr.length;
		System.out.println("Selected Items are");
		System.out.println("Weight\tValue");
		while(k>=0 && i>=1) {
			if(mem[i][k]!=mem[i-1][k]) {
				System.out.println(arr[i-1][0]+"\t"+arr[i-1][1]);
				k=k-arr[i-1][0];
			}
			i=i-1;
		}
	}
public static void main(String args[]) {
	Scanner in=new Scanner(System.in);
	System.out.println("Enter no. of items");
	int n=in.nextInt();
	System.out.println("Enter knapsack capacity");
	int W=in.nextInt();
	Knapsack.set(n,W);
	int arr[][]=new int[n][2];
	for(int i=0;i<n;i++) {
		System.out.println("Enter weight, value of item "+(i+1));
		arr[i][0]=in.nextInt();
		arr[i][1]=in.nextInt();
	}
	Knapsack.knapsack(arr, W);
	}
}
