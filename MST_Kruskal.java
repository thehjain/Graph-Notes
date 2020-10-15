import java.util.*;

//Minimal Spanning Tree using Kruskal Algorithm
//Algo
//Here we are sort all the edges
//and pick V-1 edges
//So that all vertex get connected

class MST_Kruskal {

	static class Edge implements Comparable<Edge> {
		int src, dest, weight;
		public int compareTo(Edge temp) {
			return this.weight - temp.weight;
		}
	}

	static class Subset {
		int parent, rank;
	}

	private static int V, E;
	private static Edge[] edges;

	public static void main(String[] args) {

		V = 4; E = 5;

		edges = new Edge[E];

		for (int i = 0; i < E; i++)
			edges[i] = new Edge();

		edges[0].src = 0;
		edges[0].dest = 1;
		edges[0].weight = 10;

		edges[1].src = 0;
		edges[1].dest = 2;
		edges[1].weight = 6;

		edges[2].src = 0;
		edges[2].dest = 3;
		edges[2].weight = 5;

		edges[3].src = 1;
		edges[3].dest = 3;
		edges[3].weight = 15;

		edges[4].src = 2;
		edges[4].dest = 3;
		edges[4].weight = 4;

		KruskalMST();

	}

	static int find(Subset[] sub, int i) {
		if (sub[i].parent != i) {
			sub[i].parent = find(sub, sub[i].parent);
		}
		return sub[i].parent;
	}

	static void union(Subset[] sub, int x, int y) {

		int xP = find(sub, x);
		int yP = find(sub, y);

		if (sub[xP].rank < sub[yP].rank) {
			sub[xP].parent = yP;
		} else if (sub[xP].rank > sub[yP].rank)
			sub[yP].parent = xP;
		else {
			sub[xP].parent = yP;
			sub[yP].rank++;
		}

	}

	static void KruskalMST() {

		//To store the result edges
		Edge[] res = new Edge[V];

		//index to represent result arry
		int index = 0;
		int i = 0;

		for (i = 0; i < V; i++)
			res[i] = new Edge();

		Arrays.sort(edges);

		Subset[] sub = new Subset[V];
		for (i = 0; i < V; i++)
			sub[i] = new Subset();

		for (i = 0; i < V; i++) {
			sub[i].parent = i;
			sub[i].rank = 0;
		}

		i = 0;

		while (index < V - 1) {
			Edge next_edge = new Edge();
			next_edge = edges[i++];

			int x = find(sub, next_edge.src);
			int y = find(sub, next_edge.dest);

			if (x != y) {
				res[index++] = next_edge;
				union(sub, x, y);
			}

		}

		System.out.println("this are the final edges considered");
		for (int j = 0; j < index; j++) {
			System.out.println(res[j].src + " -> " + res[j].dest + " = " + res[j].weight);
		}

	}

}