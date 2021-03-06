package interview.dp.medium;

public class Maximum_Length_of_Repeated_Subarray_718 {
	class Solution {
	    public int findLength(int[] nums1, int[] nums2) {
	        int[][] mem = new int[nums1.length + 1] [nums2.length + 1];
	        int maxLength = 0;
	        for(int i  = nums1.length - 1; i >= 0; i--) {
	            for(int j = nums2.length - 1; j >=0 ; j--) {
	                if(nums1[i] == nums2[j]) {
	                    mem[i][j] = 1 + mem[i+1][j+1];
	                    maxLength = Math.max(maxLength, mem[i][j]);
	                }
	            }
	        }
	        return maxLength;
	    }
	}
}
