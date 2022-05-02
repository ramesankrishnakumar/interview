package interview.graph.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class RottingOranges994 {
	/*
	 * Approach 1: Breadth-First Search (BFS) Intuition
	 * 
	 * This is yet another 2D traversal problem. As we know, the common algorithmic
	 * strategies to deal with these problems would be Breadth-First Search (BFS)
	 * and Depth-First Search (DFS).
	 * 
	 * As suggested by its name, the BFS strategy prioritizes the breadth over
	 * depth, i.e. it goes wider before it goes deeper. On the other hand, the DFS
	 * strategy prioritizes the depth over breadth.
	 * 
	 * The choice of strategy depends on the nature of the problem. Though
	 * sometimes, they are both applicable for the same problem. In addition to 2D
	 * grids, these two algorithms are often applied to problems associated with
	 * tree or graph data structures as well.
	 * 
	 * In this problem, one can see that BFS would be a better fit.
	 * 
	 * Because the process of rotting could be explained perfectly with the BFS
	 * procedure, i.e. the rotten oranges will contaminate their neighbors first,
	 * before the contamination propagates to other fresh oranges that are farther
	 * away.
	 * 
	 * If one is not familiar with the algorithm of BFS, one can refer to our
	 * Explore card of Queue & Stack which covers this subject.
	 * 
	 * However, it would be more intuitive to visualize the rotting process with a
	 * graph data structure, where each node represents a cell and the edge between
	 * two nodes indicates that the given two cells are adjacent to each other.
	 */

	private static int[][] directions = { { 1, 0 }, // N
			{ -1, 0 }, // S
			{ 0, 1 }, // E
			{ 0, -1 } // W
	};

	public int orangesRotting(int[][] grid) {
		return getRotten(grid);
	}

	private List<int[]> getNeighbours(int row, int column, int[][] grid, int[][] seen) {
		List<int[]> neighbours = new ArrayList<>();

		for (int[] direction : directions) {
			int nRow = row + direction[0];
			int nCol = column + direction[1];
			if (nRow < 0 || nRow >= grid.length || nCol < 0 || nCol >= grid[0].length || grid[nRow][nCol] != 1
					|| seen[nRow][nCol] == 1)
				continue;
			neighbours.add(new int[] { nRow, nCol });
		}
		return neighbours;
	}

	private int getRotten(int[][] grid) {
		int[][] seen = new int[grid.length][grid[0].length];
		int numberOfOranges = 0;
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1)
					++numberOfOranges;
				else if (grid[i][j] == 2) {
					queue.addLast(new int[] { i, j });
				}
			}
		}
		if (numberOfOranges == 0)
			return 0;
		if (queue.isEmpty())
			return -1;

		int min = 0;
		List<int[]> neigbhours = null;
		while (!queue.isEmpty()) {
			int size = queue.size();
			if (numberOfOranges == 0)
				return min;
			for (int k = 0; k < size; k++) {
				int[] element = queue.removeFirst();
				neigbhours = getNeighbours(element[0], element[1], grid, seen);
				for (int[] neighbour : neigbhours) {
					seen[neighbour[0]][neighbour[1]] = 1;
					--numberOfOranges;
					queue.addLast(neighbour);
				}
			}
			++min;
		}
		if (numberOfOranges == 0)
			return min;
		else
			return -1;
	}
}
