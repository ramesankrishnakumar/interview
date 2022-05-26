package interview.medium;

import java.util.ArrayList;
import java.util.List;

public class Spiral_Matrix_54 {
	class Solution {
		public List<Integer> spiralOrder(int[][] matrix) {
			int rows = matrix.length;
			int columns = matrix[0].length;
			List<Integer> results = new ArrayList<>();
			int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
			int[][] seen = new int[rows][columns];
			int currDir = 0;
			int i = 0;
			int j = 0;
			results.add(matrix[i][j]);
			seen[i][j] = 1;
			while (results.size() < rows * columns) {
				currDir = currDir % 4;
				int[] direction = directions[currDir];
				int ni = i + direction[0];
				int nj = j + direction[1];
				if (ni < 0 || ni >= rows || nj < 0 || nj >= columns || seen[ni][nj] == 1) {
					currDir += 1;
					continue;
				}
				i = ni;
				j = nj;
				seen[i][j] = 1;
				results.add(matrix[i][j]);
			}
			return results;
		}
	}
}
