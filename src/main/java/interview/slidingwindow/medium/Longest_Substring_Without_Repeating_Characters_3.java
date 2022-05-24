package interview.slidingwindow.medium;

import java.util.HashSet;
import java.util.Set;

public class Longest_Substring_Without_Repeating_Characters_3 {
	class Solution {
		public int lengthOfLongestSubstring(String s) {
			int i = 0;
			int maxCntOfSubStr = 0;
			Set<Character> chars = new HashSet<>();
			for (int j = 0; j < s.length(); j++) {
				while (chars.contains(s.charAt(j))) {
					chars.remove(s.charAt(i++));
				}
				chars.add(s.charAt(j));
				maxCntOfSubStr = Math.max(maxCntOfSubStr, j - i + 1);
			}
			return maxCntOfSubStr;
		}

	}
}
