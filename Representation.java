import java.util.*;
import java.io.*;

//Graph can be represented in two ways
//1.2d Array or Matrix
//2.Nested ArrayList or Nested ArrayList

class Representation {
	public static void main(String[] args) {

		int V = 5;
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

		//Adding Nested ArrayList's
		for (int i = 0; i < V; i++)
			graph.add(new ArrayList<Integer>());

		addEdge(graph, 0, 1);
		addEdge(graph, 0, 4);
		addEdge(graph, 1, 2);
		addEdge(graph, 1, 3);
		addEdge(graph, 1, 4);
		addEdge(graph, 2, 3);
		addEdge(graph, 3, 4);

		printGraph(graph);

	}

	static void printGraph(ArrayList<ArrayList<Integer>> arr) {
		System.out.println("Graph Edges");
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(i + " ");
			for (int j = 0; j < arr.get(i).size(); j++) {
				System.out.print(" -> " + arr.get(i).get(j));
			}
			System.out.println();
		}
	}

	//Function to add edges in vertexes
	static void addEdge(ArrayList<ArrayList<Integer>> graph, int src, int dest) {

		graph.get(src).add(dest);
		graph.get(dest).add(src);

		//Here we are assuming our graph is undirected.

	}

}