import java.util.*;

//Bipartitie is graph which can be divided into two sets
class Bipartite {

	private static int V;

	public static void main(String[] args) {

		V = 4;

		int graph[][] = {{0, 1, 0, 1},
			{1, 0, 1, 0},
			{0, 1, 0, 1},
			{1, 0, 1, 0}
		};

		if (isBipartite(graph, 0))
			System.out.println("Yes,Graph is Bipartitie");
		else
			System.out.println("No, Graph is not Bipartitie");

	}

	static boolean isBipartite(int[][] graph, int src) {

		//Here we will two integers to reprsent colors
		//1 for first color and 0 for second color
		//-1 means no color assigned yet
		int[] color = new int[V];

		Arrays.fill(color, -1);

		for (int v = 0; v < V; v++)
			if (color[v] == -1)
				if (!isBipartiteUtil(graph, v, color))
					return false;
		return true;
	}

	static boolean isBipartiteUtil(int[][] graph, int src, int[] color) {

		color[src] = 1;

		Queue<Integer> que = new LinkedList<>();
		que.add(src);

		while (!que.isEmpty()) {

			int curr = que.poll();

			//Means self loop exists
			if (graph[curr][curr] == 1)
				return false;

			for (int v = 0; v < V; v++) {

				if (graph[curr][v] == 1 && color[v] == -1) {
					color[v] = 1 - color[curr];
					que.add(v);
				} else if (graph[curr][v] == 1 && color[v] == color[curr])
					return false;
			}
		}
		return true;

	}

}