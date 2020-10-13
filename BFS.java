import java.util.*;

//Breadth First Search (BFS)

class BFS {
	public static void main(String[] args) {

		int V = 4;
		ArrayList<List<Integer>> graph = new ArrayList<>();

		for (int i = 0; i < V; i++)
			graph.add(new ArrayList<>());

		addEdge(graph, 0, 1);
		addEdge(graph, 0, 2);
		addEdge(graph, 1, 2);
		addEdge(graph, 2, 0);
		addEdge(graph, 2, 3);
		addEdge(graph, 3, 3);

		printBFS(graph, V);

	}

	//BFS traversal of a graph
	static void printBFS(ArrayList<List<Integer>> graph, int V) {

		//For bfs traversal we are going to use Queue
		boolean[] visited = new boolean[V];

		Queue<Integer> que = new LinkedList<>();

		//Here we are starting our traversal from vertex 0
		int s = 2;

		visited[s] = true;
		que.add(s);

		System.out.println("BFS traversal of graph is:");
		while (!que.isEmpty()) {

			s = que.poll();
			System.out.print(s + " ");

			for (int i = 0; i < graph.get(s).size(); i++) {
				int temp = graph.get(s).get(i);
				if (!visited[temp]) {
					visited[temp] = true;
					que.add(temp);
				}
			}
		}
	}

	static void addEdge(ArrayList<List<Integer>> graph, int src, int dest) {

		graph.get(src).add(dest);

		//Here we are assuming our graph is directed.

	}
}