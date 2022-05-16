package interview.slidingwindow.medium;

public class LongestPalandromicSubstring5 {
	class Solution {
		private int resultStart;
		private int resultLength;

		public String longestPalindrome(String s) {
			int strLength = s.length();
			if (strLength < 2) {
				return s;
			}
			for (int start = 0; start < strLength - 1; start++) {
				expandRange(s, start, start);
				expandRange(s, start, start + 1);
			}
			return s.substring(resultStart, resultStart + resultLength);
		}

		private void expandRange(String str, int begin, int end) {
			while (begin >= 0 && end < str.length() && str.charAt(begin) == str.charAt(end)) {
				int lengthOfWindow = end - begin + 1;
				if (resultLength < lengthOfWindow) {
					resultLength = lengthOfWindow;
					resultStart = begin;
				}
				begin--;
				end++;
			}
			// abba
			// begin = -1
			// end == 4
			// start = begin +1
			// distance = end - begin + 1 (offset index) => ( 4 - (-1)) + 1 = 6
			// distance = 6 - 2 to offset the --begin and ++ end
			// distance = end - begin + 1 - 2 => end - begin - 1
//			if (resultLength < end - begin - 1) {
//				resultStart = begin + 1;
//				resultLength = end - begin - 1;
//			}
			
		}
	}
}
