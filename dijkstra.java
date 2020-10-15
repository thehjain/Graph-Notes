import java.util.*;

//Dijkstra Algorithm to find the shortest path
class Dijkstra {

	private static int V = 9;
	private static int MAX = Integer.MAX_VALUE;

	public static void main(String[] args) {

		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
			{ 4, 0, 8, 0, 0, 0, 0, 11, 0 },
			{ 0, 8, 0, 7, 0, 4, 0, 0, 2 },
			{ 0, 0, 7, 0, 9, 14, 0, 0, 0 },
			{ 0, 0, 0, 9, 0, 10, 0, 0, 0 },
			{ 0, 0, 4, 14, 10, 0, 2, 0, 0 },
			{ 0, 0, 0, 0, 0, 2, 0, 1, 6 },
			{ 8, 11, 0, 0, 0, 0, 1, 0, 7 },
			{ 0, 0, 2, 0, 0, 0, 6, 7, 0 }
		};

		djkstra(graph, 0);

	}

	//Method to print distance
	static void printGraph(int[] dist) {
		System.out.println("Distance to all starting from 0 ");
		for (int ele : dist)
			System.out.print(ele + " ");
	}

	static int minDistance(int[] dist, boolean[] visited) {

		int min = MAX, minIndex = -1;
		for (int i = 0; i < V; i++)
			if (!visited[i] && dist[i] < min) {
				min = dist[i];
				minIndex = i;
			}

		return minIndex;
	}

	static void djkstra(int[][] graph, int src) {

		int[] dist = new int[V];

		boolean[] visited = new boolean[V];

		for (int i = 0; i < V; i++)
			dist[i] = MAX;

		dist[src] = 0;

		for (int i = 0; i < V - 1; i++) {

			int curr = minDistance(dist, visited);

			visited[curr] = true;

			for (int v = 0; v < V; v++) {
				if (!visited[v] && graph[curr][v] != 0 && dist[curr] != MAX && dist[curr] + graph[curr][v] < dist[v])
					dist[v] = dist[curr] + graph[curr][v];
			}

		}

		printGraph(dist);
	}

}