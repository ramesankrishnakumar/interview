package interview.dp.medium;

import java.util.Arrays;

public class CoinChange322 {
	class Solution {
		private int[] coins;
		private int amount;
		private int[] cache;

		public int coinChange(int[] coins, int amount) {
			if (amount <= 0)
				return 0;
			Arrays.sort(coins);
			this.cache = new int[amount + 1];
			this.coins = coins;
			this.amount = amount;
			return dp(amount) >= this.amount + 1 ? -1 : this.cache[amount];
		}

		public int dp(int remSum) {
			if (remSum == 0)
				return 0;
			if (cache[remSum] != 0)
				return cache[remSum];
			int min = this.amount + 1;
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= remSum) {
					min = Math.min(min, 1 + dp(remSum - coins[j]));
				} else
					break;
			}
			return cache[remSum] = min >= this.amount + 1 ? this.amount + 1 : min;
		}
	}
}
