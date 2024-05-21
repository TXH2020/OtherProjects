package programs;
import java.util.*;
public class BFS { 
	    LinkedList<Integer> adj[];   
	    Queue<Integer> s;
	    boolean nodes[]; 
	    BFS(int v)  
	    {    
	        adj = new LinkedList[v];  
	        for (int i=0; i<v; i++)  
	        {  
	            adj[i]=new LinkedList<>(); 
	        }  
	        s = new LinkedList<Integer>();
	        nodes=new boolean[v];
	    }  
	    void insertEdge(int v,int w)  
	    {  
	    	adj[v].add(w);
	    	adj[w].add(v);
	    }  
	    void bfs(int n)  
	    { 
	        int a = 0;  
	        nodes[n]=true;                    
	        s.add(n);
	        while (!s.isEmpty())  
	        {  
	            n = s.poll();
	            System.out.print(n+",");
	            for (int i = 0; i < adj[n].size(); i++)  
	            {  
	                a = adj[n].get(i);  
	                if (!nodes[a]) {       
	                	nodes[a]=true;
	                	s.add(a);}
	            }    
	        }  
	    }  
	    public static void main(String args[])  
	    {
	    	Scanner in=new Scanner(System.in);
	        System.out.println("Enter no. of vertices");
	        int nv=in.nextInt();
	        BFS graph=new BFS(nv);
	        System.out.println("Enter no. of edges");
	        int e=in.nextInt();
	        for(int i=1;i<=e;i++) {
	        	System.out.println("Enter edge(u,v). Vertex no. between 1 and "+nv+" only");
	        	int u=in.nextInt();
	        	int v=in.nextInt();
	        	graph.insertEdge(u, v);}
	        System.out.println("Enter starting vertex");
	        int st=in.nextInt();
	        graph.bfs(st);  
	    }  
	}  

