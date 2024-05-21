package programs;
import java.util.*;
public class InsertS {
public static void main(String args[]) {
	int a[]=new int[10];
	for(int i=0;i<10;i++)
		a[i]=(int)(Math.random()*10);
	System.out.println(Arrays.toString(a));
	int j,t;
	for(int i=0;i<9;i++) {
		 for(j=1;j<=9-i;j++) {
			 if(a[j]<a[j-1]) { 
			t=a[j];
			a[j]=a[j-1];
			a[j-1]=t;	}	
		 }
	}
	System.out.println(Arrays.toString(a));
}
}
