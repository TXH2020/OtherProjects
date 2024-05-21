/*This is a java program which I developed in response to a question in my Algoritms laboratory which was as follows:
Three users in an online music portal listen to a playlist of 8 songs that are numbered from 1 to 8 in a random order. 
Each user needs to be recommended to another user playlist’s order that has minimum number of inversions. Suggest which algorithm can be chosen for it.
	Here I have set 9 users instead of 3. We enter the user's number and the user no. satisfying the above requirements will be returned.*/ 
import java.util.*;
class MergeSort1{
	int keep_count=0;
		public int[] shuffle(int array[]) {
			Random rand = new Random();
			for (int i = 0; i < array.length; i++) {
				int index = rand.nextInt(array.length);
				int temp = array[index];
				array[index] = array[i];
				array[i] = temp;
			}
			return array;
		}
        public void merge(int b[],int c[],int a[]){
                int i=0,j=0,k=0,count=0;
                while(i<b.length && j<c.length){
                        if(b[i]<=c[j]){
                                a[k]=b[i];
                                i++;}
                        else{
                                a[k]=c[j];
                                j++;
                                count=count+b.length-i;}
                k++;}
                keep_count=keep_count+count;
                if(i==b.length){
                        for(;j<c.length;j++,k++)
                        a[k]=c[j];}
                else{
                        for(;i<b.length;i++,k++)
                        a[k]=b[i];}
                }
        public void mergesort(int a[]){
                if(a.length>1){
                int n=a.length,i;
                int b[]=new int[n/2];
		 int c[]=new int[n-n/2];
                for(i=0;i<b.length;i++)
                        b[i]=a[i];
                for(int j=0;j<c.length;j++,i++)
                        c[j]=a[i];
                mergesort(b);
                mergesort(c);
                merge(b,c,a);}}
        public static void main(String args[]){
                MergeSort1 o=new MergeSort1();
                Scanner in=new Scanner(System.in);
                int arr[][]=new int[9][8];
                for(int i=0;i<arr.length;i++) {
                	for(int j=0;j<arr[0].length;j++)
                		arr[i][j]=j+1;
                	arr[i]=o.shuffle(arr[i]);
                } 
                int a[]=new int[arr.length];
                for(int i=0;i<arr.length;i++) {
                	o.mergesort(arr[i]);
                	a[i]=o.keep_count;
                	o.keep_count=0;
                }
                System.out.println("Enter user no");
                int u=in.nextInt();
                int min=a[0],m=0;
                if(u-1==0) {
            		min=a[1];
            		m=1;
            	}
                for(int i=1;i<arr.length;i++) {
                	if(i==u-1)
                		continue;
                	if(a[i]<min) {
                		min=a[i];
                		m=i;}}
                System.out.println("Recommended user "+(m+1));
}}
