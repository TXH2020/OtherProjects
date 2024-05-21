package programs;
import java.util.*;
public class Kruskal {
	int v,e;
	public class Edge implements Comparable<Edge>{
		int src;
		int dst;
		int w;
		public int compareTo(Edge e) {
			return this.w-e.w;
		}
	};
	public class subset{
		int parent,rank;
	};
	int find(subset subsets[],int v) {
		if(subsets[v].parent!=v)
			subsets[v].parent=find(subsets,subsets[v].parent);
		return subsets[v].parent;
	}
	void union(subset subsets[],int x,int y) {
		int xtree=find(subsets,x);
		int ytree=find(subsets,y);
		if(subsets[xtree].rank<subsets[ytree].rank)
			subsets[xtree].parent=ytree;
		else if(subsets[xtree].rank>subsets[ytree].rank)
			subsets[ytree].parent=xtree;
		else {
			subsets[xtree].parent=ytree;
			subsets[ytree].rank++;
		}
			
	}
	Edge edges[];
	Kruskal(int v,int e){
		this.e=e;
		this.v=v;
		edges=new Edge[e];
		for(int i=0;i<e;i++) 
			edges[i]=new Kruskal.Edge();
	}
	void printMST(Edge mst[]) {
		for(Edge e:mst)
			System.out.println(e.src+"--->"+e.dst+"\t"+e.w);
	}
	void kruskal() {
		Arrays.sort(edges);
		Edge mst[]=new Edge[v-1];
		for(Edge e:mst)
			e=new Edge();
		subset subsets[]=new subset[v];
		for(int i=0;i<v;i++) {
			subsets[i]=new subset();
			subsets[i].parent=i;
			subsets[i].rank=0;
		}
		int i=0,count=0;
		while(count<v-1) {
			if(find(subsets,edges[i].src)!=find(subsets,edges[i].dst)) {
				union(subsets,edges[i].src,edges[i].dst);
				mst[count]=edges[i];
				count++;
			}
			i++;
		}
	printMST(mst);
	}
public static void main(String args[]) {
	Scanner in=new Scanner(System.in);
	int v,e;
	System.out.println("Enter no. of vertices and edges");
	v=in.nextInt();
	e=in.nextInt();
	Kruskal obj=new Kruskal(v,e);
	for(int i=0;i<e;i++) {
		System.out.println("Enter source vertex for edge"+(i+1));
		obj.edges[i].src=in.nextInt();
		System.out.println("Enter destination vertex for edge"+(i+1));
		obj.edges[i].dst=in.nextInt();
		System.out.println("Enter weight of edge");
		obj.edges[i].w=in.nextInt();
	}
	obj.kruskal();
}
}
