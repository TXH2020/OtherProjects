package programs;
class Prim{
	private static final int V = 7;
	int minKey(int key[], Boolean mstSet[])
	{
		int min = Integer.MAX_VALUE, min_index = -1;
		for (int v = 0; v < V; v++)
			if (mstSet[v] == false && key[v] < min) {
				min = key[v];
				min_index = v;
			}
		return min_index;
	}
	void printMST(int parent[], int key[])
	{
		System.out.println("Edge \tWeight");
		for (int i = 1; i < V; i++)
			System.out.println(parent[i] + " - " + i + "\t" + key[i]);
	}
	void primMST(int graph[][])
	{
		int parent[] = new int[V];
		int key[] = new int[V];
		Boolean mstSet[] = new Boolean[V];
		for (int i = 0; i < V; i++) {
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}
		key[0] = 0;
		parent[0] = -1; 
		for (int count = 0; count < V - 1; count++) {
			int u = minKey(key, mstSet);
			mstSet[u] = true;
			for (int v = 0; v < V; v++)
				if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
					parent[v] = u;
					key[v] = graph[u][v];
				}
		}
		printMST(parent, key);
	}

	public static void main(String[] args)
	{
		Prim t = new Prim();
		int graph[][] = new int[][] { { 0, 7, 0, 5, 0,0,0 },
									{ 7,0,8,9,7,0,0 },
									{ 0,8,0,0,5,0,0 },
									{ 5,9,0,0,15,6,0 },
									{0,7,5,15,0,8,9}, 
									{0,0,0,6,8,0,11},
									{0,0,0,0,9,11,0}};
		t.primMST(graph);
	}
}
