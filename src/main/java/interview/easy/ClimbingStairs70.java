package interview.easy;

public class ClimbingStairs70 {

	class Solution {
		public int climbStairs(int n) {

		    /*
		        *   n = 0 s = 0
		        *   n = 1 s = 1
		        *.  n = 2 s = [[1 + 1], 2] = 2
		        *   n = 3 s = 3 = [2 + 1]
		            n = 4 s = 1 + 1 + 1 + 1, = 5 = [ 3 + 2]
		                      1 + 2 + 1, 
		                      1 + 1 + 2, 
		                      2 + 2,
		                      2 + 1 + 1 
		            n = 5 s = 1 + 1 + 1 + 1 + 1, = 8 = [ 5 + 3]
		                      1 + 1 + 1 + 2
		                      1 + 1 + 2 + 1
		                      1 + 2 + 1 + 1
		                      2 + 1 + 1 + 1
		                      2 + 2 + 1
		                      2 + 1 + 2
		                      1 + 2 + 1
		        */

			int[] waysToClimbEachSteps = new int[n + 1];
			if (n == 0)
				return 0;
			if (n == 1)
				return 1;

			if (n >= 2) {
				waysToClimbEachSteps[0] = 0;
				waysToClimbEachSteps[1] = 1;
				waysToClimbEachSteps[2] = 2;
			}

			for (int i = 3; i <= n; i++) {
				waysToClimbEachSteps[i] = waysToClimbEachSteps[i - 1] + waysToClimbEachSteps[i - 2];
			}

			return waysToClimbEachSteps[n];
		}
	}

}
