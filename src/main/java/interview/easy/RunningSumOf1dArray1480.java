package interview.easy;

import java.util.Arrays;

public class RunningSumOf1dArray1480 {
	class Solution {
		private int i = 0;

		public int[] runningSum(int[] nums) {
			if (null == nums || nums.length == 0)
				return new int[1];
			return recursiveRunningSumWithoutCopy(new int[nums.length], nums);
		}

		public int[] recursiveRunningSum(int[] state, int[] numbers) {
			// state.length = 10 numbers.length = 10 you calculate the sum at index 0
			if (numbers.length == 1) {
				state[state.length - numbers.length] = numbers[0] + state[state.length - numbers.length - 1];
				return state;
			}
			if (state.length == numbers.length)
				state[state.length - numbers.length] = numbers[0];
			else
				state[state.length - numbers.length] = state[state.length - numbers.length - 1] + numbers[0];
			return recursiveRunningSum(state, Arrays.copyOfRange(numbers, 1, numbers.length));
		}

		public int[] simpleBigO_Of_NRuntime(int[] runningSumHolder, int[] nums) {

			runningSumHolder[0] = nums[0];
			for (int i = 1; i < nums.length; i++) {
				runningSumHolder[i] = nums[i] + runningSumHolder[i - 1];
			}

			return runningSumHolder;
		}

		public int[] simpleBigO_Of_NRuntime_UsingInputState(int[] nums) {
			for (int i = 1; i < nums.length; i++) {
				nums[i] = nums[i] + nums[i - 1];
			}
			return nums;
		}

		public int[] recursiveRunningSumWithoutCopy(int[] state, int[] numbers) {
			if (i == 0)
				state[i] = numbers[i];
			else
				state[i] = state[i - 1] + numbers[i];
			if (i == numbers.length - 1)
				return state;
			++i;
			return recursiveRunningSumWithoutCopy(state, numbers);
		}

	}
}
