import java.util.*;

//Topological Sorting

class Topo_Sort {

	private static int V;
	private static ArrayList<ArrayList<Integer>> graph;

	public static void main(String[] args) {

		V = 6;
		graph = new ArrayList<>();

		for (int i = 0; i < V; i++)
			graph.add(new ArrayList<>());

		addEdge(5, 2);
		addEdge(5, 0);
		addEdge(4, 0);
		addEdge(4, 1);
		addEdge(2, 3);
		addEdge(3, 1);

		System.out.println("Topological Sorting of Graph is: ");
		topoSort();

	}

	static void topoSortUtil(int v, boolean[] visited, Stack<Integer> st) {

		visited[v] = true;

		for (int i = 0; i < graph.get(v).size(); i++) {
			int temp = graph.get(v).get(i);
			if (!visited[temp])
				topoSortUtil(temp, visited, st);
		}

		st.push(v);

	}

	static void topoSort() {

		//To store elements topological order
		Stack<Integer> st = new Stack<>();

		boolean[] visited = new boolean[V];

		for (int i = 0; i < V; i++)
			if (!visited[i])
				topoSortUtil(i, visited, st);

		while (!st.isEmpty())
			System.out.print(st.pop() + " ");

	}

	static void addEdge(int u, int v) {
		graph.get(u).add(v);
	}

}