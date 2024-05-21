package programs;
import java.util.*;
public class DFS { 
	    LinkedList<Integer> adj[];   
	    Stack<Integer> s;
	    boolean nodes[] = new boolean[20]; 
	    DFS(int v)  
	    {    
	        adj = new LinkedList[20];  
	        for (int i=0; i<v; i++)  
	        {  
	            adj[i] = new LinkedList<>();  
	        }  
	        s = new Stack<Integer>();  
	    }  
	    void insertEdge(int v,int w)  
	    {  
	        adj[v].add(w);
	        adj[w].add(v);
	    }  
	    void dfs(int n)  
	    { 
	        int a = 0;  
	        nodes[n]=true;                    
	        s.push(n); 
	        while (!s.empty())  
	        {  
	            n = s.pop();
	            if(n%2==0)
	            	System.out.println(n+":blue");
	            else
	            	System.out.println(n+":red");
	            for (int i = 0; i < adj[n].size(); i++)  
	            {  
	                a = adj[n].get(i);  
	                if (!nodes[a])       
	                	dfs(a);
	            }    
	        }  
	    }  
	    public static void main(String args[])  
	    {
	    	Scanner in=new Scanner(System.in);
	        DFS graph = new DFS(20);
	        System.out.println("Enter no. of edges");
	        int e=in.nextInt();
	        for(int i=1;i<=e;i++) {
	        	System.out.println("Enter edge(u,v");
	        	int u=in.nextInt();
	        	int v=in.nextInt();
	        	graph.insertEdge(u, v);}
	        System.out.println("Enter starting edge");
	        int st=in.nextInt();
	        graph.dfs(st);  
	    }  
	}  
