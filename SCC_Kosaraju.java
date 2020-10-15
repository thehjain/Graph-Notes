import java.util.*;

//Strongy Connected Components using Kosaraju's Algorithm

class SCC_Kosaraju {

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

		printSCC();

	}

	//To fill stack with integers according to finishing time
	static void fillOrder(int u, boolean[] visited, Stack<Integer> st) {

		visited[u] = true;

		for (int i = 0; i < graph.get(u).size(); i++) {
			int temp = graph.get(u).get(i);
			if (!visited[temp]) {
				fillOrder(temp, visited, st);
			}
		}
		st.push(u);
	}

	static ArrayList<ArrayList<Integer>> getTranspose() {

		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

		for (int i = 0; i < V; i++)
			arr.add(new ArrayList<>());

		for (int v = 0; v < V; v++) {

			for (int i = 0; i < graph.get(v).size(); i++) {
				int temp = graph.get(v).get(i);
				arr.get(temp).add(v);
			}
		}
		return arr;
	}

	static void DFSUtil(int v, boolean[] visited, ArrayList<ArrayList<Integer>> arr) {

		visited[v] = true;

		for (int i = 0; i < arr.get(v).size(); i++) {
			int temp = arr.get(v).get(i);
			if (!visited[temp])
				DFSUtil(temp, visited, arr);
		}
	}

	static void printSCC() {

		Stack<Integer> st = new Stack<>();
		boolean[] visited = new boolean[V];

		for (int i = 0; i < V; i++)
			if (!visited[i])
				fillOrder(i, visited, st);

		ArrayList<ArrayList<Integer>> arr = getTranspose();

		Arrays.fill(visited, false);

		int count = 0;

		while (!st.isEmpty()) {

			int v = (int)st.pop();

			if (!visited[v]) {

				DFSUtil(v, visited, arr);
				count++;

			}

		}
		System.out.println(count);
	}

	static void addEdge(int u, int v) {
		graph.get(u).add(v);
	}

}