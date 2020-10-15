import java.util.*;

//Prims Algorithm to find minimal Spanning Tree

class MST_Prims {

	private static int V;
	private static int MAX = Integer.MAX_VALUE;
	public static void main(String[] args) {

		V = 5;

		int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
			{ 2, 0, 3, 8, 5 },
			{ 0, 3, 0, 0, 7 },
			{ 6, 8, 0, 0, 9 },
			{ 0, 5, 7, 9, 0 }
		};


		primsMST(graph);

	}

	static void printMST(int[] parent, int[][] graph) {
		System.out.println("Edges got picked for MST");
		for (int i = 1; i < V; i++) {
			System.out.println(parent[i] + " -> " + i + "  " + graph[i][parent[i]]);
		}
	}

	static int minKey(int[] dist, boolean[] visited) {
		int min = MAX, minIndex = -1;
		for (int i = 0; i < V; i++) {
			if (dist[i] < min && !visited[i]) {
				min = dist[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	static void primsMST(int[][] graph) {

		int src = 0;
		int[] parent = new int[V];
		int[] dist = new int[V];
		boolean[] visited = new boolean[V];

		Arrays.fill(dist, MAX);

		dist[src] = 0;
		parent[src] = -1;

		for (int i = 0; i < V - 1; i++) {
			int curr = minKey(dist, visited);
			visited[curr] = true;

			for (int v = 0; v < V; v++) {
				if (graph[curr][v] != 0 && !visited[v] && graph[curr][v] < dist[v]) {
					parent[v] = curr;
					dist[v] = graph[curr][v];
				}
			}

		}

		printMST(parent, graph);

	}

}