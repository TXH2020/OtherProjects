package programs;
import java.util.*;
public class Dijkstra {
	int min_dist(int dist[],boolean m[]) {
		int min=Integer.MAX_VALUE;
		int value=0;
		for(int i=0;i<dist.length;i++) 
			if(dist[i]<min && !m[i]) {
				min=dist[i];
				value=i;
			}
		return value;
	}
	void print_path(int s,int dist[]) {
		System.out.println("Shortest paths from "+s+" are ");
		for(int i=0;i<dist.length;i++)
			System.out.println((s+1)+"-->"+(i+1)+"="+dist[i]);
	}
	void dijkstra(int arr[][],int s,int v) {
		int dist[]=new int[v];
		boolean marked[]=new boolean[v];
		for(int i=0;i<v;i++)
			dist[i]=Integer.MAX_VALUE;
		dist[s]=0;
		for(int i=0;i<v;i++) {
			int u=min_dist(dist,marked);
			marked[u]=true;
			for(int j=0;j<v;j++)
				if(arr[u][j]!=0 && arr[u][j]+dist[u]<dist[j] && !marked[j])
					dist[j]=arr[u][j]+dist[u];
		}
		print_path(s,dist);
	}
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
        System.out.println("Enter no. of vertices and edges");
        int vn=in.nextInt();
        int e=in.nextInt();
        int u,v=0,w;
        int arr[][]=new int[vn][vn];
        for(int i=0;i<e;i++){
                System.out.println("Ente edge(u,v).(Vertex between 1 and "
                                +vn+")");
                u=in.nextInt();
                v=in.nextInt();
                System.out.println("Enter edge weight of ("+u+","+v+")");
                w=in.nextInt();
                arr[u-1][v-1]=w;
                arr[v-1][u-1]=w;}
        System.out.println("Enter source vertex");
        int s=in.nextInt();
        Dijkstra o=new Dijkstra();
        o.dijkstra(arr, s-1, vn);
	}
}
