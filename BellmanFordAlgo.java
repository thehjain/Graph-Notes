import java.util.*;

//Dijkstra fails if negative weight edges are
//present in graph, So we can use Bellman Ford
//Algo, but even this don't works if graph contains
// negtaive weight cycle.
//But we can check if negative weight cycle
//exists or not.

class BellmanFordAlgo {

	static class Edge {
		int src, dest, weight;
		Edge() {
			src = dest = weight = 0;
		}
	}

	private static int V, E;
	private static Edge[] edges;

	public static void main(String[] args) {

		V = 5;
		E = 8;

		edges = new Edge[E];

		for (int i = 0; i < E; i++)
			edges[i] = new Edge();

		edges[0].src = 0;
		edges[0].dest = 1;
		edges[0].weight = -1;

		edges[1].src = 0;
		edges[1].dest = 2;
		edges[1].weight = 4;

		edges[2].src = 1;
		edges[2].dest = 2;
		edges[2].weight = 3;

		edges[3].src = 1;
		edges[3].dest = 3;
		edges[3].weight = 2;

		edges[4].src = 1;
		edges[4].dest = 4;
		edges[4].weight = 2;

		edges[5].src = 3;
		edges[5].dest = 2;
		edges[5].weight = 5;

		edges[6].src = 3;
		edges[6].dest = 1;
		edges[6].weight = 1;

		edges[7].src = 4;
		edges[7].dest = 3;
		edges[7].weight = -3;

		bellmanFord();

	}

	static void printArr(int[] dist) {

		System.out.println("Distance of all vertices starting from zero: ");
		for (int ele : dist)
			System.out.print(ele + " ");

	}

	static void bellmanFord() {

		int src = 0;
		int[] dist = new int[V];

		for (int i = 0; i < V; i++)
			dist[i] = Integer.MAX_VALUE;

		dist[src] = 0;

		//Relax all the edges V-1 times
		for (int i = 0; i < V - 1; i++) {
			for (int j = 0; j < E; j++) {
				int u = edges[j].src;
				int v = edges[j].dest;
				int weight = edges[j].weight;
				if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
					dist[v] = dist[u] + weight;
			}
		}

		//check if negative weight cycle exists or not
		for (int i = 0; i < E; i++) {
			int u = edges[i].src;
			int v = edges[i].dest;
			int weight = edges[i].weight;
			if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
				System.out.println("Negative Weight Cycle Exists");
				return;
			}
		}

		printArr(dist);

	}

}