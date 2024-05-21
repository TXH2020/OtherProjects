package programs;
import java.util.*;
public class TSP {
	 int V;
	 LinkedList<Integer> adj[];   
	    Stack<Integer> s;
	    boolean nodes[];
	    int count[]
;	    TSP(int v)  
	    {    
			V=v;
	        adj = new LinkedList[v];  
	        for (int i=0; i<v; i++)  
	        {  
	            adj[i] = new LinkedList<>();  
	        }  
	        s = new Stack<Integer>();
	        nodes= new boolean[v];
	        count=new int[v];
	    } 
	    int check(boolean a[]) {
	    	for(int i=0;i<a.length;i++)
	    		if(a[i]==false)
	    			return -1;
	    	return 0;
	    }
	    int search(LinkedList<Integer> l,int key) {
	    	for(int i=0;i<l.size();i++)
	    		if(l.get(i)==key)
	    			return 0;
	    	return -1;
	    }
	    void insertEdge(int v,int w)  
	    {  
	        adj[v].add(w);
	        adj[w].add(v);
	    }  
	    void findHC()  
	    { 
	        s.push(0); 
	        int v=0;
	        for(int i=0;i<V;i++)  
	        {  
	            v = s.peek();
	            s.pop();
	            if(!nodes[v])
	            	nodes[v]=true;
	            for (int j = 0; j < adj[v].size(); j++)  
	            {  
	                int a = adj[v].get(j);  
	                if (!nodes[a])       
	                	s.push(a);
	            }    
	        }
	        if(check(nodes)==0 && search(adj[v],0)==0)
	        	System.out.println("success");
	        else
	        	System.out.println("failure");
	    }  
	    public static void main(String args[])  
	    {
	    	Scanner in=new Scanner(System.in);
	        
	        System.out.println("Enter no. of vertices and edges");
	        int nv=in.nextInt();
	        int e=in.nextInt();
	        TSP graph = new TSP(nv);
	        for(int i=1;i<=e;i++) {
	        	System.out.println("Enter edge(u,v");
	        	int u=in.nextInt();
	        	int v=in.nextInt();
	        	graph.insertEdge(u, v);}
	        graph.findHC();
	    }  
	}  

