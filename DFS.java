import java.util.*;

//DFS traversal of graph

class DFS {
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

		printDFS(graph, 2);

	}

	//DFSUtil method to print actual dfs traversal
	static void printDFSUtil(ArrayList<List<Integer>> graph, boolean[] visited, int v) {

		visited[v] = true;
		System.out.print(v + " ");

		for (int i = 0; i < graph.get(v).size(); i++) {
			int temp = graph.get(v).get(i);
			if (!visited[temp]) {
				printDFSUtil(graph, visited, temp);
			}
		}

	}

	static void printDFS(ArrayList<List<Integer>> graph, int src) {

		boolean[] visited = new boolean[graph.size()];

		System.out.println("DFS Traversal");
		printDFSUtil(graph, visited, src);

	}

	static void addEdge(ArrayList<List<Integer>> graph, int src, int dest) {

		graph.get(src).add(dest);

		//Here we are assuming our graph is directed.

	}

}
