package interview.dp.medium;

public class Longest_Common_Subsequence_1143 {
	class Solution {
		private int[][] mem;
		private String text1;
		private String text2;

		public int longestCommonSubsequence(String text1, String text2) {
			this.mem = new int[text1.length() + 1][text2.length() + 1];
			this.text1 = text1;
			this.text2 = text2;
			// for(int [] temp : mem)
			// Arrays.fill(temp, -1);
			// return dpTopDown(0, 0);

			return dpBottomUp();
		}

		public int dpTopDown(int row, int column) {
			if (row == this.text1.length() || column == this.text2.length())
				return 0;
			if (mem[row][column] != -1)
				return mem[row][column];
			if (this.text1.charAt(row) == this.text2.charAt(column))
				mem[row][column] = 1 + dpTopDown(row + 1, column + 1);
			else
				mem[row][column] = Math.max(dpTopDown(row + 1, column), dpTopDown(row, column + 1));

			return mem[row][column];
		}

		public int dpBottomUp() {
			for (int i = this.text1.length() - 1; i >= 0; i--) {
				for (int j = this.text2.length() - 1; j >= 0; j--) {
					if (this.text1.charAt(i) == this.text2.charAt(j))
						mem[i][j] = 1 + mem[i + 1][j + 1];
					else
						mem[i][j] = Math.max(mem[i][j + 1], mem[i + 1][j]);
				}
			}
			return mem[0][0];
		}
	}
}
