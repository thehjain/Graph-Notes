import java.util.*;

//Floyd Warshall Algorithm (All Pair Shortest Path)
class FloydWarshallAlgo {

	final private static int INF = 9999;

	public static void main(String[] args) {

		int graph[][] = { {0,   5,  INF, 10},
			{INF, 0,   3, INF},
			{INF, INF, 0,   1},
			{INF, INF, INF, 0}
		};

		floydWarshall(graph);

	}

	static void printGraph(int[][] dist) {

		int V = dist.length;

		System.out.println("All Pair Shortest Algo");
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				if (dist[i][j] == INF)
					System.out.print("INF ");
				else
					System.out.print(dist[i][j] + "   ");
			}
			System.out.println();
		}

	}

	static void floydWarshall(int[][] graph) {

		int V = graph.length;

		//To store the final results
		int[][] dist = new int[V][V];

		for (int i = 0; i < V; i++)
			for (int j = 0; j < V; j++)
				dist[i][j] = graph[i][j];

		// Here we are checking distance of every
		// vertex from every vertex via K
		for (int k = 0; k < V; k++) {
			for (int i = 0; i < V; i++) {
				for (int j = 0; j < V; j++) {
					if (dist[i][k] + dist[k][j] < dist[i][j])
						dist[i][j] = dist[i][k] + dist[k][j];
				}
			}
		}

		printGraph(dist);
	}
}