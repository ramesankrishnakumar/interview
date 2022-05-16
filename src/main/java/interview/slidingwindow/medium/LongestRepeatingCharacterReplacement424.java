package interview.slidingwindow.medium;

public class LongestRepeatingCharacterReplacement424 {
	class Solution {
		public int characterReplacement(String s, int k) {
			int i = 0;
			char[] charsCount = new char[26];
			int result = 0;
			int maxCharCountSeen = 0;

			for (int j = 0; j < s.length(); j++) {
				int lengthOfWindow = j - i + 1;
				charsCount[s.charAt(j) - 'A'] += 1;
				maxCharCountSeen = Math.max(maxCharCountSeen, charsCount[s.charAt(j) - 'A']);
				while (lengthOfWindow - maxCharCountSeen > k) {
					charsCount[s.charAt(i++) - 'A'] -= 1;
					// maxCharCountSeen = Math.max(maxCharCountSeen,
					// Arrays.stream(charsCount).max().getAsInt());
					lengthOfWindow = j - i + 1;
				}

				result = Math.max(result, lengthOfWindow);
			}

			return result;
		}
	}
}
