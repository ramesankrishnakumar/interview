package interview.backtracking.medium;

public class Word_Search_79 {
	class Solution {
		private final int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		private char[][] board;
		private int rows;
		private int cols;

		public boolean exist(char[][] board, String word) {
			this.board = board;
			this.rows = board.length;
			this.cols = board[0].length;
			int startIndex = 0;
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (searchWord(i, j, word, startIndex))
						return true;
				}
				startIndex = 0;
			}

			return false;
		}

		private boolean searchWord(int i, int j, String word, int index) {
			// if current char is not the one in index => return false;
			// if index >= word length return true;
			// change the char to something else so we dont match more than once
			// get neighbours and do dps again => if true return true else continue other
			// neighbours
			// change the char back return false;

			if (board[i][j] != word.charAt(index))
				return false;
			if (index == word.length() - 1)
				return true;
			board[i][j] = '0';

			for (int[] direction : directions) {
				int newI = i + direction[0];
				int newJ = j + direction[1];

				if (newI >= 0 && newI < rows && newJ >= 0 && newJ < cols && board[newI][newJ] != '0')
					if (searchWord(newI, newJ, word, index + 1))
						return true;
			}

			board[i][j] = word.charAt(index);
			return false;
		}
	}
}
