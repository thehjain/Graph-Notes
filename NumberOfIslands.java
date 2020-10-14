import java.util.*;

//Program to find number of islands
//Number of Islands means group of connected one's
// in given 2D Matrix.

class NumberOfIslands {

	private static int ROW, COL;

	public static void main(String[] args) {

		ROW = 5;
		COL = 5;

		int graph[][] = new int[][] { { 1, 1, 0, 0, 0 },
			{ 0, 1, 0, 0, 1 },
			{ 1, 0, 0, 1, 1 },
			{ 0, 0, 0, 0, 0 },
			{ 1, 0, 1, 0, 1 }
		};


		int res = countIslands(graph);

		System.out.println("Number of islands are: " + res);

	}

	//Method to check if moving to this index
	// is safe or not
	static boolean isSafe(int[][] graph, int row, int col, boolean[][] visited) {

		if (row >= 0 && row < ROW && col >= 0 && col < COL)
			if (graph[row][col] == 1 && !visited[row][col])
				return true;
		return false;
	}

	//Method to find number of islands using DFS
	static void countIslandsUtil(int[][] graph, int row, int col, boolean[][] visited) {

		//These are 8 possible direction one element can
		// be adjacent to another one in 2D Matix.
		int rowNbr[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
		int colNbr[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

		visited[row][col] = true;

		for (int index = 0; index < 8; index++) {

			if (isSafe(graph, row + rowNbr[index], col + colNbr[index], visited))
				countIslandsUtil(graph, row + rowNbr[index], col + colNbr[index], visited);

		}

	}

	static int countIslands(int[][] graph) {

		//To mark visited elements in Matrix
		boolean[][] visited = new boolean[ROW][COL];

		int count = 0;

		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				if (graph[i][j] == 1 && !visited[i][j]) {

					countIslandsUtil(graph, i, j, visited);
					++count;

				}
			}
		}
		return count;
	}

}