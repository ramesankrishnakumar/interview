package interview.graph.medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class Number_Of_Islands_200 {
	class Solution {

		private final int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

		public int numIslands(char[][] grid) {
			int rows = grid.length;
			int cols = grid[0].length;
			int numberOfIslands = 0;
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (grid[i][j] == '1') {
						++numberOfIslands;
						bfs(grid, rows, cols, i, j);
					}
				}
			}
			return numberOfIslands;
		}

		private void bfs(char[][] grid, int rows, int cols, int i, int j) {
			Queue<Integer> queue = new ArrayDeque<>();
			grid[i][j] = 0;
			queue.add(i * cols + j);
			while (!queue.isEmpty()) {
				int ele = queue.remove();
				int x = ele / cols;
				int y = ele % cols;
				for (int[] direction : directions) {
					int neighbourX = x + direction[0];
					int neighbourY = y + direction[1];
					if (neighbourX >= 0 && neighbourX < rows && neighbourY >= 0 && neighbourY < cols
							&& grid[neighbourX][neighbourY] == '1') {
						grid[neighbourX][neighbourY] = '0';
						queue.add(cols * neighbourX + neighbourY);
					}
				}
			}
		}
	}
}
