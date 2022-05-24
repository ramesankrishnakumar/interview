package interview.medium;

import java.util.PriorityQueue;

public class Kth_Largest_Element_in_an_Array_215 {
	class Solution {
		public int findKthLargest(int[] nums, int k) {
			PriorityQueue<Integer> minHeap = new PriorityQueue<>(k + 1);
			for (int num : nums) {
				minHeap.add(num);
				if (minHeap.size() > k) {
					minHeap.remove();
				}
			}
			return minHeap.remove();
		}
	}
}
