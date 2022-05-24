package interview.twopointer.medium;

public class Container_with_most_water_11 {
	class Solution {
		private int max = 0;
		public int maxArea(int[] height) {
			int left = 0;
			int right = height.length - 1;
			while (left < right) {
				int waterVolume = Math.min(height[right], height[left]) * (right - left);
				if (waterVolume > max)
					max = waterVolume;
				if (height[left] < height[right])
					left++;
				else if (height[left] > height[right])
					right--;
				else
					left++;
			}
			return max;
		}
	}
}
