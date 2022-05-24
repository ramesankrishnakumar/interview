package interview.dp.easy;

public class House_Robber_198 {
	
	class Solution {
	    
	    public int rob(int[] nums) {
	        int maxAmount = 0;
	        int maxSkippingTwoHomes = 0;
	        if(nums.length > 0)  
	            maxSkippingTwoHomes = maxAmount = nums[0];
	        if(nums.length > 1) 
	            maxAmount = Math.max(maxAmount, nums[1]);
	        for(int i = 2; i < nums.length ; i++) {
	            int currentMax = Math.max(maxAmount, maxSkippingTwoHomes + nums[i]);
	            maxSkippingTwoHomes = maxAmount;
	            maxAmount = currentMax;
	        }
	        return maxAmount;
	        
	    }
	}
}
