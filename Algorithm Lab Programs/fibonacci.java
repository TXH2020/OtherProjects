package programs;
public class fibonacci{
private int arr[];
void initialize(int n){
arr=new int[n+1];
arr[0]=0;
arr[1]=1;
}
int rec_fib(int no){
        if(no<=0)
                return 0;
        else if(no==1)
                return 1;
        else
                return rec_fib(no-1)+rec_fib(no-2);}
int dyn_fib(int ni){
for(int i=2;i<=ni;i++)
        arr[i]=arr[i-2]+arr[i-1];
return arr[ni];}
public static void main(String args[]){
fibonacci o=new fibonacci();
int sum1=0,sum2=0;
int arr[]={2,4,6,8,10,12,14,16,18,20};
System.out.println("Recursive fibonacci time:");
for(int i=0;i<arr.length;i++) {
	long s1=System.nanoTime();
	for(int j=0;j<=arr[i];j++)
			System.out.print(o.rec_fib(j));
	long e1=System.nanoTime();
	float time=(e1-s1)/1000;
System.out.println(","+time);}
System.out.println("Memorization fibonacci time:");
for(int i=0;i<arr.length;i++) {
	o.initialize(arr[i]);
	long s2=System.nanoTime();
	for(int j=0;j<=arr[i];j++)
		sum2=sum2+o.dyn_fib(j);
	long e2=System.nanoTime();
	float time=(e2-s2)/1000;
	System.out.println(arr[i]+","+time);}
}}

