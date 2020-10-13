import java.util.*;

//Program to detect a cycle in Undirected Graph
class Cycle_Undirected_Graph {

	private static int V;
	private static ArrayList<ArrayList<Integer>> graph;

	public static void main(String[] args) {

		V = 5;
		graph = new ArrayList<>();

		for (int i = 0; i < V; i++)
			graph.add(new ArrayList<>());

		addEdge(1, 0);
		addEdge(0, 2);
		addEdge(2, 1);
		addEdge(0, 3);
		addEdge(3, 4);

		if (isCyclic())
			System.out.println("Yes,Graph contains cycle.");
		else
			System.out.println("No, Graph does not contain any cycle.");

	}

	static boolean isCyclicUtil(boolean[] visited, int node, int parent) {

		visited[node] = true;

		for (int i = 0; i < graph.get(node).size(); i++) {

			int temp = graph.get(node).get(i);
			if (!visited[temp]) {
				if (isCyclicUtil(visited, temp, node))
					return true;
			} else if (temp != parent)
				return true;
		}
		return false;
	}

	static boolean isCyclic() {

		boolean[] visited = new boolean[V];
		for (int i = 0; i < V; i++)
			if (!visited[i])
				if (isCyclicUtil(visited, i, -1))
					return true;
		return false;

	}

	static void addEdge(int u, int v) {
		graph.get(u).add(v);
		graph.get(v).add(u);
	}

}