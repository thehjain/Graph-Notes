import java.util.*;

//Program to detect a cycle in Undirected Graph
class Cycle_Directed_Graph {

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

	static boolean isCyclicUtil(boolean[] visited, int i, boolean[] recStack) {

		if (recStack[i])
			return true;
		if (visited[i])
			return false;
		visited[i] = true;
		recStack[i] = true;

		for (int j = 0; j < graph.get(i).size(); j++) {
			int temp = graph.get(i).get(j);
			if (isCyclicUtil(visited, temp, recStack))
				return true;
		}
		recStack[i] = false;

		return false;

	}

	static boolean isCyclic() {

		boolean[] visited = new boolean[V];
		boolean[] recStack = new boolean[V];
		for (int i = 0; i < V; i++)
			if (!visited[i])
				if (isCyclicUtil(visited, i, recStack))
					return true;
		return false;

	}

	static void addEdge(int u, int v) {
		graph.get(u).add(v);
	}

}