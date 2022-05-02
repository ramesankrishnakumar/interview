package interview.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	class Solution {
		public int[] twoSum(int[] nums, int target) {
			Map<Integer, Integer> complimentMap = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				Integer value = target - nums[i];
				if (complimentMap.get(value) != null)
					return new int[] { complimentMap.get(value), i };
				complimentMap.put(nums[i], i);
			}
			return null;
		}
	}
}
