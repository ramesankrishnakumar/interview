package interview.easy;

import java.util.HashMap;
import java.util.Map;

public class Valid_Anagram_242 {
	class Solution {
		public boolean isAnagram(String s, String t) {

			Map<Character, Integer> lookup = new HashMap<>();

			for (char ch : s.toCharArray()) {
				lookup.put(ch, lookup.getOrDefault(ch, 0) + 1);
			}

			for (char ch2 : t.toCharArray()) {
				int val = lookup.getOrDefault(ch2, 0);
				if (val == 0)
					return false;
				else if (val == 1)
					lookup.remove(ch2);
				else
					lookup.put(ch2, val - 1);
			}

			return(lookup.entrySet().isEmpty());
		}
	}
}
