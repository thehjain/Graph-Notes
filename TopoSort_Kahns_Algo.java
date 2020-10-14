import java.util.*;

//Topological Sorting using Kahn's Algorithm

class TopoSort_Kahns_Algo {

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

		System.out.println("Topological Sorting using Kahn's Algorithm");
		topoSortKahns();

	}

	static void topoSortKahns() {

		//To store incoming edges to node.
		int[] inDegree = new int[V];

		for (int i = 0; i < V; i++) {
			ArrayList<Integer> temp = graph.get(i);
			for (int ele : temp)
				inDegree[ele]++;
		}

		//To store nodes with incoming degree zero.
		Queue<Integer> que = new LinkedList<>();

		for (int i = 0; i < V; i++)
			if (inDegree[i] == 0)
				que.add(i);

		int count = 0;

		//This will store result.
		List<Integer> res = new ArrayList<>();

		while (!que.isEmpty()) {

			int curr = que.poll();
			res.add(curr);

			for (int i = 0; i < graph.get(curr).size(); i++) {
				int temp = graph.get(curr).get(i);
				if (--inDegree[temp] == 0)
					que.add(temp);
			}
			count++;
		}

		if (count != V)
			System.out.println("There exists cycle in graph");

		for (int i : res)
			System.out.print(i + " ");

	}

	static void addEdge(int u, int v) {
		graph.get(u).add(v);
	}

}