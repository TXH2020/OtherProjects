package programs;
class MergeSort{
        public void merge(int b[],int c[],int a[]){
                int i=0,j=0,k=0;
                while(i<b.length && j<c.length){
                        if(b[i]<=c[j]){
                                a[k]=b[i];
                                i++;}
                        else{
                                a[k]=c[j];
                                j++;}
                k++;}
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
                MergeSort o=new MergeSort();
                int arr[]={10000,20000,30000,
                           40000,50000,60000,70000,80000,90000,100000};
                for(int u=0;u<arr.length;u++){
                int a[]=new int[arr[u]];
                for(int i=0;i<a.length;i++)
                        a[i]=(int)(Math.random()*10);
                long s=System.nanoTime();
                o.mergesort(a);
                long e=System.nanoTime();
                float time=(e-s)/100000;
                System.out.println(arr[u]+","+time);
}}}

