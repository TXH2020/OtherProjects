/*This is a program that I developed in response to a question in my algorithms lab
 * The question was as follows:Compare selection sort,insertion sort,merge sort 
 * for arrays having following sizes:100,200,300,500,1000,2000,3000,5000,6000,8000,
   10000,50000
   In this program, I obtain comma-seperated values, which can then be used for making a 
   plot comparing the three types of sorting.
   The plot has been included in the directory.*/
import java.lang.reflect.Method;
class MergeSort3{
        public void outerFunction(Object object, Method method, int[] arr)throws Exception{
        Object[] parameters = new Object[1];
        for(int u=0;u<arr.length;u++){
                        int a[]=new int[arr[u]];
                        for(int i=0;i<a.length;i++)
                                a[i]=(int)(Math.random()*10);
                        long s=System.nanoTime();
                        parameters[0] = a;
                        method.invoke(object, parameters);
                        long e=System.nanoTime();
                        float time=(e-s)/100000;
                        System.out.println(arr[u]+","+time);}}

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
        
       public void insertionsort(int arr[]){
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;}
            arr[j + 1] = key;}}
       public void selectionsort(int arr[])
                {
                    int n = arr.length;
                    for (int i = 0; i < n-1; i++)
                    {
                        int min_idx = i;
                        for (int j = i+1; j < n; j++)
                            if (arr[j] < arr[min_idx])
                                min_idx = j;
                        int temp = arr[min_idx];
                        arr[min_idx] = arr[i];
                        arr[i] = temp;
                    }
                }


        public static void main(String args[]){
                MergeSort3 o=new MergeSort3();
                int arr[]={100,200,300,500,1000,2000,3000,5000,6000,8000,
                           10000,50000};
                try {
                System.out.println("Merge Sort Values");
                Method functionToPass = MergeSort3.class.getMethod("mergesort", arr.getClass());
                o.outerFunction(o, functionToPass, arr);
                System.out.println("Insertion Sort Values");
                functionToPass = MergeSort3.class.getMethod("insertionsort", arr.getClass());
                o.outerFunction(o, functionToPass, arr);
                System.out.println("Selection Sort Values");
                functionToPass = MergeSort3.class.getMethod("selectionsort", arr.getClass());
                o.outerFunction(o, functionToPass, arr);}
                catch(Exception e) {
                	System.out.println("Error");
                }
        }}



